package padroescriacao.factorymethod;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotificacaoFatoryTest {

    @Test
    void deveRetornarExcecaoParaNotificacaoInexistente() {
        try {
            INotificacao servico = NotificacaoFactory.obterNotificacao("Telegram");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Notificação inexistente", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoParaNotificaoInvalido() {
        try {
            INotificacao servico = NotificacaoFactory.obterNotificacao("Carta");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Notificação inválida", e.getMessage());
        }
    }
}