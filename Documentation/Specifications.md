# Specifications

The two maze solving algorithms that will be compared to each other in this project are:

* dead-end filling
* recursive method

Both of these methods are used in scenarios where the algorithm has knowledge of the maze's layout prior to entering it and in this project they will be used for finding a path from one entrance to the other in perfect mazes. A perfect maze refers to a maze that does not have any loops, which means that there is only one correct path to get to the exit.

## Test data
The test data used in this project will be randomly generated two-dimensional ASCII mazes (mazes made of ASCII characters) where "#" means that there is a wall and " " means that there is a corridor.

An example of a small test maze:
```
########### #####
#         #     #
# ####### # ### #
#       # #   # #
####### # ### ###
#       # # #   #
##### ### # ### #
#     # # #     #
# ##### # ##### #
#   #     #     #
### # ### # #####
#   # # # #     #
# ### # # ##### #
# #   #     #   #
# # ### ##### ###
# #   #         #
######### #######
```

## Dead-end filling
The dead-end filling method (Maze solving algorithm, Wikipedia 2020) is based on finding all the dead-ends and filling all of these paths with walls until a crossroad is reached since they cannot lead to the exit. This will leave the algorithm with only the correct path. (Maze solving algorithm, Wikipedia 2020)

## Recursive method
The reqursive method (Maze solving algorithm, Wikipedia 2020) makes use of the ability to split up in the maze and marking the already visited places. In this case the algorithm will never reach the same coordinate in the maze since there will be no loops, but will instead go through a large amount of the corridors in the maze.

## Small analysis
What will be interesting to see in this project is if one of these two algorithms perform faster on average than the other. The time it takes for the **dead-end filling** algorithm will be the time it takes for it to cover every corridor in the maze since it will first fill all the corridors that lead to a dead-end and then follow the remaining path. This gives a time complexity of O(d + c) = O(t), where d is the amount of coordinates that lead to a dead-end, c is the amount of coordinates that are included in the correct path and t is the total amount of corridor coordinates in the maze. The memory required for the algorithm will be O(a), where a is the number of coordinates in the two-dimensional array, which is used to store the maze.

The **reqursive method** on the other hand will also cover a large part of the maze's corridors, but may end up performing faster if many of the corridors that lead to a dead-end are located after the final crossroad before the exit. If the algorithm does not go down these paths its excecution time will be the time it takes to visit all the corridors in the labyrinth minus the ones it misses in the end and will therefore make it faster than the dead-end filling algorithm. This will give a time complexity of O(t) - O(u), where t is the total amount of corridor coordinates and u is the amount of unvisited corridor coordinates located after the final crossroad. The memory required will in this case also be O(a) where a is the number of coordinates in the two-dimensional array, since the whole maze is stored.

## Sources
Maze solving algorithm, Wikipedia 2020, viewed 15.5.2020
https://en.wikipedia.org/wiki/Maze_solving_algorithm
