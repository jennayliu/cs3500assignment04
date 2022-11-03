# CS3500 Assignment04
## By Jenna and John


**All the images used for testing were created by ourselves**

The controller is represented by the ImageController
interface and implemented by ImageControllerImpl. Its main purpose is calling
control(), which allows the user to interact with the program through
a Readable. Note that the ImageControllerImpl currently has a somewhat
useless Appendable field that will be replaced by a view in later 
assignments.

The model is represented by ImageModel and implemented by
ImageModelImpl. It has one field which is a HashMap<String, PixelRBG[][]>.
This allows the model to store images according to a name
the user wants to use to refer to the image as. The model is 
responsible for implementation of the images, modifying, loading, or saving
them as needed.

Assisting the model is a function object interface called
ImageFunctionObject. This interface contains one sole method: apply(PixelRGB[][]);
Based on the implementation of the interface, apply takes in an image
and modifies it. The model's process method can take in an ImageFunctionObject
and use its apply method to modify one of its images.

**Script Commands**

Load an image from your files and refer to it henceforth by a new name
```
load (file-name)
```
Save an image to your files from the program 
```
save (image-name, new-file-name, new-image-name)
```
Greyscale the image based on the red, green, blue, value, intensity, or luma
of the image
```
red-component (image-name, new-image-name)

green-component (image-name, new-image-name)

blue-component (image-name, new-image-name)

value-component (image-name, new-image-name)

intensity-component (image-name, new-image-name)

luma-component (image-name, new-image-name)
```

Flip the image horizontally
```
horizontal-flip (image-name, new-image-name)
```
Flip the image vertically
```
vertical-flip (image-name, new-image-name)
```
Brighten the image based on an amount. You can input
a negative value to darken the image instead.
```
brighten (amount, image-name, new-image-name)
```