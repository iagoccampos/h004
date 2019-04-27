var size = 10000;
var vetor = new Array(size);

for(var i = 0; i < size; i++)
    vetor[i] = i;
shuffle(vetor);

console.time('bubbleSortTimer');
bubbleSort(vetor, size);
console.timeEnd('bubbleSortTimer');

function bubbleSort(vetor, tamanho) {
    var i, j; // contadores
    var trab;
    var troca = true;
    var limite = tamanho - 1;

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

//https://github.com/Daplie/knuth-shuffle
function shuffle(array) {
    var currentIndex = array.length,
        temporaryValue, randomIndex;

    // While there remain elements to shuffle...
    while(0 !== currentIndex) {

        // Pick a remaining element...
        randomIndex = Math.floor(Math.random() * currentIndex);
        currentIndex -= 1;

        // And swap it with the current element.
        temporaryValue = array[currentIndex];
        array[currentIndex] = array[randomIndex];
        array[randomIndex] = temporaryValue;
    }

    return array;
}
