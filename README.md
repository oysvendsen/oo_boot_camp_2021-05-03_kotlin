# oo_boot_camp_2021-05-03_kotlin

Copyright (c) 2021 by Fred George  
May be used freely except for training; license required for training.

OO Boot Camp reference implementation for Norwegian client in
May 2021, in Kotlin.

## Student instructions

Kotlin is relatively easy to setup with IntelliJ IDEA. 
The following instructions are for installing the code 
in IntelliJ 2021 by JetBrains. 
Adapt as necessary for your environment.

Note: This implementation was setup to use Kotlin 1.4.32, Java SDK 15, 
and JUnit 5-style for testing.

Open the reference code:

- Download the source code from github.com/fredgeorge
    - Clone, or pull and extract the zip
- Open IntelliJ
- Choose "Open" (and NOT Gradle build or import)
- Navigate to the reference code root, and enter

Source and test directories should already be tagged as such. Confirm or fix:

- File/Project Structure...
- Select "Modules"
    - Tag src directory as Sources in *exercises* module
    - Tag test directory as Tests in *tests* module
    - Add a *dependency* of the *tests* module on the *exercises* module 
    - Click "OK"
- Navigate to the RectangleTest class in the tests/test/unit package
    - The *@Test* directive should be red (wait for the compiler to catch up)
    - Choose the correction option that supports Junit5 (not 4)

Confirm that everything builds correctly (and necessary libraries exist).
There should be errors in RectangleTest. 
Fixing them is the first exercise!

## Creating this structure from scratch

The following is *only* to assist in creating the exercises from scratch.
Cloning from github is preferred (if you can get it to work).

Create a new github public repository, named
consistently with other projects, including README.md and .gitignore.
Checkout this skeleton to start.

Create a new Kotlin project using Java... Kotlin/JVM.
There are many Kotlin alternatives, including under Kotlin and Gradle. 
Use the Kotlin option under Java instead.
Target the directory just imported from github.
Override the module defaults to create *exercises*
as the default module, placing it as a subdirectory.

Create a *tests* **module** under the root

- Create a directory *test* under the tests module
- Create a directory *unit* under the test directory
- Delete the directory *src* under the tests module
- In settings for the tests module, establish *test* directory as a test directory
- In settings for the tests module, establish a dependency on the *exercises* module

Tag src and test directories as such:

- File/Project Structure...
- Select "Modules"
    - Tag src directory as Sources
    - Tag test directory as Tests
    - Click "OK"

Choose the Java JDK and Java levels to use (I use the latest of both)

Create a RectangleTest Kotlin class in the test/unit package.

- Create the first test:
  @Test fun area() {
  assertEquals(24.0, Rectangle(4, 6).area);
  }
- Highlight @Test let IntelliSense suggest a JUnit binding
- Choose the JUnit 5 option

Confirm that everything builds correctly (and necessary libraries exist).
Start implementing Rectangle in a new rectangle package until all compile
errors are gone. Then run all the tests in the test package.
