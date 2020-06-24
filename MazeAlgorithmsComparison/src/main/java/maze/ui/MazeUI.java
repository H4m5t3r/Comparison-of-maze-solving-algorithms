
package maze.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import maze.domain.Logic;

/**
 * The user interface that is used to control the program.
 * @author taleiko
 */
public class MazeUI extends Application {
    //JavaFX
    int rectWidth;
    int rectHeight;
    int extraHeight;
    //Maze preset scene
    private Pane newMazePane;
    private Pane changeSizeButtons;
    private Pane widthAndHeight;
    private Scene newMazeScene;
    private Button increaseWidth;
    private Button decreaseWidth;
    private Button increaseHeight;
    private Button decreaseHeight;
    private Button w10;
    private Button w50;
    private Button w100;
    private Button w150;
    private Button h10;
    private Button h50;
    private Button h100;
    private Button h150;
    private Label width;
    private Label length;
    private Label widthText;
    private Label lengthText;
    private Button recursiveBacktr;
    private Button kruskal;
    private Button menu;
    
    //View maze scene
    private Pane viewMazePane;
    private Scene viewMazeScene;
    private char[][] maze;
    private char[][] deadEndSolved;
    private char[][] depthFirstSolved;
    private Button deadEndSolve;
    private Button depthFirstSolve;
    
    //Solved maze scene
    private Scene solvedMazeScene;
    private Pane solvedMazePane;
    private Label processTime;
    
    //Performance test scene
    private Scene performanceScene;
    private Scene errorScene;
    private Pane performancePane;
    private Pane errorPane;
    private Button goToPerformanceTest;
    private Button startTest;
    private Label testInfo;
    private Label errorLabel;
    
    //Performance results scene
    private Scene performanceResultsScene;
    private Pane performanceResultsPane;
    private GridPane generationResultsGrid;
    private GridPane recResultsGrid;
    private GridPane krusResultsGrid;
    
    //Section 1
    //Titles
    private Label resultsTitle;
    private Label mazeGenerationTitle;
    //Results
    private Label recBAvgTitle;
    private Label kruskalAvgTitle;
    private Label recBAvgResult;
    private Label kruskalAvgResult;
    
    //Section 2
    //Titles
    private Label recBSolvingTitle;
    private Label recCol1;
    private Label recCol2;
    private Label recCol3;
    private Label recCol4;
    private Label recCol5;
    private Label recAvgCol;
    private Label deadEndRow1;
    private Label depthRow1;
    //Results
    private Label recDead1;
    private Label recDead2;
    private Label recDead3;
    private Label recDead4;
    private Label recDead5;
    private Label recDeadAvg;
    private Label recDepth1;
    private Label recDepth2;
    private Label recDepth3;
    private Label recDepth4;
    private Label recDepth5;
    private Label recDepthAvg;
    
    //Section 3
    //Titles
    private Label kruskalSolvingTitle;
    private Label krusCol1;
    private Label krusCol2;
    private Label krusCol3;
    private Label krusCol4;
    private Label krusCol5;
    private Label krusAvgCol;
    private Label deadEndRow2;
    private Label depthRow2;
    //Results
    private Label krusDead1;
    private Label krusDead2;
    private Label krusDead3;
    private Label krusDead4;
    private Label krusDead5;
    private Label krusDeadAvg;
    private Label krusDepth1;
    private Label krusDepth2;
    private Label krusDepth3;
    private Label krusDepth4;
    private Label krusDepth5;
    private Label krusDepthAvg;
    
    //Program logic
    private Logic logic;

