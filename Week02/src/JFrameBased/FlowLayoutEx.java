package JFrameBased;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FlowLayoutEx  extends JFrame {
    
    public static void main(String[] args) {
    
        //invoke constructor
        new FlowLayoutEx();
    }
    
       public FlowLayoutEx() {
    
        //here, this. means an instance of JFrame inherited 
       Dimension dim = new Dimension(600, 400);	//create an instance of Dimension with the Dimension (frame size) constructor parameters
       this.setLocation(980, 470); 	//set location of the JFrame instance
       this.setPreferredSize(dim);	//set preferredSize with dim to the JFrame instance
       this.setTitle("JTextFiled, JButton JLabel and FlowLayout");     //set title
      
       FlowLayout flowL = new FlowLayout();     //create an instance of FlowLayout (when using JLabel, it's not necessary)
       this.setLayout(flowL);   //set flowL to the JFrame instance
        
        JLabel jLabel = new JLabel("Enter text");  //create an instance of JLabel with a specified constructor having a string parameter
        JTextField textField = new JTextField(20);  //create an instance of JTextField with a specified constructor having column parameter. 20 will determine an horizontal size of textField
        textField.setToolTipText("text goes here");     //user-friendly comment
        JButton jButton = new JButton("Submit");    //create an instance of JButton with a specified constructor having a string parameter
        
        /****************************************
         * public void addActionListener(ActionListener l) {    *
         *   listenerList.add(ActionListener.class, l);                   *
         * }                                                                                             *
         ***************************************/
        jButton.addActionListener(new ActionListener() {    //add actionListener to JButton
            /***********************************************
             *  public interface ActionListener extends EventListener {         *
             *         //Invoked when an action occurs.                                          *
             *          public void actionPerformed(ActionEvent e);                    *
             *       }                                                                                                         *
            ***********************************************/  
           @Override
           public void actionPerformed(ActionEvent e) {
               
                jLabel.setText(textField.getText());    //set text with textField.getText()  to jLabel
                textField.setText("");  //erase textField
           }//end of public void actionPerformed(ActionEvent e)
       } );//end of jButton.addActionListener
      
        //BorderLayout is horizontal layout and is not workable in this program since I am using FlowLayout first.
        this.add(jLabel, BorderLayout.NORTH); //add jLabel assigning its BorderLayout.NORTH to the JFrame instance
        this.add(textField, BorderLayout.CENTER);   //add textFiled assigning its BorderLayout.Center to the JFrame instance
        this.add(jButton, BorderLayout.SOUTH);    //add jButton assigning its BorderLayout.SOUTH to the JFrame instance
        this.setVisible(true);  //make everything visible
        this.pack();    //pack it
        this.validate();    //Validates this container and all of its subcomponents.
        this.repaint(); //Repaints this component
    }
    
}
