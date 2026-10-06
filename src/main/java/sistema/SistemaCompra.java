package sistema;

import padroescriacao.abstractfactory.Entrega;
import padroescriacao.abstractfactory.FabricaAbstrata;
import padroescriacao.factorymethod.INotificacao;
import padroescriacao.factorymethod.NotificacaoFactory;
import padroescriacao.singleton.Parametros;
import padroesestruturais.bridge.Cliente;
import padroesestruturais.decorator.Pedido;

public class SistemaCompra {

    private Pedido pedido;
    private Entrega entrega;
    private Cliente cliente;
    private INotificacao notificacao;

    public SistemaCompra(Pedido pedido, FabricaAbstrata fabricaEntrega, Cliente cliente, String tipoNotificacao) {
        this.pedido = pedido;                                                   // Decorator
        this.entrega = new Entrega(fabricaEntrega);                             // Abstract Factory
        this.cliente = cliente;                                                 // Bridge
        this.notificacao = NotificacaoFactory.obterNotificacao(tipoNotificacao); // Factory Method
    }

    public float calcularTotal() {
        float subtotal = pedido.getValor() + entrega.calcularFrete();
        cliente.setValorCompra(subtotal);
        return cliente.calcularTotal();
    }

    public String finalizarCompra() {
        String usuario = Parametros.getInstance().getUsuarioLogado();               // Singleton
        return "Olá, " + usuario + "! " + notificacao.enviarConfirmacao() + ". " + entrega.informarPrazo();
    }
}