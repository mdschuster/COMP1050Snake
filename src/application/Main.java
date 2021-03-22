package application;
	
import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		Pane p = new Pane();
		Part h = new Head();
		ArrayList<Part> parts = new ArrayList<>();
		parts.add(h);
		
		p.getChildren().add(h.getGraphic());
		
		Scene s = new Scene(p,600,600);
		primaryStage.setScene(s);
		primaryStage.show();
		
		//this will run in the timeline every 100ish ms
		EventHandler<ActionEvent> handler = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				for(Part p : parts) {
					p.move();
					p.draw();
				}
			}	
		};
		
		Timeline t = new Timeline(new KeyFrame(Duration.millis(150),handler));
		t.setCycleCount(Timeline.INDEFINITE);
		t.play();
		
		//keyinput
		p.requestFocus();
		p.setOnKeyPressed((e)->{
			if(e.getCode()==KeyCode.UP) {
				h.setDir("UP");
			}
			if(e.getCode()==KeyCode.DOWN) {
				h.setDir("DOWN");
			}
			if(e.getCode()==KeyCode.LEFT) {
				h.setDir("LEFT");
			}
			if(e.getCode()==KeyCode.RIGHT) {
				h.setDir("RIGHT");
			}
		});
		
	}
	

}
