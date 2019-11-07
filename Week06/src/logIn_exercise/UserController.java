/** 
 * This is a part of LoginController, 
 * which is useful in dealing with further steps in LoginController class
 */
package week05lab;

public class User {
    
    private String name;    //private class-level string variable
    private String pwd; //private class-level string variable
    
    public User(String name, String pwd) {
        this.name = name;   //initialize name. the running user name is passed here as a parameter
        this.pwd = pwd; //initialize pwd. the running password is passed here as a parameter
    }

    public String getName() {
        //a getter for name (2nd getter)
        return name;
    }

    public String getPwd() {
        //a getter for pwd  (2nd getter)
        return pwd;
    }
    
    
    
    
}
