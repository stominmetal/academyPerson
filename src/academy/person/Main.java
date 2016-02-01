package academy.person;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Main class
 * @author izosa
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String firstName = Main.getInput("Въведете име: ");
        String surname = Main.getInput("Въведете фамилия: ");
        String EGN = Main.getInput("Въведете ЕГН: ");
        
        Person person = new Person(firstName, surname, EGN);
        System.out.println(person.fullName());
        System.out.println(person.monthOfBirth());
        System.out.println(person.checkEGN());
        
    }
    
    /**
     * Read data from console
     * @param prompt
     * @return 
     */
    private static String getInput(String prompt) {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

        System.out.print(prompt);
        System.out.flush();

        try {
            return stdin.readLine();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
    
}
