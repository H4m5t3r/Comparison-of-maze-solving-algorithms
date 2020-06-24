# Implementation document

The different algorithms used in this program are all implemented in their own Java classes. These are controlled by the class called "Logic". The graphical user interface uses a Logic class to call different methods from the classes when the user clicks different buttons.

![class diagram](https://raw.githubusercontent.com/H4m5t3r/Comparison-of-maze-solving-algorithms/master/Documentation/Pictures/class_diagram.jpg)

The mazes that are generated and solved are two-dimensional character arrays with corridors and walls. This means that when the width is w and the height is h it actually means that the size of the two-dimensional array is (2w + 1) * (2h + 1) because there are walls between the corridors and on each side of the maze. In this document w always stands for the maze's width and h for its height.

Some of the algorithms use data structures like stacks and linked lists. These have been implemented in the package called "maze.datastructures".

# Maze generating algorithms

## Recursive backtracker
The recursive backtracker method carves out a maze by starting from a room and then checking all directions around it in a random order. If it has not visited a room in the direction it looks (checked using a two-dimensional boolean array) it will add that room's x and y coordinate to their respective stack and carve out a corridor to that room. The stacks' purpose is to keep track of the route the algorithm has taken. If the algorithm reaches a room where it cannot go any further (a dead-end) it will pop the current x and y coordinates off their stacks. This way it returns to the previous room, which allows it to continue from there.

To get a random maze the order of the directions has to be random. In this case it is done using a linked list and a stack that directions are pushed to. Every time a room is reached the numbers 0, 1, 2 and 3 (up, right, down, left) are added to the linked list. Then a random index is chosen using `System.nanoTime() % numberOfDirectionsRemaining`. The direction at that index is removed from the linked list and added to the directions stack. When the directions have been added to the stack in a random order, the algorithm pops a value from it and checks the corresponding direction. Since all four directions are always checked before the algorithm returns to the previoius room it will continue checking the next direction since all the directions that have been added since the previous direction have all been removed from the stack by that point.

```
procedure recursion()
    visited[stacky.peek()][stackx.peek()] = true
    addRandomDirectionOrderToDirectionsStack()
    for i = 0 to 3
        //Up
        if directionsStack.peek() == 0
            stackx.push(stackx.peek())
            stacky.push(stacky.peek() - 1)
            checkDirection()
        //Right
        else if directionsStack.peek() == 1
            stackx.push(stackx.peek() + 1)
            stacky.push(stacky.peek())
            checkDirection()
        //Down
        else if directionsStack.peek() == 2
            stackx.push(stackx.peek())
            stacky.push(stacky.peek() + 1)
            checkDirection()
        //Left
        else if directionsStack.peek() == 3
            stackx.push(stackx.peek() - 1)
            stacky.push(stacky.peek())
            checkDirection()
```

```
procedure checkDirection(y, x)
    if (!visited[stacky.peek()][stackx.peek()])
        removeWallBetweenRooms(directionsstack.peek)
        recursion()
    directionsStack.pop()
    stackx.pop()
    stacky.pop()
```

This recursive backtracker results in a time complexity of O((2w + 1) * (2h + 1) + wh + wh). (2w + 1) * (2h + 1) comes from the base of the maze (the two-dimensional character array) containing only walls being generated. Then all spaces in the two-dimensional boolean array visited are set to false (wh) and after this the algorithm comes across every room at some point (wh). The space complexity is O((2w + 1) * (2h + 1) + wh + wh + wh + 4wh) = O((2w + 1) * (2h + 1) + 7wh). (2w + 1) * (2h + 1) is the two-dimensional character array (the maze), 3wh comes from the two-dimensional visited array and the x and y coordinates' stacks, which all have a size of w * h and 4wh comes from the direction stack that has a size of 4 * w * h.

## Kruskal's algorithm
This maze generation method is based on creating a minimum spanning tree by connecting random nodes as long as it does not create a loop. In my implementation there are two things that the program keeps track of: rooms (nodes, marked as pink numbers in the picture) and potential corridors (edges, marked with blue circles around them in the picture).

![Kruskal implementation](https://raw.githubusercontent.com/H4m5t3r/Comparison-of-maze-solving-algorithms/master/Documentation/Pictures/Kruskal%20example.jpg)

When the algorithm starts it creates a two-dimensional character array that matches the size that the user has entered. All rooms (pink numbers) are marked with " " since the maze should cover the whole area and the rest are marked as walls with "#". After that a union-find structure with the same number of elements as the number of rooms (width * height) and an array with the same number of spaces as the number of potential corridors (blue circles) is created. The corridor array is shuffled so that the algorithm checks the corridors in a random order. When the program goes through the corridor array it checks if the rooms are above and below or to the left and right of it. After that it calculates the rooms' number and checks if they are already connected in the union-find structure. If not it connects them and replaces the wall ("#") in the two-dimensional character array with a blank space (" "). After all corridor spaces have been checked the entrance and exit is added to a random odd space on the first and last row.

The most complicated part in this process is the calculation of the adjacent rooms' id number. At first glance it may seem pretty confusing but there is always a relation between them and the number can be calculated as long as you know the height of the maze. The algorithm results in a time complexity of O((2h-1) * (2w - 1) +  2 * ((w - 1) * (2h - 1) + (h - 1))). The first two parentheses come from the generation of the base for the maze where all rooms are marked with ' ' and the rest of the spaces in the two-dimensional character array with '#'. After that the room list is shuffled (one shuffle for each corridor) and after that all the corridors are gone through once. (w - 1) * (2h - 1) + (h - 1) is the number of corridors.

# Maze solving algorithms

## Dead-end filling
The dead-end filling algorithm solves mazes by searching for dead-ends and filling them in until it reaches a crossroad. It works for perfect mazes and can therefore solve all the mazes generated by the recursive backtracker and the Kruskal algorithm. In my implementation there are 3 methods: solve, isDeadEnd and fillDeadEnd. The solve method starts going through all the rooms, checking if they are blank spaces. If they are the isDeadEnd method is called. It checks if the room is a dead-end by checking if the number of corridors going from it is equal to 1. If the requirement is filled the fillDeadEnd method is called. It fills in the room, checks where the corridor is, fills it in and calls the isDeadEnd method in the next room. This results in a time complexity of O(w * h + r) where w is the maze's width, h is the maze's height and r is the random number of extra times rooms are checked, since the algorithm goes through all the rooms, checking if they have already been visited. The space complexity is O(0) since the algorithm does not use any memory and only analyzes the given maze.

## Depth-first search
The algorithm solves the given maze by marking the exit and then starting a depth-first search that lasts until the exit is found.

**Marking the exit**
```
for i = 1 to mazeWidth - 1, i += 2
    if maze[mazeHeight - 1][i] == ' '
        maze[mazeHeight - 1][i] == 'e'
```

After that the entrance is found in the same way and the search is started from the room below it. When the algorithm is in a random room it starts checking if there are corridors around it. In this implementation the check order is down, left, up, right. If there is a corridor and it is not marked with 'c' (the way it came) it starts a new search in the room the corridor leads to. When the search reaches a room it marks it with a 'c' (correct). If it finds the exit it sets the boolean exitFound to true. While exitFound is false the algorithm will continue searching for the exit and after all directions around a room have been checked it sets the 'c' back to a blank space (' ') since this path does not lead to the exit. If exitFound is true the algorithm will no longer look for ways to go since the exit has already been found and the room will be kept marked as 'c'.

**Searching for the exit inside the maze**
```
for allFourDirections
    if (direction == ' ' or direction == 'e') and !exitFound
        if direction == 'e'
            direction = 'c'
            exitFound = true
        else
            direction = 'c'
            search(direction)
    if !exitFound
        currentRoom = ' '
```

Since the worst case scenario is when the entrance and exit both are in the rightmost spaces (the search starts from the left side) and when the algorithm visits every single room in the maze the time complexity is O(2w + w * h). The space complexity is O(1) since the only thing stored is the boolean exitFound.

# Flaws
* There are some parts where the program's code get really repetetive. An example of this is the recursive backtracker class and the part of the GUI where the performance test results are displayed. I was still a bit unsure of how I would do these parts when I wrote them, which resulted in the code quality suffering a bit.
* The recursive backtracker algorithm always starts from the upper left corner. It's not really a problem but this results in that this corner is always a dead-end.

### Sources used in this project:

Maze solving algorithm, Wikipedia 2020, viewed 15.5.2020

https://en.wikipedia.org/wiki/Maze_solving_algorithm

Think Labyrinth: Daedalus

http://www.astrolog.org/labyrnth/daedalus.htm

Video: Maze Generation Algorithm - Recursive Backtracker, Easy Learn Tutorial (recursive backtracker implementation)

https://youtu.be/elMXlO28Q1U

William Fiset: Algorithms and data structures project (union-find data structure)

https://github.com/williamfiset/Algorithms