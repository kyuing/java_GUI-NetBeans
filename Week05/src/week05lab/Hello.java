/*
 * View: All the code related to the visual aspect of our programme; Frame
 * This class is another view that is controlled by Controller class.
 *
 * Controller class intervenes in between LoginView and Hello.
 * 
 * Technically, this class has nothing to do with LoginView calss in its functionality.
 * it visually outouts a result only as ordered.
 */
package week05lab;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Hello extends JFrame {
    
    public Hello(User userInfo) {
        //specified constructor that take the instance of User as a parameter
        
        this.setVisible(true);  //set this Hello frame visible
        this.setSize(150, 150); //give a size to this Hello frame
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE); //close the window && the program when x is clicked
        
        JPanel panel = new JPanel();    //create a panel
        this.add(panel);    //add panel to this Hello frame
        
        /**
         * The reason userInfo is passed as a parameter is explained here. 
         * By passing <instance>userInfo</instance> to this Hello class as a parameter, 
         * no any repetitive code is necessary to get the existing specific value
         */ 
        JLabel label = new JLabel("Hello, " + userInfo.getName() + "!");    //create label with a text.
        panel.add(label); //add label to this Hello frame
        System.out.println("The User name '" + userInfo.getName() + "' has been authorized.");
        
        this.validate();
        this.repaint();
    }
    
}
