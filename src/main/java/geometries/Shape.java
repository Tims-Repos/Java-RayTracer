package geometries;

import renderer.SceneObject;
import utilities.Ray;
import utilities.RayHit;

/**
 * Abstract class Shape from which geometries can inherit the abstract method
 * intersects. This class in turn inherits from abstract class SceneObject to
 * also give the geometry a color and position.
 * @see renderer.SceneObject
 *
 * @author Timothy
 */
public abstract class Shape extends SceneObject {
    protected float reflection;

    /**
     * Abstract intersects method that need to be overridden by all the
     * geometries that extend this class. It is created so that geometries can
     * implement their own version of this method to see if the ray intersects
     * with a geometry.
     * @param ray A Ray object to check for intersection
     * @return A RayHit object which contains information
     *         about the intersected geometry and the intersection point.
     * @see utilities.Ray
     * @see utilities.RayHit
     */
    public abstract RayHit intersects(Ray ray);

    /**
     * The doesIntersect method looks if the 'distance'(t) to object is in the
     * specified range. If it is it intersects.
     * @param t A double value representing the 'distance' to an object along
     *          the ray which we check for intersection
     * @param ray A Ray object who's t-value we need to check and if necessary
     *            also set.
     * @return A boolean value which states if an intersection happened or not.
     * @see utilities.Ray
     */
    public boolean doesIntersect(double t, Ray ray) {
        boolean intersects = false;

        if (t > Ray.T_MIN && t < ray.getT()) {

            // Inside range
            ray.setT(t);
            intersects = true;
        }

        return intersects;
    }

    /**
     * @return A boolean value that's true if the reflection is greater than
     *         zero and false otherwise.
     */
    public boolean isReflective() {
        return reflection > 0;
    }


    /**
     * @return A double value which states the reflection value of the current
     *         geometry.
     */
    public float getReflection() {
        return reflection;
    }
}
