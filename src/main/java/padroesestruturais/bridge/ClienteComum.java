package padroesestruturais.bridge;

public class ClienteComum extends Cliente {

    public ClienteComum(float valorCompra) {
        super(valorCompra);
    }

    public float calcularTotal() {
        return this.valorCompra * (1 + (this.formaPagamento.getPercentualAjuste() / 100));
    }
}