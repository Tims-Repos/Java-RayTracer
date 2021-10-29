package renderer;

import utilities.Ray;
import utilities.Vector3D;

/**
 * The Camera class which creates the camera through which we see our Image
 * object and which creates Rays for our Renderer.
 * @see utilities.Ray
 * @see renderer.Renderer
 *
 * @author Timothy
 */
public class Camera {
    private Vector3D origin;
    private Vector3D forward;
    private Vector3D horizontal;
    private Vector3D vertical;
    private double width;
    private double height;


    /**
     * Creates a new Camera object with the specified, origin(position),
     * target, targetUpDirection, fieldOfView and aspectRatio. It also
     * calculates a forward Vector3D, horizontal Vector3D, vertical Vector3D,
     * a double height and width value based upon the given arguments.
     * @param origin A Vector3D representing the Camera's Origin(position).
     * @param target A Vector3D representing the Camera's look at target (the
     *               axis which it looks down on).
     * @param targetUpDirection A Vector3D representing the targetUpDirection
     *                          which is used to calculate the horizontal
     *                          Vector3D.
     * @param fieldOfView A double value representing the Camera's field of
     *                    view in degrees.
     * @param aspectRatio A double value representing the Camera's aspect
     *                    ratio.
     * @see utilities.Vector3D
     *
     */
    public Camera(Vector3D origin, Vector3D target, Vector3D targetUpDirection, double fieldOfView, double aspectRatio) {
        this.origin = origin;

        this.forward = target.subtract(origin).normalize();
        this.horizontal = forward.cross(targetUpDirection).normalize();
        this.vertical = horizontal.cross(forward);

        this.height = Math.tan(Math.PI * fieldOfView * 0.5 / 180);
        this.width = height * aspectRatio;

    }


    /**
     * @return The Vector3D origin of the Camera. (Might be useful at a later
     *         stage.)
     * @see utilities.Vector3D
     */
    public Vector3D getOrigin() {
        return this.origin;
    }


    /**
     * The setOrigin method is used to move the camera around.
     * @param origin A Vector3D representing the new origin (position) of the
     *               Camera.
     */
    public void setOrigin(Vector3D origin) {
        this.origin = new Vector3D(origin);
    }


    /**
     * The createRay method is used to create a new Ray object with the
     * Camera's origin as it's own origin and uses the values that were
     * calculated in the Camera's constructor to calculate the Ray's direction.
     * @param u A double value which represents a normalized x coordinate on
     *          the screen.
     * @param v A double value which represents a normalized y coordinate on
     *          the screen.
     * @return A Ray object with an origin and a direction.
     * @see utilities.Vector3D
     * @see utilities.Ray
     */
    public Ray createRay(double u, double v) {
        Vector3D direction = forward.add(horizontal.multiply(u * width))
                .add(vertical.multiply(v * height));

        return new Ray(origin, direction.normalize());
    }
}
