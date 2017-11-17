package Clases;

import java.util.Random;

public class GeneradorDatosGenericos {
	private static int TAMANIO_MAX = 300;
        
	public int[] generarDatosAleatorios() {
		Random rnd = new Random();
		int[] datosGenerados = new int[TAMANIO_MAX];
		boolean[] datosUtilizados = new boolean[TAMANIO_MAX];
		for (int i = 0; i < datosGenerados.length; i++) {
			int j = rnd.nextInt(TAMANIO_MAX);
			while(datosUtilizados[j]){
				j = (j + 1) % TAMANIO_MAX;
			}
			datosGenerados[j] = i;
			datosUtilizados[j] = true;
		}
		return datosGenerados;
	}
	
	public int[] generarDatosAscendentes() {
		int [] copiaAscendente = new int[TAMANIO_MAX];
		for (int i = 0; i < TAMANIO_MAX; i++) {
			copiaAscendente[i] = i;
		}
		return copiaAscendente;
	}
	
	public int[] generarDatosDescendentes() {
		int [] copiaDescendente = new int[TAMANIO_MAX];
		for (int i = 0; i < TAMANIO_MAX; i++) {
			copiaDescendente[i] = TAMANIO_MAX - i;
		}
		return copiaDescendente;
	}
        
        public int[] generarDatosAleatorios(int cantidad) {
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
	
	public int[] generarDatosAscendentes(int cantidad) {
		int [] copiaAscendente = new int[cantidad];
		for (int i = 0; i < cantidad; i++) {
			copiaAscendente[i] = i;
		}
		return copiaAscendente;
	}
	
	public int[] generarDatosDescendentes(int cantidad) {
		int [] copiaDescendente = new int[cantidad];
		for (int i = 0; i < cantidad; i++) {
			copiaDescendente[i] = cantidad - i;
		}
		return copiaDescendente;
	}
	
}
