
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
    private Pane widthAndLength;
    private Scene newMazeScene;
    private Button increaseWidth;
    private Button decreaseWidth;
    private Button increaseLength;
    private Button decreaseLength;
    private Label width;
    private Label length;
    private Button generate;
    
    //View maze scene
    private Pane viewMazePane;
    private Scene viewMazeScene;
    private char[][] maze;
    
    //Program logic
    private Logic logic;

    @Override
    public void init() {
        this.logic = new Logic();
        
        //newMazeScene
        this.newMazePane = new Pane();
        plusMinusButtons = new Pane();
        widthAndLength = new Pane();
        increaseWidth = new Button("+");
        decreaseWidth = new Button("-");
        increaseLength = new Button("+");
        decreaseLength = new Button("-");
        
        width = new Label("" + logic.getWidth());
        width.setLayoutX(100);
        width.setLayoutY(300);
        
        length = new Label("" + logic.getLength());
        length.setLayoutX(100);
        length.setLayoutY(400);
        
        //Setting the x and y coordinates for the buttons.
        increaseWidth.setLayoutX(100);
        increaseWidth.setLayoutY(50);
        increaseWidth.setPrefWidth(30);
        
        
        decreaseWidth.setLayoutX(50);
        decreaseWidth.setLayoutY(50);
        decreaseWidth.setPrefWidth(30);
        
        increaseLength.setLayoutX(100);
        increaseLength.setLayoutY(200);
        increaseLength.setPrefWidth(30);
        
        decreaseLength.setLayoutX(50);
        decreaseLength.setLayoutY(200);
        decreaseLength.setPrefWidth(30);
        
        generate = new Button("Generate");
        generate.setLayoutX(400);
        generate.setLayoutY(400);
        
        this.newMazeScene = new Scene(newMazePane, 500, 500);
    }
    
    private void updateNewMazeScreen() {
        newMazePane.getChildren().clear();
        width.setText("" + logic.getWidth());
        length.setText("" + logic.getLength());
        newMazePane.getChildren().addAll(widthAndLength, plusMinusButtons);
    }
    
    @Override
    public void start(Stage window) throws Exception {
        plusMinusButtons.getChildren().addAll(increaseWidth, decreaseWidth, 
                increaseLength, decreaseLength, generate);
        widthAndLength.getChildren().addAll(width, length);
        
        newMazePane.getChildren().addAll(widthAndLength, plusMinusButtons);
        
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
        
        increaseLength.setOnAction((event) -> {
            logic.increaseLength();
            updateNewMazeScreen();
        });
        
        decreaseLength.setOnAction((event) -> {
            logic.decreaseLength();
            updateNewMazeScreen();
        });
        
        generate.setOnAction((event) -> {
            logic.initializeGenerator();
            //viewMazeScene
            maze = logic.getMazeFromGenerator();
            viewMazePane = new Pane();
            for (int y = 0; y < maze.length; y++) {
                for (int x = 0; x < maze[0].length; x++) {
                    viewMazePane.getChildren().add(new Rectangle(y * 25, x * 25, 24, 24));
                }
            }
            viewMazeScene = new Scene(viewMazePane, 500, 500);
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
