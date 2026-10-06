package padroesestruturais.bridge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClienteAssinaturaTest {

    @Test
    void deveRetornarClienteAssinaturaPix() {
        FormaPagamento pagamento = new Pix();
        ClienteAssinatura cliente = new ClienteAssinatura(1000.0f);
        cliente.setFormaPagamento(pagamento);
        assertEquals(902.5f, cliente.calcularTotal(), 0.01f);
    }

    @Test
    void deveRetornarClienteAssinaturaBoleto() {
        FormaPagamento pagamento = new Boleto();
        ClienteAssinatura cliente = new ClienteAssinatura(1000.0f);
        cliente.setFormaPagamento(pagamento);
        assertEquals(950, cliente.calcularTotal(), 0.01f);
    }
    @Test
    void deveRetornarClienteAssinaturaCartao() {
        FormaPagamento pagamento = new Cartao();
        ClienteAssinatura cliente = new ClienteAssinatura(1000.0f);
        cliente.setFormaPagamento(pagamento);
        assertEquals(997.5f, cliente.calcularTotal(), 0.01f);
    }


}