/*
 * Roughly speaking, Thread inheritance gurantees multi tasking.
 */
package Threads;

/**
 *
 * @author Q
 */

public class Thread_ex extends Thread {
    
    @Override
    public void run() {
        //code
        for (int i=0; i<10; i++) {
            //anything can (nearly) be executed simultaneously
            System.out.println(this.getName() + ": " + i);
        }
    }
    
    public static void main(String[] args) {
        
        Thread one = new Thread_ex(); //an instance of Thread_ex (this class)that extends Thread
        one.setName("Thread one");  //one.setName()
        
        Thread two = new Thread_ex(); //an instance of Thread_ex (this class) that extends Thread
        two.setName("Thread two");  //two.setName()
        
        /**
         * Causes this thread to begin execution; the Java Virtual Machine
         * calls the <code>run</code> method of this thread.
         */
       //the same overriden method in an instance each where instantiates a class that extends Thread can be executed simultaneously 
        System.out.println("Simultaneous == .start()");
        one.start();
        two.start();
       
        //the same overriden method in an instance each where instantiates a class that extends Thread can be executed in order 
        //System.out.println("in order = .run()");
        //one.run();
        //two.run();

    }
    
}
