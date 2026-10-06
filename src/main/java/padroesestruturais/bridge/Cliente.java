package padroesestruturais.bridge;

public abstract class Cliente {

    protected FormaPagamento formaPagamento;

    protected float valorCompra;

    public Cliente(float valorCompra) {
        this.valorCompra = valorCompra;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public void setValorCompra(float valorCompra) {
        this.valorCompra = valorCompra;
    }

    public abstract float calcularTotal();
}