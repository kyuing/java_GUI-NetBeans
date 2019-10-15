/*
 * Controller;
 * is an interaction between model and view
 * handles overall code flows 
 * == ActionListener in a sense
 */
package MVC_Example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

    Model model;    //declare an instace of Model class
    View view; //declare an instace of View_ class
    
    Controller() {
        //default constructor
        
        model = new Model();    //initialize model
        
        /**
         *initialize 'view' with a specified constructor of View class which has an object controller as a parameter  
         *The reason you use a specified constructor from View class is that 
         *in MVC, Controller or which can be regarded as so is the key class in the sense that everything should be managed(controlled) in this Controller class 
         *Any other instances which can instantiate Controller should be identified.
         *Otherwise, it's thought that there is no reason in using MVC approach
         * (functional efficient of MVC could go inefficient with undefined instantiations)   */
        view = new View(this); //this Controller class itself is passed as a refference
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("actionB")) {
            int a = view.getNumOne();   //the instance view retrieves 1st number and the value is stored into int a
            int b = view.getNumTwo();   //the instance view retrieves 2nd number and the value is stored into int b
            int result = model.addManager(a, b);    //.addManager(parameter, parameter) in the View class is called by the instance view to get the final result.  
            view.setResult(result); //the final result is set by the setter .setResult(parameter) with the instance view
        }
    }
}
