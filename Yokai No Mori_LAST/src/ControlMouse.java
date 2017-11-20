import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

/**
 * Created by bcontrer on 04/10/17.
 */
public class ControlMouse implements MouseListener {

    private Plateau plateau;
    private Fenetre fenetre;
    private int caseClicked;
    //* Liste de cases
    private final int HAUTEUR_PETITE_CASE = 101;
    private final int LARGEUR_PETITE_CASE = 144;
    private final int DEPASSEMENT_PETITE_CASE_X = 32;
    private final int DEPASSEMENT_PETITE_CASE_Y = 101;
    private int bordureX;
    private int largeurCase;
    private int bordureY;
    private int hauteurCase;


    public ControlMouse(Plateau p, Fenetre f){
        this.plateau = p;
        this.fenetre = f;
        this.fenetre.setControlClick(this);
        this.caseClicked = -1;
        this.bordureX = (int)((7.7*(fenetre.getxFenetre()))/100); //* 7.7
        this.largeurCase = (fenetre.getxFenetre()-(bordureX)) / 5;
        this.bordureY = (int)((21.1*(fenetre.getyFenetre()))/100);
        this.hauteurCase = (fenetre.getyFenetre()-(bordureY)) / 6;
    }


    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        this.caseClicked = -1;
        if ((mouseEvent.getX() >= 32) && (mouseEvent.getX() <= 750) && (mouseEvent.getY() >= 102) && (mouseEvent.getY() <= 700) ){
            this.caseClicked = (mouseEvent.getX()-bordureX)/largeurCase + (mouseEvent.getY()-bordureY)/hauteurCase *5 ;

        }

        this.caseClicked = ((mouseEvent.getX()-(bordureX/2))/largeurCase) + ((mouseEvent.getY()-(bordureY/2))/hauteurCase) *5 ;


        System.out.println("----------------------------");
       // System.out.println("largeur = " + this.fenetre.getxFenetre() + " hauteur : " + fenetre.getyFenetre());
      // System.out.println("Lcase = " + largeurCase);
      //  System.out.println("bordure = " + bordureX);
       // System.out.println("X : " + (mouseEvent.getX()-(bordureX/2))/largeurCase);
       // System.out.println("Y : " + (mouseEvent.getY()-(bordureY/2))/hauteurCase);

        // System.out.println("X : " + ((mouseEvent.getX()-bordureX)/largeurCase) + " / Y : " + ((mouseEvent.getY()-bordureY)/hauteurCase));
      // System.out.println("X :" + (mouseEvent.getX()) + " / Y : " + mouseEvent.getY());
        System.out.println(caseClicked);
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    public void initCasesPetitPlateau(){

    }


}
