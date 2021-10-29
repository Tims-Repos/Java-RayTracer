package utilities;


/**
 * The Color class is used to give the SceneObjects a color. It needs three
 * values that represent the rgb values.
 * @see renderer.SceneObject
 *
 * @author Timothy
 */
public class Color {
    private float r;
    private float g;
    private float b;


    /**
     * The empty constructor of the Color class sets the rgb values to zero
     * so it returns the color black.
     */
    public Color() {
        this.r = 0F;
        this.g = 0F;
        this.b = 0F;
    }


    /**
     * This Color constructor needs three float values and sets the
     * corresponding fields.
     * @param r A float value that represents the red value of a color.
     * @param g A float value that represents the green value of a color.
     * @param b A float value that represents the blue value of a color.
     */
    public Color(float r, float g, float b) {
        this.r = r;
        this.b = b;
        this.g = g;
    }


    /**
     * This Color constructor needs another Color object and uses it to copy
     * all the fields to this new Color object.
     * @param color A Color object from which we copy the fields from.
     */
    public Color(Color color) {
        this.r = color.r;
        this.g = color.g;
        this.b = color.b;
    }


    /**
     * The add method adds the Color parameter to the current Color object.
     * Useful for adding a lights Color to a SceneObject Color
     * @param color A Color object that represents the color to add to this
     *              Color object.
     * @see utilities.Light
     * @see renderer.SceneObject
     */
    public void add(Color color) {
        this.r += color.r;
        this.g += color.g;
        this.b += color.b;
    }

    /**
     * The multiply method multiplies the Color parameter fields with the
     * current Color object fields. (Haven't found a use for it yet.
     * Possibly to absorb the colors of another color.)
     * @param color A Color object that represents the color to multiply with
     *              this Color objects fields.
     */
    public void multiply(Color color) {
        this.r *= color.r;
        this.g *= color.g;
        this.b *= color.b;
    }

    /**
     * The multiply method multiplies the scalar parameter to the current Color
     * objects fields.
     * @param scalar A float value that represents the scalar to multiply with
     *              this Color objects fields.
     */
    public void multiply(float scalar) {
        this.r *= scalar;
        this.g *= scalar;
        this.b *= scalar;
    }


    /**
     * The intensify method multiplies the float value with the colors fields
     * to intensify the objects color.
     * @param intensity A float value representing the intensity factor.
     */
    public void intensify(float intensity) {
        this.multiply(intensity);
    }

    public void divide(int scalar) {
        this.r /= scalar;
        this.g /= scalar;
        this.b /= scalar;
    }


    /**
     * The toInteger method uses bit shifting to get an integer color value.
     * @return The color as an integer value.
     */
    public int toInteger() {
        // Implement bit shift to get integer value of color
        int red = Math.round(255 * r);
        int green = Math.round(255 * g);
        int blue = Math.round(255 * b);

        red = (red << 16) & 0x00FF0000;
        green = (green << 8) & 0x0000FF00;
        blue = blue & 0x000000FF;


        return 0xFF000000 | red | green | blue;
    }
}
