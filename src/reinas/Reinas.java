/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reinas;

/**
 *
 * @author Xavi
 */
public class Reinas {

    int[] reinas;

    public Reinas(int nReinas) {
        this.reinas = new int[nReinas];
    }

    //verifica si puede poner una reina en la fila y columa especificada
    public boolean puedePoner(int fila, int columna) {
        for (int i = 0; i < fila; i++) {
            if (reinas[i] == columna || (i - fila) == (reinas[i] - columna) ||(i - fila) == (columna - reinas[i])) 
            {
                return false;
            }
        }
        return true;
    }

    public void imprimir(int[] reinas) {
        int nReinas = reinas.length;
        for (int i = 0; i < nReinas; i++) {
            for (int j = 0; j < nReinas; j++) {
                if (reinas[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    //busca e imprime todas las posibles soluciones de n reinas en un "tablero" de n x n donde no se ataquen las reinas
    public void buscaSolucion(int fila, int nReinas) {
        for (int columna = 0; columna < nReinas; columna++) {
            if (puedePoner(fila, columna)) {
                reinas[fila] = columna;
                if (fila == nReinas - 1) {
                    imprimir(reinas);
                } else {
                    buscaSolucion(fila + 1, nReinas);
                }
            }
        }
    }

    public void getSoluciones() {
        buscaSolucion(0, reinas.length);
    }

    public static void main(String[] args) {
        Reinas obj = new Reinas(4);
        obj.getSoluciones();
     
    }
}
