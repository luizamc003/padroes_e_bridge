package padroescriacao.factorymethod;

//para testar os testes

public class NotificacaoCarta {

    public String enviarConfirmacao() {
        return "Confirmação do pedido enviada por sms";
    }

    public String enviarCancelamento() {
        return "Cancelamento do pedido enviado por sms";
    }
}