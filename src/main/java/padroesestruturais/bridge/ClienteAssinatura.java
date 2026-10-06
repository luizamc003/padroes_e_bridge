package padroesestruturais.bridge;

public class ClienteAssinatura extends Cliente {

    public ClienteAssinatura(float valorCompra) {
        super(valorCompra);
    }

    public float calcularTotal() {
        float valorComDesconto = this.valorCompra * 0.95f; // desconto
        return valorComDesconto * (1 + (this.formaPagamento.getPercentualAjuste() / 100));
    }
}