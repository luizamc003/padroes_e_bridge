package padroescriacao.factorymethod;

public class NotificacaoWhatsApp implements INotificacao {

    public String enviarConfirmacao() {
        return "Confirmação do pedido enviada por whatsApp";
    }

    public String enviarCancelamento() {
        return "Cancelamento do pedido enviado por whatsApp";
    }
}