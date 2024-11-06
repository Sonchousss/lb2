import java.time.Period;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class User implements Comparable<User>{
    private final int id;
    private String name;
    private String lastName;
    private LocalDateTime birthDate;
    private Country country;

    public int getId() {return id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}

    public LocalDateTime getBirthDate() {return birthDate;}
    public void setBirthDate(LocalDateTime birthDate) {this.birthDate = birthDate;}
    public int getAde()
    {
        LocalDateTime now = LocalDateTime.now();
        Period period = Period.between(birthDate.toLocalDate(), now.toLocalDate());
        return period.getYears();
    }

    public Country getCountry() {return country;}
    public void setCountry(Country country) {this.country = country;}

    public User(int id, String name, String lastName, LocalDateTime birthDate, Country country) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.country = country;
    }

    public static List<User> sortByLastName(List<User> users)
    {
        List<User> userCopy = new ArrayList<User>(users);
        Collections.sort(userCopy);
        return userCopy;
    }

    @Override
    public int compareTo(User o) {
        return lastName.compareTo(o.lastName);
    }
    static public  List<User> sortByAge(List<User> users)
    {
        List<User> userCopy = new ArrayList<User>(users);
        Collections.sort(userCopy, new ComparatorByAge());
        return userCopy;
    }

    static private class ComparatorByAge implements Comparator<User> {
        @Override
        public int compare(User o1, User o2) {
            return Double.compare(o1.getAde(), o2.getAde());
        }
    }

    static public boolean ageMore7(List<User> users)
    {
        for(User user : users)
        {
            if (user.getAde() < 7)
            {return false;}
        }
        return true;
    }

    static public int avgAge(List<User> users)
    {
        int avgAge = 0;
        for (User user : users)
        {
            avgAge += user.getAde();
        }
        avgAge = avgAge/users.size();
        return avgAge;
    }

    static public HashMap<Country, Integer> userCoutryCount(List<User> users)
    {
        HashMap<Country, Integer> count = new HashMap<>();
        for (User user : users)
        {
            if (!count.containsKey(user.country))
                count.put(user.country, 1);
            else
                count.put(user.country, count.get(user.getCountry()) + 1);
        }
        return count;
    }

    @Override
    public String toString()
    {
        return name+" "+lastName+" "+birthDate.toLocalDate()+" "+this.getAde()+" "+country;
    }



}
