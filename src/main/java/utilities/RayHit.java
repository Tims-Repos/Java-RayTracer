package utilities;

import geometries.Shape;


/**
 * The RayHit class is used to contain information about an intersection
 * between a Ray object and a Shape object.
 * @see utilities.Ray
 * @see geometries.Shape
 * @see utilities.Vector3D
 *
 * @author Timothy
 */
public class RayHit {
    private Ray ray;
    private Shape shape;
    private double t;
    private Vector3D normal;
    private Vector3D hitPoint;


    /**
     * The RayHit constructor is used to create a RayHit object with the
     * specified parameters.
     * @param ray The Ray object which intersected with a geometry.
     * @param shape The Shape object (geometry) which intersected with a Ray
     *              object.
     * @param normal A Vector3D object that is used to normalize the possible
     *               reflection Ray object which is created when the
     *               getReflectionRay method is called.
     * @param t A double value specifying the 'distance' from the Ray object
     *          to the intersection point on the geometry.
     * @see utilities.Ray
     * @see geometries.Shape
     * @see utilities.Vector3D
     */
    public RayHit(Ray ray, Shape shape, Vector3D normal, double t) {
        this.ray = ray;
        this.shape = shape;
        this.t = t;
        this.normal = normal.normalize();
        this.hitPoint = ray.getEndPoint(t);
    }

    /**
     * The RayHit constructor with Vector3D intersection instead of a t value
     * is also used to create a RayHit object with the specified parameters.
     * But here the point of intersection is already calculated.
     * @param ray The Ray object which intersected with a geometry.
     * @param shape The Shape object (geometry) which intersected with a Ray
     *              object.
     * @param normal A Vector3D object that is used to normalize the possible
     *               reflection Ray object which is created when the
     *               getReflectionRay method is called.
     * @param intersection A Vector3D object specifying the intersection point
     *                     of the Ray object and the Shape object.
     * @see utilities.Ray
     * @see geometries.Shape
     * @see utilities.Vector3D
     */
    public RayHit(Ray ray, Shape shape, Vector3D normal, Vector3D intersection) {
        this.ray = ray;
        this.shape = shape;
        this.normal = normal.normalize();
        this.hitPoint = intersection;

    }


    /**
     * @return A double value that represents the t value of the RayHit object.
     */
    public double getT() {
        return t;
    }


    /**
     * The getReflectionRay method creates a new Ray objects that represents
     * the reflection ray off of a surface on a Shape object.
     * @return A Ray object that represents the reflection ray off of a Shape
     *         object surface.
     * @see utilities.Ray
     * @see utilities.Vector3D
     */
    public Ray getReflectionRay() {
        return new Ray(hitPoint, ray.getDirection().subtract(normal.multiply(2.0 * ray.getDirection().dot(normal))));
    }


    /**
     * @return A Vector3D object that represents the point on which the Ray
     *         object and the Shape object intersected.
     * @see utilities.Vector3D
     */
    public Vector3D getHitPoint() {
        return hitPoint;
    }


    /**
     * @return A Shape object that represents the Shape object that was hit
     *         by the Ray object.
     * @see geometries.Shape
     */
    public Shape getShape() {
        return shape;
    }
}
