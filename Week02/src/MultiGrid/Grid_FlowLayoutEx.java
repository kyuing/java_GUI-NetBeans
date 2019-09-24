package MultiGrid;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Grid_FlowLayoutEx  extends JFrame {
    
    public static void main(String[] args) {
    
        new Grid_FlowLayoutEx();
    }
    
       public Grid_FlowLayoutEx() {
    
        //here, this. means an instance of JFrame inherited 
       Dimension dim = new Dimension(600, 400);     //create an instance of Dimension with the Dimension (frame size) constructor parameters
       this.setLocation(980, 470); 	//set location of frame
       this.setPreferredSize(dim);	//set the dimension(size) of frame at axis (700, 300)
       this.setTitle("Multiple Grid Layout");   //set a title text
        
       GridLayout gridL = new GridLayout(1,2);  //create 1x2 grid layout
       this.setLayout(gridL);   //set gridL to the Frame instance
       
       JPanel p1 = new JPanel();   //create an instance of JPanel with a default constructor
       p1.setLayout(new GridLayout(3,1));   //set a new 3x1 GridLayout to p1
       JPanel p2 = new JPanel();   //create an instance of JPanel with a default constructor
       p2.setLayout(new GridLayout(2,1));   //set a new 2x1 GridLayout to p2
       
       for (int i=0; i<3; i++) {
           //add new JButtons which use a specified constructor having a string parameter to p1 for  i<3 so that you can make 3 btns
           p1.add(new JButton("btn" + (i +1)));
       }
       
       for (int i=0; i<2; i++) {
           //add new JButtons which use a specified constructor having a string parameter to p1 for  i<2 so that you can make 2 btns
           p2.add(new JButton("btn" + (i +1)));
       }
         
       this.add(p1);    //add p1 to the JFrame  inheritance
       this.add(p2);    //add p2 to the JFrame  inheritance
        this.setVisible(true);  //letz make it visible
        this.pack();    //pack it
        this.validate();    //Validates this container and all of its subcomponents.
        this.repaint(); //Repaints this component
    }
    
}
