package padroescriacao.factorymethod;

public class NotificacaoSms implements INotificacao {

    public String enviarConfirmacao() {
        return "Confirmação do pedido enviada por sms";
    }

    public String enviarCancelamento() {
        return "Cancelamento do pedido enviado por sms";
    }
}