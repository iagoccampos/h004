//https://www.ibm.com/developerworks/community/blogs/hazem/entry/javascript_getting_all_possible_permutations?lang=en
var Util = {};

Util.getPermuts = function(array, start, output) {
    if(start >= array.length) {
        var arr = array.slice(0); //clone the array		
        output.push(arr);
    }
    else {
        var i;

        for(i = start; i < array.length; ++i) {
            Util.swap(array, start, i);
            Util.getPermuts(array, start + 1, output);
            Util.swap(array, start, i);
        }
    }
};

Util.getAllPossiblePermuts = function(array, output) {
    Util.getPermuts(array, 0, output);
};

Util.swap = function(array, from, to) {
    var tmp = array[from];
    array[from] = array[to];
    array[to] = tmp;
};

//setup
const bagCap = 100;
const itensCount = 5;
const maxItemWeight = 40;
const maxItemValue = 50;

var itens = new Array(itensCount);
var ids = new Array(itensCount);
var permutations = [];
var bestResult = 0;

for(var i = 0; i < itensCount; i++) {
    itens[i] = {};
    itens[i].value = Math.round(Math.random() * maxItemValue);
    itens[i].weight = Math.round(Math.random() * maxItemWeight);
    ids[i] = i;
}

//console.log(ids);
Util.getAllPossiblePermuts(ids, permutations);
//console.log(permutations);

console.time('mochilaTimer');
for(i = 0; i < permutations.length; i++) {
    let currentCap = 0;
    let totalVal = 0;

    for(var j = 0; j < itensCount; j++) {
        if(currentCap + itens[permutations[i][j]].weight <= bagCap) {
            currentCap += itens[permutations[i][j]].weight;
            totalVal += itens[permutations[i][j]].value;
        }
    }

    if(totalVal > bestResult)
        bestResult = totalVal;
}
console.timeEnd('mochilaTimer');

//console.log(bestResult);
