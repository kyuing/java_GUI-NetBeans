package ReviewWeek02;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import javax.swing.JSplitPane;
import javax.swing.JTextField;
//import javax.swing.SwingConstants;

public class reviewWeek02 extends JFrame {
//    private String[] s = {"label1", "label2", "label3", "label4"}; not in use for now.
    public static void main(String[] args) {
        //invoke constructor
        new reviewWeek02();
    }
    
    public reviewWeek02() {
        /*================================================================== this. ===============================================================================*/
        this.setLocation(900, 400); //set  location (900, 400) to the instance frame of JFrame inherited
        //this.setSize(new Dimension(600, 400)); //set a preferred size with (600, 400) dimension to the instance frame of JFrame inherited
        this.setPreferredSize(new Dimension(600, 400)); //set a preferred size with (600, 400) dimension to the instance frame of JFrame inherited     
        BorderLayout outer = new BorderLayout();  //create an instance "outer" of  BorderLayout using the default constructor
       this.setLayout(outer);   //set outer to the instance frame of JFrame inherited
       
       /*================================================================= mainPanel in this. ==========================================================================*/
       BorderLayout inner = new BorderLayout();  //create an instance "inner" of  BorderLayout using the default constructor
       JPanel mainPanel = new JPanel();      //create an instance "mainPanel" of  JPanel using the default constructor
       mainPanel.setLayout(inner);   //set the BorderLayout instance "inner" to the JPanel instance "mainPanel"
       this.add(mainPanel, BorderLayout.CENTER);    //add "mainPanel" whose border layout is set to be in center to the instance frame of JFrame inherited
       
       /*=========================================================== innerWestPanel in mainPanel ======================================================================*/
       BorderLayout innerWest = new BorderLayout(); //create an instance "innerWest" of  BorderLayout using the default constructor
       JPanel innerWestPanel = new JPanel();    //create an instance "innerWestPanel" of  JPanel using the default constructor
       innerWestPanel.setLayout(innerWest);  //set the BorderLayout instance "inner" to  the JPanel instance "innerWestPanel"
       innerWestPanel.setLayout(new GridLayout(2,1));  //set a layout to the JPanel instance "innerWestPanel" by having an instance of GridLayout, which has a specified constructor with  (row, col) parameters, as a parameter 
       mainPanel.add(innerWestPanel, BorderLayout.CENTER);  //add "innerWestPanel" whose border layout is set to be in center to its superdinate JPanel instance "mainPanel". 
       //It must be .CENTER not .WEST. One of innerWestPanel and innerEastPanel dominate a central border layout so that the other one can take the rest of half the given capacity still being setting its  BorderLayout.EAST
       
      /*================================================================= IWTopPanel in innerWestPanel ===============================================================*/
       //I've tried to have one more panel for innerWestPanel to have a (2,1) grid at this point, but it worked based on border layout rather than on the grid layout set. left them commented out.
       //JPanel innerPanelBreaker = new JPanel();
       //innerWestPanel.add(innerPanelBreaker);
       //innerPanelBreaker.setLayout(new GridLayout(2,1));
       
       /* BorderLayout IWTop = new BorderLayout(); //this doesn't affect IWTopPanel since the IWTopPanel is in a grid */
       //create an instance "IWTopPanel" (Inner West Top Panel) of JPanel using the default constructor
        JPanel IWTopPanel = new JPanel();    //(0,0) based on innerWestPanel.setLayout(new GridLayout(2,1));
       /* IWTopPanel.setLayout(IWTop);  //this doesn't affect IWTopPanel since the IWTopPanel is in a grid */
        //innerPanelBreaker.add(IWTopPanel);
       innerWestPanel.add(IWTopPanel);  //add "IWTopPanel"  to its superdinate JPanel instance "innerWestPanel"
       IWTopPanel.setLayout(new GridLayout(1,2));    //set a layout to the JPanel instance "IWTopPanel" by having an instance of GridLayout, which has a specified constructor with  (row, col) parameters, as a parameter 
       
       /*================================================================= IWTWPanel in IWTopPanel ===============================================================*/
        //create an instance "IWTWPanel" (Inner West Top West Panel) of JPanel using the default constructor
       JPanel IWTWPanel = new JPanel(); //(0,0) based on IWTopPanel.setLayout(new GridLayout(1,2));
       IWTopPanel.add(IWTWPanel);   //add "IWTWPanel"  to its superdinate JPanel instance "IWTopPanel"
       IWTWPanel.setLayout(new GridLayout(4,1));    //set a layout to the JPanel instance "IWTWPanel" by having an instance of GridLayout, which has a specified constructor with  (row, col) parameters, as a parameter 
       for (int i=0; i<4; i++) {
           JLabel IWTWLabel = new JLabel("label" + (i+1));  //create an instance "IWTWLanel" (Inner West Top West Label) of JLabel using a specified constructor which has a string parameter 
            IWTWPanel.add(IWTWLabel);   //add "IWTWLabel"  to its superdinate JPanel instance "IWTWPanel"
       }
       /*================================================================= IWTEPanel in IWTopPanel ===============================================================*/
       //create an instance "IWTEPanel" (Inner West Top Eest Panel) of JPanel using the default constructor
        JPanel IWTEPanel = new JPanel();    //(0,1) based on IWTopPanel.setLayout(new GridLayout(1,2));
       IWTopPanel.add(IWTEPanel);    //add "IWTEPanel"  to its superdinate JPanel instance "IWTopPanel"
       IWTEPanel.setLayout(new GridLayout(4,1));     //set a layout to the JPanel instance "IWTEPanel" by having an instance of GridLayout, which has a specified constructor with  (row, col) parameters, as a parameter 
       for (int i=0; i<4; i++) {
           JTextField tf = new JTextField("textField"  + (i+1));    //create an instance "tf"  of JTextField using a specified constructor which has a string parameter 
            IWTEPanel.add(tf);  //add "tf"  to its superdinate JPanel instance "IWTEPanel"
       }
       //innerPanelBreaker.add(innerWestPanel);

       /*================================================================= IWBottomPanel in innerWestPanel ===============================================================*/
       /* BorderLayout IWBottom = new BorderLayout(); //this doesn't affect IWTopPanel since the IWTopPanel is in a grid */
       //create an instance "IWBottonPanel" (Inner West Bottom Panel) of JPanel using the default constructor
       JPanel IWBottonPanel = new JPanel(); //(1,0) based on innerWestPanel.setLayout(new GridLayout(2,1));
       /* IWBottonPanel.setLayout(IWBottom);  //this doesn't affect IWTopPanel since the IWTopPanel is in a grid */
        //innerPanelBreaker.add(IWBottonPanel);
        //innerPanelBreaker.setLayout(innerPanelBreaker.getSize()).height /2);  //not in use for now, but it will be really useful soon!
        //innerPanelBreaker.getSize()).height /2;   //not in use for now, but it will be really useful soon!
       innerWestPanel.add(IWBottonPanel);   //add "IWBottonPanel"  to its superdinate JPanel instance "innerWestPanel"
       IWBottonPanel.setLayout(new GridLayout(4,1));     //set a layout to the JPanel instance "IWBottonPanel" by having an instance of GridLayout, which has a specified constructor with  (row, col) parameters, as a parameter 
       for (int i=0; i<4; i++) {
           JLabel IWTopInfoReturned = new JLabel("some result goes here" + (i+1));   //create an instance "IWTopInfoReturned"  of JLabel using a specified constructor which has a string parameter 
           IWBottonPanel.add(IWTopInfoReturned);    //add "IWTopInfoReturned"  to its superdinate JPanel instance "IWBottonPanel"
       }
       //innerPanelBreaker.add(IWBottonPanel);  //not in use for now, but it will be really useful soon!
        //JSplitPane jsp = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true, IWTopPanel, IWBottonPanel);  //not in use for now, but it will be really useful soon!
        //jsp.setDividerLocation(getWidth() / 2);   //not in use for now, but it will be really useful soon!
        //setContentPane(jsp);  //not in use for now, but it will be really useful soon!
       
        /*=========================================================== innerEastPanel in mainPanel ======================================================================*/
       JPanel innerEestPanel = new JPanel();    //create an instance "innerEestPanel"  of JPanel using the default constructor
       mainPanel.add(innerEestPanel, BorderLayout.EAST);    //add "innerEestPanel" whose border layout is set to be in EAST to its superdinate JPanel instance "mainPanel"
       innerEestPanel.setLayout(new GridLayout(4,4));     //set a layout to the JPanel instance "innerEestPanel" by having an instance of GridLayout, which has a specified constructor with  (row, col) parameters, as a parameter 
       for (int i=0; i<16; i++) {
           JButton  btn = new JButton();  //create an instance "btn"  of JButton using the default constructor
           btn.setText("btn" + (i+1));    //set some text to btn
            innerEestPanel.add(btn);    //add "btn"  to its superdinate JPanel instance "innerEestPanel"
       }
       
       this.setVisible(true);  //get everything visible
        this.pack();    //pack everything. As I am using this.setPreferredSize(new Dimension(600, 400)); .pack() must be invoked.
        this.validate();    //Validates this container and all of its subcomponents.
        this.repaint(); //Repaints this component
       
    }
}
