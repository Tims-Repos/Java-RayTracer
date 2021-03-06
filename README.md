# Java Raytracer

My experimental raytracer made in Java without any external libraries. Created solely for learning purposes, that's why it currently generates only one image. 

I could have created a whole Java Swing GUI which would update the BufferedImage so it would actually render the scene instead of just saving a single image, but I was constrained by the deadline. I would have had to research a lot of topics in a limited time, because when using the Java Swing framework it's also good to know a few things about how multithreading works in Java. Depending on the time I need to spend on other higher priority projects, I will try adding new features to the raytracer in the future, because I think it's a really fun project from which I have learned a lot already.


## Features

- Can generate an image with the Scene on it.
- Added a few spheres, lights and a plane to the scene.
- Created an abstract class SceneObject which gives every object in the scene a position and a color
- Created an abstract class Shape which inherits from the SceneObject class and has an abstract method called intersects which all the subclasses override.
- Also trace reflection rays with a recursion depth.
- The whole project is also available as [javadoc.](https://htmlpreview.github.io/?https://raw.githubusercontent.com/Tims-Repos/Java-RayTracer/master/javadoc/overview-tree.html)
