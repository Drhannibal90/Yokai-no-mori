import javax.swing.*;
import java.awt.*;

/**
 * Created by bcontrer on 04/10/17.
 */
public class Fenetre extends JFrame {

    //* Composants graphiques
    //* Panel principal
    private JPanel fenetre, imagePlateau;
    //* Menu
    private JMenuBar menuBar;
    private JMenu menuPrincipal, menuAutre;
    private JMenuItem quitItem, resizeItem, newgameItem;
    //* Autres
    private Plateau plateau;
    private boolean petiteFenetre;
    private int xFenetre;
    private int yFenetre;


    public Fenetre(Plateau plateau){
        this.petiteFenetre = true;
        this.xFenetre = 553;
        this.yFenetre = 850;
        this.plateau = plateau;
        //* Création fenêtre
        creerFenetre();
        initMenu();
        addToWindow();
        pack();

     //   setSize(this.xFenetre, this.yFenetre);
        setTitle("Yokaï no mori");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);
    }

    //* Méthodes pour créer la fenêtre
    public void creerFenetre() {
        //* Création de tout les composants graphiques de la fenetre ( sauf Menu )

        //* Création de l'image de fond ( plateau )
        ImageIcon imageIcon =new ImageIcon( "fond2.png");
        ImageIcon imgNull =new ImageIcon( "fond3.png"); //* taille mini fenetre

        this.imagePlateau = new JPanel();
        this.imagePlateau = new PlateauGraphic(resizeWindow(imageIcon, xFenetre, yFenetre).getImage(), plateau, this);
        JLabel image = new JLabel(resizeWindow(imgNull, xFenetre, yFenetre));
       this.imagePlateau.add(image);

    }

    public void initMenu() {
        //* Création des componsants du menu

        //* Barre de menu *\\
        this.menuBar = new JMenuBar();

        //*  menu *\\
        this.menuPrincipal = new JMenu("Option");
        this.menuAutre = new JMenu("Aide");

        //* sous menu *\\
        this.newgameItem = new JMenuItem("Nouvelle partie");
        this.resizeItem = new JMenuItem("Changer la taille");
        this.quitItem = new JMenuItem("Quitter");

        //*  Ajout des items *\\

        this.menuPrincipal.add(this.newgameItem);
        this.menuPrincipal.add(this.resizeItem);
        this.menuPrincipal.addSeparator();
        this.menuPrincipal.add(this.quitItem);

        this.menuBar.add(this.menuPrincipal);
        this.menuBar.add(this.menuAutre);

        setJMenuBar(this.menuBar);

    }
    public void addToWindow() {
        //* Ajouts des composants graphique dans la fenêtre principales
        this.fenetre = new JPanel();
        this.fenetre.add(this.imagePlateau);
        setContentPane(this.fenetre);
    }

public ImageIcon resizeWindow(ImageIcon imageIcon, int width, int height){
    //   this.xFenetre = ((int) (1550)/2)-247;
    //   this.yFenetre = ((int) 880)-50; //* 247

    Image img = imageIcon.getImage();
    Image imgResize = img.getScaledInstance((int)(width),(int)(height),Image.SCALE_DEFAULT);
    imageIcon=new ImageIcon(imgResize);

    return imageIcon;
}


    //* Méthodes pour initialiser les controleurs
    public void  setControlMenu(ControlMenu cm){
        //* initialiser le controlMenu
        this.resizeItem.addActionListener(cm);
    }

    public void setControlClick(ControlMouse controlMouse) {
        //* initialiser le ControlClick
        this.imagePlateau.addMouseListener(controlMouse);
    }
    public void update(){
        imagePlateau.repaint();
    }

    //* ...

    //* GETTERS && SETTERS


    public boolean isPetiteFenetre() {
        return petiteFenetre;
    }

    public void setPetiteFenetre(boolean petiteFenetre) {
        this.petiteFenetre = petiteFenetre;
    }

    public int getxFenetre() {
        return xFenetre;
    }

    public void setxFenetre(int xFenetre) {
        this.xFenetre = xFenetre;
    }

    public int getyFenetre() {
        return yFenetre;
    }

    public void setyFenetre(int yFenetre) {
        this.yFenetre = yFenetre;
    }

    public JPanel getImagePlateau() {
        return imagePlateau;
    }

    public void setImagePlateau(JPanel imagePlateau) {
        this.imagePlateau = imagePlateau;
    }
}
