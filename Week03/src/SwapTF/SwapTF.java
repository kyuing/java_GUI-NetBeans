package SwapTF;

import java.awt.Font;
import static java.awt.Font.BOLD;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author HP
 */
public class SwapTF extends JFrame implements ActionListener {
    private JTextField tf1, tf2;    //class-level JTextfield variables that is accessed within a project range
    private JButton btn;    //class-level JButton variables that is accessed within a project range
    private JPanel p;   //class-level JPanel variables that is accessed within a project range
    
    public static void main(String[] args) {
        //invoke constructor
        new SwapTF();
    }
    public SwapTF() {
        
        p = new JPanel(new GridLayout(3,1));    //the panel p will have a 3X1 grid layout
        this.tf1 = new JTextField("text1"); //initialize tf1 and set text in it
        this.tf2 = new JTextField("text2"); //initialize tf2 and set text in it
        Font font1 = new Font("Arial", Font.BOLD, 30);  //create an instance of Font with a specified constructor having font name, style and size as parameters
        this.tf1.setFont(font1);   //set font1 to tf1
        this.tf2.setFont(new Font("Verdana", Font.ITALIC, 30)); //set a new font to tf2 by having a new Font class that has three parameteres of font name, style and size as a parameter.
        this.tf1.setHorizontalAlignment(SwingConstants.CENTER); //set the text set in tf1 to be in center. SwingConstants is an interface for alignment. SwingConstants.TOP/RIGHT/CENTER... is a parameter which has a its own attribute. 
        this.tf2.setHorizontalAlignment(SwingConstants.CENTER); //set the text set in tf2 to be in center
        this.btn = new JButton("swap"); //initialize btn and set text in it
        this.btn.setActionCommand("swapAC"); // set a string action command to btn
        this.btn.addActionListener(this);   //.addActionListener(interface ActionListener as parameter) will allow btn' action to be listened.
        p.add(tf1); //add tf1 to p at (0,0) of p = new JPanel(new GridLayout(3,1));
        p.add(tf2); //add tf2 to p at (1,0) of p = new JPanel(new GridLayout(3,1));
        p.add(btn); //add btn to p at (2,0) of p = new JPanel(new GridLayout(3,1));
        this.add(p);    //add p to this SwapTF class frame extended
        this.setSize(500, 500); //set size of this SwapTF class frame extended
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);  //terminate the GUI when x is clicked
        this.setVisible(true);  //lets get it visible.
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String ac = e.getActionCommand();   //ac takes an action command set in any of .setActionCommand();
        if (ac.equals("swapAC")) { //ac == swapAC 
                
            Stack stack = new Stack();  //create an instance of Stack. last-in-first-out (LIFO)
            stack.add(this.tf1.getText());  //add tf1's text set to stack
            stack.add(this.tf2.getText());  //add tf2's text set to stack
            //String one = this.tf1.getText();  this has the same result as when using stack
            //String two = this.tf2.getText();  this has the same result as when using stack
            
            //cast is required the codes below. it semms that when using .setText(stack.pop()), the value popped is not a string format so it needs to be casted to be a string.
            this.tf1.setText((String) stack.pop()); //set a new text to tf1 by popping the top value that is the value of tf2 in stack 
            this.tf2.setText((String) stack.pop()); //set a new text to tf2 by popping the top value that is the value of tf1 in stack 
            System.out.println("this.tf1.getText(); " + this.tf1.getText());
            System.out.println("this.tf2.getText(); " + this.tf2.getText());
            System.out.println();
         }
    }
}
