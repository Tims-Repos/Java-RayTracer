package renderer;

import geometries.Shape;
import utilities.Color;
import utilities.Light;
import utilities.Vector3D;

import java.util.ArrayList;
import java.util.List;


/**
 * The Scene class holds everything that can be viewed through the camera.
 * All the lights and shapes are derivatives from the abstract SceneObject
 * class so the Scene also holds a list of all the SceneObjects currently
 * contained in the Scene.
 * @see renderer.Camera
 * @see utilities.Light
 * @see geometries.Shape
 * @see renderer.SceneObject
 *
 * @author Timothy
 */
public class Scene {


    /**
     * The Vector3D origin represents the center of the Scene. Everything
     * revolves around this point.
     * @see utilities.Vector3D
     */
    public final static Vector3D ORIGIN = new Vector3D(0, 0, 0);
    private Color backgroundColor;
    private List<SceneObject> sceneObjects;
    private List<Shape> geometries;
    private List<Light> lights;


    /**
     * The empty Scene constructor sets the background color of the scene to
     * black and initializes the sceneObjects, geometries and lights lists.
     * @see utilities.Color
     * @see renderer.SceneObject
     * @see geometries.Shape
     * @see utilities.Light
     */
    public Scene() {
        this.backgroundColor = new Color();
        this.sceneObjects = new ArrayList<>();
        this.geometries = new ArrayList<>();
        this.lights = new ArrayList<>();

    }


    /**
     * @return A Color object that represents the method returns the background
     *         color of the Scene.
     * @see utilities.Color
     */
    public Color getBackgroundColor() {
        return backgroundColor;
    }


    /**
     * @return A java List object that contains all the geometries(shapes)
     *         currently in the scene.
     * @see geometries.Shape
     */
    public List<Shape> getGeometries() {
        return geometries;
    }

    /**
     * @return A java List object that contains all the lights currently in the
     *         scene.
     * @see utilities.Light
     */
    public List<Light> getLights() {
        return lights;
    }


    /**
     * The add method needs a SceneObjecs as a parameter and adds it to the
     * sceneObjects list. Then it checks if it's an instance of a Shape or
     * a Light class and also adds it to the corresponding list.
     * @param sceneObject A SceneObject that gets added to the sceneObjects
     *                    list and corresponding shapes or lights list.
     */
    public void add(SceneObject sceneObject) {
        sceneObjects.add(sceneObject);
        if (sceneObject instanceof Shape) {
            geometries.add((Shape) sceneObject);
        }

        if (sceneObject instanceof Light) {
            lights.add((Light) sceneObject);
        }
    }

    /**
     * The remove method needs a SceneObject as a parameter and removes it from
     * the sceneObjects list. Then it checks if it's an instance of a Shape or
     * a Light class and also removes it from the corresponding list.
     * @param sceneObject A SceneObject that gets removed from the sceneObjects
     *                    list and corresponding shapes or lights list
     */
    public void remove(SceneObject sceneObject) {
        sceneObjects.remove(sceneObject);
        if (sceneObject instanceof Shape) {
            geometries.remove(sceneObject);
        }

        if (sceneObject instanceof Light) {
            lights.add((Light) sceneObject);
        }
    }
}
