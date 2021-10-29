package main;

/**
 * The Driver class which contains the main method. It creates a new Controller
 * object which it uses to call it's initializeRenderer function and after that
 * it calls its startRenderer function to render an image.
 * @see main.Controller
 * @see renderer.Renderer
 *
 * @author Timothy
 */
public class Driver {

    public static void main(String[] args) {

        Controller controller = new Controller();
        controller.initializeRenderer();
        controller.startRenderer();
        
    }

}
