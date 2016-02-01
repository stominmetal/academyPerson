
package academy.person;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Person class
 * @author izosa
 */
public class Person {
    
    private String firstName;
    private String surname;
    private String EGN;

    public Person(String firstName, String surname, String EGN) {
        this.firstName = firstName;
        this.surname = surname;
        this.EGN = EGN;
    }
    
    public String fullName(){
        return this.firstName + " " + this.surname;
    }
    
    public String monthOfBirth(){
        
        Integer month = Integer.parseInt(this.EGN.substring(2, 4));

        // проверка за всички родени след 31.12.1999
        if(month > 12){
            month = month-40;
        }
        
        // check http://docs.oracle.com/javase/6/docs/api/java/text/SimpleDateFormat.html
        
        Date date = null;
        try {
            date = new SimpleDateFormat("M").parse(month.toString());
        } catch (ParseException ex) {
            Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
        }
        String result = new SimpleDateFormat("MMMMM").format(date);

        return result;
    }
    
    public Boolean checkEGN(){
        
        Boolean result = true;
        
        // Проверка на дължината
        if(this.EGN.length() != 10){
            return false;
        }
        
        // Преубразуване на String в int array
        
        int[] values = new int[this.EGN.length()];
        for (int i=0; i<this.EGN.length(); i++){
            values[i] = new Integer(String.valueOf(this.EGN.charAt(i)));
        }
        

        // 1. Всяка цифра се умножава със съответното ѝ тегло (виж таблицата)
        // 2. Получените произведения се сумират
        
        int sum= 0;
        
        sum += values[0] * 2;
        sum += values[1] * 4;
        sum += values[2] * 8;
        sum += values[3] * 5;
        sum += values[4] * 10;
        sum += values[5] * 9;
        sum += values[6] * 7;
        sum += values[7] * 3;
        sum += values[8] * 6;
        
        // 3. Сумата се дели на 11 като се взема остатъка
        int reminder = sum % 11;

        
        // 4. Ако остатъкът от делението е по-малък от 10, тогава той се взема като контролна цифра, иначе – 0
        
        int check;
        
        if(reminder < 10){
            check = reminder;
        } else {
            check = 0;
        }
        
        // проверка на контролната сума
        if(check != values[9])
        {
            return false;
        }
        
        return result;
    }
    
}
