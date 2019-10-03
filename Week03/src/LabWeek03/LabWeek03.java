package LabWeek03;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

class LabWeek03 extends JFrame implements ActionListener {
    private JTextField tf;  //a private class level JTextFiled variable tf
    private JMenuItem itemC;    //a class level JMenuIem variable itemC
    
    LabWeek03() {
        
        frameManager(); //invoke frameManager
    
    }
    
    public void frameManager() {
        
        //here, this. means this Calc class that inherits of JFrame which implements ActionListener.
       Dimension dim = new Dimension(500, 400);     //create an instance of Dimension with the Dimension (frame size) constructor parameters
       this.setLocation(980, 470); 	//set location of frame
       this.setPreferredSize(dim);	//set the dimension(size) of frame at axis (700, 300)
       this.setTitle("Calc Layout, menu bar");   //set a title text
       
       JMenuBar menuBar = new JMenuBar();   //create an instance of JMenubar with the default constructor
       this.setJMenuBar(menuBar);   //set menuBar to this Calc class
       JMenu menu = new JMenu("File");  //create an instance of JMenu with a specified constructor that has a string parameter
       menuBar.add(menu);   //add menu to menuBar
       JMenu subMenu = new JMenu("subMenu");    //create an instance of JMenu with a specified constructor that has a string parameter
       menu.add(subMenu);   //add subMenu to menu. JMenu can have another JMenu in it
       JMenuItem itemInSubMenu =  new JMenuItem("item In SubMenu"); //create an instance of JMenuItem with a specified constructor that has a string parameter
       subMenu.add(itemInSubMenu);  //add itemInSubMenu to subMenu
       this.itemC =  new JMenuItem("Close");    //create an instance of JMenuItem with a specified constructor that has a string parameter
       this.itemC.setActionCommand("closeAC");  //set an action command with a string action to itemC
       menu.add(this.itemC);    //add itemC to menu
       this.itemC.addActionListener(this); //add actionListener to itemC. the parameter this roughly means Actionliener class which has actionPerformed(ActionEvent e){} but does actually means the whole context of class Calc extends JFrame implements ActionListener {}
       
       BorderLayout outer = new BorderLayout();  //create an instance of BorderLayout using the default constructor
       this.setLayout(outer);   //set an outer layout to the Frame inherited. It won't look different since the BorderLayout instance "outer" is set into the frame directly.
       
       this.tf = new JTextField(15);   //add the instance of JTextField having 15 col size to tf
       this.tf.setPreferredSize(new Dimension(0, 50));  //set a preferred width and height size to tf by having an instance of Dimension class as a parameter
       this.add(this.tf, BorderLayout.NORTH);    //add tf assigning BorderLayout.NORTH to the JFrame inherited 
       
       BorderLayout inner = new BorderLayout(); //create an instance of BorderLayout using the default constructor
       JPanel mainPanel = new JPanel();       //create an instance of JPanel using its default constructor
       /****************************************************************************************
       *set an inner layout to mainPanel. In this case, it does look different from not using .setLayout();  when running GUI. *
       *by using .setLayout(BorderLayout instance) at an appropriate point, a component sets its size and goes responsive  *
       * within its superordinate component                                                                                                                                                     *
       *****************************************************************************************/
       mainPanel.setLayout(inner);  
       this.add(mainPanel, BorderLayout.CENTER);    //add mainPanel assigning BorderLayout.CENTER to the JFrame inherited 
       
//       BorderLayout innerPanelTopBolder = new BorderLayout(); //create an instance of BorderLayout using the default constructor. //not in use
       JPanel innerPanelTop = new JPanel();       //create an instance of JPanel using its default constructor
       mainPanel.add(innerPanelTop, BorderLayout.NORTH);    //add innerPanelTop assigning BorderLayout.NORTH to mainPanel
       
       JPanel innerPanelBotton = new JPanel();       //create an instance of JPanel using its default constructor
       mainPanel.add(innerPanelBotton, BorderLayout.CENTER);    //add innerPanelBotton assigning BorderLayout.NORTH to mainPanel
       
       innerPanelTop.setLayout(new GridLayout(1,5));    //set a layout of innerPanelTop to be 1 row 5 cols
//        innerPanelTop.setLayout(innerPanelTopBolder); //not in use
        String[] topBtnSource = {"MC", "MR", "M+", "M-", "MS"}; //create a string array for btn names
       for (int i=0; i<5; i++) {
           JButton  topBtn = new JButton(topBtnSource[i]); //create an instance of JButton with a specified constructor having a string parameter. the value in topBtnsource[i] is string.
            innerPanelTop.add(topBtn);  //add topBtn to innerPanelTop
            topBtn.addActionListener(this); //add actionListener to topBtn
       }
       
       innerPanelBotton.setLayout(new GridLayout(6,4));     //set a layout using GridLayout instance which has 6 rows and 4 colums as a parameter for innerPanelBotton
       String[] bottomBtnSource = {"%", "V", "^", "1/x", "CE", "C", "<=", "/", "7", "8", "9", "*", "4", "5", "6", "-", "1", "2", "3", "+", "+-", "0", ".", "="}; //a tring array having btn sources
       for (int i=0; i<24; i++) {
           JButton  bottomBtn = new JButton(bottomBtnSource[i]);  //create an instance of JButton with a specified constructor having a string parameter. the array bottmBtn goes there
           //innerPanelBotton will apply .setLayout() to itself much more responsively as innerPanelBotton is based on a grid
            innerPanelBotton.add(bottomBtn);    //add bottomBtn to innerPanelBotton
            bottomBtn.addActionListener(this);  //add addActionListener method that takes the JFrame inherited which is this Calc class as a parameter to bottomBtn
       }
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);  //close the program when x is cliecked
        this.setVisible(true);  //get everything visible
        this.pack();    //pack everything
        this.validate();    //Validates this container and all of its subcomponents.
        this.repaint(); //Repaints this component
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String getAC = e.getActionCommand(); //store the action command set in any of .setActionCommand()

        if (getAC.equals("closeAC")){   //you don't know how many components used .setActionCommand() so find what is appropriate at a point by using .equals()
            Confirmation conf = new Confirmation(); //create an instance of Confirmation class with the default constructor
            conf.setVisible(true);  //make conf visible
        }
    }
    
     public static void main(String[] args) {
        //invoke constructor LabWeek03()
        new LabWeek03();
    }
    
}
