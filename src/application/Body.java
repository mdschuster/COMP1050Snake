package application;

import java.util.ArrayList;

public class Body extends Part{
	
	private ArrayList<Part> p;
	
	public Body(ArrayList<Part> p) {
		//super needs the x and y where we create the rectangle
		super(p.get(p.size()-1).getXPos(), p.get(p.size()-1).getYPos());
		this.p=p;
	}

	@Override
	public void move() {
		//update the prev pos with our current pos
		prevXPos=xPos;
		prevYPos=yPos;
		
		//update xPos and yPos to follow whatever is prev in the arraylist
		int myIndex=p.indexOf(this);
		xPos=p.get(myIndex-1).getPrevXPos();
		yPos=p.get(myIndex-1).getPrevYPos();
	}
	
}
