package catchALotProject.game2;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

// Shark class.
public class SharkKeyboardHandlerGM2 implements KeyboardHandler {

    private boolean endTime = false;
    private static final int speed = 25;
    // Pictures needed as parameters for constructor.
    private Picture sharkD;


    public boolean isEndTime() {
        return endTime;
    }

    public void setEndTime(boolean endTime) {
        this.endTime = endTime;
    }

    // Constructor, with 2 pictures, (left and right).
    public SharkKeyboardHandlerGM2(Picture sharkD){
        this.sharkD = sharkD;

    }

    // It is what it is.
    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
    }

    // Keyboard method where we define the picture/class movement.
    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        // To restrict/delete the shark.
        if(endTime == true){
            return;
        }

        // Decided to go with switch case, makes sense too.
        switch (keyboardEvent.getKey()) {

            // The Ifs prevent the picture from leaving the background/canvas.
            case KeyboardEvent.KEY_D:
                if(sharkD.getMaxX() >= 910){
                    return;
                }
                sharkD.load("resources/sharkD.gif");
                sharkD.translate(speed,0);
                sharkD.draw();
                break;

            case KeyboardEvent.KEY_A:
                if( sharkD.getX() <= Game2.PADDING){
                    return;
                }
                sharkD.load("resources/sharkL.gif");
                sharkD.translate(-speed,0);
                sharkD.draw();
                break;

            case KeyboardEvent.KEY_W:
                if(sharkD.getY() <= Game2.PADDING){
                    return;
                }
                sharkD.load("resources/sharkD.gif");
                sharkD.translate(0,-speed);
                sharkD.draw();
                break;

            case KeyboardEvent.KEY_S:
                if( sharkD.getMaxY() >= 510){
                    return;
                }
                sharkD.load("resources/sharkL.gif");
                sharkD.translate(0,speed);
                sharkD.draw();
                break;

        }
    }
}

