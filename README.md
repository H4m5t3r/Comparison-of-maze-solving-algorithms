# Maze generation and comparison of maze solving algorithms

In this project I will create a program that generates perfect mazes (mazes with only one solution and no loops) and compares dead-end filling and a recursive algorithm as maze solving methods by analyzing their execution times.

**Note: When the program is run from the terminal it will not automatically give the JVM extra memory. Because of this the performance test for the recursive backtracker generator will not be able to run because it will run out of memory and cause an error. Occasionally the generator may run out of memory if the size of the maze is somewhere around 150 * 150.**

## Useful links
[Specifications](https://github.com/H4m5t3r/Comparison-of-maze-solving-algorithms/blob/master/Documentation/Specifications.md)

[Implementation document](https://github.com/H4m5t3r/Comparison-of-maze-solving-algorithms/blob/master/Documentation/Implementation%20document.md#implementation-document)

[Testing document](https://github.com/H4m5t3r/Comparison-of-maze-solving-algorithms/blob/master/Documentation/Testing%20document.md#testing-document)

#### Weekly reports
[Week 1](https://github.com/H4m5t3r/Comparison-of-maze-solving-algorithms/blob/master/Documentation/Weekly%20reports/Week%201.md)

[Week 2](https://github.com/H4m5t3r/Comparison-of-maze-solving-algorithms/blob/master/Documentation/Weekly%20reports/Week%202.md#week-2)

[Week 3](https://github.com/H4m5t3r/Comparison-of-maze-solving-algorithms/blob/master/Documentation/Weekly%20reports/Week%203.md#week-3)

[Week 4](https://github.com/H4m5t3r/Comparison-of-maze-solving-algorithms/blob/master/Documentation/Weekly%20reports/Week%204.md#week-4)

[Week 5](https://github.com/H4m5t3r/Comparison-of-maze-solving-algorithms/blob/master/Documentation/Weekly%20reports/Week%205.md#week-5)

## Useful commands
**Run these commands in the folder "MazeAlgorithmsComparison"**

Run the program
```
mvn compile exec:java -Dexec.mainClass=maze.main.Main
```

Generate a Jacoco report that can be found in */target/site/jacoco*
```
mvn test jacoco:report
```

Generate a Checkstyle report that can be found in */target/site*
```
mvn jxr:jxr checkstyle:checkstyle
```

Run the JUnit tests
```
mvn test
```
Generate a Javadoc that can be found in */target/site/apidocs*
```
mvn javadoc:javadoc
```
