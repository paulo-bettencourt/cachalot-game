package catchALotProject.game2;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

// Whale class.
public class WhaleKeyboardHandlerGM2 implements KeyboardHandler {

    private boolean endTime = false;
    private static final int speed = 50;
    // Needed to restrict/delete the whale.
    private ConfirmBiteGM2 bitten;
    // Pictures needed as parameters for constructor.
    private Picture whaleD;


    public boolean isEndTime() {
        return endTime;
    }

    public void setEndTime(boolean endTime) {
        this.endTime = endTime;
    }

    // Constructor, with 2 pictures, (left and right).
    public WhaleKeyboardHandlerGM2(Picture whaleD, ConfirmBiteGM2 bitten){
        this.whaleD = whaleD;
        this.bitten = bitten;
    }

    // It is what it is.
    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
    }

    // Keyboard method where we define the picture/class movement.
    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        // To restrict/delete the whale.
        if(bitten.isBitten() || endTime == true){
            return;
        }

        // Decided to go with switch case, makes sense too.
        switch (keyboardEvent.getKey()) {

            // The Ifs prevent the picture from leaving the background/canvas.
            case KeyboardEvent.KEY_L:
                if( whaleD.getMaxX() >= 910){
                    return;
                }
                whaleD.load("resources/whaleD.png");
                whaleD.translate(speed,0);
                whaleD.draw();
                break;

            case KeyboardEvent.KEY_J:
                if(whaleD.getX() <= 10 ){
                    return;
                }
                whaleD.load("resources/whaleL.png");
                whaleD.translate(-speed,0);
                whaleD.draw();

                break;

            case KeyboardEvent.KEY_I:
                if( whaleD.getY() <= 10 ){
                    return;
                }
                whaleD.load("resources/whaleD.png");
                whaleD.translate(0,-speed);
                whaleD.draw();
                break;

            case KeyboardEvent.KEY_K:
                if(whaleD.getMaxY() >= 510){
                    return;
                }
                whaleD.load("resources/whaleL.png");
                whaleD.translate(0,speed);
                whaleD.draw();
                break;

        }
    }
}
