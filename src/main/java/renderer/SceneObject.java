package renderer;

import utilities.Color;
import utilities.Vector3D;


/**
 * The SceneObject is the abstract parent class of all the objects that can be
 * added to the Scene. It specifies the position and the color of all the child
 * classes, because every SceneObjects needs at least those two variables.
 * @see utilities.Vector3D
 * @see utilities.Color
 *
 * @author Timothy
 */
public abstract class SceneObject {
    protected Vector3D position;
    protected Color color;


    /**
     * Currently not in use, but might be useful at a later stage.
     * @param position A Vector3D object that specifies the new position that
     *                 the object needs to be set to.
     * @see utilities.Vector3D
     */
    public void setPosition(Vector3D position) {
        this.position = position;
    }


    /**
     * @return A Vector3D object that represents the current position of the
     *         sceneObject.
     * @see utilities.Vector3D
     */
    public Vector3D getPosition() {
        return position;
    }


    /**
     * Also currently not in use, but might be useful at a later stage.
     * @param color A Color object that specifies the new color that the
     *              object needs to be set to.
     * @see utilities.Color
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * @return A Color object that represents the current color of the
     *         sceneObject
     */
    public Color getColor() {
        return color;
    }
}
