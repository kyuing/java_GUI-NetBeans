package JOptionPane;

import java.awt.Component;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Q
 */
public class CustomOptionPane01 extends JFrame{

    public static void main(String[] args) {
        
        new CustomOptionPane01();
    }
    
    public CustomOptionPane01() {
        this.setVisible(true);
        this.setSize(300,300);
                
        String[] options = {"op01","op02", "op03", "op04", "op05"};
        int index_no = JOptionPane.showOptionDialog(
                this, //Component parentComponent
                "YES OR NO MESSAGES", //Object message
                "title", //String title 
                JOptionPane.YES_NO_OPTION,  //int messageType public static final int         YES_NO_OPTION = 0;
                JOptionPane.QUESTION_MESSAGE,   //Icon icon
                null,
                options, //Object[] options
                options[1]  //Object initialValue. this can be null
                );
        
        //returns index number of the string array options beginning at 0
        JOptionPane.showMessageDialog(this, index_no); 

        this.validate();
        this.repaint();
    }    
}
