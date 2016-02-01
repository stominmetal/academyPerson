/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        
        
        Person person = new Person("Ivan", "Petrov", "9008145769");
        System.out.println(person.fullName());
        System.out.println(person.monthOfBirth());
        System.out.println(person.checkEGN());
       
        
        
        
    }
    
}
