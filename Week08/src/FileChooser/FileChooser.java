/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileChooser;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class FileChooser extends JFrame{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        new FileChooser();
    }
    
    public FileChooser() {
        this.setVisible(true);
        this.setSize(300,300);
        
        JFileChooser fs = new JFileChooser();
        fs.showOpenDialog(this);
        File file = fs.getSelectedFile();
        System.out.println(file);
        

        this.validate();
        this.repaint();
    }    
}
