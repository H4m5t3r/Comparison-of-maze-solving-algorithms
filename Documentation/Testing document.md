# Testing document

This program is tested using two kinds of tests: JUnit tests and performance tests.

# Junit tests
The JUnit tests are located in the package called "tests". They can be run using the command `mvn test` in the folder called "MazeAlgorithmsComparison". These tests have been created to make sure that every part of the program works correctly by testing it in smaller parts. An example of this is the DeadEndFilling class. In this case there are two important methods: isDeadEnd() and fillDeadEnd(). The isDeadEnd method is tested by creating two-dimensional character arrays that contain all the possible scenarios it could come across and checking that it returns the correct boolean answer. The classes used in the program have all been tested in similar ways.

![jacoco test coverage](https://raw.githubusercontent.com/H4m5t3r/Comparison-of-maze-solving-algorithms/master/Documentation/Pictures/test_coverage.png)

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
```
char[][] test = {
    {'#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#'},
    {'#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
    {'#', ' ', '#', '#', '#', '#', '#', ' ', '#', ' ', '#'},
    {'#', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#'},
    {'#', ' ', '#', ' ', '#', '#', '#', '#', '#', ' ', '#'},
    {'#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#'},
    {'#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#'},
    {'#', ' ', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', '#'},
    {'#', ' ', '#', ' ', '#', ' ', '#', '#', '#', ' ', '#'},
    {'#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
    {'#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#'}
};

char[][] solution = {
    {'#', '#', '#', '#', '#', '#', '#', 'c', '#', '#', '#'},
    {'#', ' ', '#', ' ', ' ', ' ', ' ', 'c', 'c', 'c', '#'},
    {'#', ' ', '#', '#', '#', '#', '#', ' ', '#', 'c', '#'},
    {'#', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', 'c', '#'},
    {'#', ' ', '#', ' ', '#', '#', '#', '#', '#', 'c', '#'},
    {'#', ' ', ' ', ' ', '#', 'c', 'c', 'c', 'c', 'c', '#'},
    {'#', '#', '#', '#', '#', 'c', '#', '#', '#', '#', '#'},
    {'#', ' ', ' ', ' ', '#', 'c', '#', ' ', ' ', ' ', '#'},
    {'#', ' ', '#', ' ', '#', 'c', '#', '#', '#', ' ', '#'},
    {'#', ' ', '#', 'c', 'c', 'c', ' ', ' ', ' ', ' ', '#'},
    {'#', '#', '#', 'c', '#', '#', '#', '#', '#', '#', '#'}
};
```

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
The performance tests are part of the program and can be run by the user. When the program is started there is a button that says "Performance tests" in the menu. When this button is clicked the user is taken to a view where they can start the tests. The performance test is run by the class called "PerformanceComparator". It makes the different algorithms perform their task multiple times and displays the results after the test is done. There are three parts.

## Part 1
In this part the maze generating algorithms (recursive backtracker and Kruskal) are tested. First they are run one time to make sure that the code has been compiled before the test data is gathered (because of Java's just-in-time compilation). Then both algorithms are run 10 times and an average value is calculated. The mazes that are generated in these tests have a width and height of 3000. If the program is run in NetBeans it is important ot allocate enough memeory for the JVM stack and heap. Otherwise the recursive backtracker algorithm will run out of memory.

## Part 2
In this part test data is gathered on how long it takes for the dead-end filling and depth-first search algorithm to solve mazes generated by the recursive backtracker algorithm. The mazes have the same width and height as in part 1 (3000 * 3000). A similar procedure is run where a maze is generated and then the solving algorithms both solve it before once before the actual test data is gathered. When the data gathering starts the same procedure is repeated 5 times. When the results are shown the time from each individual run as well as an average value is displayed. More information about running the tests can be found in the [user manual](https://github.com/H4m5t3r/Comparison-of-maze-solving-algorithms/blob/master/Documentation/Manual.md).

## Part 3
In this part the same procedure is repeated as in part 2 but now the solving algorithms solve mazes generated by Kruskal's algorithm.

# Test data
There is also a class called "Datagathering". This class runs the same tests as the PerformanceComparator class but it runs them 100 times and creates text files containing the test data. The mazes are 3000 * 3000 Below are some examples of the results.

### Recursive backtracker maze generation
![recursive backtracker maze generation](https://raw.githubusercontent.com/H4m5t3r/Comparison-of-maze-solving-algorithms/master/Documentation/Pictures/recb.png)

### Kruskal maze generation
![kruskal maze generation](https://raw.githubusercontent.com/H4m5t3r/Comparison-of-maze-solving-algorithms/master/Documentation/Pictures/kruskal.png)

### Recursive backtracker maze solving
![recursive backtracker maze solving](https://raw.githubusercontent.com/H4m5t3r/Comparison-of-maze-solving-algorithms/master/Documentation/Pictures/recSolve.png)

### Kruskal maze solving
![kruskal maze solving](https://raw.githubusercontent.com/H4m5t3r/Comparison-of-maze-solving-algorithms/master/Documentation/Pictures/kruskalSolve.png)
