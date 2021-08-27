/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whoscounting;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author JEFRY
 */
public class WhosCounting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Variables del juego
        int estrategia[][] = llenarEstrategia();
        int numRuleta, posicionUsuario, posicionComputador;

        int cantidadesDeJuegos = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad de juegos que desea"));

        for (int k = 0; k < cantidadesDeJuegos; k++) {
            Integer humano[] = new Integer[5];
            Integer computadora[] = new Integer[5];
            for (int i = 0; i < 5; i++) {
                numRuleta = girarRuleta();
                String juegoHumanoActual="";
                for (int j = 0; j < humano.length; j++) {
                    if (humano[j]==null) {
                        juegoHumanoActual+=" | ";
                    }
                    else{
                        juegoHumanoActual+=humano[j]+" | ";
                    }
                }

                //USUARIO
                do {
                    posicionUsuario = Integer.parseInt(JOptionPane.showInputDialog(null, "Sú número es " + numRuleta + ", escoja en que posición ponerlo: "+juegoHumanoActual));
                    posicionUsuario = posicionUsuario - 1;
                } while ((posicionUsuario < 0 || posicionUsuario > 4) || humano[posicionUsuario] != null);

                humano[posicionUsuario] = numRuleta;
                JOptionPane.showMessageDialog(null, "Posición ingresada correctamente");

                //COMPUTADOR
                posicionComputador = estrategia[numRuleta][i] - 1;
                while (computadora[posicionComputador] != null) {
                    posicionComputador++;
                }

                computadora[posicionComputador] = numRuleta;
                
            }
            //Transformas los vectores a números
            String numHumanoStr = "";
            int numHumano = 0;
            for (Integer i : humano) {
                numHumanoStr += i;
            }
            numHumano = Integer.parseInt(numHumanoStr);

            String numComputadorStr = "";
            int numComputador = 0;
            for (Integer i : computadora) {
                numComputadorStr += i;
            }
            numComputador = Integer.parseInt(numComputadorStr);

           JOptionPane.showMessageDialog(null,"Su resultado: "+numHumano+"\nEl resultado de la máquina: "+numComputador+"\n"+((numHumano > numComputador) ? "Ganó usted" : "Ganó máquina"));
        }

    }

    public static int girarRuleta() {
        return (int) (Math.random() * (9));
    }

    public static int[][] llenarEstrategia() {
        int estrategia[][] = new int[10][5];
        //Llenar matriz: NUMERO OBSERVADO: X, GIRO: Y+1
        estrategia[0][0] = 5;
        estrategia[0][1] = 4;
        estrategia[0][2] = 3;
        estrategia[0][3] = 2;
        estrategia[0][4] = 1;
        estrategia[1][0] = 5;
        estrategia[1][1] = 3;
        estrategia[1][2] = 3;
        estrategia[1][3] = 2;
        estrategia[1][4] = 1;
        estrategia[2][0] = 5;
        estrategia[2][1] = 3;
        estrategia[2][2] = 3;
        estrategia[2][3] = 2;
        estrategia[2][4] = 1;
        estrategia[3][0] = 4;
        estrategia[3][1] = 3;
        estrategia[3][2] = 2;
        estrategia[3][3] = 2;
        estrategia[3][4] = 1;
        estrategia[4][0] = 4;
        estrategia[4][1] = 3;
        estrategia[4][2] = 2;
        estrategia[4][3] = 2;
        estrategia[4][4] = 1;
        estrategia[5][0] = 3;
        estrategia[5][1] = 3;
        estrategia[5][2] = 2;
        estrategia[5][3] = 1;
        estrategia[5][4] = 1;
        estrategia[6][0] = 3;
        estrategia[6][1] = 2;
        estrategia[6][2] = 1;
        estrategia[6][3] = 1;
        estrategia[6][4] = 1;
        estrategia[7][0] = 2;
        estrategia[7][1] = 2;
        estrategia[7][2] = 1;
        estrategia[7][3] = 1;
        estrategia[7][4] = 1;
        estrategia[8][0] = 1;
        estrategia[8][1] = 1;
        estrategia[8][2] = 1;
        estrategia[8][3] = 1;
        estrategia[8][4] = 1;
        estrategia[9][0] = 1;
        estrategia[9][1] = 1;
        estrategia[9][2] = 1;
        estrategia[9][3] = 1;
        estrategia[9][4] = 1;
        return estrategia;

    }

}
