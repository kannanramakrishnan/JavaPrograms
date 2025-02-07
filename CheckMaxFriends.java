// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Student {
    private final String name;
    private final List<Student> friends;

    public Student(String name, List<Student> friends) {
        this.name = name;
        this.friends = friends != null ? new ArrayList<>(friends) : new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Student> getFriends() {
        return new ArrayList<>(friends); // Defensive copy for immutability
    }
}
public class Main  {
    public static void main(String[] args) {
        
        Student alice = new Student("Alice", new ArrayList<>());
        Student bob = new Student("Bob", Arrays.asList(alice));
        Student charlie = new Student("Charlie", Arrays.asList(alice, bob));
        Student dave = new Student("Dave", Arrays.asList(alice, bob, charlie));
        
       List<Student> sList = Arrays.asList(alice, bob, charlie, dave);
       Optional<Student> maxFriends = sList.stream().max(Comparator.comparingInt(s -> s.getFriends().size()));
       maxFriends.ifPresent(s->System.out.println("name: "+s.getName()));
       
    }
}
