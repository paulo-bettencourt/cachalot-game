package catchALotProject.game3;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class WhaleKeyboardHandler implements KeyboardHandler {

    private int speed = 25;
    private Picture pictureLeft;

    private boolean keyboardEndGame = false;

    // constructor that receives the left and right whale
    public WhaleKeyboardHandler(Picture pictureLeft) {

        this.pictureLeft = pictureLeft;
        keyboardEndGame = false;
    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        //  if keyboardendgame is true, the game is over
        // is invoked after the init() on the Game3 class
        if(keyboardEndGame == true) {
            return;
        }

        switch(keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                if(pictureLeft.getMaxX() >= 910) {
                    return;
                }
                pictureLeft.load("resources/whaleD.png");
                pictureLeft.translate(speed,0);
                pictureLeft.draw();
                break;

            case KeyboardEvent.KEY_LEFT:
                if(pictureLeft.getX() <= Game3.PADDING) {
                    return;
                }
                pictureLeft.load("resources/whaleL.png");
                pictureLeft.translate(-speed,0);
                pictureLeft.draw();
                break;

            case KeyboardEvent.KEY_UP:
                if(pictureLeft.getY() <= Game3.PADDING) {
                    return;
                }
                pictureLeft.load("resources/whaleD.png");
                pictureLeft.translate(0,-speed);
                pictureLeft.draw();
                break;

            case KeyboardEvent.KEY_DOWN:
                if(pictureLeft.getMaxY() >= 510) {
                    return;
                }
                pictureLeft.load("resources/whaleL.png");
                pictureLeft.translate(0,speed);
                pictureLeft.draw();
                break;

       } }

    public boolean setKeyboardEndGameTrue() {
        return keyboardEndGame = true;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

    }


}
