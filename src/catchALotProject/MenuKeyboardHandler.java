package catchALotProject;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class MenuKeyboardHandler implements KeyboardHandler {

    private int gameNumber = 0;

    public MenuKeyboardHandler() {

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {




    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_A:
                gameNumber = 1;
                break;
            case KeyboardEvent.KEY_S:

                gameNumber = 2;
                break;
            case KeyboardEvent.KEY_D:

                gameNumber =3;
                break;
            case KeyboardEvent.KEY_X:
                System.exit(0);
                break;
            case KeyboardEvent.KEY_B:
                gameNumber= 0;
                break;
        }
    }

    public int getGameNumber() {
        return gameNumber;
    }

    public void setGameNumber(int gameNumber) {
        this.gameNumber = gameNumber;
    }
}
