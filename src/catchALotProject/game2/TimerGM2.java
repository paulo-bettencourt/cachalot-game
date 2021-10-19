package catchALotProject.game2;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.Timer;
import java.util.TimerTask;

// Found this on the web and modified it.. slightly.
public class TimerGM2 {
    private boolean endTimer = false;
    Timer timer;

    public boolean isEndTimer() {
        return endTimer;
    }

    public void setEndTimer(boolean endTimer) {
        this.endTimer = endTimer;
    }

    // Timer constructor.
    public TimerGM2 (int seconds)   {
        timer = new Timer();
        // So.. This is basically the time our timer will have, name's "delay".
        timer.schedule(new TimerGM2Task (),seconds*5850); // Lasts around 30 seconds.
    }

    // The timer itself, with a built-in constructor and method that runs our timer.. i think.
    class TimerGM2Task extends TimerTask {
        public void run() {
            timer.cancel();
            // If the Whale isn't bitten and the timer runs out.
            endTimer = true;
        }
    }

}
