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
    private PlateauGraphic plateauGraph;


    public ControlMouse(Plateau p, Fenetre f){
        this.plateau = p;
        this.fenetre = f;
        fenetre.setControlClick(this);
        caseClicked = -1;
        plateauGraph = (PlateauGraphic) fenetre.getImagePlateau();
        bordureX = plateauGraph.getBordureX();
        largeurCase = plateauGraph.getLargeurCase();
        bordureY = plateauGraph.getBordureY();
        hauteurCase = plateauGraph.getHauteurCase();
    }


    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
       caseClicked = -1;
        /*if ((mouseEvent.getX() >= 32) && (mouseEvent.getX() <= 750) && (mouseEvent.getY() >= 102) && (mouseEvent.getY() <= 700) ){
            caseClicked = (mouseEvent.getX()-bordureX)/largeurCase + (mouseEvent.getY()-bordureY)/hauteurCase *5 ;

        }*/

        this.caseClicked = ((mouseEvent.getX()-(bordureX/2))/largeurCase) + ((mouseEvent.getY()-(bordureY/2))/hauteurCase) *5 ;


        System.out.println("----------------------------");

       // System.out.println("X : " + (mouseEvent.getX()-(bordureX/2))/largeurCase);
       // System.out.println("Y : " + (mouseEvent.getY()-(bordureY/2))/hauteurCase);
        int [][] tabTest = {
                {4,0,0,0,0,-4},
                {5,1,4,0,-1,-5},
                {6,1,0,0,-1,-6},
                {5,1,5,0,-1,-5},
                {4,0,1,0,0,4},

        };
        plateauGraph.tableauToSprite(tabTest);
        plateauGraph.repaint();

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
