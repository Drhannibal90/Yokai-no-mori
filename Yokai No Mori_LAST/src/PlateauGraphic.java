import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PlateauGraphic extends JPanel {


    private ImageIcon imgPlateauLoaded;
    private Image imgPlateau;

    private ImageIcon imgKodamaLoaded;
    private ImageIcon imgKirinLoaded;
    private ImageIcon imgOniLoaded;
    private ImageIcon imgKoropokkuruLoaded;

    private String path;
    private Plateau plateau;
    private Fenetre fenetre;

    private int bordureX;
    private int largeurCase;
    private int bordureY;
    private int hauteurCase;

    private List<Sprite> listeSprite;

    private boolean debutPartie;


    public PlateauGraphic(Image img, Plateau plateau, Fenetre fenetre){

        this.plateau = plateau;
        this.fenetre = fenetre;
        debutPartie  =true;
        listeSprite = new ArrayList<Sprite>();

        bordureX = (int)((7.7*(fenetre.getxFenetre()))/100); //* 7.7
        largeurCase = (fenetre.getxFenetre()-(bordureX)) / 5;
        bordureY = (int)((21.1*(fenetre.getyFenetre()))/100);
        hauteurCase = (fenetre.getyFenetre()-(bordureY)) / 6;


        imgKodamaLoaded = new ImageIcon(new ImageIcon("kodama.png").getImage().getScaledInstance(65,65, Image.SCALE_DEFAULT));
        imgKirinLoaded = new ImageIcon(new ImageIcon("kirin.png").getImage().getScaledInstance(65, 65, Image.SCALE_DEFAULT));
        imgOniLoaded = new ImageIcon(new ImageIcon("oni.png").getImage().getScaledInstance(65, 65, Image.SCALE_DEFAULT));
        imgKoropokkuruLoaded = new ImageIcon(new ImageIcon("koropokkuru.png").getImage().getScaledInstance(65, 65, Image.SCALE_DEFAULT));
        imgPlateau = img;


    }

    public void initPlateau(Graphics2D g2){
        for(int i=0; i<plateau.getTab().length; i++){
            switch(Math.abs(plateau.getTab()[i])){
                case 1:
                    g2.drawImage(imgKodamaLoaded.getImage(), ((bordureX/4)+(largeurCase/4))+(largeurCase*(i%5)),((bordureY/4)+(hauteurCase/2))+(hauteurCase*((i-(i%5))/5)),null);
                    break;
                case 2:
                    g2.drawImage(imgKoropokkuruLoaded.getImage(), ((bordureX/4)+(largeurCase/4))+(largeurCase*(i%5)),((bordureY/4)+(hauteurCase/2))+(hauteurCase*((i-(i%5))/5)),null);
                    break;
                case 3:
                    g2.drawImage(imgKirinLoaded.getImage(), ((bordureX/4)+(largeurCase/4))+(largeurCase*(i%5)),((bordureY/4)+(hauteurCase/2))+(hauteurCase*((i-(i%5))/5)),null);
                    break;
                case 4:
                    g2.drawImage(imgOniLoaded.getImage(), ((bordureX/4)+(largeurCase/4))+(largeurCase*(i%5)),((bordureY/4)+(hauteurCase/2))+(hauteurCase*((i-(i%5))/5)),null);
                    break;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g){

        super.paintComponent(g);
        //* optimisation 2d
        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(imgPlateau, 0,0,null);
            initPlateau(g2);





    }
    public void tableauToSprite(int[][] tab){

    }
    


    public int getBordureX() {
        return bordureX;
    }

    public void setBordureX(int bordureX) {
        this.bordureX = bordureX;
    }

    public int getLargeurCase() {
        return largeurCase;
    }

    public void setLargeurCase(int largeurCase) {
        this.largeurCase = largeurCase;
    }

    public int getBordureY() {
        return bordureY;
    }

    public void setBordureY(int bordureY) {
        this.bordureY = bordureY;
    }

    public int getHauteurCase() {
        return hauteurCase;
    }

    public void setHauteurCase(int hauteurCase) {
        this.hauteurCase = hauteurCase;
    }
}
