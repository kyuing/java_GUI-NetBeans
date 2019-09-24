package JFrameBased;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GridLayoutEx  extends JFrame {
    
    public static void main(String[] args) {
        //invoke constructor
        new GridLayoutEx();
    }
    
       public GridLayoutEx() {
    
        //here, this. means an instance of JFrame inherited 
       Dimension dim = new Dimension(600, 400);	//create an instance of Dimension with the Dimension (frame size) constructor parameters
       this.setLocation(980, 470); 	//set location of frame
       this.setPreferredSize(dim);	//set the dimension(size) of frame at axis (700, 300)
       this.setTitle("JTextFiled, JButton JLabel and GridLayout"); //set title
        
      /* how GridLayout works is that
           it does its best effort within a given condition.
           for example,
           you have GridLayout ex = new GridLayout(1,1);
           you then have btn1 btn2 and btn3 to put into the grid
           GridLayout executes one row as given. it will never change
           GridLayout then creates 3 more colums so it should be (1,3) at final.
           btn1 is assinged at (0,0)
           btn2 is assinged at (0,1)
           btn3 is assinged at (0,2)
       */
       GridLayout gridL = new GridLayout(3,1);  //create an instance of GridLayout with a specified constructor having x y axis parameterers
       this.setLayout(gridL);   //set girdL to the JFrame instance
        
        JLabel jLabel = new JLabel("Enter text");  //create an instance of JLabel with a specified constructor having a string parameter
        JTextField textField = new JTextField(20);  //create an instance of JTextField with a specified constructor having column parameter. 20 will determine an horizontal size of textField
        textField.setToolTipText("text goes here"); //user-friendly comment
        JButton jButton = new JButton("Submit");    //create an instance of JButton with a specified constructor having a string parameter
        
        //add an instance of ActionListener to jButton
        jButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               //invoked when an action occured
                jLabel.setText(textField.getText());    //set text with textField.getText()  to jLabel
                textField.setText("");  //erase textField
           }
       } );
      
        this.add(jLabel); //add the instance of JLabel to the JFrame instance
        this.add(textField);    //add the instance of JTextField to the JFrame instance
        this.add(jButton);    //add the instance of JButton to the JFrame instance
        this.setVisible(true);  //get everything visible
        this.pack();    //pack it
        this.validate();    //Validates this container and all of its subcomponents.
        this.repaint(); //Repaints this component
    }
    
}
