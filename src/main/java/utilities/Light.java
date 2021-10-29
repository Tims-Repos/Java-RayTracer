package utilities;

import renderer.SceneObject;

/**
 * The light class inherits from abstract class SceneObject to give the light
 * a color and a position.
 * @see renderer.SceneObject
 *
 * @author Timothy
 */
public class Light extends SceneObject {
    private float intensity;


    /**
     * The Light constructor sets a position, color and intensity for the light
     * object.
     * @param position A Vector3D object that represents the position of the
     *                 light object.
     * @param color A Color object that represents the color of the light
     *              object.
     * @param intensity A float value that represents the intensity of the
     *                  light.
     * @see utilities.Vector3D
     * @see utilities.Color
     */
    public Light(Vector3D position, Color color, float intensity) {
        this.position = new Vector3D(position);
        this.color = new Color(color);
        this.intensity = intensity;
    }


    /**
     * The getColor method gets the color of the shape that the RayHit object
     * has hit and multiplies the lights intensity with its color so that the
     * object looks brighter.
     * @param hit A RayHit object that has information about the shape that it
     *            hit.
     * @return A Color object that represents the color of the hit shape
     *         multiplied with the lights intensity.
     */
    public Color getColor(RayHit hit) {
        Color shapeColor = hit.getShape().getColor();
        shapeColor.multiply(intensity);
        return shapeColor;
    }
}
