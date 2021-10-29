package renderer;

import geometries.Shape;
import utilities.*;

/**
 * The Renderer class which does all the heavy lifting. Here we give a Camera
 * object and a Scene object and render the Scene with the help of the Camera
 * on an Image.
 * @see renderer.Camera
 * @see renderer.Scene
 * @see utilities.Image
 *
 * @author Timothy
 */
public class Renderer {

    private final static int MAX_RECURSION_LEVEL = 5;
    private Camera camera;
    private Scene scene;


    /**
     * Give a Camera and Scene object to the constructor and set them as
     * private fields for usage in the Renderer.
     * @param camera A Camera object which we use to create Rays that can hit
     *               objects.
     * @param scene A Scene object in which we shoot the Rays from the camera
     *              to see if we hit objects.
     * @see renderer.Camera
     * @see renderer.Scene
     * @see utilities.Ray
     */
    public Renderer(Camera camera, Scene scene) {
        this.camera = camera;
        this.scene = scene;
    }


    /**
     * The render method which is the function that gets called from the
     * controller. We give it an image and loop through all the pixels and set
     * the colors of the pixels based on the Ray intersections.
     * @param image An Image object whose pixels we color based on the
     *              intersections from the Rays
     * @see main.Controller
     * @see utilities.Image
     * @see utilities.Ray
     */
    public void render(Image image) {
        camera.setOrigin(new Vector3D(0,0,200));
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {

                image.draw(x, y, getPixelColor(x, y, image.getWidth(), image.getHeight()).toInteger());
            }
        }
        image.write();
    }


    /**
     * The findHit method loops through all the shapes in the scene and looks
     * if they intersect with the ray parameter. If it hits one, it checks if
     * the 'distance'(t) to the object is smaller than that of the previous
     * ray. If so, it means an object is hit that was closer to us. So replace
     * the t value of the ray to that of the hitRay
     * @param ray A Ray object which is shot through a pixel. Used to look for
     *            an intersection with an Object
     * @return A RayHit object which contains information about the
     *         intersection and the object it hit.
     * @see utilities.RayHit
     * @see utilities.Ray
     * @see geometries.Shape
     */
    private RayHit findHit(Ray ray) {
        RayHit hit = null;

        for (Shape geometry : scene.getGeometries()) {
            RayHit h = geometry.intersects(ray);
            if(h != null && h.getT() < ray.getT()) {
                hit = h;
                ray.setT(h.getT());
            }
        }
        return hit;
    }


    /**
     * The trace method use the findHit method to look for an intersection. If
     * it found one we call the shade method to get the color of the hit
     * object.
     * @param ray A Ray object which we pass to the findHit method.
     * @param depth An int value to keep track of the recursion depth.
     *              (How many secondary rays are spawned from the primary one).
     * @return A Color Object which we use to color the pixel.
     * @see utilities.RayHit
     * @see utilities.Ray
     * @see utilities.Color
     */
    private Color trace(Ray ray, int depth) {
        RayHit hit = findHit(ray);
        Color color = scene.getBackgroundColor();

        if(hit != null) {
            color = shade(hit, depth);
        }

        return color;
    }


    /**
     * The shade method is used to loop through all the lights in the scene to
     * check if we intersect a light from the point on the object. If not it
     * means it is in the shadow and we can give it a dark color. Also
     * calculate a reflection ray to see how the light bounces off of the hit
     * object and add all those colors together.
     * @param hit A RayHit object that has information about the hit object.
     * @param depth A int value which specifies the amount of secondary rays
     *              spawned from the primary ray.
     * @return A Color Object which we pass up to the trace function that uses
     *         it to color the pixels.
     * @see utilities.RayHit
     * @see utilities.Ray
     * @see utilities.Light
     * @see utilities.Color
     */
    private Color shade(RayHit hit, int depth) {
        Color color = scene.getBackgroundColor();

        for(Light light : scene.getLights()) {
            Vector3D lightTarget = hit.getHitPoint().subtract(light.getPosition());
            Ray lightRay = new Ray(hit.getHitPoint(), lightTarget);
            lightRay.setT(lightTarget.length());

            RayHit obstruction = findHit(lightRay);
            if (obstruction == null) {
                Color lightColor = light.getColor(hit);
                color.add(lightColor);
            }
        }

        if (depth <= MAX_RECURSION_LEVEL && hit.getShape().isReflective()) {
            // Create temporary color to store the color we get from trace so
            // that we can use the intensify function which operates on the
            // color object itself and multiplies the geometry its reflection
            // value with the color.
            Color temp = trace(hit.getReflectionRay(), depth + 1);
            temp.intensify(hit.getShape().getReflection());
            color.add(temp);
        }
        return color;
    }


    /**
     * The getPixelColor method is the method that is used to convert the Image
     * pixels to screen pixels and passes them to the createRay method to get a
     * Ray that goes through the pixel. Which we can then pass to the trace
     * function.
     * @param x An int value that represents the x coordinate on the Image.
     * @param y An int value that represents the y coordinate on the Image.
     * @param width An int value that represents the width of the Image.
     * @param height An int value that represents the height of the Image.
     * @return A Color object which represents the color of the pixel on the
     *         image.
     * @see utilities.Image
     * @see utilities.Ray
     * @see renderer.Camera
     * @see utilities.Color
     */
    public Color getPixelColor(int x, int y, int width, int height) {
        double pixelX = 2 * (x + 0.5) / width - 1;
        double pixelY = 1 - 2 * (y + 0.5) / height;
        Ray ray = camera.createRay(pixelX, pixelY);
        return trace(ray, 0);
    }
}
