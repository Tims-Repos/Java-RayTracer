package geometries;

import utilities.Color;
import utilities.Ray;
import utilities.RayHit;
import utilities.Vector3D;

/**
 * The Plane class is a geometry that extends the abstract Shape class which
 * has the abstract method 'intersects' to see if a ray intersects with a
 * geometry.
 * @see geometries.Shape
 *
 * @author Timothy
 */
public class Plane extends Shape {
    private Vector3D normal;


    /**
     * Create a new Plane object with the specified position, a normal, a color
     * and a reflection value.
     * @param position A Vector3D object representing the planes position.
     * @param normal A Vector3D object representing the planes normal.
     * @param color A Color object representing the planes color.
     * @param reflection A double value representing the planes reflection
     *                   value.
     * @see utilities.Vector3D
     * @see utilities.Color
     */
    public Plane(Vector3D position, Vector3D normal, Color color, float reflection) {
        this.position = new Vector3D(position);
        this.color = new Color(color);
        this.normal = normal;
        this.reflection = reflection;
    }


    /**
     * Override abstract parent class' intersects method to see if the ray
     * intersects with the Plane geometry.
     * @param ray A Ray object representing the ray to check for intersection.
     * @return A RayHit object which contains information
     *         about the intersected plane and the intersection point.
     * @see utilities.Ray
     * @see utilities.RayHit
     */
    @Override
    public RayHit intersects(Ray ray) {
        RayHit rayHit = null;

        // Check if we intersect
        double directionDotNormal = ray.getDirection().dot(normal);
        if (directionDotNormal != 0) {

            // Find point of intersection
            double t = (position.subtract(ray.getOrigin())).dot(normal) / directionDotNormal;

            // Check if it does intersect with the ray
            if(doesIntersect(t, ray)) {
                rayHit = new RayHit(ray, this, normal, t);
            }
        }

        return rayHit;
    }
}
