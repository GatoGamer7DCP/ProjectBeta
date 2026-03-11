package projectbeta;

import static org.lwjgl.opengl.GL11.*;

public class Renderer {

    private float camX = 0;
    private float camY = 2;
    private float camZ = 6;
    public void moveCamera(float dx, float dz) {
        camX += dx;
        camZ += dz;
    }

    private Texture grass;
    private Texture stone;

    public Renderer() {

        glEnable(GL_TEXTURE_2D);

        grass = new Texture("assets/textures/grass.png");
        stone = new Texture("assets/textures/stone.png");
    }

    public void render() {

        glViewport(0, 0, 800, 600);

        glClearColor(0.5f, 0.7f, 1.0f, 1.0f);
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

        glEnable(GL_DEPTH_TEST);

        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glFrustum(-1, 1, -0.75, 0.75, 1, 100);

        glMatrixMode(GL_MODELVIEW);
        glLoadIdentity();

        glMatrixMode(GL_MODELVIEW);
        glLoadIdentity();
        
        glRotatef(20f, 1f, 0f, 0f);
        glTranslatef(-camX, -camY, -camZ);

        for (int x = -5; x < 5; x++) {
            for (int z = -5; z < 5; z++) {

                drawCube(x, 0, z);

            }
        }
    }

    private void drawCube(float x, float y, float z) {

    glPushMatrix();
    glTranslatef(x, y, z);

    glBegin(GL_QUADS);

    // ===== TOPO (grass) =====
    grass.bind();

    glTexCoord2f(0,0); glVertex3f(-0.5f, 0.5f, -0.5f);
    glTexCoord2f(1,0); glVertex3f( 0.5f, 0.5f, -0.5f);
    glTexCoord2f(1,1); glVertex3f( 0.5f, 0.5f,  0.5f);
    glTexCoord2f(0,1); glVertex3f(-0.5f, 0.5f,  0.5f);

    // ===== BASE (stone) =====
    stone.bind();

    glTexCoord2f(0,0); glVertex3f(-0.5f, -0.5f, -0.5f);
    glTexCoord2f(1,0); glVertex3f( 0.5f, -0.5f, -0.5f);
    glTexCoord2f(1,1); glVertex3f( 0.5f, -0.5f,  0.5f);
    glTexCoord2f(0,1); glVertex3f(-0.5f, -0.5f,  0.5f);

    // ===== FRENTE =====
    stone.bind();

    glTexCoord2f(0,0); glVertex3f(-0.5f,-0.5f,0.5f);
    glTexCoord2f(1,0); glVertex3f(0.5f,-0.5f,0.5f);
    glTexCoord2f(1,1); glVertex3f(0.5f,0.5f,0.5f);
    glTexCoord2f(0,1); glVertex3f(-0.5f,0.5f,0.5f);

    // ===== TRÁS =====

    glTexCoord2f(0,0); glVertex3f(-0.5f,-0.5f,-0.5f);
    glTexCoord2f(1,0); glVertex3f(0.5f,-0.5f,-0.5f);
    glTexCoord2f(1,1); glVertex3f(0.5f,0.5f,-0.5f);
    glTexCoord2f(0,1); glVertex3f(-0.5f,0.5f,-0.5f);

    // ===== ESQUERDA =====

    glTexCoord2f(0,0); glVertex3f(-0.5f,-0.5f,-0.5f);
    glTexCoord2f(1,0); glVertex3f(-0.5f,-0.5f,0.5f);
    glTexCoord2f(1,1); glVertex3f(-0.5f,0.5f,0.5f);
    glTexCoord2f(0,1); glVertex3f(-0.5f,0.5f,-0.5f);

    // ===== DIREITA =====

    glTexCoord2f(0,0); glVertex3f(0.5f,-0.5f,-0.5f);
    glTexCoord2f(1,0); glVertex3f(0.5f,-0.5f,0.5f);
    glTexCoord2f(1,1); glVertex3f(0.5f,0.5f,0.5f);
    glTexCoord2f(0,1); glVertex3f(0.5f,0.5f,-0.5f);

    glEnd();

    glPopMatrix();
}
}