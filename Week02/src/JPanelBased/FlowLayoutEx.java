package JPanelBased;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FlowLayoutEx  extends JFrame{
    
    public static void main(String[] args) {
        //invoke constructor
        new FlowLayoutEx();
    }
    
       public FlowLayoutEx() {
    
        //here, this. means an instance of JFrame inherited 
       Dimension dim = new Dimension(600, 400);	//create an instance of Dimension with the Dimension (frame size) constructor parameters
       this.setLocation(980, 470); 	//set location of frame
       this.setPreferredSize(dim);	//set the dimension(size) of frame at axis (700, 300)
       this.setTitle("JTextFiled, JButton JLabel and FlowLayout"); //set title
        
       //Since JPanel is being used, you don't have to declare FlowLayout. JPanel works like FlowLayout
        JPanel jPanel = new JPanel();   //create an instance of JPanel with a default constructor. JPanel is a logical panel (container)
        
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
                textField.setText("");   //erase textField
           }
       } );
       
        //BorderLayout is horizontal layout and is not workable in this program since JTextfield, JButton and JLabel are used in one JPanel
        this.add(jPanel);   //add the instance of JPanel to the JFrame inherited
        jPanel.add(jLabel, BorderLayout.NORTH); //add jLabel assigning its BorderLayout.NORTH to the JFrame instance
        jPanel.add(textField, BorderLayout.CENTER); //add textFiled assigning its BorderLayout.Center to the JFrame instance
        jPanel.add(jButton, BorderLayout.SOUTH);    //add jButton assigning its BorderLayout.SOUTH to the JFrame instance
        this.setVisible(true);  //make everything visible
        this.pack();     //pack it
        this.validate();    //Validates this container and all of its subcomponents.
        this.repaint(); //Repaints this component
    }
    
}
