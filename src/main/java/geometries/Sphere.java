package geometries;

import utilities.Color;
import utilities.Ray;
import utilities.RayHit;
import utilities.Vector3D;

/**
 * The Sphere class is a geometry that extends the abstract Shape class which
 * has the abstract method 'intersects' to see if a ray intersects with a
 * geometry.
 * @see geometries.Shape
 *
 * @author Timothy
 */
public class Sphere extends Shape{
    private double radius;


    /**
     * Creates a new Sphere object with the specified position as it's center,
     * a radius, a color and a reflection value.
     * @param position A Vector3D object which represents the position(center)
     *                 of the sphere.
     * @param radius A double value which represents the sphere's radius.
     * @param color A Color object which represents the sphere's color.
     * @param reflection A double value which represents the sphere's
     *                   reflection value.
     * @see utilities.Vector3D
     * @see utilities.Color
     */
    public Sphere(Vector3D position, double radius, Color color, float reflection) {
        this.position = new Vector3D(position);
        this.radius = radius;
        this.color = new Color(color);
        this.reflection = reflection;
    }

    /**
     * Override abstract parent class' intersects method to see if the ray
     * intersects with the Sphere geometry.
     * @param ray A Ray object representing the ray to check for intersection.
     * @return A RayHit object which contains information
     *         about the intersected plane and the intersection point.
     * @see utilities.Ray
     * @see utilities.RayHit
     */
    @Override
    public RayHit intersects(Ray ray) {
        RayHit rayHit = null;

        // Save ray origin and direction to local variables to save a lot of
        // writing and subtract the origin with the position of the sphere
        Vector3D rayOrigin = ray.getOrigin().subtract(position);
        Vector3D rayDirection = ray.getDirection();

        // Calculate the coefficients
        double a = rayDirection.dot(rayDirection);
        double b = 2 * rayOrigin.dot(rayDirection);
        double c = rayOrigin.dot(rayOrigin) - radius * radius;

        // Check if we intersect
        double discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {

            // Find the two intersection points t1 (close) t2(far)
            double t1 = (-b - Math.sqrt(discriminant)) / (2 * a);
            double t2 = (-b + Math.sqrt(discriminant)) / (2 * a);

            if (t1 > 0 || t2 > 0) {

                double t;
                Vector3D normal;
                Vector3D intersection;

                if (t1 < 0 && t2 > 0) {
                    // Ray origin lies inside sphere
                    t = t2;
                    intersection = ray.getEndPoint(t);
                    normal = intersection.subtract(position);
                } else {
                    // Both roots are positive
                    t = t1;
                    intersection = ray.getEndPoint(t);
                    normal = position.subtract(intersection);
                }

                rayHit = new RayHit(ray, this, normal, intersection);
            }
        }

        return rayHit;
    }
}
