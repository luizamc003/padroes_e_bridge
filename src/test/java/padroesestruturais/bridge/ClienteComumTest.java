package padroesestruturais.bridge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClienteComumTest {

    @Test
    void deveRetornarClienteComumPix() {
        FormaPagamento pagamento = new Pix();
        ClienteComum cliente = new ClienteComum(1000.0f);
        cliente.setFormaPagamento(pagamento);
        assertEquals(950.0f, cliente.calcularTotal(), 0.01f);
    }

    @Test
    void deveRetornarClienteComumBoleto() {
        FormaPagamento pagamento = new Boleto();
        ClienteComum cliente = new ClienteComum(1000.0f);
        cliente.setFormaPagamento(pagamento);
        assertEquals(1000, cliente.calcularTotal(), 0.01f);
    }
    @Test
    void deveRetornarClienteComumCartao() {
        FormaPagamento pagamento = new Cartao();
        ClienteComum cliente = new ClienteComum(1000.0f);
        cliente.setFormaPagamento(pagamento);
        assertEquals(1050.0f, cliente.calcularTotal(), 0.01f);
    }


}