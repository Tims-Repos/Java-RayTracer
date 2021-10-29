package utilities;


/**
 * The Options class is used to store all the options relating to the
 * raytracer (can contain more options at a later stage).
 *
 * @author  Timothy
 */
public class Options {
    private static final int DEFAULT_SIZE = 640;
    private static final int DEFAULT_FOV = 90;
    private final int height;
    private final int width;
    private final int fieldOfView;


    /**
     * This Options constructor sets the width, height and field of view.
     * @param width An int value representing the specified width.
     * @param height An int value representing the specified height.
     * @param fieldOfView An int value representing the specified field of
     *                    view.
     */
    public Options(int width, int height, int fieldOfView) {
        this.width = width;
        this.height = height;
        this.fieldOfView = fieldOfView;
    }

    /**
     * This Options constructor sets the width, height and calls the Options
     * constructor that accepts three parameters with a default field of view
     * value.
     * @param width An int value representing the specified width.
     * @param height An int value representing the specified height.
     */
    public Options(int width, int height) {
        this(width, height, DEFAULT_FOV);
    }


    /**
     * This Options constructor calls the Options constructor that accepts
     * three parameters with a default width, height and field of view value.
     */
    public Options() {
        this(DEFAULT_SIZE, DEFAULT_SIZE, DEFAULT_FOV);
    }


    /**
     * @return An int value that represents the current height.
     */
    public int getHeight() {
        return height;
    }


    /**
     * @return An int value that represents the current width.
     */
    public int getWidth() {
        return width;
    }


    /**
     * @return An int value that represents the current field of view.
     */
    public int getFieldOfView() {
        return fieldOfView;
    }


    /**
     * The getAspectRatio method calculates the aspect ratio based on the
     * specified width and height. If width is bigger divide width by height.
     * If height is bigger divide height by width.
     * @return A double value representing the calculated aspect ratio.
     */
    public double getAspectRatio() {
        double aspectRatio = 0.0;

        if (width > height) {
            aspectRatio = (double) width / (double) height;
        } else {
            aspectRatio = (double) height / (double) width;
        }
        return aspectRatio;
    }
}
