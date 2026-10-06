package padroesestruturais.decorator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    @Test
    void deveRetornarValorPedido() {
        Pedido pedido = new PedidoBasico(1000.0f);

        assertEquals(1000.0f, pedido.getValor(), 0.1f);
    }

    @Test
    void deveRetornarValorPedidoComSeguro() {
        Pedido pedido = new Seguro(new PedidoBasico(1000.0f));

        assertEquals(1050.0f, pedido.getValor(), 0.1f);
    }

    @Test
    void deveRetornarValorPedidoComEmbalagemPresente() {
        Pedido pedido = new EmbalagemPresente(new PedidoBasico(1000.0f));

        assertEquals(1020.0f, pedido.getValor(), 0.1f);
    }

    @Test
    void deveRetornarValorPedidoComGarantiaEstendida() {
        Pedido pedido = new GarantiaEstendida(new PedidoBasico(1000.0f));

        assertEquals(1100.0f, pedido.getValor(), 0.1f);
    }

    @Test
    void deveRetornarValorPedidoComSeguroMaisEmbalagemPresente() {
        Pedido pedido = new Seguro(new EmbalagemPresente(new PedidoBasico(1000.0f)));

        assertEquals(1071.0f, pedido.getValor(), 0.1f);
    }

    @Test
    void deveRetornarValorPedidoComGarantiaEstendidaMaisSeguro() {
        Pedido pedido = new GarantiaEstendida(new Seguro(new PedidoBasico(1000.0f)));

        assertEquals(1155.0f, pedido.getValor(), 0.1f);
    }

    @Test
    void deveRetornarValorPedidoComGarantiaEstendidaMaisEmbalagemPresente() {
        Pedido pedido = new GarantiaEstendida(new EmbalagemPresente(new PedidoBasico(1000.0f)));

        assertEquals(1122.0f, pedido.getValor(), 0.1f);
    }

    @Test
    void deveRetornarValorPedidoComGarantiaEstendidaMaisSeguroMaisEmbalagemPresente() {
        Pedido pedido = new GarantiaEstendida(new Seguro(new EmbalagemPresente(new PedidoBasico(1000.0f))));

        assertEquals(1178.1f, pedido.getValor(), 0.1f);
    }

    @Test
    void deveRetornarDescricaoPedido() {
        Pedido pedido = new PedidoBasico(1000.0f);

        assertEquals("Pedido basico", pedido.getDescricao());
    }

    @Test
    void deveRetornarDescricaoPedidoComSeguro() {
        Pedido pedido = new Seguro(new PedidoBasico(1000.0f));

        assertEquals("Pedido basico/Seguro", pedido.getDescricao());
    }

    @Test
    void deveRetornarDescricaoPedidoComEmbalagemPresente() {
        Pedido pedido = new EmbalagemPresente(new PedidoBasico(1000.0f));

        assertEquals("Pedido basico/Embalagem", pedido.getDescricao());
    }

    @Test
    void deveRetornarDescricaoPedidoComGarantiaEstendida() {
        Pedido pedido = new GarantiaEstendida(new PedidoBasico(1000.0f));

        assertEquals("Pedido basico/Garantia", pedido.getDescricao());
    }

    @Test
    void deveRetornarDescricaoPedidoComSeguroMaisEmbalagemPresente() {
        Pedido pedido = new Seguro(new EmbalagemPresente(new PedidoBasico(1000.0f)));

        assertEquals("Pedido basico/Embalagem/Seguro", pedido.getDescricao());
    }

    @Test
    void deveRetornarDescricaoPedidoComGarantiaEstendidaMaisSeguro() {
        Pedido pedido = new GarantiaEstendida(new Seguro(new PedidoBasico(1000.0f)));

        assertEquals("Pedido basico/Seguro/Garantia", pedido.getDescricao());
    }

    @Test
    void deveRetornarDescricaoPedidoComGarantiaEstendidaMaisEmbalagemPresente() {
        Pedido pedido = new GarantiaEstendida(new EmbalagemPresente(new PedidoBasico(1000.0f)));

        assertEquals("Pedido basico/Embalagem/Garantia", pedido.getDescricao());
    }

    @Test
    void deveRetornarDescricaoPedidoComGarantiaEstendidaMaisSeguroMaisEmbalagemPresente() {
        Pedido pedido = new GarantiaEstendida(new Seguro(new EmbalagemPresente(new PedidoBasico(1000.0f))));

        assertEquals("Pedido basico/Embalagem/Seguro/Garantia", pedido.getDescricao());
    }
}