/**
 * Created by bcontrer on 04/10/17.
 */
public class Controleur {

    public Controleur(Plateau p) {
        Fenetre f = new Fenetre(p);
        new ControlMouse(p,f);
        new ControlMenu(p,f);
        f.setVisible(true);
    }
}
