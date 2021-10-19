package catchALotProject.game2;

import catchALotProject.Main;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game2 {

    // I mean, why not? it looks good!
    public static final int PADDING = 10;
    // Starting positions for both whale and shark.
    public static final int yStart = 260;
    public static final int xShark = 810;
    public static final int xWhale = 60;
    //Property that holds the time the players have left.
    public static double timer;
    private Picture win =new Picture(Game2.PADDING,Game2.PADDING, "resources/SharkWinsFinal.png"); ;

    // Picture Instantiation.
    private Picture ocean2 = new Picture(PADDING,PADDING, "resources/ocean2.gif");
    Picture lose = new Picture(Game2.PADDING,Game2.PADDING, "resources/WhaleWinsFinal.png");

    // ConfirmBite needs to know the pictures.


    // Method that will start this game mode.
    public boolean startGM2() throws InterruptedException {
        Picture whaleD  = new Picture(xWhale,yStart, "resources/whaleD.png");
        // Shark needs 100-50 size.
        Picture sharkD  = new Picture(xShark,yStart, "resources/sharkD.gif");
        sharkD.load("resources/sharkL.gif");
        ConfirmBiteGM2 bitten = new ConfirmBiteGM2(whaleD,sharkD);
        TimerGM2 time = new TimerGM2 ( 5 ) ;
        timer=30;
        win.delete();
        lose.delete();
        // Method to invoke the drawing of the background and of our "players".
        ocean2.draw();
        // Pro tip: Draw the background picture first. Trust me.
        whaleD.draw();
        sharkD.draw();


        // Handler instantiation.
        WhaleKeyboardHandlerGM2 whale = new WhaleKeyboardHandlerGM2(whaleD,bitten);
        SharkKeyboardHandlerGM2 shark = new SharkKeyboardHandlerGM2(sharkD);

        whale.setEndTime(false);
        shark.setEndTime(false);

        // Keyboard instantiation.
        Keyboard keyboard = new Keyboard(whale);
        Keyboard keyboard2 = new Keyboard(shark);

        // Whale Keys.
        keyboard.addEventListener(KeyboardEvent.KEY_L, KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(KeyboardEvent.KEY_J,KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(KeyboardEvent.KEY_I, KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(KeyboardEvent.KEY_K, KeyboardEventType.KEY_RELEASED);

        // Shark Keys.
        keyboard2.addEventListener(KeyboardEvent.KEY_D,KeyboardEventType.KEY_RELEASED);
        keyboard2.addEventListener(KeyboardEvent.KEY_A,KeyboardEventType.KEY_RELEASED);
        keyboard2.addEventListener(KeyboardEvent.KEY_W,KeyboardEventType.KEY_RELEASED);
        keyboard2.addEventListener(KeyboardEvent.KEY_S,KeyboardEventType.KEY_RELEASED);

        // Props Jhost, for your help.
        Text showTimer = new Text(410,30,"" + timer);

        // While it's not bitten, it'll keep checking until it is.
        // When the timer ends, movement is halted.
        while(!bitten.isBitten()){
            Thread.sleep(250);
            // ----------
            timer -= 0.25;
            showTimer.setText("Time left: " + timer);
            showTimer.draw();
            // ----------
            bitten.bite();
            if(time.isEndTimer()){
              whale.setEndTime(true);
              shark.setEndTime(true);
              // If the timer ends and the whale is still alive, game over pic is drawn.

                lose.draw();
                return Main.win = false;
            }
        }

        // When bitten becomes true, it exits the while and you win pic is drawn.
        win.draw();
        whale.setEndTime(true);
        shark.setEndTime(true);
        return Main.win = false;
    }
}