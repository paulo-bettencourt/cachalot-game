package catchALotProject.game2;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class ConfirmBiteGM2 {

    // We're gonna need this.. to make the whale proper dead.
    private boolean bite = false;

    // Pictures needed as parameters for constructor.
    private Picture whaleD;
    private Picture sharkD;

    // Constructor, with 4 pictures as parameters. (to check if the whale's been bitten by the shark).
    public ConfirmBiteGM2(Picture whaleD, Picture sharkD) {
        this.whaleD = whaleD;
        this.sharkD = sharkD;
    }

    // Boolean getter.
    public boolean isBitten(){
        return bite;
    }

    // Crucial method that will check if the shark took a bite or not.
    // PS: Thank you Rui and Sal.
    public void bite() {
        if(whaleD.getX() < sharkD.getMaxX() && whaleD.getMaxX() > sharkD.getX() &&
                 whaleD.getY() < sharkD.getMaxY() && whaleD.getMaxY() > sharkD.getY()){
            bite = true;
            whaleD.delete();
        }
    }
}
