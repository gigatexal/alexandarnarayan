

package week2;
//color 255, 209, 0


import processing.core.*;
import java.util.*;

public class HelloGUI extends PApplet {
	private String URL = "http://funflightscom.c.presscdn.com/wp-content/uploads/2014/04/LaJolla.jpg";
	private PImage bkgrndImage;	
	
	
	public void setup() {
		
		bkgrndImage = loadImage(URL,"jpg");
		size(bkgrndImage.width/2,bkgrndImage.height/2);
		
	}
	
	public void draw(){
		Date currDate = new Date();
		String currentDate = currDate.toString();
		
		bkgrndImage.resize(width, height);
		image(bkgrndImage,0,0);
		fill(255,209,0);
		ellipse(width/4,width/4,height/5,height/5);
		
		System.out.println(currentDate);

		
		
		
	}
}


