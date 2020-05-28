
package maze.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import maze.domain.Logic;

/**
 * The user interface that is used to control the program.
 * @author taleiko
 */
public class MazeUI extends Application {
    //JavaFX
    //Maze preset scene
    private Pane newMazePane;
    private Pane plusMinusButtons;
    private Pane widthAndHeight;
    private Scene newMazeScene;
    private Button increaseWidth;
    private Button decreaseWidth;
    private Button increaseHeight;
    private Button decreaseHeight;
    private Label width;
    private Label length;
    private Button generate;
    
    //View maze scene
    private Pane viewMazePane;
    private Scene viewMazeScene;
    private char[][] maze;
    private Button deadEndSolve;
    
    //
    
    //Program logic
    private Logic logic;

    @Override
    public void init() {
        this.logic = new Logic();
        
        //newMazeScene
        this.newMazePane = new Pane();
        plusMinusButtons = new Pane();
        widthAndHeight = new Pane();
        increaseWidth = new Button("+");
        decreaseWidth = new Button("-");
        increaseHeight = new Button("+");
        decreaseHeight = new Button("-");
        
        width = new Label("" + logic.getWidth());
        width.setLayoutX(85);
        width.setLayoutY(55);
        
        length = new Label("" + logic.getHeight());
        length.setLayoutX(85);
        length.setLayoutY(205);
        
        //Setting the x and y coordinates for the buttons.
        increaseWidth.setLayoutX(100);
        increaseWidth.setLayoutY(50);
        increaseWidth.setPrefWidth(30);
        
        
        decreaseWidth.setLayoutX(50);
        decreaseWidth.setLayoutY(50);
        decreaseWidth.setPrefWidth(30);
        
        increaseHeight.setLayoutX(100);
        increaseHeight.setLayoutY(200);
        increaseHeight.setPrefWidth(30);
        
        decreaseHeight.setLayoutX(50);
        decreaseHeight.setLayoutY(200);
        decreaseHeight.setPrefWidth(30);
        
        generate = new Button("Generate");
        generate.setLayoutX(300);
        generate.setLayoutY(300);
        
        //ViewMazeScene
        deadEndSolve = new Button("Dead-end filling");
        
        this.newMazeScene = new Scene(newMazePane, 500, 500);
    }
    
    private void updateNewMazeScreen() {
        newMazePane.getChildren().clear();
        width.setText("" + logic.getWidth());
        length.setText("" + logic.getHeight());
        newMazePane.getChildren().addAll(widthAndHeight, plusMinusButtons);
    }
    
    @Override
    public void start(Stage window) throws Exception {
        plusMinusButtons.getChildren().addAll(increaseWidth, decreaseWidth, 
                increaseHeight, decreaseHeight, generate);
        widthAndHeight.getChildren().addAll(width, length);
        
        newMazePane.getChildren().addAll(widthAndHeight, plusMinusButtons);
        
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
        
        //viewMazeScene
        deadEndSolve.setOnAction((event) -> {
            logic.deadEndSolve();
        });
        
        generate.setOnAction((event) -> {
            logic.initializeGenerator();
            logic.generateMaze();
            //viewMazeScene
            maze = logic.getMazeFromGenerator();
            viewMazePane = new Pane();
            for (int y = 0; y < maze.length; y++) {
                for (int x = 0; x < maze[0].length; x++) {
                    if (y == 1 && x == 1) {
                        viewMazePane.getChildren().add(new Rectangle(x * 25, y * 25, 15, 15));
                    } else if (maze[y][x] == '#') {
                        viewMazePane.getChildren().add(new Rectangle(x * 25, y * 25, 24, 24));
                    }
                }
            }
            viewMazePane.getChildren().add(deadEndSolve);
            viewMazeScene = new Scene(viewMazePane, 700, 700);
            window.setScene(viewMazeScene);
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
