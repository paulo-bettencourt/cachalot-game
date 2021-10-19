package catchALotProject;

import catchALotProject.game1.Game1;
import catchALotProject.game2.Game2;
import catchALotProject.game3.Game3;
import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Shape;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.List;

public class Main {
        public static boolean win;

    public static void main(String[] args) throws InterruptedException {
        Picture menu = new Picture(10,10,"resources/menu.png");
        Game1 game1 = new Game1();
        // Creating an instance of Game2 called catchALot..
        Game2 catchALot = new Game2();




        Game3 game = new Game3();


        SoundMenu menuSound = new SoundMenu("/resources/MenuTrap.wav");
        menuSound.play(true);
        menuSound.setLoop(2);
        SoundMenu instructions = new SoundMenu("/resources/NyanCat8bit.wav");
        SoundMenu multiPlayer = new SoundMenu("/resources/gameMP.wav");
        SoundMenu singlePlayer = new SoundMenu("/resources/gameSP.wav");
        MenuKeyboardHandler gameMenu = new MenuKeyboardHandler();


        Keyboard keyboard = new Keyboard(gameMenu);


        keyboardEvents(keyboard);

        while (true) {

            menu.draw();

            if (gameMenu.getGameNumber()==1){
                menuSound.stop();
                menu.delete();
                game1.intructionPicker();
                menuSound.play(true);

            }
            if (gameMenu.getGameNumber()==2){
                menuSound.stop();
                Thread.sleep(1500);
                multiPlayer.play(true);
                multiPlayer.setLoop(10);
                menu.delete();
                //..and invoking the startGM2 method to start the game.
                catchALot.startGM2();
                multiPlayer.stop();
                checkIfBack(gameMenu);
                Thread.sleep(1500);
                menuSound.play(true);

            }
            if (gameMenu.getGameNumber()==3){
                menuSound.stop();
                Thread.sleep(1500);
                singlePlayer.play(true);
                singlePlayer.setLoop(10);
                menu.delete();
                game.init();
                game.enemy();
                singlePlayer.stop();
                checkIfBack(gameMenu , win );
                Thread.sleep(1500);
                menuSound.play(true);
            }



        }
    }




    public static void keyboardEvents(Keyboard keyboard) throws InterruptedException {

        KeyboardEvent a = new KeyboardEvent();
        a.setKey(KeyboardEvent.KEY_B);
        a.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(a);


        KeyboardEvent e = new KeyboardEvent();
        e.setKey(KeyboardEvent.KEY_A);
        e.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(e);


        KeyboardEvent i = new KeyboardEvent();
        i.setKey(KeyboardEvent.KEY_S);
        i.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(i);


        KeyboardEvent o = new KeyboardEvent();
        o.setKey(KeyboardEvent.KEY_D);
        o.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(o);

        KeyboardEvent u = new KeyboardEvent();
        u.setKey(KeyboardEvent.KEY_X);
        u.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(u);


    }

    public static void checkIfBack(MenuKeyboardHandler gameMenu , boolean win ){
        SoundMenu winOrLose = null;
        if ( win  ){
            winOrLose= new SoundMenu("/resources/youWin.wav");
            System.out.println("ok");
            winOrLose.setLoop(10);
            winOrLose.play(true);
        }
        if ( !win ){
          winOrLose= new SoundMenu("/resources/youLose.wav");
          winOrLose.setLoop(10);
            winOrLose.play(true);
        }
        while (gameMenu.getGameNumber()!=0){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        winOrLose.stop();
        gameMenu.setGameNumber(4);
        List<Shape> shapes = Canvas.getInstance().getShapes();
        shapes.clear();
    }

    public static void checkIfBack(MenuKeyboardHandler gameMenu){
        SoundMenu cheer =new SoundMenu("/resources/cheering.wav");
        cheer.setLoop(5);
        cheer.play(true);
        while (gameMenu.getGameNumber()!=0){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        cheer.stop();
        gameMenu.setGameNumber(4);
        List<Shape> shapes = Canvas.getInstance().getShapes();
        shapes.clear();
    }


    }


