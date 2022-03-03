import processing.core.PApplet;

public class Animation extends PApplet {
    final float BOX_SIZE = 20.f;
    final float MAX_BOX_HEIGHT = 380.f;
    final int   BOX_COUNT = 19;
    final float CAMERA_DISTANCE = 600;
    final float RPS = 0.05f;

    public void settings() {
        size(1000, 1000, P3D);
    }

    public void setup()
    {
        stroke(0);
        fill(255);
    }
  
    public void draw()
    {
        background(40);
        translate(width / 2, height / 2);
        
        float currentSec = millis() / 1000.f;
        float angle = currentSec * TWO_PI * RPS;
        float cameraX = sin(angle) * CAMERA_DISTANCE;
        float cameraY = cos(angle) * CAMERA_DISTANCE;
        camera(cameraX, cameraY, 300, 0, 0, 0, 0, 0, -1);
        pointLight(255, 255, 255, 300, 300, 300);

        for (int x = 0; x < 19; x++) {
            push();
            translate((x - BOX_COUNT / 2) * BOX_SIZE, 0, 0);
            for (int y = 0; y < 19; y++) {
                push();
                translate(0, (y - BOX_COUNT / 2) * BOX_SIZE, 0);
                int centeredX = x - BOX_COUNT / 2;
                int centeredY = y - BOX_COUNT / 2;
                float height = sin(currentSec + sqrt(centeredX * centeredX + centeredY * centeredY) / 5) * MAX_BOX_HEIGHT;
                box(BOX_SIZE, BOX_SIZE, height);
                pop();
            }
            pop();
        }
    }
    
    public static void main(String[] args) {
        PApplet.main(new String[] { "Animation" });
    }
}