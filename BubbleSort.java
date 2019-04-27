package bubblesort;

public class BubbleSort {
    public static void main(String[] args) {
	int size = 10;
	int[] vetor = new int[size];

	for(int i = 0; i < size; i++) {
	    vetor[i] = i;
	}
	shuffle(vetor);

	long startTime = System.nanoTime();
	bubbleSort(vetor, size);
	long endTime = System.nanoTime();

	System.out.println("bubbleSortTimer: " + (endTime - startTime) / 1_000_000 + "ms");
    }

    static void bubbleSort(int vetor[], int tamanho) {
	int i; // contadores
	int j = 0;
	int trab;
	boolean troca = true;
	int limite = tamanho - 1;

	while(troca) {
	    troca = false;
	    for(i = 0; i < limite; i++) {
		if(vetor[i] > vetor[i + 1]) {
		    trab = vetor[i];
		    vetor[i] = vetor[i + 1];
		    vetor[i + 1] = trab;
		    j = i;
		    troca = true;
		}
	    }
	    limite = j;
	}
    }

    static int[] shuffle(int[] array) {
	int currentIndex = array.length, temporaryValue, randomIndex;

	while(0 != currentIndex) {
	    randomIndex = (int) Math.floor(Math.random() * currentIndex);
	    currentIndex -= 1;

	    temporaryValue = array[currentIndex];
	    array[currentIndex] = array[randomIndex];
	    array[randomIndex] = temporaryValue;
	}

	return array;
    }
}
