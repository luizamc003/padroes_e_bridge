package padroescriacao.abstractfactory;

public class Entrega {

    private Frete frete;
    private Prazo prazo;

    public Entrega (FabricaAbstrata fabrica) {
        this.frete = fabrica.createFrete();
        this.prazo = fabrica.createPrazo();
    }

    public float calcularFrete() {
        return this.frete.calcular();
    }

    public String informarPrazo() {
        return this.prazo.informar();
    }
}
