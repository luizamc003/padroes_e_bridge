package padroesestruturais.decorator;

public class PedidoBasico implements Pedido {

    public float valor;

    public PedidoBasico(float valor) {
        this.valor = valor;
    }

    public String getDescricao(){
        return "Pedido basico";
    }

    @Override
    public float getValor() {
        return this.valor;
    }
}
