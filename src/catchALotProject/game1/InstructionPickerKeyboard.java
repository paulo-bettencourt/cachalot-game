package catchALotProject.game1;

import catchALotProject.game3.Game3;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class InstructionPickerKeyboard implements KeyboardHandler {

    private int gameNumber = 3;

    public InstructionPickerKeyboard() {


    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {


        switch(keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_A:
                gameNumber = 1;
                break;

            case KeyboardEvent.KEY_S:
                gameNumber = 2;
                break;

            case KeyboardEvent.KEY_B:
                gameNumber= 0;
                break;


       } }

    public int getGameNumber() {
        return gameNumber;
    }

    public void setGameNumber(int gameNumber) {
        this.gameNumber = gameNumber;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

    }


}
