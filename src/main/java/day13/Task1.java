package day13;

public class Task1 {
    public static void main(String[] args) {
        User user1 = new User("ivan");
        User user2 = new User("nikolay");
        User user3 = new User("vasiliy");

        user1.sendMessage(user2, "привет, Николай!");
        user1.sendMessage(user2, "это Ванек");

        user2.sendMessage(user1, "здорово, ванек");
        user2.sendMessage(user1, "как жизнь молодая?");
        user2.sendMessage(user1, "давно мы не общались тут");

        user3.sendMessage(user1, "эй ты, ванек");
        user3.sendMessage(user1, "я тебе уже который раз пишу");
        user3.sendMessage(user1, "когда отдашь мою кепку?");

        user1.sendMessage(user3, "здравствуйте, василий");
        user1.sendMessage(user3, "я первый раз от вас получаю сообщения");
        user1.sendMessage(user3, "какая кепка? ты попутал?");

        user3.sendMessage(user1, "простите, перепутал я");

        MessageDatabase.showDialog(user1, user2);
    }
}
