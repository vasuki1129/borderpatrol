//Hello!
//I am simplevis
//I am the most basic visual output from the alaron collective
//I provide basic input output operations necessary to interact with the collective

//I am as simple as possible
//I am as fast as possible

//I exist to serve you.







//RUN ME ONLY IF A SERVER IS RUNNING



package client;
import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
 
import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import static client.SimpleVisUtilities.*;

public class SimpleVis {
	  // The window handle
    private long window;
    AgentSprite player;
    public Socket sock;
    server.networking.CharStatPacket curPack;
    
    public void run() throws UnknownHostException, IOException {
        System.out.println("Hello LWJGL " + Version.getVersion() + "!");
        sock = new Socket(InetAddress.getByName("127.0.0.1"),9098);
        
        player = new AgentSprite();
        
        
        try {
            init();
            loop();
 
            // Free the window callbacks and destroy the window
            glfwFreeCallbacks(window);
            glfwDestroyWindow(window);
        } finally {
            // Terminate GLFW and free the error callback
            glfwTerminate();
            glfwSetErrorCallback(null).free();
        }
    }
 
    private void init() {
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
 
        int WIDTH = 800;
        int HEIGHT = 800;
 
        // Create the window
        window = glfwCreateWindow(WIDTH, HEIGHT, "Hello World!", NULL, NULL);
        if ( window == NULL )
            throw new RuntimeException("Failed to create the GLFW window");
 
        // Setup a key callback. It will be called every time a key is pressed, repeated or released.
        glfwSetKeyCallback(window, (window, key, scancode, action, mods) -> {
            if ( key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE )
                glfwSetWindowShouldClose(window, true); // We will detect this in our rendering loop
        });
 
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
 
    private void loop() throws IOException {
        // This line is critical for LWJGL's interoperation with GLFW's
        // OpenGL context, or any context that is managed externally.
        // LWJGL detects the context that is current in the current thread,
        // creates the GLCapabilities instance and makes the OpenGL
        // bindings available for use.
        GL.createCapabilities();
 
        // Set the clear color
        glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
 
        
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity(); // Resets any previous projection matrices
        glOrtho(0, 800, 800, 0, 1, -1);
        glMatrixMode(GL_MODELVIEW);
        // Run the rendering loop until the user has attempted to close
        // the window or has pressed the ESCAPE key.
        float frame = 0;
        float endFrame = 10000000;

        while ( !glfwWindowShouldClose(window) ) {
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer
            player.update(curPack);
            
            
            
            
            
            
            glfwSwapBuffers(window); // swap the color buffers
 
            // Poll for window events. The key callback above will only be
            // invoked during this call.
            glfwPollEvents();
            frame++;
        }
        sock.close();
    }
 
    
    private class AgentSprite implements Renderable{
    	public float x;
    	public float y;
    	
    	public void render(){
    		drawCircle(x,y,2);
    		drawCircle(x,y,7);
    	}
    	
    	public void update(server.networking.CharStatPacket curPkt){
    		//x = curPkt.
    	}
    	
    }
    
    
    
    public static void main(String[] args) throws UnknownHostException, IOException {
        new SimpleVis().run();
    }
	
	
	
    private class comThread implements Runnable {

		@Override
		public void run() {
			
			
		}
    	
    	
    }
    
}
