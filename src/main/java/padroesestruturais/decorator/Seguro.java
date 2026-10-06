package padroesestruturais.decorator;

public class Seguro extends PedidoDecorator {

    public Seguro(Pedido pedido) {
        super(pedido);
    }

    public float getPercentualValor() {
        return 5;
    }

    public String getNomeDescricao() {
        return "Seguro";
    }
}
