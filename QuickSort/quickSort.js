var size = 10000;
var vetor = new Array(size);

for(var i = 0; i < size; i++)
    vetor[i] = i;
shuffle(vetor);

console.time('quickSortTimer');
quickSort(vetor, size);
console.timeEnd('quickSortTimer');

function quickSort(vetor, tamanho, i, j) {
    var trab, esq, dir, pivo; //
    esq = i;
    dir = j;
    pivo = vetor[Math.round((esq + dir) / 2.0)];

    do {
        while(vetor[esq] < pivo)
            esq++;
        while(vetor[dir] > pivo)
            dir--;
        if(esq <= dir) {
            trab = vetor[esq];
            vetor[esq] = vetor[dir];
            vetor[dir] = trab;
            esq++;
            dir--;
        }
    } while (esq <= dir);

    if(dir - i >= 0)
        quickSort(vetor, tamanho, i, dir);
    if(j - esq >= 0)
        quickSort(vetor, tamanho, esq, j);
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
