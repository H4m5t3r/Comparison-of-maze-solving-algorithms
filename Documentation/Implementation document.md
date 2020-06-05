# Implementation document

The different algorithms used in this program are all implemented in their own Java classes. These are controlled by the class called "Logic". The graphical user interface uses a Logic class to call different methods from the classes when the user clicks different buttons.

*insert class diagram*

The mazes that are generated and solved are two-dimensional character arrays with corridors and walls. This means that when the width is x and the height is y it actually means that the size of the two-dimensional array is (2x + 1) * (2y + 1) because there are walls between the corridors and on each side of the maze.

Some of the algorithms use data structures like stacks and linked lists. These have been implemented in the package called "maze.data_structures".

**Sources used in this project:**

Maze solving algorithm, Wikipedia 2020, viewed 15.5.2020
https://en.wikipedia.org/wiki/Maze_solving_algorithm

Think Labyrinth: Daedalus
http://www.astrolog.org/labyrnth/daedalus.htm
