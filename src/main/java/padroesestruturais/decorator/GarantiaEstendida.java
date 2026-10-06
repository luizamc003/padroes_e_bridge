package padroesestruturais.decorator;

public class GarantiaEstendida extends PedidoDecorator {

    public GarantiaEstendida(Pedido pedido) {
        super(pedido);
    }

    public float getPercentualValor() {
        return 10;
    }

    public String getNomeDescricao() {
        return "Garantia";
    }
}
