/*
 * View: All the code related to the visual aspect of our programme; Frame
 * no any technical approach in comtrolling is required. 
 * the more it visually represnts as controlled, the clearer it gets its role completed in full.
 */
package week05lab;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginView_ extends JFrame {
    
    private JTextField tf1, tf2, result;    //a private class level tfs
    private LoginController controllerRef;    //a private class level controller (a ref of Controller class)
    
    public LoginView_(LoginController controller) {
        //specified constructor
        
        //By instantiating View class in Controller class, the Controller class itself is passed (referenced) as a parameter
        //so the instance view in Controller class can reference it during its processes
        this.controllerRef = controller;
        
        loginFrameManager();    //loginFrameManager();
        conponents();   //conponents();
        validation();   //validation();
        
    }
    
    private void conponents() {
            
        JPanel loginPanel = new JPanel();   //declare a panel
        this.add(loginPanel);    //add loginPanel to this LogininView frame        
        
        tf1 = new JTextField(20);   //initialize tf with a preferred width
        loginPanel.add(tf1);    //add tf to loginPanel
        tf2 = new JTextField(20);   //initialize tf with a preferred width
        loginPanel.add(tf2);    //add tf to loginPanel
        JButton btn = new JButton("Login"); //declare a button with a text initialized
        loginPanel.add(btn);    //add btn to loginPanel
        
        /**
         * add an actionListener with 'controllerRef', the reference of the Controller, into btn
         * The original Controller class indirectly listens to an action via its ref.
         * <code>btn.addActionListener(this.controllerRef);</code> below needs to be specified,
         * so the instance view can access to LoginView
         * 
         * Now, the action added to btn is listened to by controllerRef, 
         * meaning that LoginView class doesn't need to implement ActionListener
         * (ActionListener has already been implemented in Controller class)
         * 
         * The rest of codes needed after an action picked is then implemented in the actionPerformed method in the Controller class */
        btn.addActionListener(this.controllerRef);
        btn.setActionCommand("actionB");    //set an action command to btn
        result = new JTextField(20);    //initialize tf with a preferred width
        result.setPreferredSize(new Dimension(0, 50));  //give some height to the current tf
        loginPanel.add(result); //add result(the current tf) to loginPanel
    }
    
    public void loginFrameManager() {
        
        this.setVisible(true); //set this View frame visible
        this.setSize(250,200);  //set a size to this LoginView frame
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE); //close the window && the program when x is clicked
}

    private void validation() {
        
        this.validate();
        this.repaint();
    }    
    
    public String getUserName() {
        //a getter for user name (1st getter); the resource for 2nd getter in userInfo class, the instance of User
        return this.tf1.getText();  
    }
    
    public String getUserPsw() {
        //a getter for user password (1st getter); the resource for 2nd getter in userInfo class, the instance of User
        return this.tf2.getText();
    }
    
    public void setResult(String userInfo) {
        //a setter for a resulting message. 
        this.result.setText(userInfo);
    }
}
