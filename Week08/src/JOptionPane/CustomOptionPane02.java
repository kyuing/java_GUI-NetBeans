package JOptionPane;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Q
 */
public class CustomOptionPane02 extends JFrame{

    public static void main(String[] args) {
        
        new CustomOptionPane02();
    }
    
    public CustomOptionPane02() {
        this.setVisible(true);
        this.setSize(300,300);
        
        String[] options = {"op01","op02", "op03", "op04"};
        
        String selector = (String) JOptionPane.showInputDialog(
                this, //Component parentComponent
                "message goes here", //Object message
                "title",  //String title
                JOptionPane.PLAIN_MESSAGE,  //public static final int   PLAIN_MESSAGE = -1; /** No icon is used. */
                null,
                options, //Object[] options
                options[0]  //Object initialValue. this can be null
                );
        //output the option selected on this parent Component
        JOptionPane.showMessageDialog(this, selector + " is selected");

        this.validate();
        this.repaint();
    }    
}
