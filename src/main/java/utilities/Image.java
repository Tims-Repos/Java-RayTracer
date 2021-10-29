package utilities;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


/**
 * The Image class is used to represent an Image (or frame if you will) that
 * gets projected on the screen by the renderer and is seen by the Camera.
 * Underneath it writes the pixels to the java BufferedImage class.
 * @see renderer.Renderer
 * @see renderer.Camera
 *
 * @author Timothy
 */
public class Image {
    private final String FILETYPE = "PNG";
    private final String FILENAME = "renderedImage.png";
    private int width;
    private int height;
    private File image;
    private BufferedImage buffer;


    /**
     * The Image constructor gets a width and height as parameter and creates
     * an Image with the specified width and height. It also creates a file
     * to write to later and the actual BufferedImage which will contain the
     * data.
     * @param width An int value representing the width of the image.
     * @param height An int value representing the height of the image.
     * @see java.io.File
     * @see java.awt.image.BufferedImage
     */
    public Image(int width, int height) {
        this.width = width;
        this.height = height;
        image = new File(FILENAME);
        buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    }


    /**
     * The write method is used to write all the data from the BufferedImage
     * object to the file we created in the constructor of the image object.
     * @see java.io.File
     * @see java.awt.image.BufferedImage
     */
    public void write() {
        try {
            ImageIO.write(buffer, FILETYPE, image);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * The draw method is used to give each pixel (specified by the x and y)
     * a rgb color value.
     * @param x An int value representing the x coordinate of a pixel.
     * @param y An int value representing the y coordinate of a pixel.
     * @param rgb An int value representing the rgb value.
     * @see utilities.Color
     * @see java.awt.image.BufferedImage
     */
    public void draw(int x, int y, int rgb) {
        buffer.setRGB(x, y, rgb);
    }


    /**
     * @return An int value that represents the width of the Image object.
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return An int value that represents the height of the Image object.
     */
    public int getHeight() {
        return height;
    }

}
