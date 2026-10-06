package padroesestruturais.decorator;

public abstract class PedidoDecorator implements Pedido {

    private Pedido pedido;

    private String descricao;

    public PedidoDecorator(Pedido pedido) {
        this.pedido = pedido;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public abstract float getPercentualValor();

    public float getValor() {
        return this.pedido.getValor() * (1 + (this.getPercentualValor() / 100));
    }

    public abstract String getNomeDescricao();

    public String getDescricao(){
        return this.pedido.getDescricao() + "/" + this.getNomeDescricao();
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }


}


