/*
 * Controller;
 * is an interaction between model and view
 * handles overall code flows 
 * == ActionListener
 */
package week05lab;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController implements ActionListener {
    
    LoginModel model;   //declare an instace of Model class
    LoginView_ view;    //declare an instace of View_ class
    Hello halo; //declare an instace of Hello class
    
    public LoginController() {
        
        model = new LoginModel(); //initialize model as a new LoginModel
        
        /**
         *initialize 'view' with a specified constructor of View class which has an object controller as a parameter  
         *The reason the specified constructor in View class is used is that 
         *in MVC approach, Controller or which can be regarded as so is the key class in the sense that everything should be managed(controlled) in this Controller class 
         *Any other instances which can instantiate Controller in another classed should be identified.
         *Otherwise, it's thought that there is no reason in considering MVC approach
         *(functional efficient of MVC could go inefficient with undefined instantiations of Controller)   */
        view = new LoginView_(this); //Controller itself is passed as a refference(param)
        
        /**
         * no any ActionListener needs to be added here.
         * With <code>view = new LoginView_(this);</code> above,
         * this Controller is referenced in View class.
         * The object of Controller in View class will listen to a component picked.
         * all that is needed from now on is 
         * 
         * @Override
         * actionPerformed(ActionEvent e) {}
         */
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("actionB")) {
            String name = view.getUserName();   //the instance view retrieves the running user name and the value is stored into String name
            String psw = view.getUserPsw(); //the instance view retrieves the running password and the value is stored into into String psw
            
            //Declare an instance of User.
            User userInfo = new User(name, psw);    //name, psw above are passed to the specified constructor in User class
            
            /**
             * Declare && initialize the boolean variable a boolean variable, by calling .modelManager
             * via model, the instance of LoginModel
             * @param userInfo, the instance of User which has a specific running user info
             * @return true || false depending on two values between userInfo and user_info in sql  */ 
            boolean isValidUser = model.modelManager(userInfo);  
            System.out.println("isValidUser == " + isValidUser);    //just check if ture or false oon console

            if (isValidUser) {  //if true
                
                //initialize the instance of Hello. The instance halo is not going to be used for any other purpose
                //the initializing process itself by passing userInfo as a parameter will call the specified constructor in Hello class
                //The Hello class itself will do an expected role probably meaning that the instance halo does nothing after being initialized
                halo = new Hello(userInfo);
                
                
                //.dispose() releases all of the native screen resources to be marked as undisplayable
                view.dispose(); //dispose the instance view that is the current frame
            }else { //false
                //just output the message below.
                //the setter setResult in Loginview_ class sets the message to the JTextField result, which is retrieved by the instance view
                view.setResult("Please check your login info again");
                System.out.println("The User name '" + userInfo.getName() + "' has not been authorized.");
            }
            
//            
            
            
        }
    }
}
