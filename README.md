# Maze generation and comparison of maze solving algorithms

In this project I will create a program that generates perfect mazes (mazes with only one solution and no loops) and compares dead-end filling and a recursive algorithm as maze solving methods by analyzing their execution times.

## Useful links
[Specifications](https://github.com/H4m5t3r/Comparison-of-maze-solving-algorithms/blob/master/Documentation/Specifications.md)
#### Weekly reports
[Week 1](https://github.com/H4m5t3r/Comparison-of-maze-solving-algorithms/blob/master/Documentation/Weekly%20reports/Week%201.md)

[Week 2](https://github.com/H4m5t3r/Comparison-of-maze-solving-algorithms/blob/master/Documentation/Weekly%20reports/Week%202.md#week-2)

## Useful commands
**Run these commands in the folder "MazeAlgorithmsComparison"**

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
Generate a Javadoc that cna be found in */target/site/apidocs*
```
mvn javadoc:javadoc
```
