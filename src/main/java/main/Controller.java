package main;

import geometries.Plane;
import geometries.Sphere;
import renderer.Camera;
import renderer.Renderer;
import renderer.Scene;
import utilities.*;


/**
 * The Controller class which controls the whole application and the only way
 * from which we can interact with the Renderer class through the main method.
 * @see main.Driver
 *
 * @author Timothy
 */
public class Controller {
    private Options options;
    private Image image;
    private Scene scene;
    private Camera camera;
    private Renderer renderer;


    /**
     * Create a new Controller object which also creates an Options object with
     * default parameters.
     * @see utilities.Options
     */
    public Controller() {
        options = new Options();
    }


    /**
     * A method which initializes an Image object, a Scene object and a Camera
     * object, so that a Renderer object can be created with a Camera and Scene
     * object that it needs as constructor arguments.
     * @see utilities.Image
     * @see renderer.Scene
     * @see renderer.Camera
     */
    public void initializeRenderer() {
        initializeImage();
        initializeScene();
        initializeCamera();
        renderer = new Renderer(camera, scene);
    }


    /**
     * The private initialize Image method creates a new Image object with the
     * width and height specified in the Options object as its constructor
     * arguments.
     * @see utilities.Image
     * @see utilities.Options
     */
    private void initializeImage() {
        image = new Image(options.getWidth(), options.getHeight());
    }

    /**
     * The initializeScene method creates a new Scene object after which it
     * calls the Scene's add method which accepts any object that extends the
     * abstract SceneObject class. It adds a few geometries and two lights.
     * @see renderer.Scene
     * @see renderer.SceneObject
     * @see geometries.Sphere
     * @see geometries.Plane
     * @see utilities.Light
     */
    private void initializeScene() {
        scene = new Scene();
        scene.add(new Sphere(new Vector3D(12,5,0), 1, new Color(0F, 1F, 0F), 0.8F));
        scene.add(new Sphere(new Vector3D(0, 0, 20), 2, new Color(0F, 0.5F, 0.5F), 0));
        scene.add(new Sphere(new Vector3D(0, 0, 10),3, new Color(0.5F, 0.2F,0.2F), 0.5F));
        scene.add(new Plane(new Vector3D(0,0,0), new Vector3D(0, 1, 0), new Color(1F, 0F, 0F), 0.6F));
        scene.add(new Light(new Vector3D(1, 1, 1), new Color(1F, 1F, 1F), 0.8F));
        scene.add(new Light(new Vector3D(0.5, 0.5, 0.5), new Color(1F, 1F, 1F), 1F));
    }


    /**
     * The initializeCamera method creates a new Camera object which takes the
     * Scene's static ORIGIN variable as it's position, a Vector3D
     * target (lookAt), a Vector3D targetUpGuide, a fieldOfView and an
     * aspectRatio which are both specified in the Options object.
     * @see renderer.Camera
     * @see utilities.Vector3D
     * @see utilities.Options
     */
    private void initializeCamera() {
        camera = new Camera(
                Scene.ORIGIN,
                new Vector3D(0, 0, -1),
                new Vector3D(0, 1, 0),
                options.getFieldOfView(),
                options.getAspectRatio());
    }


    /**
     * The startRenderer function calls the render method of the renderer
     * object and passes the initialized Image object as an argument to it.
     * @see renderer.Renderer
     */
    public void startRenderer() {
        renderer.render(image);
    }



}
