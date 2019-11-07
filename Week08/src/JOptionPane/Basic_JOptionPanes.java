package JOptionPane;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class Basic_JOptionPanes extends JFrame{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        new Basic_JOptionPanes();
    }
    
    public Basic_JOptionPanes() {
        
        this.setVisible(true);
        this.setSize(300,300);
        
        /**
        * Brings up an information-message dialog titled "Message".
        *
        * @param parentComponent determines the <code>Frame</code> in
        *          which the dialog is displayed; if <code>null</code>,
        *          or if the <code>parentComponent</code> has no
        *          <code>Frame</code>, a default <code>Frame</code> is used
        * @param message   the <code>Object</code> to display
        * @exception HeadlessException if
        *   <code>GraphicsEnvironment.isHeadless</code> returns
        *   <code>true</code>
        * @see java.awt.GraphicsEnvironment#isHeadless
        */
        //any pane is central-located as far as the parent component is assigned to be a parameter 
        JOptionPane.showMessageDialog(this, "message goes here");
        
        //warning pane changing symbol and title
        JOptionPane.showMessageDialog(this, "warning message goes here", "WARNING", JOptionPane.WARNING_MESSAGE);
        
        //error pane changing symbol and title
        JOptionPane.showMessageDialog(this, "error message goes here", "ERROR", JOptionPane.ERROR_MESSAGE);
        
        /** 
         * Type used for <code>showConfirmDialog</code>. 
         * public static final int         YES_NO_OPTION = 0;
         * YES returns 0
         * NO returns 1
         */
        int n = JOptionPane.showConfirmDialog(this, "confirmation message goes here", "CONFIRMATION", JOptionPane.YES_NO_OPTION);
        JOptionPane.showMessageDialog(this, n);
        
        
        this.validate();
        this.repaint();
    }
    
}
