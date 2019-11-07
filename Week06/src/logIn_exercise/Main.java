/*
 * Basic MVC structure example:
 *  - get a running user info from a frame 
 *  - validate the user info with a simple sample user data at a table in sql DB
 *   - if the running user info == the value at the table, 
       - close the existing frame
       - show another frmae and add some welcome message on it. 
     - if not, output some unauthrized message in the existing frame  
 */
package week05lab;


/**
 *
 * @author Q
 */
public class Main {

    public static void main(String[] args) {
        //invoke constructor
        new LoginController();

    }    
}
