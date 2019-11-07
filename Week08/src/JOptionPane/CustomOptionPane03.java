package JOptionPane;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Q
 */
public class CustomOptionPane03 extends JFrame{

    public static void main(String[] args) {
       
        new CustomOptionPane03();
    }
    
    public CustomOptionPane03() {
        
        this.setVisible(true);
        this.setSize(300,300);
        
        String s = (String) JOptionPane.showInputDialog(
                this, //Component parentComponent
                "message goes here", //Object message
                "title", //String title 
                JOptionPane.PLAIN_MESSAGE,  // public static final int   PLAIN_MESSAGE = -1;  /** No icon is used. */
                null,
                null,    //Object[] options
                null     //Object initialValue. 
                );
        //output the plain text input as a result (JLabel-like return)
        JOptionPane.showMessageDialog(this, s);

        this.validate();
        this.repaint();
    }    
}
