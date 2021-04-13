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
				checkCollisions(parts);
			}	
		};
		
		Timeline t = new Timeline(new KeyFrame(Duration.millis(150),handler));
		t.setCycleCount(Timeline.INDEFINITE);
		t.play();
		
		//keyinput
		p.requestFocus();
		p.setOnKeyPressed((e)->{
			String curDir=h.getDir(); //UP or DOWN or LEFT or RIGHT
			if(e.getCode()==KeyCode.UP) {
				if(!curDir.equals("DOWN")) {
					h.setDir("UP");
				}
			}
			if(e.getCode()==KeyCode.DOWN) {
				if(!curDir.equals("UP")) {
					h.setDir("DOWN");
				}
			}
			if(e.getCode()==KeyCode.LEFT) {
				if(!curDir.equals("RIGHT")) {
					h.setDir("LEFT");
				}
			}
			if(e.getCode()==KeyCode.RIGHT) {
				if(!curDir.equals("LEFT")) {
					h.setDir("RIGHT");
				}
			}
			if(e.getCode()==KeyCode.SPACE) {
				addBody(parts,p);
			}
		});
		
	}
	
	public static void checkCollisions(ArrayList<Part> parts) {
		int headX=parts.get(0).getXPos();
		int headY=parts.get(0).getYPos();
		
		//if we don't know which element is the head
//		for(Part p : parts) {
//			if(p instanceof Head) {
//				headX=p.getXPos();
//				headY=p.getYPos();
//				break;
//			}
//		}
		
		//check for collision with boundary
		if(headX<0 || headX>600 || headY<0 || headY>600) {
			System.out.printf("Game Over%n");
			System.exit(0);
		}
		
		//check for collision with body parts
		int bodyX;
		int bodyY;
		//looks at every part except at index 0
		for(int i=1;i<parts.size();i++) {
			bodyX=parts.get(i).getXPos();
			bodyY=parts.get(i).getYPos();
			if(bodyX==headX && bodyY==headY) {
				System.out.printf("Game Over%n");
				System.exit(0);
			}
		}
		
	}
	
	public static void addBody(ArrayList<Part> parts, Pane pane) {
		Body b = new Body(parts);
		parts.add(b);
		pane.getChildren().add(b.getGraphic());
	}
	

}
