package day13;

import java.util.ArrayList;
import java.util.List;

public class MessageDatabase {
    private static final List<Message> messages = new ArrayList<>();

    private MessageDatabase() {
    }

    public static void sendMessage(User u1, User u2, String text) {
        Message message = new Message(u1, u2, text);
        messages.add(message);
    }

    public static List<Message> getMessages() {
        return messages;
    }

    public static void showDialog(User u1, User u2) {
        List<Message> filteredMessages = messages.stream()
                .filter(message ->
                        (message.getSender().equals(u1) || message.getSender().equals(u2))
                        && (message.getReceiver().equals(u1) || message.getReceiver().equals(u2))
                )
                .sorted((m1, m2) -> m1.getCreatedAt().compareTo(m2.getCreatedAt()))
                .toList();

        for (Message message : filteredMessages) {
            System.out.println(message.getSender().getUsername() + ": " + message.getText());
        }
    }
}
