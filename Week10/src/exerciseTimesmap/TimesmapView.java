package exerciseTimesmap;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Q
 */
class TimesmapView extends JFrame{
    
    //private access
    private TimesmapController tcRef;   //TimesmapController ref
    private JList timeList; //a JList
    private String[] col = {"The result converted into current time format"};   //column for JTable
    private String[][] field;   //rows for JTable
    
    //protected access
    protected DefaultTableModel dtm;  //a DefaultTableModel
    protected JTable myTable;       //a JTable
    protected JCheckBox chin01; // a JCheckBox. JCheckBox allows multiple selections but only one JCheckBox is used.
    
    //specific constructor
    public TimesmapView(TimesmapController tcRef) {

        //init tcRef
        this.tcRef = tcRef;
    }
    
    //components()
    public void components() {
        
        JPanel topP = new JPanel(); //a JPanel
        JPanel pEpoch = new JPanel(new GridLayout(3,1));    //a JPanel with 3X1 grid
        JPanel _0_0 = new JPanel(new GridLayout(1,3)); //a JPanel with 1X3 grid
        JPanel pHoler01 = new JPanel(); //a JPanel for padding
        _0_0.add(pHoler01); //padding added to JPanel with 1X3 grid
        JLabel lUnixTime = new JLabel("UNIX TIME"); //a JLabel with the text
        Font font = new Font("Verdana", Font.ITALIC, 40);   //an instance of Font
        lUnixTime.setFont(font);    //font added to the JLabel
        _0_0.add(lUnixTime);    // the JLabel added to JPanel with 1X3 grid
        JPanel pHoler02 = new JPanel(); //a JPanel for padding
        _0_0.add(pHoler02); //padding added to JPanel with 1X3 grid
        
        pEpoch.add(_0_0);   //JPanel with 1X3 grid added to JPanel with 3X1 grid
        
        JPanel _1_0 = new JPanel(new GridLayout(1,3));  //a JPanel with 1X3 grid
        JPanel pHoler03 = new JPanel(); //a JPanel for padding
        _1_0.add(pHoler03); //padding added to JPanel with 1X3 grid
        
        /** Get all the unix times from the DB using the getter getEpoch() in the controller class
         * The getter getEpoch() returns the value retrieved by
         * the <code>this.epoch = tModel.epochRetriever();</code> at the controller class  */
        String[] epoch = this.tcRef.getEpoch(); 
        timeList = new JList(epoch); //init the JList instance with the unix time 
        
        //set a selection mode to the JList instance giving SINGLE_INTERVAL_SELECTION
        timeList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        timeList.addListSelectionListener(this.tcRef);  //ListSelectionListener added to the JList instance
        JScrollPane sp = new JScrollPane(timeList); //declare & init a JScrollPane. put the JList instance int it.
        sp.setPreferredSize(new Dimension(150, 80));    //give a size to the JScrollPane instance
        _1_0.add(sp); //the JScrollPane instance added to the JPanel with 1X3 grid
        JPanel pHoler04 = new JPanel(); //a JPanel for padding
        _1_0.add(pHoler04); //padding added to JPanel with 1X3 grid
        
        pEpoch.add(_1_0); //JPanel with 1X3 grid added to JPanel with 3X1 grid
        
        JPanel _2_0 = new JPanel(new GridLayout(1,3));  //a JPanel with 1X3 grid
        JPanel pHoler05 = new JPanel(); //a JPanel for padding
        _2_0.add(pHoler05); //padding added to JPanel with 1X3 grid
        
        //init an instance of JCheckBox with some texts
        chin01 = new JCheckBox("Convert an epoch to current time format");
        chin01.setSelected(false); //set the JCheckBox instance to be deselected 
        chin01.addActionListener(tcRef); //AC added to the JCheckBox instance
        chin01.setActionCommand("acToCT"); //set AC command to the JCheckBox instance
        _2_0.add(chin01);   //the JCheckBox instance added to the JPanel with 1X3 grid

        JPanel pHoler06 = new JPanel(); //a JPanel for padding
        _2_0.add(pHoler06); //padding added to JPanel with 1X3 grid
        
        pEpoch.add(_2_0);   //JPanel with 1X3 grid added to JPanel with 3X1 grid

        topP.add(pEpoch);   //the completed JPanel with 3X1 grid added to the top panel
        this.add(topP, BorderLayout.NORTH); //the op panel added to the north of this frame
        
        JPanel pTable = new JPanel();   //a panel for JTable
        TimesmapModel rowSelector = new TimesmapModel();    //declare & init an instance of the model
        rowSelector.dbConnector();  //connect to DB

       this.field = rowSelector.fieldManager();    //now, this.field has 1st row of the table from the DB
       dtm = new DefaultTableModel(this.field, this.col);  //init the DefaultTableModel instance with the given rows and columns

       //initialize the JTable instance with the instance of the defaultTableModel assinged as a parameter
       this.myTable = new JTable(dtm); 

       //declare and initialize a new JScrollPane. put the table in it.
       JScrollPane sp02 = new JScrollPane(this.myTable);    
       sp02.setPreferredSize(new Dimension(250,200));    //set size for the JScrollPane instance
       pTable.add(sp02);    //the JScrollPane instance added to the panel for JTable
       this.add(pTable, BorderLayout.CENTER); //the panel for JTable added to the center of this frame
         
    }
    
    public void attributeManager() {
        
        this.setSize(600,520);  //give a size to this frame
        this.setVisible(true);  //make this frame visible
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //close the project completely on clicking X
    }
    
    public void validations() {
        
        this.validate();    //this.validate();
        this.repaint();     //this.repaint();
    }
    
    //a getter that returns the instance of JList for the other classes to use it.
    public JList getTimeList() {
        
        return this.timeList;
    }
}
