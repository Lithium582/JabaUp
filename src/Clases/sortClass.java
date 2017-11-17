/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Alf
 */
public class sortClass {

    private int[] vectorIncremento;

    public sortClass() {
        this.vectorIncremento = new int[]{127, 17, 5, 1};
    }

    public int[] insercionDirecta(int[] vector) {
        int[] copia = vector.clone();
        for (int i = 1; i < copia.length; i++) {
            int aux = copia[i];
            int j = i - 1;
            while (j >= 0 && aux < copia[j]) {
                copia[j + 1] = copia[j];
                j--;
            }
            copia[j + 1] = aux;
        }
        return copia;
    }

    public int[] shellSort(int[] vector) {
        int[] copia = vector.clone();
        int indice = this.calcularVectorIncremento(copia.length);
        while (indice < this.vectorIncremento.length) {
            int incremento = this.vectorIncremento[indice];
            for (int i = incremento; i < copia.length; i++) {
                int aux = copia[i];
                int j = i - incremento;
                while (j >= 0 && aux < copia[j]) {
                    copia[j + incremento] = copia[j];
                    j -= incremento;
                }
                copia[j + incremento] = aux;
            }
            indice++;
        }
        return copia;
    }

    private int calcularVectorIncremento(int valor) {
        for (int i = this.vectorIncremento.length - 1; i >= 0; i--) {
            if (this.vectorIncremento[i] < valor) {
                return i;
            }
        }
        return -1;
    }

    public int[] bubbleSort(int[] vector) {
        int[] copia = vector.clone();
        for (int i = 0; i < copia.length - 1; i++) {
            for (int j = 0; j < copia.length - i - 1; j++) {
                if (copia[j] > copia[j + 1]) {
                    int aux = copia[j];
                    copia[j] = copia[j + 1];
                    copia[j + 1] = aux;
                }
            }
        }
        return copia;
    }

    public int[] quickSort2(int[] vector) {
        return this.quickSort2(vector, 0, vector.length - 1);
    }

    public int[] quickSort2(int[] vector, int l, int h) {
        int[] copia = vector.clone();
        int p;
        int left = l;
        int right = h;
        if (right > l) {
            p = encuentraBigote(copia, l, h);

            if (p != 0) {
                while (right > left) {
                    while (copia[left] < p) {
                        left++;
                    }

                    while (copia[right] > p) {
                        right--;
                    }

                    int aux = copia[left];
                    copia[left] = copia[right];
                    copia[right] = aux;
                }

                quickSort2(copia, l, right - 1);
                quickSort2(copia, right, h);
            }
        }
        return copia;
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
            if (vector[l] >= vector[h]) {
                return vector[l];
            }
            return vector[h];
        }
        return 0;
    }

    public int[] quickSort(int[] vector) {
        return this.quickSort(vector, 0, vector.length - 1);
    }

    public int[] quickSort(int[] vector, int l, int h) {
        int p;
        int[] copia = vector.clone();
        if (h > l) {
            p = particionar(copia, l, h);
            quickSort(copia, l, p - 1);
            quickSort(copia, p + 1, h);
        }
        return copia;
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

    public int[] seleccionDirecta(int[] vector) {
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

    public String strArray(int[] vector) {
        String strRetorno = "";
        if (vector.length > 0) {
            strRetorno = String.valueOf(vector[0]);
            for (int i = 1; i < vector.length; i++) {
                strRetorno += "," + String.valueOf(vector[i]);
            }
        }
        return strRetorno;
    }

    public int[] heapSort(int[] vector) {
        int[] copia = vector.clone();
        for (int i = copia.length / 2 - 1; i >= 0; i--) {
            heapificar(copia, copia.length, i);
        }
        for (int i = copia.length - 1; i >= 0; i--) {
            int aux = copia[0];
            copia[0] = copia[i];
            copia[i] = aux;
            heapificar(copia, i, 0);
        }
        return copia;
    }

    private void heapificar(int arr[], int n, int i) {
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
            heapificar(arr, n, maximo);
        }
    }
}