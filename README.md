# CMSC335

Design, implement and test a Java class Inheritance hierarchy that would satisfy the following is-a and has-a relationships:

- [x] A Shape is an object
- [x] A Shape has a NumberofDimensions
- [x] A TwoDimensionalShape is a Shape
- [x] A TwoDimensionalShape has an area
- [x] A Circle is a TwoDimensionalShape
- [x] A Square is a TwoDimensionalShape
- [x] A Triangle is a TwoDimensionalShape
- [x] A Rectangle is a TwoDimensionalShape

- [x] A ThreeDimensionalShape is a Shape
- [x] A ThreeDimensionalShape has a volume
- [x] A Sphere is a ThreeDimensionalShape
- [x] A Cube is a ThreeDimensionalShape
- [x] A Cone is a ThreeDimensionalShape
- [ ] A Cylinder is a ThreeDimensionalShape
- [ ] A Torus is a ThreeDimensionalShape

- [*] Create a command line driven menu that allows a user to construct each of the TwoDimensional and ThreeDimensional Shape subclasses. 
- [x] The menu should continue to loop prompting for a specific class and then prompt for appropriate input parameters. 
- [ ] The values returned should be the volume or area as appropriate to the shape. 
- [*] Error checks should be in developed to make sure appropriate menu items and types of data were input and prompt the user to enter to correct data. 
- [x] An option to exit the program should be available as well that will provide an appropriate Thank you message along with the current date and time.

### Example
```
*********Welcome to the Java OO Shapes Program ********** 
Select from the menu below:
1. Construct a Circle
2. Construct a Rectangle
3. Construct a Square
4. Construct a Triangle
5. Construct a Sphere
6. Construct a Cube
7. Construct a Cone
8. Construct a Cylinder
9. Construct a Torus
10. Exittheprogram
2
You have selected a Rectangle
What is the length?
4
What is the Width?
9.5
The area of the Rectangle is 38.
Would you like to continue? (Y or N)
3
Sorry I do not understand. Enter Y or N Y
Select from the menu below:
1. Construct a Circle
2. Construct a Rectangle
3. Construct a Square
4. Construct a Triangle
5. Construct a Sphere
6. Construct a Cube
7. Construct a Cone
8. Construct a Cylinder
9. Construct a Torus
10. Exittheprogram
10
Thanks for using the program. Today is Nov 11 at 1:40 PM.
```