package catchALotProject.game1;

import catchALotProject.SoundMenu;
import catchALotProject.game2.SharkKeyboardHandlerGM2;
import catchALotProject.game2.WhaleKeyboardHandlerGM2;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game1 {

    private Picture instructionPicker;
    private Picture game1Intructions;
    private Picture game2Intructions;
    private InstructionPickerKeyboard instruction;
    private SoundMenu instructions = new SoundMenu("/resources/NyanCat8bit.wav");


    public Game1() {
        instructionPicker = new Picture(10,10,"resources/rules.png");
        game1Intructions = new Picture(10,10,"resources/pvpInt.png");
        game2Intructions= new Picture(10,10,"resources/spInt.png");
       this.instruction = new InstructionPickerKeyboard();
        init(instruction);
    }

    public void intructionPicker(){
        instruction.setGameNumber(3);
        instructions.play(true);
        instructions.setLoop(30);
        while (instruction.getGameNumber()!=0){
            instructionPicker.draw();
            if (instruction.getGameNumber() == 1) {
                instructionPicker.delete();
                game1Intructions.draw();
                goBack();
                game1Intructions.delete();
                instruction.setGameNumber(4);
            }
            if (instruction.getGameNumber() == 2) {
                instructionPicker.delete();
                game2Intructions.draw();
                goBack();
                game2Intructions.delete();
                instruction.setGameNumber(4);

            }
        }
        instructionPicker.delete();
        instructions.stop();


    }

    public void init(InstructionPickerKeyboard instruction){

        // Keyboard instantiation.
        Keyboard keyboard = new Keyboard(instruction);

        // Whale Keys.
        keyboard.addEventListener(KeyboardEvent.KEY_A, KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(KeyboardEvent.KEY_S,KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(KeyboardEvent.KEY_B, KeyboardEventType.KEY_RELEASED);

    }
    public void goBack(){
        while (instruction.getGameNumber()!=0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
