import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {

    public String getBotUsername() {

        return "isThisTokentoobot";
    }

    public String getBotToken() {
        return "5820259174:AAEngP9P8KY7iIx_9T73jIvx18LM8FMaNuk";
    }

    public void onUpdateReceived(Update update) {
        System.out.println(update.getMessage().getText());
        System.out.println(update.getMessage().getFrom().getFirstName());




        String command=update.getMessage().getText();
        if(command.equals("/hello")){
            String str="hello"+update.getMessage().getFrom().getFirstName().toString();
            SendMessage sendMessage=new SendMessage();
            sendMessage.setChatId(update.getMessage().getChatId().toString());
            sendMessage.setText(str);
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
