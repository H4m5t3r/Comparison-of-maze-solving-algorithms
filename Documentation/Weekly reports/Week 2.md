# Week 2

There has been a small change to the subject of this project: instead of only focusing on maze solving algorithms the project will also include maze generating. I spent this week gathering information about maze generation and started implementing the recursive backtracing algorithm. I also added Checkstyle and Jacoco plugins that can be run with the commands on the project's [front page](https://github.com/H4m5t3r/Comparison-of-maze-solving-algorithms). For some reason the Checkstyle file filter I've created doesn't work. I've placed the skipped_files.xml file in the same folder as the Checkstyle and addded it as a module but the report still includes the GUI class.

At the time of writing I've managed to make the program generate a non-random maze. Debugging is easier in a controlled environment. When the program is started a window appears where the user can change the width and the height of the maze. When the "Generate" button is clicked the program generates a maze and visualizes it. I noticed that once the maze size is larger than 5*5 the whole area is not used. Looking at what is printed in the console it seems like I've done something wrong implementing the direction stack. The program can also generate a random maze if the two Collections.shuffle() methods in the MazeGenerator class are enabled, but because of the error I seem to have made somewhere the mazes do not cover the whole area. Another thing worth mentioning is that 0 stands for up, 1 for right, 2 for down and 3 for left. I noticed that it is never made clear in the code.

I created JUnit tests for the methods that have been completed. They can be run with the command on the [front page](https://github.com/H4m5t3r/Comparison-of-maze-solving-algorithms) No tests have been created for the maze generating algorithm itself since it is not complete yet. I noticed that even though the Cell and Neighbor classes have been deleted they still appear in the Jacoco report. I don't know why.

There are a few spots in the code that could be replaced with methods instead of using repetetive code. I will do some changes when the maze generating code works corretly. Other improvements what could be done would be to correct the current Checkstyle errors. Right now there are 5 that are linked to the Logic and MazeGenerator classes. The rest of the errors are related to the GUI class which, as mentioned earlier, for some reason is still included in the Checkstyle scan.

For some reason there is an error when I try to generate a Javadoc. The file is generated but I couldn't figure out how to get rid of the error.

When I manage to get the maze generating algorithm working my next step will be to implement the maze solving algorithms and make improvements to the code.

| Day | Hours | What I did  |
| :----:|:-----| :-----|
|19.5|6| I started gathering information about maze generation, created a base structure for the program and added Checkstyle. |
|20.5|5| I worked on the GUI and started implementing the recursive backtracing maze generation algorithm. |
|21.5|4| I made some progress with the recursive backtracing algorithm but it doesn't work correctly yet. |
|22.5|8| I worked on the recursive backtracing algorithm and updated the documentation. |

Total number of hours this week: 23
