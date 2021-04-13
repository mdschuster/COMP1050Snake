package application;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Apple implements Drawable{
	private int xPos;
	private int yPos;
	
	private Rectangle graphic;
	
	public Apple(int xPos, int yPos) {
		this.xPos=xPos;
		this.yPos=yPos;
		
		graphic = new Rectangle(10,10,xPos,yPos);
		graphic.setFill(Color.RED);
	}

	@Override
	public void draw() {
		graphic.setX(xPos);
		graphic.setY(yPos);
	}
	
	public int getXPos() {
		return xPos;
	}
	
	public int getYPos() {
		return yPos;
	}
	
	public Rectangle getGraphic() {
		return graphic;
	}
}
