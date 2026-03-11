package projectbeta;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;

public class Game {

    private long window;

    public void run() {

        GLFW.glfwInit();

        window = GLFW.glfwCreateWindow(800, 600, "ProjectBeta", 0, 0);
        GLFW.glfwMakeContextCurrent(window);

        GL.createCapabilities();

        Renderer renderer = new Renderer();

        while (!GLFW.glfwWindowShouldClose(window)) {

            renderer.render();

            GLFW.glfwSwapBuffers(window);
            GLFW.glfwPollEvents();

if (GLFW.glfwGetKey(window, GLFW.GLFW_KEY_W) == GLFW.GLFW_PRESS)
    renderer.moveCamera(0f, -0.1f);

if (GLFW.glfwGetKey(window, GLFW.GLFW_KEY_S) == GLFW.GLFW_PRESS)
    renderer.moveCamera(0f, 0.1f);

if (GLFW.glfwGetKey(window, GLFW.GLFW_KEY_A) == GLFW.GLFW_PRESS)
    renderer.moveCamera(-0.1f, 0f);

if (GLFW.glfwGetKey(window, GLFW.GLFW_KEY_D) == GLFW.GLFW_PRESS)
    renderer.moveCamera(0.1f, 0f);
        }

        GLFW.glfwTerminate();
    }
}