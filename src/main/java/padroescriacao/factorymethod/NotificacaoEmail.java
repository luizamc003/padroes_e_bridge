package padroescriacao.factorymethod;

public class NotificacaoEmail implements INotificacao {

    public String enviarConfirmacao() {
        return "Confirmação do pedido enviada por email";
    }

    public String enviarCancelamento() {
        return "Cancelamento do pedido enviado por email";
    }
}