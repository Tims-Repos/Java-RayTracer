package utilities;


/**
 * The Ray class is used to represent a ray that gets shot from the Camera
 * object and into the scene to look for intersections with Shape objects or
 * Light objects.
 * @see renderer.Camera
 * @see renderer.Scene
 * @see geometries.Shape
 * @see utilities.Light
 */
public class Ray {

    /**
     * The T_MIN double value represents the smallest value allowed for the
     * t variable.
     */
    public final static double T_MIN = 0.00_001;

    /**
     * The T_MAX double value represents the biggest value allowed for the
     * t variable. In this case 'Infinity'.
     */
    public final static double T_MAX = Double.POSITIVE_INFINITY;
    private Vector3D origin;
    private Vector3D direction;
    private double t;


    /**
     * The Ray constructor creates a new Ray object with the specified origin
     * and the direction and also sets the t value to the T_MAX value because
     * no intersection has happened yet.
     * @param origin A Vector3D object representing the origin of the Ray
     *               object.
     * @param direction A Vector3D object representing the direction of the Ray
     *                  object.
     */
    public Ray(Vector3D origin, Vector3D direction) {
        this.origin = origin;
        this.direction = direction;
        this.t = T_MAX;
    }


    /**
     * @return A Vector3D object that represents the origin of the Ray object.
     */
    public Vector3D getOrigin() {
        return origin;
    }


    /**
     * @return A Vector3D object that represents the direction of the Ray
     *         object.
     */
    public Vector3D getDirection() {
        return direction;
    }


    /**
     * @param t A double value that represents the new t value to set.
     */
    public void setT(double t) {
        this.t = t;
    }


    /**
     * @return A double value that represents the current t value.
     */
    public double getT() {
        return t;
    }


    /**
     * The getEndpoint method calculates the intersection point of the Ray
     * object based on the t value.
     * @param t A double value that represents the 'distance' to the
     *          intersection point.
     * @return A Vector3D object representing the intersection point of the
     *         Ray object with a Shape object.
     */
    public Vector3D getEndPoint(double t) {
        return origin.add(direction.multiply(t));
    }

}
