/*
 * Static doesn't require any instantiation approach. 
 * The source class should be specified.
 */
package StaticAccess;

import JOptionPane.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //comment out one of the follwing depending on non-static and static
        
        
        //any method including static methods in a class can be retireved by an instantiation
        
        
        NewClass newClass = new NewClass(); //an instance
        System.out.println("* instantiation");
        newClass.hi();  //public void hi()
        newClass.bye(); //public static void bye() 
        
        /*************************************************************************/
        //static method in a class can be retireved with no any instantiation
        System.out.println("\n* static access");
        NewClass.hii();
        NewClass.bye();
    }
}
