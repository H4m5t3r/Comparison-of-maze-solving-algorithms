# Manual

Start with downloading the latest version of the program [here](ADD LINK TO RELEASE). It uses Java version 11, so make sure you have Java installed.

## Starting the program
Once you have downloaded the jar file you can run it with the following command (make sure you run it in the directory where the file is saved):
```
java -jar -----------.jar
```

## The menu
Once you run the program the menu screen will appear. Here you have the option to set the size of the mazes that will be generated. You can change the width and height by one by clicking the plus and minus buttons or jump to a given size by clicking the buttons with numbers. The minimum size is 2 and the mazimum size is 150. At the top edge you will see three other buttons: "Recursive backtracker", "Kruskal" and "Performance tests". The first two will generate mazes using the recursive backtracker method and Kruskal's algorithm. More information about this can be found in the [implementation document](https://github.com/H4m5t3r/Comparison-of-maze-solving-algorithms/blob/master/Documentation/Implementation%20document.md#maze-generating-algorithms). The "Performance tests" button will take you to the part of the program where the performance tests can be run. More on this later in the document.

## Maze generation and solving
When one of the two maze generation buttons ("Recursive backtracker" and "Kruskal") is clicked a maze will be generated and displayed. Now two new buttons will have appeared on the screen: "Dead-end filling" and "Depth-first search". When one of them is clicked the maze will be solved using the respective method. More information about this can also be found in the [implementation document](https://github.com/H4m5t3r/Comparison-of-maze-solving-algorithms/blob/master/Documentation/Implementation%20document.md#maze-solving-algorithms). The correct path will be marked as green. New mazes can be generated be clicking the generation buttons again and the same maze can also be solved by the other solving algorithm button that is still present. To the right of the alternatives the algorithm's performance time will be displayed. It is worth noting that this is not the actual performance test that is run from a separate section of the program. You can return to the menu by clicking the button that says "Menu" in the upper right corner.

![]()