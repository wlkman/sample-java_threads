package threads.threadObject.hello;



/**
 * An application that creates an instance of Thread must provide the code that will run in that thread.
 * There are two ways to do this:
 *
 *
 * Provide a Runnable object. The Runnable interface defines a single method, run,
 * meant to contain the code executed in the thread. The Runnable object is passed to the Thread constructor,
 * as in the HelloRunnable example:
 */
public class HelloRunnable implements Runnable {

    public void run() {
        System.out.println("Hello from a thread!");
    }

    public static void main(String args[]) {
        (new Thread(new HelloRunnable())).start();
    }

}