    @Override
    public void init() {
        this.logic = new Logic();
        rectWidth = 3;
        rectHeight = 3;
        extraHeight = 30;
        
        //newMazeScene
        this.newMazePane = new Pane();
        changeSizeButtons = new Pane();
        widthAndHeight = new Pane();
        increaseWidth = new Button("+");
        decreaseWidth = new Button("-");
        increaseHeight = new Button("+");
        decreaseHeight = new Button("-");
        
        width = new Label("" + logic.getWidth());
        width.setLayoutX(85);
        width.setLayoutY(135);
        
        length = new Label("" + logic.getHeight());
        length.setLayoutX(85);
        length.setLayoutY(205);
        
        widthText = new Label("Maze width:");
        widthText.setLayoutX(60);
        widthText.setLayoutY(105);
        
        lengthText = new Label("Maze height:");
        lengthText.setLayoutX(60);
        lengthText.setLayoutY(175);
        
        goToPerformanceTest = new Button("Performance tests");
        
        //Setting the x and y coordinates for the buttons.
        increaseWidth.setLayoutX(115);
        increaseWidth.setLayoutY(130);
        increaseWidth.setPrefWidth(30);
        
        decreaseWidth.setLayoutX(50);
        decreaseWidth.setLayoutY(130);
        decreaseWidth.setPrefWidth(30);
        
        increaseHeight.setLayoutX(115);
        increaseHeight.setLayoutY(200);
        increaseHeight.setPrefWidth(30);
        
        decreaseHeight.setLayoutX(50);
        decreaseHeight.setLayoutY(200);
        decreaseHeight.setPrefWidth(30);
        
        //Width "shortcuts"
        w10 = new Button("10");
        w10.setLayoutX(170);
        w10.setLayoutY(130);
        
        w50 = new Button("50");
        w50.setLayoutX(220);
        w50.setLayoutY(130);
        
        w100 = new Button("100");
        w100.setLayoutX(270);
        w100.setLayoutY(130);
        
        w150 = new Button("150");
        w150.setLayoutX(330);
        w150.setLayoutY(130);
        
        //Height "shortcuts"
        h10 = new Button("10");
        h10.setLayoutX(170);
        h10.setLayoutY(200);
        
        h50 = new Button("50");
        h50.setLayoutX(220);
        h50.setLayoutY(200);
        
        h100 = new Button("100");
        h100.setLayoutX(270);
        h100.setLayoutY(200);
        
        h150 = new Button("150");
        h150.setLayoutX(330);
        h150.setLayoutY(200);
        
        recursiveBacktr = new Button("Recursive backtracker");
        recursiveBacktr.setLayoutX(0);
        recursiveBacktr.setLayoutY(0);
        
        kruskal = new Button("Kruskal");
        kruskal.setLayoutX(165);
        kruskal.setLayoutY(0);
        
        menu = new Button("Menu");
        menu.setLayoutX(590);
        menu.setLayoutY(0);
        
        //viewMazeScene
        deadEndSolve = new Button("Dead-end filling");
        deadEndSolve.setLayoutX(235);
        depthFirstSolve = new Button("Depth-first search");
        depthFirstSolve.setLayoutX(359);
        
        this.newMazeScene = new Scene(newMazePane, 500, 500);
        
        //Performance test scene
        goToPerformanceTest.setLayoutX(300);
        performancePane = new Pane();
        startTest = new Button("Start the tests");
        startTest.setLayoutX(185);
        startTest.setLayoutY(260);
        testInfo = new Label("Here you can run the performance tests. It may "
                + "take\nseveral minutes for them to complete depending\non the "
                + "environment.");
        testInfo.setLayoutY(140);
        testInfo.setLayoutX(90);
        performancePane.getChildren().addAll(testInfo, startTest, menu);
        performanceScene = new Scene(performancePane, 500, 500);
        //Loading screen
        errorLabel = new Label("Unkown error. Please make sure that enough "
                + "memory has been allocated\nfor the JVM stack and heap.");
        errorLabel.setLayoutX(5);
        errorLabel.setLayoutY(230);
        errorPane = new Pane();
        errorPane.getChildren().add(errorLabel);
        errorScene = new Scene(errorPane, 500, 500);
    }
    
    private void updateNewMazeScreen() {
        newMazePane.getChildren().clear();
        width.setText("" + logic.getWidth());
        length.setText("" + logic.getHeight());
        newMazePane.getChildren().addAll(widthAndHeight, changeSizeButtons);
        try {
            newMazePane.getChildren().addAll(recursiveBacktr, kruskal, goToPerformanceTest);
        } catch (Exception e) {
            
        }
    }
    
