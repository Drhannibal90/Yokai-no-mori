import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by bcontrer on 04/10/17.
 */
public class ControlMenu implements ActionListener {

    private Plateau plateau;
    private Fenetre fenetre;

    //* Constantes
    private final int TAILLE_X_GRANDE = 1500;
    private final int TAILLE_Y_GRANDE = 1500;
    private final int TAILLE_X_PETIT = 800;
    private final int TAILLE_Y_PETIT = 850;


    public ControlMenu(Plateau p, Fenetre f){
        this.plateau = p;
        this.fenetre = f;
        this.fenetre.setControlMenu(this);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Changer la taille")){
            if (this.fenetre.isPetiteFenetre()){
                this.fenetre.setSize(TAILLE_X_GRANDE,TAILLE_Y_GRANDE);
                this.fenetre.setxFenetre(TAILLE_X_GRANDE);
                this.fenetre.setyFenetre(TAILLE_Y_GRANDE);
                this.fenetre.setPetiteFenetre(false);
            }else{
                this.fenetre.setSize(TAILLE_X_PETIT,TAILLE_Y_PETIT);
                this.fenetre.setxFenetre(TAILLE_X_PETIT);
                this.fenetre.setyFenetre(TAILLE_Y_PETIT);
                this.fenetre.setPetiteFenetre(true);

            }
        }
    }
}
