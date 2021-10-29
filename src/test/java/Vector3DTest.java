import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utilities.Vector3D;

import static org.junit.jupiter.api.Assertions.assertAll;

/**
 * The Vector3DTest is a test class for all the Vector3D methods.
 * @see utilities.Vector3D
 *
 * @author Timothy
 */
class Vector3DTest {
    private Vector3D vector1 = new Vector3D(1,2,3);
    private Vector3D vector2 = new Vector3D(1,5,7);
    private double scalar = 2.0;
    private double lengthVector1 = Math.sqrt(14);

    /**
     * The testVector3D method runs a group of assertions that test the
     * various methods of the Vector3D class.
     */
    @Test
    @DisplayName("Test addition, dot product and cross product")
    void testVector3D() {
        assertAll("Vector3D",
                () -> Assertions.assertEquals(vector1.add(vector2),
                        new Vector3D(2, 7, 10)),
                () -> Assertions.assertEquals(vector1.dot(vector2),
                        32),
                () -> Assertions.assertEquals(vector1.cross(vector2),
                        new Vector3D(-1, -4, 3)),
                () -> Assertions.assertEquals(vector1.subtract(vector2),
                        new Vector3D(0, -3, -4)),
                () -> Assertions.assertEquals(vector1.multiply(scalar),
                        new Vector3D(2, 4, 6)),
                () -> Assertions.assertEquals(vector1.divide(scalar),
                        new Vector3D(0.5, 1, 1.5)),
                () -> Assertions.assertEquals(vector1.length(),
                        lengthVector1),
                () -> Assertions.assertEquals(vector1.normalize(),
                        new Vector3D(1 / lengthVector1, 2 / lengthVector1, 3 / lengthVector1)));
    }
}
