package client;
import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.opengl.GL11;
public class SimpleVisUtilities {

	public final static float DEG2RAD = 3.14159f/180f;
	 

	public static void drawPoint(float x, float y){
		glBegin(GL_POINTS);
			glVertex2f(x,y);
		glEnd();
		
	}
	
	public static void drawCircle(float x, float y, float r){
		
		   glBegin(GL_LINE_LOOP);
		 
		   for (int i=0; i < 360; i++)
		   {
		      float degInRad = i*DEG2RAD;
		      GL11.glVertex2d((Math.cos(degInRad)*r)+x,(Math.sin(degInRad)*r)+y);
		   }
		 
		   glEnd();	
	
	}
}
