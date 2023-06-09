# FriskyBrainGame
## Machine Problem for CMSC 13

This program Frisky Brain is a game about a student taking a final exam in one of his major subjects, the Survey of 
Programming Paradigms. The exam questions are sequential, meaning one cannot go back to the previous question once 
the player has already moved to the next question. It is comprised of 30 multiple choice questions, which will be 
randomly generated by the game each time the program is executed, 15 questions are theoretical, and the other 15 are 
about programming languages. The user must achieve a passing score equivalent to 60% to pass the said subject.


The FriskyBrainGame folder holds the src, build, dist and nbproject folder. 

The src folder contains four sub folders namely FriskyBrain, Images, Questions and Sound. The FriskyBrain folder contains 
the source code, the .java files where the `Frisky_Brain.java` file is the main class. On the other hand, the Images 
folder contains the images for the programming questions part of the game, the images includes the code snippets both 
for the questions and the choices. The Questions folder holds the `CS13 Questions.csv` file that stores all the questions,
choices, and the filenames of the images. The Sound folder keeps the sound effects and the background music files of 
the game. 


The build folder is the output directory for compiled classes.


The dist folder is where the jar file is located.


To run the project from the command line do the following:

1. Ensure that all the java files found in the FriskyBrain folder are compiled which is the 
   first step to perform.
2. After which, you can now proceed to run the program in the command prompt.
2. In the command prompt navigate to the FriskyBrainGame folder 
3. Go to the src folder 
3. Then type: `java FriskyBrain.Frisky_Brain`


You can also run the project from the command line through:

Navigating to the dist folder and typing the following:
`java -jar "FriskyBrainGame.jar"` 

----------------------------------------------------------------------------------------------------------------------------------------------------

To run the project from the NetBeans IDE, do the folllowing:

1. Open the NetBeans application
2. Then click the File tab 
3. Select Open project,
4. Then choose the file FriskyBrainGame.
5. Lastly, click the green triangle or press F6 to run the project.


Developers:

+ EG Renz S. Go 
+ Thereze Nuelle Roca
