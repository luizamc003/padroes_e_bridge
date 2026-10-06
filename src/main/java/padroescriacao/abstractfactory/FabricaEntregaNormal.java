package padroescriacao.abstractfactory;

public class FabricaEntregaNormal implements FabricaAbstrata {

    @Override
    public Frete createFrete() { return new FreteNormal(); }

    @Override
    public Prazo createPrazo() { return new PrazoNormal(); }
}