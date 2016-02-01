package academy.person;

/**
 *
 * @author aisdata
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Person person = new Person("Ivan", "Petrov", "9810152323");
        System.out.println(person.fullName());
        System.out.println(person.monthOfBirth());
        System.out.println(person.checkEGN());
    }
    
}
