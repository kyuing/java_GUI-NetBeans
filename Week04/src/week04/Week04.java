package week04;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author QT_Han
 */
public class Week04 extends JFrame {
    //
    private String[] col = {"TIME", "Monday", "Tuesday", "Wednesday"};    //columns
    private String[][] field = //fields
    {
        {"9-11.30","MN", "webDev", ""},
        {"12-14.30", "OS", "GUI",""},
        {"15-17.30", "", "DB", "lab"},
        
    };
    public static void main(String[] args) {
        //invoke constructor
        new Week04();
    }
    
    public Week04() {
        
     
        //this.setSize(470,160);
        this.setPreferredSize(new Dimension(480,160));  //set a preferred size(350,350) to this Week04 frame visible
        
        //BorderLayout topBolder = new BorderLayout(); //create topBorder. this doesn't affect really or is not necessary for now
        JPanel topPanel = new JPanel(); //create topPanel
        JLabel label = new JLabel("JTable & JScrollPanel"); //create label
        //label/*or topPanel*/.setLayout(topBolder);  //set the layout of topPanel to be fitted in the given frame in full. this doesn't affect really or is not necessary for now
        topPanel.add(label);    //add label set with some text to topPanel
        this.add(topPanel, BorderLayout.NORTH); //add topPanel to this Week04 frame
        
        //BorderLayout bottBolder = new BorderLayout(); //create topBorder. this doesn't affect really or is not necessary for now
        JPanel bottPanel = new JPanel(); //create bottPanel
        JTable table = new JTable(this.field, this.col);    //create an instance of JTable with a specified constructor that has Vector rowData, Vector columnNames as parameters.
        //table.setLayout(bottBolder);  //set the layout of topPanel to be fitted in the given frame in full. this doesn't affect really or is not necessary for now
        
     /**
     * Creates a <code>JScrollPane</code> that displays the contents of the specified component,
     * where both horizontal and vertical scrollbars appear whenever the component's contents are larger than the view.
     * @see #setViewportView
     * @param view the component to display in the scrollpane's viewport
     * 
     *  public JScrollPane(Component view) {
     *      this(view, VERTICAL_SCROLLBAR_AS_NEEDED, HORIZONTAL_SCROLLBAR_AS_NEEDED);
     *  }  */
        JScrollPane scrollPane = new JScrollPane(table);    //create an instance of JScrollPane with a specified constructor that has a Component view parameter.        
        bottPanel.add(scrollPane);  //add scrollPane to bottPanel
        //scrollPane.setPreferredSize(400,600);
        //this.getContentPane().add(bottPanel, BorderLayout.CENTER);
        this.add(bottPanel, BorderLayout.CENTER);    //add bottPanel to this Week04 frame        
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);  //close the window and the program when x is clicked
        this.pack();    //pack this Week04 frame since .setPreferredSize() is being used
        this.setVisible(true); //set this Week04 frame visible
        System.out.println("weekly time table");
    }  
}
