# CS3500 Assignment04
## By Jenna and John


**All the images used for testing were created by ourselves**

Through testing, every part of the program is complete
in the sense that it is working.

The controller is represented by the ImageController
interface and implemented by ImageControllerImpl. Its main purpose is calling
control(), which allows the user to interact with the program through
a Readable. Note that the ImageControllerImpl currently has a somewhat
useless Appendable field that will likely be replaced by a view in later 
assignments.
*The controller's design has stayed the same since the previous assignment,
but there have been more commands added to support additional functions.*

The model is represented by ImageModel and implemented by
ImageModelImpl. It has one field which is a HashMap<String, PixelRBG[][]>.
This allows the model to store images according to a name
the user wants to use to refer to the image as. The model is
responsible for implementation of the images, modifying, loading, or saving
them as needed. *The model's design has stayed the same since the previous
assignment. The only change is moving the makeImageCopy() method
to the ImageUtil class.*

Assisting the model is a function object interface called
ImageFunctionObject. This interface contains one sole method: apply(PixelRGB[][]).
Based on the implementation of the interface, apply takes in an image
and modifies it. The model's process method can take in an ImageFunctionObject
and use its apply method to modify one of its images. *This interface's design
has stayed the same since the previous assignment. We simply added three more
classes: Blur, Sharpen, and Transform.*

As mentioned before, we moved the makeImageCopy() method to
the ImageUtil class as a public static method instead of a private one. 
This is because we figured that this method was appropriate
for the class, and also because we needed the method beyond 
just in the model.

A user can interact with the program via System.in or
a script file. More info in the USEME file, which lists
every command.

