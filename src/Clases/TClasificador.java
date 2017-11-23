package Clases;

import java.util.Arrays;
import java.util.Collections;

public class TClasificador {

    public static final int INSERCION = 1;
    public static final int LABURBUJA = 2;
    public static final int QUICKSORT = 3;
    public static final int HEAPSORT = 4;
    public static final int SELECCION = 5;
    public static final int ELDEJAVA = 6;

    private final String[] _nombreMetodos;
    private static final GeneradorDatosGenericos _jabaGenerador = new GeneradorDatosGenericos();
    private static final long _tiempoMaximo = 1000;

    public TClasificador() {
        _nombreMetodos = new String[]{"Inserción", "Burbuja", "QuickSort", "HeapSort", "Selección", "Ordenación Java"};
    }

    /**
     * Punto de entrada al clasificador
     *
     * @param metodoClasificacion
     * @param orden
     * @param tamanioVector
     * @return Un vector del tam. solicitado, ordenado por el algoritmo
     * solicitado
     */
    public int[] Clasificar(int[] vector, int metodo, boolean cascara) {
        switch (metodo) {
            case INSERCION: {
                if (cascara) {
                    return InsertionCascara(vector);
                } else {
                    return InsertionSort(vector);
                }
            }
            case LABURBUJA:{
                if (cascara) {
                    return LaBurbujaCascara(vector);
                } else {
                    return LaBurbujaSort(vector);
                }
            }
            case QUICKSORT:{
                if (cascara) {
                    return QuickSortCascara(vector);
                } else {
                    return QuickSort(vector);
                }
            }
            case HEAPSORT:{
                if (cascara) {
                    return JepSortCascara(vector);
                } else {
                    return JepSort(vector);
                }
            }
            case SELECCION:{
                if (cascara) {
                    return SelectionSortCascara(vector);
                } else {
                    return SelectionSort(vector);
                }
            }
            case ELDEJAVA:{
                if (cascara) {
                    return JavaSortCascara(vector);
                } else {
                    Arrays.sort(vector);
                    return vector;
                }
            }
            default:{
                System.err.println("JabaUp dice: \nHOLA");
                break;
            }
        }

        return vector;
    }

    //Algorito de Inserción
    /**
     * @param vector
     * @return
     */
    protected int[] InsertionSort(int[] vector) {
        if (vector != null) {
            for (int i = 1; i < vector.length; i++) {
                int j = i - 1;
                int aux = vector[i];
                /*while ((j >= 0) && (vector[j] > vector[j + 1])) {
                    //int aux = vector[j + 1];
                    //vector[j + 1] = vector[j];
                    //vector[j] = aux;
                    j--;
                }*/
                while ((j >= 0) && (vector[j] > aux)) {
                    vector[j + 1] = vector[j];
                    j--;
                }
                
                vector[j+1] = aux;
            }
            return vector;
        }
        return null;
    }

    protected int[] InsertionCascara(int[] datosParaClasificar) {
        if (datosParaClasificar != null) {
            return datosParaClasificar;
        }
        return null;
    }

    //Algorito de La Burbuja
    private int[] LaBurbujaSort(int[] vector) {
        boolean ordenado = false;
        int ultimo = vector.length - 1;
        
        while (!ordenado) {
            ordenado = true;
            for (int i = 0; i < ultimo; i++) {
                if (vector[i] > vector[i + 1]) {
                    int aux = vector[i + 1];
                    vector[i + 1] = vector[i];
                    vector[i] = aux;
                    ordenado = false;
                }
            }
            ultimo--;
        }

        return vector;
    }

    protected int[] LaBurbujaCascara(int[] datosParaClasificar) {
        if (datosParaClasificar != null) {
            return datosParaClasificar;
        }
        return null;
    }

    //Algorito QuickSort
    protected int[] QuickSort(int[] datosParaClasificar) {
        QuickSort(datosParaClasificar, 0, datosParaClasificar.length - 1);
        return datosParaClasificar;
    }

    private int[] QuickSort(int[] entrada, int i, int j) {
        if (entrada.length > 1) {
            int izquierda = i;
            int derecha = j;
            int pivote = encuentraPivote(izquierda, derecha, entrada);

            while (izquierda <= derecha) {
                while ((entrada[izquierda] < pivote) && (izquierda < j)) {
                    izquierda++;//Error
                }

                while ((pivote < entrada[derecha]) && (derecha > i)) {
                    derecha--;//Error
                }

                if (izquierda <= derecha) {
                    int aux = entrada[izquierda];
                    entrada[izquierda] = entrada[derecha];
                    entrada[derecha] = aux;
                    izquierda++;
                    derecha--;
                }
            }

            if (i < derecha) {
                QuickSort(entrada, i, derecha); //Error
            }
            if (izquierda < j) {
                QuickSort(entrada, izquierda, j); //Error
            }
        }

        return entrada;
    }

    private int encuentraPivote(int l, int h, int[] vector) {
        //int v1 = vector[l];
        //int v2 = vector[h];
        int v3 = vector[l + (h - l) / 2];

        return v3;
        //return (v1 + v3) / 2;
    }

