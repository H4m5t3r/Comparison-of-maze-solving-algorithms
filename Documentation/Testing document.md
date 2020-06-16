# Testing document

This program is tested using two kinds of tests: JUnit tests and performance tests.

# Junit tests
The JUnit tests are located in the package called "tests". They can be run using the command `mvn test` in the folder called "MazeAlgorithmsComparison". These tests have been created to make sure that every part of the program works correctly by testing it in smaller parts. An example of this is the DeadEndFilling class. In this case there are two important methods: isDeadEnd() and fillDeadEnd(). The isDeadEnd method is tested by creating two-dimensional character arrays that contain all the possible scenarios it could come across and checking that it returns the correct boolean answer. The classes used in the program have all been tested in similar ways.

## Algorithms

### RecursiveBacktrackerTest
This class has 3 tests. mazeIsOnlyMadeOfWallsAfterInit checks that the maze's base is only made of walls after it has been initialized. removeWallWorks checks that walls are removed from the correct space when the removeWall method is called. The final test numberOfBlankSpacesCorrect checks that the number of blank spaces in the generated maze is correct. The maze is random, but what we do know is that since this maze is a minimum spanning tree the number of blank spaces should be equal to the number of rooms plus the corridors between them (rooms - 1) plus an entrance and exit.

### KruskalMazeTest
Two main things are tested in this class. The first one includes the 4 first tests that all check that the calculations that the KruskalMaze class does when checking the adjacent rooms are correct. 4 different mazes are tested to make sure that the calculations are not only correct for a maze with a specific height. The correct results were checked manually. The second main thing that this class tests is the same thing that numberOfBlankSpacesCorrect in the RecursiveBacktrackerTest class does. It checks that the maze actually is a minimum spanning tree.

### DeadEndFillingTest
This class tests different scenarios that the algorithm could come across. This includes L-shaped turns, T and X junctions and dead-ends.  The tests check if isDeadEnd() returns true only when there is a dead-end.

**The two-dimensional array used int the test:**
```
char[][] test1 = {
    {'#', '#', '#', '#', '#'},
    {'#', ' ', ' ', ' ', '#'},
    {'#', ' ', '#', ' ', '#'},
    {'#', ' ', ' ', ' ', '#'},
    {'#', '#', '#', '#', '#'}
};

char[][] test2 = {
    {'#', ' ', '#', '#', ' ', '#'},
    {' ', ' ', '#', ' ', ' ', ' '},
    {'#', ' ', '#', '#', '#', '#'},
    {'#', '#', '#', '#', ' ', '#'},
    {' ', ' ', ' ', '#', ' ', ' '},
    {'#', ' ', '#', '#', ' ', '#'}
};

char[][] test3 = {
    {'#', '#', '#', '#', '#', '#', '#'},
    {'#', '#', '#', ' ', '#', '#', '#'},
    {'#', '#', '#', ' ', '#', '#', '#'},
    {'#', ' ', ' ', ' ', ' ', ' ', '#'},
    {'#', '#', '#', ' ', '#', '#', '#'},
    {'#', '#', '#', ' ', ' ', ' ', '#'},
    {'#', '#', '#', ' ', '#', '#', '#'},
    {'#', '#', '#', ' ', '#', '#', '#'},
    {'#', '#', '#', '#', '#', '#', '#'}
};
```

The class also tests if the algorithm works correctly in an example labyrinth.

```
char[][] test = {
    {'#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#'},
    {'#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', '#'},
    {'#', '#', '#', '#', '#', ' ', '#', ' ', '#', ' ', '#'},
    {'#', ' ', ' ', ' ', '#', ' ', ' ', ' ', '#', ' ', '#'},
    {'#', '#', '#', ' ', '#', '#', '#', '#', '#', ' ', '#'},
    {'#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
    {'#', ' ', '#', '#', '#', '#', '#', '#', '#', ' ', '#'},
    {'#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', '#'},
    {'#', ' ', '#', '#', '#', '#', '#', ' ', '#', '#', '#'},
    {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
    {'#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#'}
};

char[][] solution = {
    {'#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#'},
    {'#', '#', '#', ' ', ' ', ' ', '#', ' ', ' ', ' ', '#'},
    {'#', '#', '#', '#', '#', ' ', '#', ' ', '#', ' ', '#'},
    {'#', '#', '#', '#', '#', ' ', ' ', ' ', '#', ' ', '#'},
    {'#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#'},
    {'#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#'},
    {'#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#'},
    {'#', '#', '#', '#', '#', '#', '#', ' ', ' ', ' ', '#'},
    {'#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#'},
    {'#', '#', '#', ' ', ' ', ' ', ' ', ' ', '#', '#', '#'},
    {'#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#'}
};
```

### DepthFirstSearchTest
There are 3 tests in this class. entranceAndExitFoundTest checks that the entrance and exit are found and that the algorithm starts below the entrance. pathFindTest tests if a test maze is solved correctly by checking that all rooms on the correct path and the corridors between them are marked with "c". largerMazeTest checks if the exit has been found when a larger maze is generated.

### FisherYatesShuffleTest
This class contains one test. It checks that all the numbers that were on the list before it was shuffled is still present after it has been shuffled.

## Data structures
### StackTest
This class test the stack's methods (push(), pop(), peek(), size(), isEmpty()) by adding and removing values from it.

### LinkedListTest
Here the properties of a linked list are tested by using its available methods and checking that the list still is intact.

### UnionFindTest
The union-find data structure is tested by checking if different nodes are connected when they should and if the structure finds the correct root node.


# Performance tests
The performance tests are part of the program and can be run by the user. When the program is started there is a button that says "Performance tests". When this button is pressed the user is taken to a view where they can start the tests. The performance test is run in the class called "PerformanceComparator". It makes the different algorithms perform their task multiple times and displays the results after the test is done. At the moment there is no loading screen so after the button that starts the performance test is pressed the user has to wait for about 40 seconds.