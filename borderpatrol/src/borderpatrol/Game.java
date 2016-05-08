package borderpatrol;


import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
 
import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

import java.nio.ByteBuffer;

public class Game {
	
	GLFWKeyCallback keyCallback;
	
	private long window;
	
	public void init(){
        // Setup an error callback. The default implementation
        // will print the error message in System.err.
        GLFWErrorCallback.createPrint(System.err).set();
 
        // Initialize GLFW. Most GLFW functions will not work before doing this.
        if ( !glfwInit() )
            throw new IllegalStateException("Unable to initialize GLFW");
 
        // Configure our window
        glfwDefaultWindowHints(); // optional, the current window hints are already the default
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); // the window will stay hidden after creation
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE); // the window will be resizable
 
        int WIDTH = StaticConfig.winWidth;
        int HEIGHT = StaticConfig.winHeight;
 
        // Create the window
        window = glfwCreateWindow(WIDTH, HEIGHT, "Hello World!", NULL, NULL);
        if ( window == NULL )
            throw new RuntimeException("Failed to create the GLFW window");
 
        keyCallback = new GLFWKeyCallback() {
            @Override
            public void invoke(long window, int key, int scancode, int action, int mods) {
                if (key == GLFW_KEY_ESCAPE && action == GLFW_PRESS) {
                    glfwSetWindowShouldClose(window, true);
                }
            }
        };
 
        // Get the resolution of the primary monitor
        GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
        // Center our window
        glfwSetWindowPos(
            window,
            (vidmode.width() - WIDTH) / 2,
            (vidmode.height() - HEIGHT) / 2
        );
 
        // Make the OpenGL context current
        glfwMakeContextCurrent(window);
        // Enable v-sync
        glfwSwapInterval(1);
 
        // Make the window visible
        glfwShowWindow(window);
		
	}
	
	public void loop(){
		
		int buffer = GL45.glCreateBuffers();
		ByteBuffer bbfr = BufferUtils.createByteBuffer(9);
		bbfr.putFloat(-1.0f);
		bbfr.putFloat(-1.0f);
		bbfr.putFloat(0.0f);
		
		bbfr.putFloat(0.0f);
		bbfr.putFloat(1.0f);
		bbfr.putFloat(0.0f);
		
		bbfr.putFloat(1.0f);
		bbfr.putFloat(-1.0f);
		bbfr.putFloat(0.0f);
		
		bbfr.flip();
		
		
		while (glfwWindowShouldClose(window) != true) {
		    /* Do something */
			double time = glfwGetTime();
			
		
		
		
			
			
			glfwSwapBuffers(window);
			glfwPollEvents();
		}
	}
	
	
	public void shutdown(){
        glfwFreeCallbacks(window);
        glfwDestroyWindow(window);
        glfwTerminate();
        glfwSetErrorCallback(null).free();
	}
	
}
