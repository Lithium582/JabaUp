/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jabaup;

import Clases.*;

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
        
        int[] ale10000 = gnd.generarDatosAleatorios(10132);
        
        TClasificador clasifica = new TClasificador();
        
        //Inserción
        System.out.println("Orden por Inserción");
        long tiempoAntes = System.nanoTime();
        clasifica.clasificar(ale10000, 2, true);
        long tiempoDespues = System.nanoTime();
        
        //System.out.println(TClasificador.strArray(ale10000));
        
        double diferencia = (tiempoDespues - tiempoAntes) / Math.pow(10, 6);
        System.out.println("Ascendente 10000: " + diferencia);
        
    }
    
}
