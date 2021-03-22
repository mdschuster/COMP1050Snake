package application;

public class Head extends Part{

	public Head() {
		super(300,300);
	}

	@Override
	public void move() {
		//update the prev positions
		prevXPos=xPos;
		prevYPos=yPos;
		
		//move the object (change xPos and yPos)
		switch(dir) {
			case("UP"):
				yPos-=size;
				break;
			case("DOWN"):
				yPos+=size;
				break;
			case("LEFT"):
				xPos-=size;
				break;
			case("RIGHT"):
				xPos+=size;
				break;
			default:
				System.out.printf("Unknown direction%n");
				break;
		}
		
	}
	
}
