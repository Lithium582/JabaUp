package Clases;

import java.util.Random;

public class GeneradorDatosGenericos {
    public int[] generarDatos(int pTipo, int pCantidad){
        switch(pTipo){
            case 1:{
                return generarDatosAscendentes(pCantidad);
            }
            
            case 2:{
                return generarDatosDescendentes(pCantidad);
            }
            
            case 3:{
                return generarDatosAleatorios(pCantidad);
            }
            default:{
                return null;
            }
        }
    }
    
        private int[] generarDatosAleatorios(int cantidad) {
		Random rnd = new Random();
		int[] datosGenerados = new int[cantidad];
		boolean[] datosUtilizados = new boolean[cantidad];
		for (int i = 0; i < datosGenerados.length; i++) {
			int j = rnd.nextInt(cantidad);
			while(datosUtilizados[j]){
				j = (j + 1) % cantidad;
			}
			datosGenerados[j] = i;
			datosUtilizados[j] = true;
		}
		return datosGenerados;
	}
	
	private int[] generarDatosAscendentes(int cantidad) {
		int [] copiaAscendente = new int[cantidad];
		for (int i = 0; i < cantidad; i++) {
			copiaAscendente[i] = i;
		}
		return copiaAscendente;
	}
	
	private int[] generarDatosDescendentes(int cantidad) {
		int [] copiaDescendente = new int[cantidad];
		for (int i = 0; i < cantidad; i++) {
			copiaDescendente[i] = cantidad - i;
		}
		return copiaDescendente;
	}
	
}
