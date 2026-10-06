package padroescriacao.abstractfactory;

public class FabricaEntregaExpressa implements FabricaAbstrata {

    @Override
    public Frete createFrete() { return new FreteExpresso(); }

    @Override
    public Prazo createPrazo() { return new PrazoExpresso(); }
}