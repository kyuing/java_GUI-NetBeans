package week01;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainWeek01 extends JFrame{

    public static void main(String[] args) {
        // this main can be invoked in a separate class but JFrame must be extended again. 
        new MainWeek01();
    }
    
    public MainWeek01() {
    
        //here, this. means an instance of JFrame inherited 
        
        this.setVisible(true);
        this.setSize(600, 400);
        this.setTitle("Title");
        
        //JPanel is a logical panel (container)
        JPanel jPanel = new JPanel();   //create an instance of JPanel with a default constructor
        this.add(jPanel);   //add the instance of JPanel to the JFrame inherited
        
        JLabel jLabel = new JLabel("Hello World");  //create an instance of JLabel with a specified constructor having a string parameter
        jPanel.add(jLabel); //add the instance of JLabel to the JPanel instantiated
        
        for (int i=0; i<10; i++) {
            JButton jButton = new JButton("Button");    //create an instance of JButton with a specified constructor having a string parameter
            jPanel.add(jButton);    //add the instance of JButton to the JPanel instantiated
            //jPanel.add(jButton + (i+1));    //this does not work in netBeans why?
        }
        
        
        this.validate();    //Validates this container and all of its subcomponents.
        this.repaint(); //Repaints this component
    }
    
}
