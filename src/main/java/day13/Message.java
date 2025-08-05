package day13;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;
import java.util.Locale;

public class Message {
    private final User sender;
    private final User receiver;
    private final String text;
    private LocalDateTime createdAt = LocalDateTime.now();

    public Message(User sender, User receiver, String text) {
        this.sender = sender;
        this.receiver = receiver;
        this.text = text;
    }

    public User getSender() {
        return sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {

        Formatter formatter = new Formatter();

        ZonedDateTime zdt = createdAt.atZone(ZoneId.of("Europe/Moscow"));

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss MSK yyyy", Locale.ENGLISH);

        String formattedDate = zdt.format(dateTimeFormatter) + " MSK";

        return formatter.format("""
                FROM: %s
                TO: %s
                ON: %s
                %s""", sender, receiver.getUsername(), formattedDate, text).toString();
    }
}
