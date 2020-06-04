
package maze.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    private Button generate;
    private Button options;
    
    //View maze scene
    private Pane viewMazePane;
    private Scene viewMazeScene;
    private char[][] maze;
    private char[][] deadEndSolved;
    private char[][] depthFirstSolved;
    private Button deadEndSolve;
    private Button depthFirstSolve;
    
    //SolvedMazeScene
    private Scene solvedMazeScene;
    private Pane solvedMazePane;
    private Label processTime;
    
    //Program logic
    private Logic logic;

    @Override
    public void init() {
        this.logic = new Logic();
        rectWidth = 4;
        rectHeight = 4;
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
        
        generate = new Button("Generate");
        generate.setLayoutX(0);
        generate.setLayoutY(0);
        
        options = new Button("Options");
        options.setLayoutX(130);
        options.setLayoutY(0);
        
        //viewMazeScene
        deadEndSolve = new Button("Dead-end filling");
        depthFirstSolve = new Button("Depth-first search");
        depthFirstSolve.setLayoutX(300);
        
        this.newMazeScene = new Scene(newMazePane, 500, 500);
    }
    
    private void updateNewMazeScreen() {
        newMazePane.getChildren().clear();
        width.setText("" + logic.getWidth());
        length.setText("" + logic.getHeight());
        newMazePane.getChildren().addAll(widthAndHeight, changeSizeButtons);
        try {
            newMazePane.getChildren().add(generate);
        } catch (Exception e) {
            
        }
    }
    
    @Override
    public void start(Stage window) throws Exception {
        changeSizeButtons.getChildren().addAll(increaseWidth, decreaseWidth, 
                increaseHeight, decreaseHeight, generate, w10, w50, w100, w150,
                h10, h50, h100, h150);
        widthAndHeight.getChildren().addAll(width, length, widthText, lengthText);
        
        newMazePane.getChildren().addAll(widthAndHeight, changeSizeButtons);
        
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
        
        generate.setOnAction((event) -> {
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
            processTime.setLayoutX(200);
            viewMazePane.getChildren().addAll(deadEndSolve, depthFirstSolve, options, processTime);
            viewMazeScene = new Scene(viewMazePane);
            window.setScene(viewMazeScene);
        });
        
        options.setOnAction((event) -> {
            try {
                newMazePane.getChildren().add(generate);
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
            processTime.setLayoutX(200);
            solvedMazePane.getChildren().addAll(generate, options, processTime);
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
                        solvedMazePane.getChildren().add(new Rectangle(x * rectWidth, y * rectHeight + extraHeight, rectWidth, rectHeight));
                    } else if (depthFirstSolved[y][x] == 'c') {
                        Rectangle rect = new Rectangle(x * rectWidth, y * rectHeight + extraHeight, rectWidth, rectHeight);
                        rect.setFill(Color.GREEN);
                        solvedMazePane.getChildren().add(rect);
                    }
                }
            }
            processTime = new Label(time / 1000 + " μs");
            processTime.setLayoutX(200);
            solvedMazePane.getChildren().addAll(generate, options, processTime);
            solvedMazeScene = new Scene(solvedMazePane);
            window.setScene(solvedMazeScene);
        });

        window.setScene(newMazeScene);
        window.show();
    }
    
    @Override
    public void stop() {
        System.out.println("Closing");
        System.exit(0);
    }
}
