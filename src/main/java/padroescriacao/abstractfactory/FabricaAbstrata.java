package padroescriacao.abstractfactory;

public interface FabricaAbstrata {
    Frete createFrete();
    Prazo createPrazo();
}
