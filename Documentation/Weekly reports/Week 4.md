# Week 4

This week I implemented the depth-first search algorithm and added a class called "PerformanceComparator" that runs a performance test. This test can be run from the UI by the user. Right now the test generates 10 mazes and calculates an average generation time. I will modify it so that it generates 11 mazes and discards the first result to avoid collecting incorrect data because of Java's Just In Time compilation. Since the mazes are all random it would perhaps also be a better idea to display the results of every run in a table so that is easier to compare how the solving algrithms perform. I'm unsure of how many runs I should set the test to perform. When the size of the labyrinth is 5000 * 5000 and the generating algorithm is run 10 times it takes 1-2 minutes to complete the tests. I set it to 3000 * 3000 to make it easier to test the program's features. The UI won't let the user create mazes larger than 150 * 150 because it makes the window run really slow because of all the JavaFX elements on the screen, but larger mazes can be created by the generator class now that I increased the the program's available memory.

When compiling the code the program's memory has to be increased or the test won't have enough memory to run the recursive algorithm. I don't know what the exact stable values are be but when the maximum stack size was set to 200 MB and the maximum heap size was set to 600 MB the performance test
seemed to run without any problems.

My plans for next week are to make the performance test display the results of individual runs and to implement another maze generating algorithm using either Kruskal's or Prim's algorithm. They seem to work in a similar way and regardless of which one I choose to implement it seems like I will have to create some kind of union-find structure. I'm unsure of how to choose a random room in the Kruskal variant or choosing a "minimum value" room i Prim's variant. One way of choosing random values would be to make each coordinate have a number and adding each number 4 times to a stack. I could get a random order by picking random values from a linked list and adding them to the stack, but this could get inefficient if the labyrinths are large and the program has to go through many values to get to one of them.

How much I can expand the program after I've implemented another maze generating algorithm is unclear. If I have enough time left I might impelement one more algorithm. It depends on how challenging or easy the one I'm working on now will be.

| Day | Hours | What I did  |
| :----:|:-----| :-----|
|31.5|3| I corrected an error in the LinkedList class and created more tests. |
|3.6|5| I corrected Checkstyle errors, implemented the depth-first search algorithm, created tests for it and gathered info about how to use Kruskal's algorithm to generate mazes. |
|4.6|4| I modified the pogram's structure to be able to implement another maze generating algorithm and increased the program's available memory so that mazes larger than 150 * 150 can be created. I also added a new class called "PerformanceComparator". This class will be used for the performance tests. |
|5.6|5| I created performance tests, added new views to the UI so that the tests can be started by the user and updated the documentation. |
Total number of hours this week: 17