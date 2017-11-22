import java.util.List;

/**
 * Created by bcontrer on 04/10/17.
 */


public class Plateau {
    public static int tour;
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

    public static void bougerPiece(int[] numPiece, int[] numCase, int[][] tab, List cimetiere){
        if( tab[numCase[0]][numCase[1]] != 0){
            mangePiece(tab[numCase[0]][numCase[1]],cimetiere);
        }
        tab[numCase[0]][numCase[1]] = tab[numPiece[0]][numPiece[1]];
        tab[numPiece[0]][numPiece[1]]=0;
        tour++;
    }

    public static void mangePiece(int nbEstMange,List cimetiere){
        cimetiere.add(nbEstMange);
    }

    //1 == pion
    //2 == super pion
    //3 == ogre
    //4 == super ogre
    //5 == dragon
    //6 == roi
    //- == adversaire

    public static int[][] getMovePiece(int numPiece){
        int[][] possitionPossible=new int[3][3];
        for(int i=0;i<3;i++){
            possitionPossible[0][i]=0;
            possitionPossible[1][i]=0;
            possitionPossible[2][i]=0;
        }
        if(numPiece==1){
            possitionPossible[1][2]=1;
            return possitionPossible;
        }
        if(numPiece==-1){
            possitionPossible[1][0]=1;
            return possitionPossible;
        }
        if(numPiece==2 || numPiece==4 || numPiece==5){
            possitionPossible[0][2]=1;
            possitionPossible[1][2]=1;
            possitionPossible[2][2]=1;
            possitionPossible[0][1]=1;
            possitionPossible[2][1]=1;
            possitionPossible[1][0]=1;
            return possitionPossible;
        }
        if(numPiece==-2 || numPiece==-4 || numPiece==-5){
            possitionPossible[0][0]=1;
            possitionPossible[1][0]=1;
            possitionPossible[2][0]=1;
            possitionPossible[0][1]=1;
            possitionPossible[2][1]=1;
            possitionPossible[1][2]=1;
            return possitionPossible;
        }
        if(numPiece==3){
            possitionPossible[0][2]=1;
            possitionPossible[1][2]=1;
            possitionPossible[2][2]=1;
            possitionPossible[0][0]=1;
            possitionPossible[0][2]=1;
            return possitionPossible;
        }
        if(numPiece==-3){
            possitionPossible[0][0]=1;
            possitionPossible[1][0]=1;
            possitionPossible[2][0]=1;
            possitionPossible[2][0]=1;
            possitionPossible[2][2]=1;
            return possitionPossible;
        }
        if(numPiece==6 || numPiece==-6){
            possitionPossible[0][0]=1;
            possitionPossible[1][0]=1;
            possitionPossible[2][0]=1;
            possitionPossible[0][1]=1;
            possitionPossible[1][1]=1;
            possitionPossible[2][1]=1;
            possitionPossible[0][2]=1;
            possitionPossible[1][2]=1;
            possitionPossible[2][2]=1;
            return possitionPossible;
        }
        return possitionPossible;
    }

    public static int[][] getMovePossible(int[] numPiece,int[][] tab){
        int[][] mouvementPossible;
        int[][] possitionPossible=new int[5][6];

        mouvementPossible=getMovePiece( tab[ numPiece[0] ][ numPiece[1] ] );

        for(int x=0;x<5;x++){
            for(int y=0;y<6;y++){
                possitionPossible[x][y]=0;
            }
        }

        for (int x=0;x<3;x++){
            for (int y=0;y<3;y++){
                if(mouvementPossible[x][y]==1){
                    if( tab[ numPiece[0] ][ numPiece[1] ] > 0){
                        if(numPiece[0]+x-1>=0 && numPiece[0]+x-1<5 && numPiece[1]+y-1>=0 && numPiece[1]+y-1<6) {
                            if (tab[numPiece[0] + x - 1][numPiece[1] + y - 1] <= 0) {
                                possitionPossible[numPiece[0] + x - 1][numPiece[1] + y - 1] = 1;
                            }
                        }
                    }
                    else{
                        if(numPiece[0]+x-1>=0 && numPiece[0]+x-1<5 && numPiece[1]+y-1>=0 && numPiece[1]+y-1<6) {
                            if (tab[numPiece[0] + x - 1][numPiece[1] + y - 1] >= 0) {
                                possitionPossible[numPiece[0] + x - 1][numPiece[1] + y - 1] = 1;
                            }
                        }
                    }
                }
            }
        }

        return possitionPossible;
    }

    public static int[][] placePieceDeCimetiere(int numPiece,int[][] tab){
        int[][] tabPlaceOK=new int[5][6];
        for (int x=0;x<5;x++){
            for(int y=0;y<6;y++){
                if(tab[x][y]==0){
                    tabPlaceOK[x][y]=1;
                }
                else
                    tabPlaceOK[x][y]=0;
            }
        }
        if(numPiece==1 ){
            for (int x=0;x<5;x++){
                for(int y=0;y<6;y++){
                    if(tab[x][y]==1){
                        tabPlaceOK[x][0]=0;
                        tabPlaceOK[x][1]=0;
                        tabPlaceOK[x][2]=0;
                        tabPlaceOK[x][3]=0;
                        tabPlaceOK[x][4]=0;
                        tabPlaceOK[x][5]=0;
                    }
                }
            }
        }
        if(numPiece==-1 ){
            for (int x=0;x<5;x++){
                for(int y=0;y<6;y++){
                    if(tab[x][y]==-1){
                        tabPlaceOK[x][0]=0;
                        tabPlaceOK[x][1]=0;
                        tabPlaceOK[x][2]=0;
                        tabPlaceOK[x][3]=0;
                        tabPlaceOK[x][4]=0;
                        tabPlaceOK[x][5]=0;
                    }
                }
            }
        }

        return tabPlaceOK;
    }

    public static void mettreDepuisCimetiere(int nbPiece,int valPiece,List cimetiere,int[] coord, int[][] tab){
        tab[coord[0]][coord[1]]=valPiece;
        cimetiere.remove(nbPiece);
        tour++;
    }
    public int[] getTab() {
        return tab;
    }
}
