package padroescriacao.abstractfactory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EntregaTest {

    @Test
    void deveCalcularFreteNormalPrazoNormal() {
        FabricaAbstrata fabrica = new FabricaEntregaNormal();
        Entrega entrega = new Entrega(fabrica);
        assertEquals("entrega em até 7 dias", entrega.informarPrazo());
    }

    @Test
    void deveCalcularFreteNormalEntregaNormal() {
        FabricaAbstrata fabrica = new FabricaEntregaNormal();
        Entrega entrega = new Entrega(fabrica);
        assertEquals(15.0f, entrega.calcularFrete(), 0.01f);
    }

    @Test
    void deveCalcularFreteExpressoPrazoNormal() {
        FabricaAbstrata fabrica = new FabricaEntregaExpressa();
        Entrega entrega = new Entrega(fabrica);
        assertEquals("entrega em até 2 dias", entrega.informarPrazo());
    }

    @Test
    void deveCalcularFreteExpressoEntregaNormal() {
        FabricaAbstrata fabrica = new FabricaEntregaExpressa();
        Entrega entrega = new Entrega(fabrica);
        assertEquals(30.0f, entrega.calcularFrete(), 0.01f);
    }

}