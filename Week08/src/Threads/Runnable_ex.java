/** another way to do multi tasking
 * ____________________________________________________________________________________________
 * The class Runnable_ex has three instances;
 * 1 <Thread_ex instance>one</Thread_ex instance>: the instance of <class>Thread_ex</class> 
 * 2 <Thread_ex instance>two</Thread_ex instance>: the instance of <class>Thread_ex</class> 
 * 3 <Thread_ex instance>three</Thread_ex instance>: the instance of <class>Thread_ex</class> 
 *   that takes <instance>runnable</instance> of <class>Runnable_ex</class> 
 *   as a target parameter 
 * ____________________________________________________________________________________________
 * each <overridden method>run</overridden method> 
 * in <class>Thread_ex</class> and in <class>Runnable_ex</class>
 * does the same thing.
 * (it should be recognized differently even though those do the same thing)
 * 
 * Either one is overridden depending on the constructor type that is in use 
 * in <class>Thread</class>
 * 
 * 
 */
package Threads;

/**
 *
 * @author Q
 */
public class Runnable_ex implements Runnable {
    
    @Override
    public void run() {
        //The method run functions the same as the one in Thread class
        //and can't be run without Thread class
        for (int i=0; i<10; i++) {
            
            /**
             * anything can (nearly) be executed simultaneously
             * As interface has no getter & setter,
             * some additional text should be set manually if wanted
             */
            //System.out.println(this.getName() + ": " + i); //this does not work
            System.out.println("Thread three (Thread & Runnable based, from Runnable_ex.java): " + i);
        }
    }
    
    public static void main(String[] args) {
        
        Thread one = new Thread_ex(); //an instance of Thread_ex. Thread_ex extends Thread
        one.setName("Thread one (Thread based, from Runnable_ex.java)");   //one.setName()
        
        Thread two = new Thread_ex(); //an instance of Thread_ex. Thread_ex extends Thread
        two.setName("Thread two (Thread based, from Runnable_ex.java)");  //two.setName()
        
/*________________________________________________________________________________________________________________*/
        
        //an instance of Runnable_ex (this class). Runnable_ex implements Runnable
        Runnable runnable = new Runnable_ex();  
                
        /**
        * <code>public Thread(Runnable target);</code>
        * Allocates a new {@code Thread} object. This constructor has the same
        * effect as {@linkplain #Thread(ThreadGroup,Runnable,String) Thread}
        * {@code (null, target, gname)}, where {@code gname} is a newly generated
        * name. Automatically generated names are of the form
        * {@code "Thread-"+}<i>n</i>, where <i>n</i> is an integer.
        *
        * @param  target
        *         the object whose {@code run} method is invoked when this thread
        *         is started. If {@code null}, this classes {@code run} method does
        *         "nothing".
        * 
        * public Thread(Runnable target) {
        *   init(null, target, "Thread-" + nextThreadNum(), 0);
        * }
        */
        
        /**
         * The instance three below instantiates Thread_ex that extends Thread, 
         * where has the specific constructor that has a target parameter,
         * which is the instance runnable that instantiates 
         * the class Runnable_ex (this class) that implements the interface Runnable 
         */
        Thread three = new Thread(runnable); 
        
        //expected getName() to work when being called but it didn't
        three.setName("Thread three (Thread & Runnable based, from Runnable_ex.java)");  //this won't be set
        
        /**
         * Causes this thread to begin execution; the Java Virtual Machine
         * calls the <code>run</code> method of this thread.
         */
       
        //the same overriden method in an instance each where instantiates a class(Thread_ex) that extends Thread can be executed simultaneously 
        System.out.println("Simultaneous == .start()");
        one.start();    //Thread one = new Thread_ex();
        two.start();    //Thread two = new Thread_ex();
        
        //the same overriden method in an instance each where instantiates a class(Runnable_ex) that implements Runnable can be executed simultaneously 
        //Runnable runnable = new Runnable_ex();  
        //Thread three = new Thread(runnable); 
        three.start();
       
        //needs to have a look more in detail
        //any overriden method based on thread approach can be executed in order
        //System.out.println("in order = .run()");
        //one.run();
        //two.run();
        //three.run();

    }
    
}
