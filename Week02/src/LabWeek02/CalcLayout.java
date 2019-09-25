package LabWeek02;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalcLayout  extends JFrame {
    
    public static void main(String[] args) {
        //invoke constructor
        new CalcLayout();
    }
    
       public CalcLayout() {
    
        //here, this. means an instance of JFrame inherited 
       Dimension dim = new Dimension(500, 400);     //create an instance of Dimension with the Dimension (frame size) constructor parameters
       this.setLocation(980, 470); 	//set location of frame
       this.setPreferredSize(dim);	//set the dimension(size) of frame at axis (700, 300)
       this.setTitle("Calc Layout ");   //set a title text
       
       BorderLayout outer = new BorderLayout();  //create an instance of BorderLayout using the default constructor
       this.setLayout(outer);   //set an outer layout to the Frame inherited. It won't look different since the BorderLayout instance "outer" is set into the frame directly.
       
       JTextField tf = new JTextField(15);   //add the instance of JTextField having 15 col size to tf
       tf.setPreferredSize(new Dimension(30, 50));  //set a preferred width and height size to tf by having an instance of Dimension class as a parameter
       this.add(tf, BorderLayout.NORTH);    //add tf assigning BorderLayout.NORTH to the JFrame inherited 
       
       BorderLayout inner = new BorderLayout(); //create an instance of BorderLayout using the default constructor
       JPanel mainPanel = new JPanel();       //create an instance of JPanel using its default constructor
       /****************************************************************************************
       *set an inner layout to mainPanel. In this case, it does look different from not using .setLayout();  when running GUI. *
       *by using .setLayout(BorderLayout instance) at an appropriate point, a component sets its size and goes responsive  *
       * within its superordinate component                                                                                                                                                     *
       *****************************************************************************************/
       mainPanel.setLayout(inner);  
       this.add(mainPanel, BorderLayout.CENTER);    //add mainPanel assigning BorderLayout.CENTER to the JFrame inherited 
       
       JPanel innerPanelTop = new JPanel();       //create an instance of JPanel using its default constructor
       mainPanel.add(innerPanelTop, BorderLayout.NORTH);    //add innerPanelTop assigning BorderLayout.NORTH to mainPanel
       
       JPanel innerPanelBotton = new JPanel();       //create an instance of JPanel using its default constructor
       mainPanel.add(innerPanelBotton, BorderLayout.CENTER);    //add innerPanelBotton assigning BorderLayout.NORTH to mainPanel
       
       for (int i=0; i<5; i++) {
           JButton  topBtn = new JButton("opBtn" + (i+1)); //create an instance of JButton with a specified constructor having a string parameter
            innerPanelTop.add(topBtn);  //add btns to innerPanelTop
       }
       
       innerPanelBotton.setLayout(new GridLayout(6,4));     //set a layout using GridLayout instance which has 6 rows and 4 colums as a parameter for innerPanelBotton
       for (int i=0; i<24; i++) {
           JButton  bottomBtn = new JButton();  //create an instance of JButton with a default constructor
           bottomBtn.setText("btn" + (i+1));    //set text to bottomBtn
           
           //innerPanelBotton will apply .setLayout() to itself much more responsively as innerPanelBotton is based on a grid
            innerPanelBotton.add(bottomBtn);    //add bottomBtn to innerPanelBotton
       }
       
        this.setVisible(true);  //get everything visible
        this.pack();    //pack everything
        this.validate();    //Validates this container and all of its subcomponents.
        this.repaint(); //Repaints this component
    }
    
}
