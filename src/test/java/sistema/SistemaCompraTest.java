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

    // Monta uma compra de 1000 e devolve o total
    private float calcular(FabricaAbstrata entrega, Cliente cliente, FormaPagamento pagamento) {
        cliente.setFormaPagamento(pagamento);
        SistemaCompra sistema = new SistemaCompra(new PedidoBasico(1000.0f), entrega, cliente, "NotificacaoEmail");
        return sistema.calcularTotal();
    }

    // Monta uma compra e devolve a mensagem final
    private String finalizar(FabricaAbstrata entrega, String notificacao) {
        Cliente cliente = new ClienteComum(0);
        cliente.setFormaPagamento(new Boleto());
        SistemaCompra sistema = new SistemaCompra(new PedidoBasico(1000.0f), entrega, cliente, notificacao);
        return sistema.finalizarCompra();
    }

    // ===== Entrega Normal (1000 + 15 = 1015) =====

    @Test
    void deveCalcularEntregaNormalClienteComumBoleto() {
        assertEquals(1015.0f, calcular(new FabricaEntregaNormal(), new ClienteComum(0), new Boleto()), 0.01f);
    }

    @Test
    void deveCalcularEntregaNormalClienteComumCartao() {
        assertEquals(1065.75f, calcular(new FabricaEntregaNormal(), new ClienteComum(0), new Cartao()), 0.01f);
    }

    @Test
    void deveCalcularEntregaNormalClienteComumPix() {
        assertEquals(964.25f, calcular(new FabricaEntregaNormal(), new ClienteComum(0), new Pix()), 0.01f);
    }

    @Test
    void deveCalcularEntregaNormalClienteAssinaturaBoleto() {
        assertEquals(964.25f, calcular(new FabricaEntregaNormal(), new ClienteAssinatura(0), new Boleto()), 0.01f);
    }

    @Test
    void deveCalcularEntregaNormalClienteAssinaturaCartao() {
        assertEquals(1012.46f, calcular(new FabricaEntregaNormal(), new ClienteAssinatura(0), new Cartao()), 0.01f);
    }

    @Test
    void deveCalcularEntregaNormalClienteAssinaturaPix() {
        assertEquals(916.04f, calcular(new FabricaEntregaNormal(), new ClienteAssinatura(0), new Pix()), 0.01f);
    }

    // ===== Entrega Expressa (1000 + 30 = 1030) =====

    @Test
    void deveCalcularEntregaExpressaClienteComumBoleto() {
        assertEquals(1030.0f, calcular(new FabricaEntregaExpressa(), new ClienteComum(0), new Boleto()), 0.01f);
    }

    @Test
    void deveCalcularEntregaExpressaClienteComumCartao() {
        assertEquals(1081.5f, calcular(new FabricaEntregaExpressa(), new ClienteComum(0), new Cartao()), 0.01f);
    }

    @Test
    void deveCalcularEntregaExpressaClienteComumPix() {
        assertEquals(978.5f, calcular(new FabricaEntregaExpressa(), new ClienteComum(0), new Pix()), 0.01f);
    }

    @Test
    void deveCalcularEntregaExpressaClienteAssinaturaBoleto() {
        assertEquals(978.5f, calcular(new FabricaEntregaExpressa(), new ClienteAssinatura(0), new Boleto()), 0.01f);
    }

    @Test
    void deveCalcularEntregaExpressaClienteAssinaturaCartao() {
        assertEquals(1027.42f, calcular(new FabricaEntregaExpressa(), new ClienteAssinatura(0), new Cartao()), 0.01f);
    }

    @Test
    void deveCalcularEntregaExpressaClienteAssinaturaPix() {
        assertEquals(929.58f, calcular(new FabricaEntregaExpressa(), new ClienteAssinatura(0), new Pix()), 0.01f);
    }

    // ===== Com serviços extras (Decorator junto com o resto) =====


    // ===== Todos os serviços + Entrega Normal (1178.1 + 15 = 1193.1) =====

    // Monta uma compra com todos os serviços extras e devolve o total
    private float calcularComServicos(FabricaAbstrata entrega, Cliente cliente, FormaPagamento pagamento) {
        Pedido pedido = new GarantiaEstendida(new Seguro(new EmbalagemPresente(new PedidoBasico(1000.0f))));
        cliente.setFormaPagamento(pagamento);
        SistemaCompra sistema = new SistemaCompra(pedido, entrega, cliente, "NotificacaoSms");
        return sistema.calcularTotal();
    }

    @Test
    void deveCalcularTodosServicosEntregaNormalClienteComumBoleto() {
        assertEquals(1193.1f, calcularComServicos(new FabricaEntregaNormal(), new ClienteComum(0), new Boleto()), 0.01f);
    }

    @Test
    void deveCalcularTodosServicosEntregaNormalClienteComumCartao() {
        assertEquals(1252.76f, calcularComServicos(new FabricaEntregaNormal(), new ClienteComum(0), new Cartao()), 0.01f);
    }

    @Test
    void deveCalcularTodosServicosEntregaNormalClienteComumPix() {
        assertEquals(1133.45f, calcularComServicos(new FabricaEntregaNormal(), new ClienteComum(0), new Pix()), 0.01f);
    }


    @Test
    void deveCalcularTodosServicosEntregaNormalClienteAssinaturaBoleto() {
        assertEquals(1133.45f, calcularComServicos(new FabricaEntregaNormal(), new ClienteAssinatura(0), new Boleto()), 0.01f);
    }

    @Test
    void deveCalcularTodosServicosEntregaNormalClienteAssinaturaCartao() {
        assertEquals(1190.12f, calcularComServicos(new FabricaEntregaNormal(), new ClienteAssinatura(0), new Cartao()), 0.01f);
    }

    @Test
    void deveCalcularTodosServicosEntregaNormalClienteAssinaturaPix() {
        assertEquals(1076.77f, calcularComServicos(new FabricaEntregaNormal(), new ClienteAssinatura(0), new Pix()), 0.01f);
    }

    // ===== Todos os serviços + Entrega Expressa (1178.1 + 30 = 1208.1) =====

    @Test
    void deveCalcularTodosServicosEntregaExpressaClienteComumBoleto() {
        assertEquals(1208.1f, calcularComServicos(new FabricaEntregaExpressa(), new ClienteComum(0), new Boleto()), 0.01f);
    }

    @Test
    void deveCalcularTodosServicosEntregaExpressaClienteComumCartao() {
        assertEquals(1268.50f, calcularComServicos(new FabricaEntregaExpressa(), new ClienteComum(0), new Cartao()), 0.01f);
    }

    @Test
    void deveCalcularTodosServicosEntregaExpressaClienteComumPix() {
        assertEquals(1147.69f, calcularComServicos(new FabricaEntregaExpressa(), new ClienteComum(0), new Pix()), 0.01f);
    }


    @Test
    void deveCalcularTodosServicosEntregaExpressaClienteAssinaturaBoleto() {
        assertEquals(1147.69f, calcularComServicos(new FabricaEntregaExpressa(), new ClienteAssinatura(0), new Boleto()), 0.01f);
    }

    @Test
    void deveCalcularTodosServicosEntregaExpressaClienteAssinaturaCartao() {
        assertEquals(1205.08f, calcularComServicos(new FabricaEntregaExpressa(), new ClienteAssinatura(0), new Cartao()), 0.01f);
    }

    @Test
    void deveCalcularTodosServicosEntregaExpressaClienteAssinaturaPix() {
        assertEquals(1090.31f, calcularComServicos(new FabricaEntregaExpressa(), new ClienteAssinatura(0), new Pix()), 0.01f);
    }


    // ===== Finalização: 3 notificações × 2 entregas =====

    @Test
    void deveFinalizarPorEmailComEntregaNormal() {
        Parametros.getInstance().setUsuarioLogado("Maria");
        assertEquals("Olá, Maria! Confirmação do pedido enviada por e-mail. entrega em até 7 dias ",
                finalizar(new FabricaEntregaNormal(), "NotificacaoEmail"));
    }

    @Test
    void deveFinalizarPorEmailComEntregaExpressa() {
        Parametros.getInstance().setUsuarioLogado("Maria");
        assertEquals("Olá, Maria! Confirmação do pedido enviada por e-mail. entrega em até 2 dias",
                finalizar(new FabricaEntregaExpressa(), "NotificacaoEmail"));
    }

    @Test
    void deveFinalizarPorSmsComEntregaNormal() {
        Parametros.getInstance().setUsuarioLogado("Ana");
        assertEquals("Olá, Ana! Confirmação do pedido enviada por SMS. entrega em até 7 dias",
                finalizar(new FabricaEntregaNormal(), "NotificacaoSms"));
    }

    @Test
    void deveFinalizarPorSmsComEntregaExpressa() {
        Parametros.getInstance().setUsuarioLogado("Ana");
        assertEquals("Olá, Ana! Confirmação do pedido enviada por SMS. entrega em até 2 dias",
                finalizar(new FabricaEntregaExpressa(), "NotificacaoSms"));
    }

    @Test
    void deveFinalizarPorWhatsAppComEntregaNormal() {
        Parametros.getInstance().setUsuarioLogado("João");
        assertEquals("Olá, João! Confirmação do pedido enviada por WhatsApp. entrega em até 7 dias",
                finalizar(new FabricaEntregaNormal(), "NotificacaoWhatsApp"));
    }

    @Test
    void deveFinalizarPorWhatsAppComEntregaExpressa() {
        Parametros.getInstance().setUsuarioLogado("João");
        assertEquals("Olá, João! Confirmação do pedido enviada por WhatsApp. Entrega em até 2 dias",
                finalizar(new FabricaEntregaExpressa(), "NotificacaoWhatsApp"));
    }

    // ===== Erro =====

    @Test
    void deveRetornarExcecaoParaNotificacaoInexistente() {
        Cliente cliente = new ClienteComum(0);
        cliente.setFormaPagamento(new Pix());

        assertThrows(IllegalArgumentException.class,
                () -> new SistemaCompra(new PedidoBasico(1000.0f), new FabricaEntregaNormal(), cliente, "Carta"));
    }
}