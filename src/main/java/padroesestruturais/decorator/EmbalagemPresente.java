package padroesestruturais.decorator;

public class EmbalagemPresente extends PedidoDecorator {

    public EmbalagemPresente(Pedido pedido) {
        super(pedido);
    }

    public float getPercentualValor() {
        return 2;
    }

    public String getNomeDescricao() {
        return "Embalagem";
    }
}
