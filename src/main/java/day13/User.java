package day13;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private String username;
    private final List<User> subscriptions = new ArrayList<>();

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public List<User> getSubscriptions() {
        return subscriptions;
    }

    public void subscribe(User user) {
        if (! this.isSubscribed(user)) {
            subscriptions.add(user);
        }
    }

    public boolean isSubscribed(User user) {
        return subscriptions.contains(user);
    }

    public void sendMessage(User user, String text) {
        MessageDatabase.sendMessage(this, user, text);
    }

    @Override
    public String toString() {
        return "User{" +
               "username='" + username + '\'' +
               ", subscriptions=" + subscriptions +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username);
    }

    public boolean isFriend(User user) {
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(username);
    }
}
