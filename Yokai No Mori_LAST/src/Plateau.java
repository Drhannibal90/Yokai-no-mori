/**
 * Created by bcontrer on 04/10/17.
 */


public class Plateau {
    private int[] tab;

    /**
     * Constructeur du modele..
     * Joueurs 1 positif, joueur 2 negatif
     * ORC = 4
     * Dragon = 3
     * Roi = 2x œx
     * Pion = 1
     */
    public Plateau(){
        tab = new int[30];
        for(int i=0; i<tab.length; i++){
            tab[0]=0;
        }

        /* Pieces joueur 1 */
        tab[0] = 4; tab[1] = 3; tab[2] = 3; tab[3] = 3; tab[4] = 4;
        tab[11] = 1; tab[12] = 1; tab[13] = 1;

        /* Pieces joueur 2*/
        tab[16] = -1; tab[17] = -1; tab[18] = -1;
        tab[25] = -4; tab[26] = -3; tab[27] = -3; tab[28] = -3; tab[29] = -4;
    }

    public int[] getTab() {
        return tab;
    }
}
