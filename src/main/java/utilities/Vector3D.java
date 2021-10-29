package utilities;


/**
 * The Vector3D class is used to represent a three dimensional vector that
 * can be used for calculations in the three dimensional space.
 *
 * @author Timothy
 */
public class Vector3D {
    public final double x;
    public final double y;
    public final double z;


    /**
     * This Vector3D constructor needs three double values and sets the
     * corresponding x, y, z fields.
     * @param x A double value that represents the x coordinate of the Vector3D
     *          object.
     * @param y A double value that represents the y coordinate of the Vector3D
     *          object.
     * @param z A double value that represents the z coordinate of the Vector3D
     *          object.
     */
    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }


    /**
     * This Vector3D constructor needs two double values and calls the
     * Vector3D constructor that accepts three parameters, with the two
     * given parameters and a default value of 0.0 for the z field.
     * @param x A double value that represents the x coordinate of the Vector3D
     *          object.
     * @param y A double value that represents the y coordinate of the Vector3D
     *          object.
     */
    public Vector3D(double x, double y) {
        this(x, y, 0.0);
    }

    /**
     * This Vector3D constructor needs one double value and calls the
     * Vector3D constructor that accepts three parameters, with the given
     * parameter and a default value of 0.0 for the y and z fields.
     * @param x A double value that represents the x coordinate of the Vector3D
     *          object.
     */
    public Vector3D(double x) {
        this(x, 0.0, 0.0);
    }


    /**
     * This Vector3D constructor calls the Vector3D constructor that accepts
     * three parameters, with a default value of 0.0 for the x, y and z fields.
     */
    public Vector3D() {
        this(0.0, 0.0, 0.0);
    }

    /**
     * This Vector3D constructor needs another Vector3D object and uses it to
     * copy all the fields to this new Vector3D object.
     * @param vector A Vector3D object from which we copy the fields from.
     */
    public Vector3D(Vector3D vector) {
        this.x = vector.x;
        this.y = vector.y;
        this.z = vector.z;
    }

    /**
     * The multiply method multiplies the scalar parameter to the current
     * Vector3D objects fields.
     * @param scalar A float value that represents the scalar to multiply with
     *              this Vector3D objects fields.
     * @return A new Vector3D object that is multiplied by a scalar value.
     */
    public Vector3D multiply(double scalar) {
        return new Vector3D(x * scalar, y * scalar, z * scalar);
    }

    /**
     * The dot method calculates the dot product of this Vector3D object and
     * the Vector3D object given as a parameter.
     * @param vector A Vector3D object that is used in the dot product
     *               calculation.
     * @return A double value that is the result of this Vector3D object dotted
     *         with another Vector3D object.
     */
    public double dot(Vector3D vector) {
        return this.x * vector.x + this.y * vector.y + this.z * vector.z;
    }

    /**
     * The cross method calculates the cross product of this Vector3D object
     * and the Vector3D object given as a parameter.
     * @param vector A Vector3D object that is used in the cross product
     *               calculation.
     * @return A new Vector3D that represents the result of this Vector3D
     *         object crossed with another Vector3D object.
     */
    public Vector3D cross(Vector3D vector) {
        return new Vector3D(
                this.y * vector.z - this.z * vector.y,
                this.z * vector.x - this.x * vector.z,
                this.x * vector.y - this.y * vector.x);
    }

    /**
     * The add method adds this Vector3D object to the Vector3D object given as
     * a parameter.
     * @param vector A Vector3D object that is used to add to this Vector3D
     *               object.
     * @return A new Vector3D that represents the result of this Vector3D
     *         object added to another Vector3D object.
     */
    public Vector3D add(Vector3D vector) {
        return new Vector3D(this.x + vector.x, this.y + vector.y, this.z + vector.z);
    }

    /**
     * The subtract method subtracts this Vector3D object from the Vector3D
     * object given as a parameter.
     * @param vector A Vector3D object that is used to subtract from this
     *               Vector3D object.
     * @return A new Vector3D that represents the result of this Vector3D
     *         object subtracted from another Vector3D object.
     */
    public Vector3D subtract(Vector3D vector) {
        return new Vector3D(this.x - vector.x, this.y - vector.y, this.z - vector.z);
    }

    /**
     * The divide method divides the current Vector3D objects fields by the
     * scalar parameter.
     * @param scalar A float value that represents the scalar to divide
     *              this Vector3D objects fields by.
     * @return A new Vector3D object that is divided by a scalar value.
     */
    public Vector3D divide(double scalar) {
        return new Vector3D(this.x / scalar, this.y / scalar, this.z / scalar);
    }


    /**
     * The length method calculates the length of a vector.
     * @return A double value that represents the length of this Vector3D
     *         object.
     */
    public double length() {
        return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    }


    /**
     * The normalize method calculates the normalized (length 1) Vector3D
     * object of the current Vector3D.
     * @return A new Vector3D object that represents the normalized version of
     *         the current Vector3D object.
     */
    public Vector3D normalize() {
        double length = this.length();
        return new Vector3D(this.x / length, this.y / length, this.z / length);
    }


    /**
     * @return A new Vector3D object which goes in the opposite direction.
     */
    public Vector3D negate() {
        return multiply(-1);
    }


    /**
     * The equals method is only used in the testcases to see if two Vector3D
     * objects are equal to eachother.
     * @param object The object to check for equality with the current
     *               Vector3D object.
     * @return A boolean value which states if the parameter object is equal
     *         to the current Vector3D object.
     */
    @Override
    public boolean equals(Object object) {
        // Made this only for JUnit purposes
        boolean objectEquals = false;

        if (this == object) {
            objectEquals = true;
        } else if (object != null && getClass() == object.getClass()) {
            Vector3D vector = (Vector3D) object;
            objectEquals = x == vector.x && y == vector.y && z == vector.z;
        }

        return objectEquals;
    }
}
