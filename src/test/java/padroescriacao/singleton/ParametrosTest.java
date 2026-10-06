package padroescriacao.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParametrosTest {

    @Test
    public void deveRetornarNomeLoja() {
        Parametros.getInstance().setNomeLoja("Loja 1");
        assertEquals("Loja 1", Parametros.getInstance().getNomeLoja());
    }

    @Test
    public void deveRetornarUsuario() {
        Parametros.getInstance().setUsuarioLogado("Usuario 1");
        assertEquals("Usuario 1", Parametros.getInstance().getUsuarioLogado());
    }

}