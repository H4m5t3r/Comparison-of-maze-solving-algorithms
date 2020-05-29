This week I completed the recursive backtracker algorithm and implemented the dead-end filling algorithm. I also created a new package called data_structures where I created a stack and linked list class. These classes have now replaced Java's own classes PriorityQueue and LinkedList, which I used in the maze generator before my own classes were created. I have written tests for these classes and they also seem to work correctly when used in the recursive backtracking algorithm.

The GUI has also gotten an update. There are now 3 views: newMaze, viewMaze and solvedMaze. When the program is started the newMaze view is displayed. The user can change the width and height of the maze. When the "Generate" button is clicked the maze is generated and the viewMaze view is displayed. The maximum width and height has been set to 150. When I tried setting both to 200 I got a StackOverflow error when the maze was being generated. This could probably be avoided by allocating more memory for the program. The user can let the program solve the maze with the dead-end filling method or to go back to the first view and change the size of the mazes that are generated. When the maze has been solved the solvedMaze view is displayed. The user can either generate a new maze or go back to the settings.

During the coming weeks I may add a checker to the UI that scales the size of the displayed maze according to how big it is set to be. Right now it displays the JavaFX squares used for displaying the maze are always the same size, but it would be practical to have a size modifier. This is still just an idea and I may not implement it before most of the project is done. Right now my main focus is on implementing the recursive depth-first search algorithm. Once that is done I will either work on the part of the program that will compare the algorithms' performance time or implement more generating and solving methods.

Another improvement that could be done would be to make the filled dead ends grey instead of just blacking them out so that they can still be seen. This would mean that I have to change the code since it assumes that all walls an filled corridors are marked with '#'.

| Day | Hours | What I did  |
| :----:|:-----| :-----|
|24.5|4| I created a linked list class. This class will be used for choosing random directions when the mazes are generated. |
|25.5|1| I created a stack class. |
|26.5|3| I wrote tests for the stack class and debugged the maze generator. |
|28.5|5| I implemented the dead-end fill algorithm. |
|29.5|3| I added more options to the GUI and updated the documentation. |

Total number of hours this week: 16