    @Override
    public void start(Stage window) throws Exception {
        changeSizeButtons.getChildren().addAll(increaseWidth, decreaseWidth, 
                increaseHeight, decreaseHeight, recursiveBacktr, kruskal, w10, w50, w100, w150,
                h10, h50, h100, h150);
        widthAndHeight.getChildren().addAll(width, length, widthText,
                lengthText);
        
        newMazePane.getChildren().addAll(widthAndHeight, changeSizeButtons,
                goToPerformanceTest);
        
        //Setting button actions
        //newMazeScene
        increaseWidth.setOnAction((event) -> {
            logic.increaseWidth();
            updateNewMazeScreen();
        });
        
        decreaseWidth.setOnAction((event) -> {
            logic.decreaseWidth();
            updateNewMazeScreen();
        });
        
        increaseHeight.setOnAction((event) -> {
            logic.increaseHeight();
            updateNewMazeScreen();
        });
        
        decreaseHeight.setOnAction((event) -> {
            logic.decreaseHeight();
            updateNewMazeScreen();
        });
        
        w10.setOnAction((event) -> {
            logic.setWidth(10);
            updateNewMazeScreen();
        });
        
        w50.setOnAction((event) -> {
            logic.setWidth(50);
            updateNewMazeScreen();
        });
        
        w100.setOnAction((event) -> {
            logic.setWidth(100);
            updateNewMazeScreen();
        });
        
        w150.setOnAction((event) -> {
            logic.setWidth(150);
            updateNewMazeScreen();
        });
        
        h10.setOnAction((event) -> {
            logic.setHeight(10);
            updateNewMazeScreen();
        });
        
        h50.setOnAction((event) -> {
            logic.setHeight(50);
            updateNewMazeScreen();
        });
        
        h100.setOnAction((event) -> {
            logic.setHeight(100);
            updateNewMazeScreen();
        });
        
        h150.setOnAction((event) -> {
            logic.setHeight(150);
            updateNewMazeScreen();
        });
        
        goToPerformanceTest.setOnAction((event) -> {
            menu.setLayoutX(0);
            try {
                performancePane.getChildren().add(menu);
            } catch (Exception e) {
                
            }
            window.setScene(performanceScene);
        });
        
        startTest.setOnAction((event) -> {
            window.setScene(errorScene);
            logic.performanceTest();
            performanceResultsPane = new Pane();
            generationResultsGrid = new GridPane();
            recResultsGrid = new GridPane();
            krusResultsGrid = new GridPane();
            
            resultsTitle = new Label("Results");
            //Section 1
            mazeGenerationTitle = new Label("Maze generation");
            recBAvgTitle = new Label("Recursive backtracker average:");
            kruskalAvgTitle = new Label("Kruskal average:");
            recBAvgResult = new Label(logic.getRecTime() / 1000000 + " ms");
            kruskalAvgResult = new Label(logic.getKruskalTime() / 1000000 + " ms");
            generationResultsGrid.add(recBAvgTitle, 0, 0);
            generationResultsGrid.add(kruskalAvgTitle, 0, 1);
            generationResultsGrid.add(recBAvgResult, 1, 0);
            generationResultsGrid.add(kruskalAvgResult, 1, 1);
            
            //Section 2
            recBSolvingTitle = new Label("Recursive backtracker maze solving");
            //Rows
            recCol1 = new Label("1  ");
            recCol2 = new Label("2  ");
            recCol3 = new Label("3  ");
            recCol4 = new Label("4  ");
            recCol5 = new Label("5  ");
            recAvgCol = new Label("Avg  ");
            //Columns
            deadEndRow1 = new Label("Dead-end filling ");
            depthRow1 = new Label("Depth-first search ");
            //Results
            //Dead-end filling
            long[] recDeadResults = logic.getRecDead();
            recDead1 = new Label(recDeadResults[0] / 1000000 + " ms  ");
            recDead2 = new Label(recDeadResults[1] / 1000000 + " ms  ");
            recDead3 = new Label(recDeadResults[2] / 1000000 + " ms  ");
            recDead4 = new Label(recDeadResults[3] / 1000000 + " ms  ");
            recDead5 = new Label(recDeadResults[4] / 1000000 + " ms  ");
            long average = 0;
            for (int i = 0; i < recDeadResults.length; i++) {
                average += recDeadResults[i];
            }
            average /= recDeadResults.length;
            recDeadAvg = new Label(average / 1000000 + " ms  ");
            //Depth-first search
            long[] recDepthResults = logic.getRecDepth();
            recDepth1 = new Label(recDepthResults[0] / 1000000 + " ms  ");
            recDepth2 = new Label(recDepthResults[1] / 1000000 + " ms  ");
            recDepth3 = new Label(recDepthResults[2] / 1000000 + " ms  ");
            recDepth4 = new Label(recDepthResults[3] / 1000000 + " ms  ");
            recDepth5 = new Label(recDepthResults[4] / 1000000 + " ms  ");
            average = 0;
            for (int i = 0; i < recDepthResults.length; i++) {
                average += recDepthResults[i];
            }
            average /= recDepthResults.length;
            recDepthAvg = new Label(average / 1000000 + " ms  ");
            //Placing the values in the table
            //Text
            recResultsGrid.add(recCol1, 0, 1);
            recResultsGrid.add(recCol2, 0, 2);
            recResultsGrid.add(recCol3, 0, 3);
            recResultsGrid.add(recCol4, 0, 4);
            recResultsGrid.add(recCol5, 0, 5);
            recResultsGrid.add(recAvgCol, 0, 6);
            recResultsGrid.add(deadEndRow1, 1, 0);
            recResultsGrid.add(depthRow1, 2, 0);
            //Dead-end filling data
            recResultsGrid.add(recDead1, 1, 1);
            recResultsGrid.add(recDead2, 1, 2);
            recResultsGrid.add(recDead3, 1, 3);
            recResultsGrid.add(recDead4, 1, 4);
            recResultsGrid.add(recDead5, 1, 5);
            recResultsGrid.add(recDeadAvg, 1, 6);
            //Depth-first search data
            recResultsGrid.add(recDepth1, 2, 1);
            recResultsGrid.add(recDepth2, 2, 2);
            recResultsGrid.add(recDepth3, 2, 3);
            recResultsGrid.add(recDepth4, 2, 4);
            recResultsGrid.add(recDepth5, 2, 5);
            recResultsGrid.add(recDepthAvg, 2, 6);
            
            //Section 3
            kruskalSolvingTitle = new Label("Kruskal maze solving");
            //Rows
            krusCol1 = new Label("1  ");
            krusCol2 = new Label("2  ");
            krusCol3 = new Label("3  ");
            krusCol4 = new Label("4  ");
            krusCol5 = new Label("5  ");
            krusAvgCol = new Label("Avg  ");
            //Columns
            deadEndRow2 = new Label("Dead-end filling ");
            depthRow2 = new Label("Depth-first search ");
            //Results
            //Dead-end filling
            long[] krusDeadResults = logic.getKrusDead();
            krusDead1 = new Label(krusDeadResults[0] / 1000000 + " ms  ");
            krusDead2 = new Label(krusDeadResults[1] / 1000000 + " ms  ");
            krusDead3 = new Label(krusDeadResults[2] / 1000000 + " ms  ");
            krusDead4 = new Label(krusDeadResults[3] / 1000000 + " ms  ");
            krusDead5 = new Label(krusDeadResults[4] / 1000000 + " ms  ");
            average = 0;
            for (int i = 0; i < krusDeadResults.length; i++) {
                average += krusDeadResults[i];
            }
            average /= krusDeadResults.length;
            krusDeadAvg = new Label(average / 1000000 + " ms  ");
            //Depth-first search
            long[] krusDepthResults = logic.getKrusDepth();
            krusDepth1 = new Label(krusDepthResults[0] / 1000000 + " ms  ");
            krusDepth2 = new Label(krusDepthResults[1] / 1000000 + " ms  ");
            krusDepth3 = new Label(krusDepthResults[2] / 1000000 + " ms  ");
            krusDepth4 = new Label(krusDepthResults[3] / 1000000 + " ms  ");
            krusDepth5 = new Label(krusDepthResults[4] / 1000000 + " ms  ");
            average = 0;
            for (int i = 0; i < krusDepthResults.length; i++) {
                average += krusDepthResults[i];
            }
            average /= krusDepthResults.length;
            krusDepthAvg = new Label(average / 1000000 + " ms  ");
            //Placing the values in the table
            //Text
            krusResultsGrid.add(krusCol1, 0, 1);
            krusResultsGrid.add(krusCol2, 0, 2);
            krusResultsGrid.add(krusCol3, 0, 3);
            krusResultsGrid.add(krusCol4, 0, 4);
            krusResultsGrid.add(krusCol5, 0, 5);
            krusResultsGrid.add(krusAvgCol, 0, 6);
            krusResultsGrid.add(deadEndRow2, 1, 0);
            krusResultsGrid.add(depthRow2, 2, 0);
            //Dead-end filling data
            krusResultsGrid.add(krusDead1, 1, 1);
            krusResultsGrid.add(krusDead2, 1, 2);
            krusResultsGrid.add(krusDead3, 1, 3);
            krusResultsGrid.add(krusDead4, 1, 4);
            krusResultsGrid.add(krusDead5, 1, 5);
            krusResultsGrid.add(krusDeadAvg, 1, 6);
            //Depth-first search data
            krusResultsGrid.add(krusDepth1, 2, 1);
            krusResultsGrid.add(krusDepth2, 2, 2);
            krusResultsGrid.add(krusDepth3, 2, 3);
            krusResultsGrid.add(krusDepth4, 2, 4);
            krusResultsGrid.add(krusDepth5, 2, 5);
            krusResultsGrid.add(krusDepthAvg, 2, 6);
            
            //Setting layout coordinates
            resultsTitle.setLayoutX(220);
            resultsTitle.setLayoutY(10);
            
            mazeGenerationTitle.setLayoutX(190);
            mazeGenerationTitle.setLayoutY(35);
            
            generationResultsGrid.setLayoutX(100);
            generationResultsGrid.setLayoutY(60);
            
            recBSolvingTitle.setLayoutX(110);
            recBSolvingTitle.setLayoutY(125);
            
            recResultsGrid.setLayoutX(100);
            recResultsGrid.setLayoutY(150);
            
            kruskalSolvingTitle.setLayoutX(170);
            kruskalSolvingTitle.setLayoutY(295);
            
            krusResultsGrid.setLayoutX(100);
            krusResultsGrid.setLayoutY(320);
            
            performanceResultsPane.getChildren().addAll(menu, resultsTitle,
                    mazeGenerationTitle, generationResultsGrid,
                    recBSolvingTitle, recResultsGrid, kruskalSolvingTitle,
                    krusResultsGrid);
            
            
            performanceResultsScene = new Scene(performanceResultsPane, 500, 500);
            window.setScene(performanceResultsScene);
        });
        
        recursiveBacktr.setOnAction((event) -> {
            logic.initializeRecursiveBacktracker();
            long time = System.nanoTime();
            logic.generateRecursiveBacktrackerMaze();
            time = System.nanoTime() - time;
            //viewMazeScene
            maze = logic.getMazeFromRecursiveBacktracker();
            viewMazePane = new Pane();
            for (int y = 0; y < maze.length; y++) {
                for (int x = 0; x < maze[0].length; x++) {
                    if (maze[y][x] == '#') {
                        viewMazePane.getChildren().add(new Rectangle(x * rectWidth, y * rectHeight + extraHeight, rectWidth, rectHeight));
                    }
                }
            }
            processTime = new Label(time / 1000 + " μs");
            processTime.setLayoutX(500);
            viewMazePane.getChildren().addAll(recursiveBacktr, kruskal, deadEndSolve, depthFirstSolve, menu, processTime);
            viewMazeScene = new Scene(viewMazePane);
            window.setScene(viewMazeScene);
        });
        
        kruskal.setOnAction((event) -> {
            logic.initializeKruskal();
            long time = System.nanoTime();
            logic.generateKruskalMaze();
            time = System.nanoTime() - time;
            //viewMazeScene
            maze = logic.getMazeFromKruskal();
            viewMazePane = new Pane();
            for (int y = 0; y < maze.length; y++) {
                for (int x = 0; x < maze[0].length; x++) {
                    if (maze[y][x] == '#') {
                        viewMazePane.getChildren().add(new Rectangle(x * rectWidth, y * rectHeight + extraHeight, rectWidth, rectHeight));
                    }
                }
            }
            processTime = new Label(time / 1000 + " μs");
            processTime.setLayoutX(500);
            viewMazePane.getChildren().addAll(recursiveBacktr, kruskal, deadEndSolve, depthFirstSolve, menu, processTime);
            viewMazeScene = new Scene(viewMazePane);
            window.setScene(viewMazeScene);
        });
        
        menu.setOnAction((event) -> {
            menu.setLayoutX(590);
            try {
                newMazePane.getChildren().add(recursiveBacktr);
            } catch (Exception e) {
                
            }
            try {
                newMazePane.getChildren().add(kruskal);
            } catch (Exception e) {
                
            }
            window.setScene(newMazeScene);
        });
        
        //solvedMazeScene
        deadEndSolve.setOnAction((event) -> {
            deadEndSolved = new char[maze.length][maze[0].length];
            for (int i = 0; i < maze.length; i++) {
                for (int j = 0; j < maze[0].length; j++) {
                    deadEndSolved[i][j] = maze[i][j];
                }
            }
            long time = System.nanoTime();
            logic.deadEndSolve(deadEndSolved);
            time = System.nanoTime() - time;
            solvedMazePane = new Pane();
            for (int y = 0; y < deadEndSolved.length; y++) {
                for (int x = 0; x < deadEndSolved[0].length; x++) {
                    if (deadEndSolved[y][x] == '#' && maze[y][x] == '#') {
                        solvedMazePane.getChildren().add(new Rectangle(x * rectWidth, y * rectHeight + extraHeight, rectWidth, rectHeight));
                    } else if (deadEndSolved[y][x] == ' ' && maze[y][x] == ' ') {
                        Rectangle rect = new Rectangle(x * rectWidth, y * rectHeight + extraHeight, rectWidth, rectHeight);
                        rect.setFill(Color.GREEN);
                        solvedMazePane.getChildren().add(rect);
                    }
                }
            }
            processTime = new Label(time / 1000 + " μs");
            processTime.setLayoutX(500);
            solvedMazePane.getChildren().addAll(recursiveBacktr, kruskal, menu,
                    processTime, depthFirstSolve);
            solvedMazeScene = new Scene(solvedMazePane);
            window.setScene(solvedMazeScene);
        });
        
        depthFirstSolve.setOnAction((event) -> {
            //Copying the unsolved maze
            depthFirstSolved = new char[maze.length][maze[0].length];
            for (int i = 0; i < maze.length; i++) {
                for (int j = 0; j < maze[0].length; j++) {
                    depthFirstSolved[i][j] = maze[i][j];
                }
            }
            //Solving and visualizing
            long time = System.nanoTime();
            logic.depthFirstSolve(depthFirstSolved);
            time = System.nanoTime() - time;
            solvedMazePane = new Pane();
            for (int y = 0; y < maze.length; y++) {
                for (int x = 0; x < maze[0].length; x++) {
                    if (depthFirstSolved[y][x] == '#') {
                        solvedMazePane.getChildren().add(new Rectangle(x *
                                rectWidth, y * rectHeight + extraHeight,
                                rectWidth, rectHeight));
                    } else if (depthFirstSolved[y][x] == 'c') {
                        Rectangle rect = new Rectangle(x * rectWidth, y *
                                rectHeight + extraHeight, rectWidth,
                                rectHeight);
                        rect.setFill(Color.GREEN);
                        solvedMazePane.getChildren().add(rect);
                    }
                }
            }
            processTime = new Label(time / 1000 + " μs");
            processTime.setLayoutX(500);
            solvedMazePane.getChildren().addAll(recursiveBacktr, kruskal, menu,
                    processTime, deadEndSolve);
            solvedMazeScene = new Scene(solvedMazePane);
            window.setScene(solvedMazeScene);
        });

        window.setScene(newMazeScene);
        window.show();
    }
    
    @Override
    public void stop() {
        System.exit(0);
    }
}
