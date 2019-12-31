package JComboBox;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Q
 */
public class JComboBox_exView extends JFrame {
    
    
    private JComboBox cusComboBox;  //a JComboBox for customer
    private JComboBoxController jcbControllerRef;   //controller ref
    
    protected DefaultTableModel dtm;    //dtm; protected access so the controller can access to the view
    protected JTable myTable;    //a table to show the selected customer row
    private String[] col = {"ID", "username", "fname", "lname", "email"};    //columns for the table
    private String[][] field;   //rows for the table
    
    private JComboBox admComboBox;  //a JComboBox for admin
    protected DefaultTableModel dtmAdm;    //dtmAdm; protected access so the controller can access to the view
    protected JTable myTableAdm;    //a table to show the selected customer row    
    protected JPanel bottP_grid, bottP_grid_admin; //panels that set GridLayout for customer and admins each.
    protected JRadioButton cus, adm;    //JRadioButtons for customers and admins
    
    public JComboBox_exView(JComboBoxController thisPassed) {
        //specific constructor. 
        this.jcbControllerRef = thisPassed; //initialize this.jcbControllerRef
    }
    
    public void components() {

        /****************************the view for customers********************************************/
        
        //top panel for JRadio btn
        
        //Create the radio buttons that allow one selection only. 
        String[] s = {"Customer", "Administrator"}; 
        cus = new JRadioButton(s[0]); 
        adm = new JRadioButton(s[1]); 
        cus.setName("cusRadioButton");  //this will work like action command
        adm.setName("admRadioButton");  //this will work like action command
        cus.addMouseListener(this.jcbControllerRef); //add ML to cusComboBox. 
        adm.addMouseListener(this.jcbControllerRef); //add ML to cusComboBox. 
        
        //set the default selection
        cus.setSelected(true); 

        //Group the radio buttons. 
        ButtonGroup group = new ButtonGroup(); 
        group.add(cus); 
        group.add(adm); 

        JPanel pRadio = new JPanel();   //a panel
        pRadio.add(cus);
        pRadio.add(adm);
        
        this.add(pRadio, BorderLayout.NORTH);   //add the panel to this frame
        
        //bottom panel
        String[] customerName;  //1d array customerName to be used in JComboBox
        
        //get the customer name returned from the model via the controller class
        customerName = jcbControllerRef.getCustomerName(); 

        cusComboBox = new JComboBox(customerName); //initialize cusComboBox with the array customerName
        cusComboBox.addActionListener(this.jcbControllerRef); //add AC to cusComboBox
        cusComboBox.setActionCommand("acFullName");     //add AC to cusComboBox
        cusComboBox.setPreferredSize(new Dimension(190,20));    //give a size to component

        JPanel pTop = new JPanel();    //a top panel
        pTop.add(cusComboBox); //add cusComboBox to pTop
        bottP_grid = new JPanel(new GridLayout(2,1));   //initialize the bottom panel with 2 rows, 1 col
        
        JPanel ptemp = new JPanel(new GridLayout(1,4)); //1X4 grid panel
        JPanel pHolder01 = new JPanel();    
        ptemp.add(pHolder01);   //(0,0)
        JPanel pLabel = new JPanel();
        JLabel nameLabel = new JLabel("                       Full name");
        pLabel.add(nameLabel);
        ptemp.add(pLabel);  //(0,1)
        ptemp.add(pTop);    //(0,2)
        JPanel pHolder02 = new JPanel();
        ptemp.add(pHolder02); //(0,3)

        bottP_grid.add(ptemp);   //(0.0) at the grid-based panel

       /**
        * the instances of defaultTableModel, JTable  
        * will be no longer in any specific use.
        * The purpose of them is on providing this view class with a initial setting
        * so that dynamic updates at the table can be implemented based on that.
        * Further detail is explained at JComboBox_exModel class */

       //create a new instance of JComboBox_exModel
       JComboBox_exModel rowSelector = new JComboBox_exModel();
       rowSelector.dbConnector();  //connect to DB

       this.field = rowSelector.selectCRowFromDB();    //now, this.field has 1st row of the table from the DB

       //initialize a new defaultTableModel with rows and columns as parameters repectively
       dtm = new DefaultTableModel(this.field, this.col);  

       //initialize myTable with the instance of the defaultTableModel as a parameter
       this.myTable = new JTable(dtm); 

       //declare and initialize a new JScrollPane. put the table in it.
       JScrollPane scrollPane = new JScrollPane(this.myTable);    
       scrollPane.setPreferredSize(new Dimension(750,300));    //set size for scrollPane

       JPanel pBott = new JPanel();    //a bott panel
       pBott.add(scrollPane); //add scrollPane to the pBott
       bottP_grid.add(pBott); //(1,0) at the grid-based panel
       this.add(bottP_grid, BorderLayout.CENTER); //add pBott to this frame


       /***************************the another view for admins***************************/
       //the same top panel which has JRadidoButtons will be shared here
       

        //bottom panel
        String[] adminName;  //1d array customerName to be used in JComboBox
        
        //get the admin name returned from the model via the controller class
        adminName = jcbControllerRef.getAdminName(); 

        admComboBox = new JComboBox(adminName); //initialize admComboBox with the array adminName
        admComboBox.addActionListener(this.jcbControllerRef); //add AC to admComboBox
        admComboBox.setActionCommand("acFullNameAdm");     //add AC to admComboBox
        admComboBox.setPreferredSize(new Dimension(190,20));    //give a size to component
        
        JPanel pTopAdm = new JPanel();    //a panel
        pTopAdm.add(admComboBox); //add admComboBox to the panel
        bottP_grid_admin = new JPanel(new GridLayout(2,1)); //initialize a panel with 2 rows & 1 col

        JPanel ptempRe = new JPanel(new GridLayout(1,4)); //1X4 grid panel
        JPanel pHolder03 = new JPanel();    
        ptempRe.add(pHolder03);   //(0,0)
        JPanel pLabelRe = new JPanel();
        JLabel nameLabelRe = new JLabel("                       Full name");
        pLabelRe.add(nameLabelRe);
        ptempRe.add(pLabelRe);  //(0,1)
        ptempRe.add(pTopAdm);    //(0,2)
        JPanel pHolder04 = new JPanel();
        ptempRe.add(pHolder04); //(0,3)

        bottP_grid_admin.add(ptempRe);   //(0.0) at the grid-based panel
        
       /**
        * the instances of defaultTableModel, JTable  
        * will be no longer in any specific use.
        * The purpose of them is on providing this view class with a initial setting
        * so that dynamic updates at the table can be implemented based on that.
        * Further detail is explained at JComboBox_exModel class */

       //create a new instance of JComboBox_exModel
       JComboBox_exModel rowSelectorAdm = new JComboBox_exModel();
       rowSelectorAdm.dbConnector();  //connect to DB

       this.field = rowSelectorAdm.selectAdmRowFromDB();    //now, this.field has 1st row of the table from the DB

       //initialize a new defaultTableModel with rows and columns as parameters repectively
       dtmAdm = new DefaultTableModel(this.field, this.col);  

       //initialize myTableAdm with the instance of the defaultTableModel as a parameter
       this.myTableAdm = new JTable(dtmAdm); 

       //declare and initialize a new JScrollPane. put the table in it.
       JScrollPane scrollPaneAdm = new JScrollPane(this.myTableAdm);    
       scrollPaneAdm.setPreferredSize(new Dimension(750,300));    //set size for scrollPane

       JPanel pBottAdm = new JPanel();    //a panel
       pBottAdm.add(scrollPaneAdm); //add scrollPane to the panel
       bottP_grid_admin.add(pBottAdm);  //(1,0) at the grid panel
       bottP_grid_admin.setVisible(false);  //set it to be invisible
       this.add(bottP_grid_admin, BorderLayout.SOUTH); //add pBott to this frame to be located SOUTH in temporary

    }
   
    public void attributeManager() {
        
        this.setSize(780,320);  //give a size to this frame
        this.setVisible(true);  //make this frame visible
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //close the project completely on clicking X
    }
    
    public void validations() {
        
        this.validate();    //this.validate();
        this.repaint();     //this.repaint();
    }
    
    public JComboBox getCusComboBox() {
        //getter for the controller to get the instace cusComboBox
        return this.cusComboBox;
    }
    
    public JComboBox getAdminComboBox() {
        //getter for the controller to get the instace cusComboBox
        return this.admComboBox;
    }
    
}
