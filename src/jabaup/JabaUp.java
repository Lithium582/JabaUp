/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jabaup;

import Clases.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Lithium582
 */
public class JabaUp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorDatosGenericos gnd = new GeneradorDatosGenericos();
//
//        int[] ascendente300 = gnd.generarDatosAscendentes(300);
//        int[] ascendente3000 = gnd.generarDatosAscendentes(3000);
//        int[] ascendente30000 = gnd.generarDatosAscendentes(30000);
//
//        int[] descendente300 = gnd.generarDatosDescendentes(300);
//        int[] descendente3000 = gnd.generarDatosDescendentes(3000);
//        int[] descendente30000 = gnd.generarDatosDescendentes(30000);
//
//        int[] aleaTorio300 = gnd.generarDatosAleatorios(300);
//        int[] aleaTorio3000 = gnd.generarDatosAleatorios(3000);
//        int[] aleaTorio30000 = gnd.generarDatosAleatorios(30000);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TClasificador objClasificador = new TClasificador();
        boolean b = false;
        int op = -1;

        try {
            while (op != 0) {
                if (b) {
                    System.out.println(" ----------------------------------------------- ");
                    System.out.println(" ------------ ENTER para continuar ------------- ");
                    System.out.println(" ----------------------------------------------- ");
                    reader.readLine();
                } else {
                    b = !b;
                }

                System.out.println("==============================");
                System.out.println(" Bienvenido a JABA-UP ");
                System.out.println("==============================");
                System.out.println(" Seleccione su método de ordenación ");
                System.out.println("1 - Inserción");
                System.out.println("2 - La Burbuja");
                System.out.println("3 - QuickSort");
                System.out.println("4 - HeapSort");
                System.out.println("5 - Selección");
                System.out.println("6 - Ordenación de Java");
                op = Integer.parseInt(reader.readLine());

                if(op > 0){
                    if(op > 6){
                        System.out.println("Valor inválido");
                    } else {
                        System.out.println("Ingrese la cantidad de elementos");
                        int cantidad = Integer.parseInt(reader.readLine());
                        
                        objClasificador.Clasificador(op, cantidad);
                    }
                }
            }
        } catch (Exception ex) {

        }
    }

}
