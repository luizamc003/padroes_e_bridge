package sistema;

import org.junit.jupiter.api.Test;
import padroescriacao.abstractfactory.FabricaAbstrata;
import padroescriacao.abstractfactory.FabricaEntregaExpressa;
import padroescriacao.abstractfactory.FabricaEntregaNormal;
import padroescriacao.singleton.Parametros;
import padroesestruturais.bridge.*;
import padroesestruturais.decorator.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SistemaCompraTest {

    private float calcular(FabricaAbstrata entrega, Cliente cliente, FormaPagamento pagamento) {
        cliente.setFormaPagamento(pagamento);
        SistemaCompra sistema = new SistemaCompra(new PedidoBasico(1000.0f), entrega, cliente, "Email");
        return sistema.calcularTotal();
    }

    private String finalizar(FabricaAbstrata entrega, String notificacao) {
        Cliente cliente = new ClienteComum(0);
        cliente.setFormaPagamento(new Boleto());
        SistemaCompra sistema = new SistemaCompra(new PedidoBasico(1000.0f), entrega, cliente, notificacao);
        return sistema.finalizarCompra();
    }


    @Test
    void deveFinalizarPorEmailComEntregaNormal() {
        Parametros.getInstance().setUsuarioLogado("Maria");
        assertEquals("Olá, Maria! Confirmação do pedido enviada por email. entrega em até 7 dias",
                finalizar(new FabricaEntregaNormal(), "Email"));
    }

    @Test
    void deveFinalizarPorEmailComEntregaExpressa() {
        Parametros.getInstance().setUsuarioLogado("Maria");
        assertEquals("Olá, Maria! Confirmação do pedido enviada por email. entrega em até 2 dias",
                finalizar(new FabricaEntregaExpressa(), "Email"));
    }

    @Test
    void deveFinalizarPorSmsComEntregaNormal() {
        Parametros.getInstance().setUsuarioLogado("Ana");
        assertEquals("Olá, Ana! Confirmação do pedido enviada por sms. entrega em até 7 dias",
                finalizar(new FabricaEntregaNormal(), "Sms"));
    }

    @Test
    void deveFinalizarPorSmsComEntregaExpressa() {
        Parametros.getInstance().setUsuarioLogado("Ana");
        assertEquals("Olá, Ana! Confirmação do pedido enviada por sms. entrega em até 2 dias",
                finalizar(new FabricaEntregaExpressa(), "Sms"));
    }

    @Test
    void deveFinalizarPorWhatsAppComEntregaNormal() {
        Parametros.getInstance().setUsuarioLogado("João");
        assertEquals("Olá, João! Confirmação do pedido enviada por whatsApp. entrega em até 7 dias",
                finalizar(new FabricaEntregaNormal(), "WhatsApp"));
    }

    @Test
    void deveFinalizarPorWhatsAppComEntregaExpressa() {
        Parametros.getInstance().setUsuarioLogado("João");
        assertEquals("Olá, João! Confirmação do pedido enviada por whatsApp. entrega em até 2 dias",
                finalizar(new FabricaEntregaExpressa(), "WhatsApp"));
    }


    @Test
    void deveRetornarExcecaoParaNotificacaoInexistente() {
        Cliente cliente = new ClienteComum(0);
        cliente.setFormaPagamento(new Pix());

        assertThrows(IllegalArgumentException.class,
                () -> new SistemaCompra(new PedidoBasico(1000.0f), new FabricaEntregaNormal(), cliente, "Carta"));
    }


    // ===== Pagamentos com Entrega Normal (1000 + 15 = 1015) =====

    @Test
    void deveCalcularEntregaNormalClienteComumPix() {
        assertEquals(964.25f, calcular(new FabricaEntregaNormal(), new ClienteComum(0), new Pix()), 0.01f);
    }

    @Test
    void deveCalcularEntregaNormalClienteComumBoleto() {
        assertEquals(1015.0f, calcular(new FabricaEntregaNormal(), new ClienteComum(0), new Boleto()), 0.01f);
    }

    @Test
    void deveCalcularEntregaNormalClienteComumCartao() {
        assertEquals(1065.75f, calcular(new FabricaEntregaNormal(), new ClienteComum(0), new Cartao()), 0.01f);
    }


    @Test
    void deveCalcularEntregaNormalClienteAssinaturaPix() {
        assertEquals(916.04f, calcular(new FabricaEntregaNormal(), new ClienteAssinatura(0), new Pix()), 0.01f);
    }

    @Test
    void deveCalcularEntregaNormalClienteAssinaturaBoleto() {
        assertEquals(964.25f, calcular(new FabricaEntregaNormal(), new ClienteAssinatura(0), new Boleto()), 0.01f);
    }

    @Test
    void deveCalcularEntregaNormalClienteAssinaturaCartao() {
        assertEquals(1012.46f, calcular(new FabricaEntregaNormal(), new ClienteAssinatura(0), new Cartao()), 0.01f);
    }

    // ===== Pagamentos com Entrega Expressa (1000 + 30 = 1030) =====

    @Test
    void deveCalcularEntregaExpressaClienteComumPix() {
        assertEquals(978.5f, calcular(new FabricaEntregaExpressa(), new ClienteComum(0), new Pix()), 0.01f);
    }

    @Test
    void deveCalcularEntregaExpressaClienteComumBoleto() {
        assertEquals(1030.0f, calcular(new FabricaEntregaExpressa(), new ClienteComum(0), new Boleto()), 0.01f);
    }

    @Test
    void deveCalcularEntregaExpressaClienteComumCartao() {
        assertEquals(1081.5f, calcular(new FabricaEntregaExpressa(), new ClienteComum(0), new Cartao()), 0.01f);
    }

    @Test
    void deveCalcularEntregaExpressaClienteAssinaturaPix() {
        assertEquals(929.58f, calcular(new FabricaEntregaExpressa(), new ClienteAssinatura(0), new Pix()), 0.01f);
    }

    @Test
    void deveCalcularEntregaExpressaClienteAssinaturaBoleto() {
        assertEquals(978.5f, calcular(new FabricaEntregaExpressa(), new ClienteAssinatura(0), new Boleto()), 0.01f);
    }

    @Test
    void deveCalcularEntregaExpressaClienteAssinaturaCartao() {
        assertEquals(1027.42f, calcular(new FabricaEntregaExpressa(), new ClienteAssinatura(0), new Cartao()), 0.01f);
    }
}
