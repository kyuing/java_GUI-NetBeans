package LabWeek03;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Confirmation extends JFrame implements ActionListener {
    
    public Confirmation() {
            
        this.setVisible(true);  //set class Confirmation extends JFrame implements ActionListener visible
        this.setSize(200, 200); //set size
        this.setLocation(950, 440); //set the frame location
        JPanel mainP = new JPanel(new GridLayout(2,1)); //create a main panel. (2,1)
        this.add(mainP);    //add mainP to this Confirmation class's frame inherited
        JLabel displayConfirm = new JLabel("Are you sure?");   //dreate an instance of JLabel using a specified constructor having a string parameter in JLabel class
        mainP.add(displayConfirm); //add displayConfirm to this Confirmation class's frame inherited at (0,0) of JPanel mainP = new JPanel(new GridLayout(2,1))
        JPanel bottomP = new JPanel(new GridLayout(1,2));   //create bottomP that has (1,2) grid in it. bottomP at the same time is also at (1,0) of JPanel mainP = new JPanel(new GridLayout(2,1)) 
        mainP.add(bottomP); //add bottmP to this Confirmation class's frame inherited
        JButton b1 = new JButton("YES");   //create b1 setting its string as "YES"
        JButton b2 = new JButton("NO"); //create b2 setting its string as "NO"
        bottomP.add(b1); //add b1 to bottomP at (0,0) of JPanel bottomP = new JPanel(new GridLayout(1,2));
        bottomP.add(b2); //add b2 to bottomP at (0,1) of JPanel bottomP = new JPanel(new GridLayout(1,2));
        b1.setActionCommand("acYES");   //set an action command with a string preferred to b1. Remember that the string set as a parameter in b1 has nothing to do with .setActionCommand().
        b2.setActionCommand("acNO");    //set an action command with a string preferred to b2. Remember that the string set as a parameter in b1 has nothing to do with .setActionCommand()
        b1.addActionListener(this); //add an action listener to this Confirmation class that extends JFrame implementing ActionListener. Roughly speaking, Comfirmation class can simultaneously be regarded as an instance of the interface Actionlistener in a sense since 'this' is the parameter of this code.
        b2.addActionListener(this); //same as the above.
                    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String yes = e.getActionCommand();  //store the action command set in any of .setActionCommand()
            if(yes.equals("acYES")) { //you don't know how many components used .setActionCommand() so find what is appropriate at a point by using .equals()
                System.out.println("good bye");
                System.exit(0); //terminate the program 
            }else {
                //if not, acNO for now
                System.out.println("just closed the 2nd GUI.");
                this.setVisible(false); //just make this Confirmation class's frame inherited invisible
                
        }
    }
}
