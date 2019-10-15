/*
 * All the code related to the visual aspect of our programme; Frame
 */
package MVC_Example;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class View extends JFrame {
    
    private JTextField tf1, tf2, result;    //a private class level tfs
    private Controller controllerRef; //a private class level controller
    
    public View(Controller controller) {
        //specified constructor
        
        //By instantiating View class in Controller class, the Controller class itself is passed as a parameter
        //so the instance view can reference it during its processes
        this.controllerRef = controller;  
        frameManager(); //frameManager();
        conponents();   //conponents();
        validation();   //validation();
    }
    
    private void conponents() {
        
        JPanel topPanel = new JPanel(); //create topPanel
        JLabel label = new JLabel("MVC example"); //create label
        topPanel.add(label);    //add label set with some text to topPanel
        this.add(topPanel, BorderLayout.NORTH); //add topPanel to this View frame
        
        JPanel bottPanel = new JPanel(new GridLayout(4,1)); //create bottPanel which has 4X1 grid
        this.add(bottPanel, BorderLayout.CENTER);    //add bottPanel to this View frame
        
        tf1 = new JTextField(20);   //initialize tf with a preferred width
        bottPanel.add(tf1); //add tf to bottPanel
        tf2 = new JTextField(20);   //initialize tf with a preferred width
        bottPanel.add(tf2); //add tf to bottPanel
        JButton btn = new JButton("result");    //declare a button and set some text
        bottPanel.add(btn); //add btn to bottPanel
        
        /**
         * The original Controller class listens to an action and sums up the final result.
         * But its process goes indirectly by creating an instance of View
         * so that The Controller can retrieves all the info needed only without having to do tons of coding again and again from the instance of View.
         * 
         * To let the instance of View work as expected, the original Controller class is referenced on the top of this View class 
         * (private class-level declaration first && then initialization)
         * 
         * add an actionListener with 'controllerRef', the instance of the Controller, which is a reference-based object, into btn
         * 
         * Now, the action added to btn is listened to by controllerRef which doesn't require this View class to implement ActionListener
         * (ActionListener has already been implemented in Controller class)
         * and the rest of codes needed after the action picked is then implemented in the actionPerformed method in the Controller class
         */
        btn.addActionListener(this.controllerRef);  //Controller class 
        btn.setActionCommand("actionB");    //set an action command to btn
        result = new JTextField(20); //initialize tf with a preferred width
        bottPanel.add(result);  //add tf to bottPanel
        
    }
    
    public void frameManager() {
        
        this.setVisible(true); //set this View frame visible
        this.setPreferredSize(new Dimension(480,460));  //set a preferred size(350,350) to this View frame
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);  //close the window && the program when x is clicked
        this.pack();    //pack this View frame since .setPreferredSize() is being used
        
}

    private void validation() {
        
        this.validate();
        this.repaint();
    }    
    
    public int getNumOne() {
        //a getter for 1st number
        return Integer.parseInt(this.tf1.getText());
    }
    
    public int getNumTwo() {
        //a getter for 2nd number
        return Integer.parseInt(this.tf2.getText());
    }
    
    public void setResult(int added) {
        //a setter for tf to show the final result
        this.result.setText(String.valueOf(added));
    }
}
