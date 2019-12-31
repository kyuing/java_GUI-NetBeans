package JComboBox;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComboBox;

/**
 *
 * @author Q
 */
public class JComboBoxController implements ActionListener, MouseListener {

    
   private JComboBox_exView aView;  //declare view
   private JComboBox_exModel aModel;    //declare model
   
   
   /**
    * customerName, adminName == preps for each of the combo box 
    * 
    * selectedCusName, selectedAdmName == the column storages from each of the corresponding table at DB 
    * for selected customer name & admin name */
   private String[] customerName, adminName, selectedCusName, selectedAdmName; 
   private String fname=null, lname=null;    //usser names to select a specific row from DB
   
    public JComboBoxController() {
        //default constructor
        
        aModel = new JComboBox_exModel();   //initilize a new Model
        aModel.dbConnector();   //connect to DB
        
        /**
         * Retrieve customer names and admin names for each of the JCombo box instances from the model.
         * The method selectCnameFromDB() & selectAnameFromDB() have the query to get all the names from the DB each*/
        customerName = aModel.selectCnameFromDB();   
        adminName = aModel.selectAnameFromDB();   

        //initialize a new JComboBox_exView. Pass this JComboBoxController class as a parameter
        aView = new JComboBox_exView(this); 
        aView.attributeManager();   //inital view setting
        aView.components();  //components to be shown
        aView.validations(); //validate
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("acFullName")) {
        
            /**
             * The AC is added to the instance of JComboBox in the view class
             * which has all of the fname + lname from sql DB as a drop down list each.
             * Here, once a cell in the combo box is selected, retrieve it.*/
            System.out.println(this.aView.getCusComboBox().getSelectedItem() 
            + " retireved at actionPerformed(ActionEvent e), JComboBoxController()");
   
            String[] spliter = null;    //an array to get fname and lname as a string each.
            
            //fname and lname from the selected item in the combo box is split up with the spaces 
            spliter = this.aView.getCusComboBox().getSelectedItem().toString().split("  ");
            this.fname = spliter[0].toString(); //fname from 0 index
            this.lname = spliter[1].toString(); //lname from 1 index
            
            //check if the string variables have an OK value retrieved each.
            System.out.println("\nselected fname at actionPerformed => " + this.fname);
            System.out.println("selected lname at actionPerformed => " + this.lname);

            /*
             * The 1D array selectedCusName stores columns of a specific row 
             * from the method selectedFullNames(string, string) in the model class*/
            selectedCusName = aModel.selectedFullNames(fname, lname);

            //remove the current row using the instance of DefaultTableModel
            aView.dtm.removeRow(0);
            
            //insert a row at the first cell in the JTable with the selected customer info in full
            aView.dtm.insertRow(0, selectedCusName);

        }else {
            
            //admin selected from the JRadioBtn. the same approach as above
            if(e.getActionCommand().equals("acFullNameAdm")) {
                
                //print seleected names for check.
                System.out.println(this.aView.getAdminComboBox().getSelectedItem() 
                + " retireved at actionPerformed(ActionEvent e), JComboBoxController()");

                String[] spliter = null;    //an array to get fname and lname as a string each.

                //fname and lname from the selected item in the combo box is split up with the spaces 
                spliter = this.aView.getAdminComboBox().getSelectedItem().toString().split("  ");
                this.fname = spliter[0].toString(); //fname from 0 index
                this.lname = spliter[1].toString(); //lname from 1 index

                //check if the string variables have an OK value retrieved each.
                System.out.println("\nselected fname at actionPerformed => " + this.fname);
                System.out.println("selected lname at actionPerformed => " + this.lname);

                /*
                 * The 1D array selectedAdmName stores columns of a specific row 
                 * from the method selectedFullNames_adm(string, string) in the model class*/
                selectedAdmName = aModel.selectedFullNames_adm(fname, lname);

                //remove the current row using the instance of DefaultTableModel
                aView.dtmAdm.removeRow(0);

                //insert a row at the first cell in the JTable with the selected admin info in full
                aView.dtmAdm.insertRow(0, selectedAdmName);
            }   
            
        }

    }
    
    //customer name getter to the view class
    public String[] getCustomerName() {
        
        return this.customerName;
    }
    
    //admin name getter to the view class
    public String[] getAdminName() {
        
        return this.adminName;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("mouseClicked");        
        
        //admin at JRadioBtn
        if(e.getComponent().getName().equals("admRadioButton")) {
            
            //print the component name
            System.out.println(e.getComponent().getName());   
            
            this.aView.adm.setSelected(true); //admin is selected in the JRadioBtn
            this.aView.bottP_grid.setVisible(false);    //hide the customer grid panel
            
            this.aView.bottP_grid_admin.setVisible(true);   //show the admin panel            
            
            //reset the admin grid panel's location to be in center instead of the customer grid panel
            //(replace the customer grid panel with the admin panel)
            this.aView.add(aView.bottP_grid_admin, BorderLayout.CENTER);    
            
        }else {
            //customer at JRadioBtn
            
            this.aView.cus.setSelected(true);   //customer is selected
            this.aView.bottP_grid.setVisible(true); //show the customer grid panel
            System.out.println(e.getComponent().getName());   //print the component name
        }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("mousePressed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("mouseReleased");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("mouseEntered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("mouseExited");
    }
}
