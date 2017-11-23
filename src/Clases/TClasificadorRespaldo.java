package Clases;

import java.util.Collections;

public class TClasificadorRespaldo {

    public static final int METODO_CLASIFICACION_INSERCION = 1;
    public static final int METODO_CLASIFICACION_SHELL = 2;
    public static final int METODO_CLASIFICACION_BURBUJA = 3;
    public static final int METODO_CLASIFICACION_QUICKSORT = 4;
    public static final int PRECISION = 1;

    private int[] vectorIncremento;

    public TClasificadorRespaldo() {
        //this.vectorIncremento = new int[]{5003, 1009, 211, 127, 17, 13, 7, 5, 1};
        this.vectorIncremento = new int[]{5066, 2533, 1266, 633, 316, 158, 79, 39, 19, 9, 4, 2, 1};
    }

    private int calcularVectorIncremento(int valor) {
        for (int i = this.vectorIncremento.length - 1; i >= 0; i--) {
            if (this.vectorIncremento[i] > valor) {
                return i + 1;
            }
        }
        return 0;
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
    public int[] clasificar(int[] datosParaClasificar, int metodoClasificacion, boolean cascara) {
        switch (metodoClasificacion) {
            case METODO_CLASIFICACION_INSERCION: {
                if (cascara) {
                    return ordenarPorInsercionCascara(datosParaClasificar);
                } else {
                    return ordenarPorInsercion(datosParaClasificar);
                }
            }
            case METODO_CLASIFICACION_SHELL:
                return ordenarPorShellB(datosParaClasificar);
            //return shellSort(datosParaClasificar);
            case METODO_CLASIFICACION_BURBUJA:
                return ordenarPorBurbuja(datosParaClasificar);
            case METODO_CLASIFICACION_QUICKSORT:
                return ordenarPorQuickSort(datosParaClasificar);
                //return quickSort2(datosParaClasificar);
                //return quickSort3(datosParaClasificar);
            case 5:
                return quickSort(datosParaClasificar);
            default:
                System.err.println("Este codigo no deberia haberse ejecutado");
                break;
        }
        return datosParaClasificar;
    }

    protected int[] ordenarPorInsercionCascara(int[] datosParaClasificar) {
        if (datosParaClasificar != null) {
            return datosParaClasificar;
        }
        return null;
    }

    private void intercambiar(int[] vector, int pos1, int pos2) {
        int temp = vector[pos2];
        vector[pos2] = vector[pos1];
        vector[pos1] = temp;
    }

    /**
     * @param datosParaClasificar
     * @return
     */
    private int[] ordenarPorShell(int[] datosParaClasificar) {
        int j, inc;
        int[] incrementos = new int[]{3223, 358, 51, 10, 3, 1};

        for (int posIncrementoActual = 1; posIncrementoActual < incrementos.length; posIncrementoActual++) {
            inc = incrementos[posIncrementoActual];
            if (inc < (datosParaClasificar.length / 2)) {
                for (int i = inc; i < datosParaClasificar.length; i++) {
                    j = i - inc;
                    while (j >= 0) {
                        if (datosParaClasificar[j] > datosParaClasificar[j + inc]) {
                            intercambiar(datosParaClasificar, j, j + inc);
                        }
                        j = j -= inc;
                    }
                }
            }
        }
        return datosParaClasificar;
    }

    private int[] ordenarPorShellB(int[] datosParaClasificar) {
        int pIzq;
        int cantValores = datosParaClasificar.length;
        //int distancia = cantValores / 2;
        int indice = this.calcularVectorIncremento(cantValores);
        int distancia = vectorIncremento[indice];

        while (distancia > 0) {
            for (int i = distancia; i < cantValores; i++) {
                int pDer = datosParaClasificar[i];

                for (pIzq = i; (pIzq >= distancia) && (datosParaClasificar[pIzq - distancia] > pDer); pIzq -= distancia) {
                    datosParaClasificar[pIzq] = datosParaClasificar[pIzq - distancia];
                }

                datosParaClasificar[pIzq] = pDer;
            }

            //distancia = distancia / 2;
            if (distancia > 1) {
                indice++;
                distancia = vectorIncremento[indice];
            } else {
                distancia = 0;
            }
        }
        return datosParaClasificar;
    }

    public int[] shellSort(int[] vector) {
        int indice = this.calcularVectorIncremento(vector.length);
        while (indice < this.vectorIncremento.length) {
            int incremento = this.vectorIncremento[indice];
            for (int i = incremento; i < vector.length; i++) {
                int aux = vector[i];
                int j = i - incremento;
                while (j >= 0 && aux < vector[j]) {
                    vector[j + incremento] = vector[j];
                    j -= incremento;
                }
                vector[j + incremento] = aux;
            }
            indice++;
        }

        return vector;
    }

    /**
     * @param datosParaClasificar
     * @return
     */
    protected int[] ordenarPorInsercion(int[] datosParaClasificar) {
        if (datosParaClasificar != null) {
            for (int i = 2; i < datosParaClasificar.length; i++) {
                int j = i - 1;
                while ((j >= 0) && (datosParaClasificar[j] > datosParaClasificar[j + 1])) {
                    intercambiar(datosParaClasificar, j + 1, j);
                    j--;
                }
            }
            return datosParaClasificar;
        }
        return null;
    }

    private int[] ordenarPorBurbuja(int[] datosParaClasificar) {
        System.out.println("Burbuja");
        //datosParaClasificar = null;
        int n = datosParaClasificar.length - 1;
        for (int i = 0; i <= n; i++) {
            for (int j = n; j >= (i + 1); j--) {
                if (datosParaClasificar[j] < datosParaClasificar[j - 1]) {
                    intercambiar(datosParaClasificar, j - 1, j);
                }
            }
        }
        return datosParaClasificar;
    }

    public static String strArray(int[] vector) {
        String strRetorno = "";
        if (vector.length > 0) {
            strRetorno = String.valueOf(vector[0]);
            for (int i = 1; i < vector.length; i++) {
                strRetorno += "," + String.valueOf(vector[i]);
            }
        }
        return strRetorno;
    }

    public int[] quickSort2(int[] vector) {
        int[] cont = new int[1];
        cont[0] = 0;
        this.quickSort2(vector, 0, vector.length - 1, cont);

        return vector;
    }

    public void quickSort2(int[] vector, int l, int h, int[] contador) {
        contador[0]++;
        System.out.println(contador[0]);
        int p;
        int left = l;
        int right = h;
        if (right > l) {
            p = encuentraBigote(vector, l, h);
            System.out.println((h - l) + " elementos impresos");
            if (p != 0) {
                while (right > left) {
                    while (vector[left] < p) {
                        left++;
                    }

                    while (vector[right] >= p) {
                        right--;
                    }

                    int aux = vector[left];
                    vector[left] = vector[right];
                    vector[right] = aux;
                    right--;
                    left++;
                }

                if(left == right){
                    if(left != l && right != h){
                        right--;
                    }
                }
                
                if (left < h) {
                    quickSort2(vector, left, h, contador);
                }
                if (l < right) {
                    quickSort2(vector, l, right, contador);
                }
            }
//        }
        }

    }

    private int encuentraBigote(int[] vector, int l, int h) {
        int res = vector[l];
        for (int i = l; i <= h; i++) {
            if (res != vector[i]) {
                res = -1;
                break;
            }
        }

        //Significa que encontró claves diferentes
        if (res == -1) {
            int v1 = vector[l];
            int v2 = vector[h];
            int v3 = vector[l + (h - l) / 2];

            return (v1 + v2 + v3) / 3;
        }

        return 0;

    }

    public int[] quickSort(int[] vector) {
        this.quickSort(vector, 0, vector.length - 1);

        return vector;
    }

    public void quickSort(int[] vector, int l, int h) {
        int p;
        if (h > l) {
            p = particionar(vector, l, h);
            quickSort(vector, l, p - 1);
            quickSort(vector, p + 1, h);
        }
    }

    private int particionar(int[] vector, int l, int h) {
        int contador;
        int p;
        int firsthigh;
        p = h;
        firsthigh = l;
        for (contador = l; contador < h; contador++) {
            if (vector[contador] < vector[p]) {
                int aux = vector[contador];
                vector[contador] = vector[firsthigh];
                vector[firsthigh] = aux;
                firsthigh++;
            }
        }
        int aux = vector[p];
        vector[p] = vector[firsthigh];
        vector[firsthigh] = aux;
        return firsthigh;
    }

    protected int[] ordenarPorQuickSort(int[] datosParaClasificar) {
        quicksort(datosParaClasificar, 0, datosParaClasificar.length - 1);
        return datosParaClasificar;
    }

    private void quicksort(int[] entrada, int i, int j) {
        int izquierda = i;
        int derecha = j;

        int pivote = encuentraPivote(izquierda, derecha, entrada);
//        if (posicionPivote >= 0) {
//            int pivote = entrada[posicionPivote];//El sexto error!!!!! :D

            while (izquierda <= derecha) {
                while ((entrada[izquierda] < pivote) && (izquierda < j)) {
                    izquierda++;//Error
                }

                while ((pivote < entrada[derecha]) && (derecha > i)) {
                    derecha--;//Error
                }

                if (izquierda <= derecha) {
                    intercambiar(entrada, izquierda, derecha);//Eggog
                    izquierda++;
                    derecha--;
                }
 //           }

            if (i < derecha) {
                quicksort(entrada, i, derecha); //Error
            }
            if (izquierda < j) {
                quicksort(entrada, izquierda, j); //Error
            }
        }
    }

    private int encuentraPivote(int l, int h, int[] vector) {
        int v1 = vector[l];
            int v2 = vector[h];
            int v3 = vector[l + (h - l) / 2];

            return (v1 + v2 + v3) / 3;

    }

    public int[] quickSort3(int[] vector) {
        int[] cont = new int[1];
        cont[0] = 0;
        this.quickSort2(vector, 0, vector.length - 1, cont);

        return vector;
    }

    public void quickSort3(int[] vector, int left, int right, int[] contador) {
        int pivote = (left + right) / 2;//encuentraBigoteQuick3(vector, left, right);
        contador[0]++;
        System.out.println(contador[0]);
        int i = left;
        int j = right;
        while (i < j) {
            while (vector[i] < pivote) {
                i++;
            }

            while (vector[j] > pivote) {
                j--;
            }
            
                int aux = vector[i];
                vector[i] = vector[j];
                vector[j] = aux;

            if (left < j) {
                //quickSort2(vector, l, right - 1, contador);
                quickSort3(vector, left, j, contador);
            }
            if (i < right) {
                //quickSort2(vector, right, h,contador);
                quickSort3(vector, i, right, contador);
            }
        }
    }

    private int encuentraBigoteQuick3(int[] vector, int l, int h) {
        int res = vector[l];
        for (int i = l; i <= h; i++) {
            if (res != vector[i]) {
                res = -1;
                break;
            }
        }

        //Significa que encontró claves diferentes
        if (res == -1) {
            int v1 = vector[l];
            int v2 = vector[h];
            int v3 = vector[l + (h - l) / 2];

            return (v1 + v2 + v3) / 3;
        }

        return 0;

    }
}
