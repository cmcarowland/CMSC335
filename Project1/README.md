# Project 1 Java OO Shapes

- [Project Requirements](#project_requirements)
- [Installation](#installation)
- [Usage](#usage)
- [Troubleshooting](#troubleshooting)
- [Example](#example)

## Project Requirements

Design, implement and test a Java class Inheritance hierarchy that would satisfy the following is-a and has-a relationships:

<details Open>
    <summary>Show Project Requirements</summary>

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
- [x] A Cylinder is a ThreeDimensionalShape
- [x] A Torus is a ThreeDimensionalShape

- [x] Create a command line driven menu that allows a user to construct each of the TwoDimensional and ThreeDimensional Shape subclasses. 
- [x] The menu should continue to loop prompting for a specific class and then prompt for appropriate input parameters. 
- [x] The values returned should be the volume or area as appropriate to the shape. 
- [x] Error checks should be in developed to make sure appropriate menu items and types of data were input and prompt the user to enter to correct data. 
- [x] An option to exit the program should be available as well that will provide an appropriate Thank you message along with the current date and time.

</details>

## Installation

To build the project press the play button for your IDE’s Java build and run pipeline. 
If that fails you can use make and the provided Makefile.
### Makefile Options 
- all
- main : Build the main package
- tests : Build the test package. 
- executeTests :  Allows the user to execute the tests using the JUnit runner from the command line. (not recommended but will get results)

### Tests 
Run the tests in VSCode test explorer or equivilent test suite.

## Usage
Perfered method is to use a IDE's build and run tools. Open the project and once your Java environment is in a ready state open the Project1.java file and press the run button for the IDE.

#### Backup method
From a terminal, “cd” into the Project directory you unzipped the project into in the steps above. Once in the Project1 directory enter the command “make” and the project will build main and tests packages. Your class files will be placed in a folder called bin with the structure below. 

- Project1 
    - bin 
        - main 
        - tests 

Change directory into Project1/bin and run the command java main.Project1

## Troubleshooting
If your project stops building and running with the Java plugins you may have a Java cache issue. In VSCode on a failed build there will be an option to clear the cache.  This has fixed the buiid pipeline issues for me in the past. If this will not work the Makefile was created as a work-around.

## Example
<details Open>
    <summary>Show Example</summary>

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

</details>