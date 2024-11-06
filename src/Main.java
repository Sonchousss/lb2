import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.time.LocalDateTime;

public class Main {
    static public void printUsers(List<User> users)
    {
        for (User user : users)
            System.out.println(user);
        System.out.println();
    }
    public static void main(String[] args) {
        List<User> users = new ArrayList<User>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        users.add(new User(1639, "Игнат", "Лукошко", LocalDateTime.parse("2005-04-08 00:00", formatter), Country.BELARUS));
        users.add(new User(1639, "Иван", "Иванов", LocalDateTime.parse("2022-01-08 00:00", formatter), Country.RUSSIA));
        users.add(new User(1639, "Катерина", "Петрова", LocalDateTime.parse("2002-01-01 00:00", formatter), Country.RUSSIA));
        users.add(new User(1639, "Наталья", "Клачкова", LocalDateTime.parse("1985-05-17 00:00", formatter), Country.KAZAKHSTAN));
        users.add(new User(1639, "Рулан", "Бербир", LocalDateTime.parse("2009-11-30 00:00", formatter), Country.UZBEKISTAN));

        printUsers(users);
        printUsers(User.sortByLastName(users));
        printUsers(User.sortByAge(users));
        System.out.println(User.ageMore7(users));
        System.out.println(User.avgAge(users));
        System.out.println(User.userCoutryCount(users));

    }
}