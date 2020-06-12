# Week 5

This week I implemented the Kruskal maze generator. This class generates perfect mazes by creating a minimum spanning tree. In my implementation there are two things that the program keeps track of: rooms (the pink numbers) and corridors (marked with blue circles). The algorithm checks if the rooms in each side of it are connected and if they aren't it removes the wall. More informantion can be found in the [implementation document](https://github.com/H4m5t3r/Comparison-of-maze-solving-algorithms/blob/master/Documentation/Implementation%20document.md#implementation-document). I have not created tests for this class yet but the dead-end solve method confirms that it works correctly since there would be extra green lines if there were any loops or other errors in the maze.

![Kruskal implementation](https://raw.githubusercontent.com/H4m5t3r/Comparison-of-maze-solving-algorithms/master/Documentation/Pictures/Kruskal%20example.jpg)

Next week I will work on the performance tests and the documentation. It seems like I won't have enough time to implements more algorithms so from now on I will focus on finishing what I've got.

| Day | Hours | What I did  |
| :----:|:-----| :-----|
|8.6|5| I started implementing the maze generating algorithm that is based on creating a minimum spanning tree using Kruskal's algorithm and created the needed data structures. |
|9.6|4| I worked on the calculation methods in the KruskalMaze class. |
|10.6|4| I completed the Kruskal maze algorithm and added it to the GUI. |
|12.6|3| I updated the documentation and did a peer review. |

Total number of hours this week: 16