    protected int[] QuickSortCascara(int[] datosParaClasificar) {
        if (datosParaClasificar != null) {
            return datosParaClasificar;
        }
        return null;
    }

    //Algorito Heap
    public int[] JepSort(int[] vector) {
        int[] copia = vector.clone();
        for (int i = copia.length / 2 - 1; i >= 0; i--) {
            Jepificar(copia, copia.length, i);
        }
        for (int i = copia.length - 1; i >= 0; i--) {
            int aux = copia[0];
            copia[0] = copia[i];
            copia[i] = aux;
            Jepificar(copia, i, 0);
        }
        return copia;
    }

    /**
     *
     * @param arr
     * @param n
     * @param i
     */
    private void Jepificar(int arr[], int n, int i) {
        int maximo = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && arr[l] > arr[maximo]) {
            maximo = l;
        }
        if (r < n && arr[r] > arr[maximo]) {
            maximo = r;
        }
        if (maximo != i) {
            int swap = arr[i];
            arr[i] = arr[maximo];
            arr[maximo] = swap;
            Jepificar(arr, n, maximo);
        }
    }
    
    protected int[] JepSortCascara(int[] datosParaClasificar) {
        if (datosParaClasificar != null) {
            return datosParaClasificar;
        }
        return null;
    }
    
    //Algorito Selección
    public int[] SelectionSort(int[] vector) {
        int[] copia = vector.clone();
        for (int i = 0; i < copia.length; i++) {
            int min = i;
            for (int j = i; j < copia.length; j++) {
                if (copia[j] < copia[min]) {
                    min = j;
                }
            }
            int aux = copia[i];
            copia[i] = copia[min];
            copia[min] = aux;
        }
        return copia;
    }
    
    protected int[] SelectionSortCascara(int[] datosParaClasificar) {
        if (datosParaClasificar != null) {
            return datosParaClasificar;
        }
        return null;
    }

    //Algorito Java
    protected int[] JavaSortCascara(int[] datosParaClasificar) {
        if (datosParaClasificar != null) {
            return datosParaClasificar;
        }
        return null;
    }
    
    //Otros Métodos
    public static String ArrayToString(int[] vector) {
        String strRetorno = "";
        if (vector.length > 0) {
            strRetorno = String.valueOf(vector[0]);
            for (int i = 1; i < vector.length; i++) {
                strRetorno += "," + String.valueOf(vector[i]);
            }
        }
        return strRetorno;
    }

    public void Clasificador(int pMetodo, int pCantidad) {
        String tiemposGuardar = _nombreMetodos[pMetodo-1] + "\n";
        for(int i = 1; i < 4; i++){ //Por método (Random, ascendente, descendente)
                int[] vectorAUtilizar = _jabaGenerador.generarDatos(i, pCantidad);
                
                //Ascendente
                if (i == 1) {
                    //System.out.println("Ascendente de " + _cantidadElementos[j] + " elementos: " + tiempoFinal + " milisegundos");
                    tiemposGuardar += "Ascendente de " + pCantidad + " elementos:\n";
                }
                //Descendente
                if (i == 2) {
                    //System.out.println("Descendente de " + _cantidadElementos[j] + " elementos: " + tiempoFinal + " milisegundos");
                    tiemposGuardar += "Descendente de " + pCantidad + " elementos:\n";
                }
                //Randómico
                if (i == 3) {
                    //System.out.println("Randómico de " + _cantidadElementos[j] + " elementos: " + tiempoFinal + " milisegundos");
                    tiemposGuardar += "Randómico de " + pCantidad + " elementos:\n";
                }
                
                for (int h = 0; h <= 10; h++) {
                    //Realizamos el procedimiento sin cascara
                    long total = 0;
                    double llamadas = 0;
                    long start = System.nanoTime();
                    while (total < _tiempoMaximo) {
                        llamadas++;
                        int[] copia = vectorAUtilizar.clone();
                        this.Clasificar(copia, pMetodo, false);
                        total = (System.nanoTime() - start) / 1000000;
                    }
                    double tiempoMedio = total / llamadas;

                    //Realizamos el procedimiento con cascara
                    total = 0;
                    llamadas = 0;
                    start = System.nanoTime();
                    while (total < _tiempoMaximo) {
                        llamadas++;
                        int[] copia = vectorAUtilizar.clone();
                        this.Clasificar(copia, pMetodo, true);
                        total = (System.nanoTime() - start) / 1000000;
                    }
                    double tiempoCascara = total / llamadas;
                    double tiempoFinal = tiempoMedio - tiempoCascara;
                    
                    tiemposGuardar += tiempoFinal + "\n";
                } 
        }
        
        String[] guardar = new String[1];
        guardar[0] = tiemposGuardar;
        
        ManejadorArchivosGenerico.escribirArchivo("./src/" + _nombreMetodos[pMetodo-1] + ".txt", guardar);
    }
    }
