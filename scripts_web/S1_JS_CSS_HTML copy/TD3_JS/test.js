// Bases
let a=5;
function multiplier(){
    let b=6;
    return a*b;
}

console.log(multiplier()); // execute la fonction

function aff(){
    var c=5;
    let d=9;
}
console.log(c); // Visible car défini comme une var
console.log(d); // Invisible car défini dans un bloc




// Arguments
function add(e,f){
    return e+f;
}
console.log(add(9,10));




// Appeler une fonction dans une autre
function mult(add,g,h){
    return add(g,h)*2;
}




// Fonction flechée
let x = (a,b) => a*b;
console.log(x(4,8));


// Les listes

function affNoms(noms){
    for(let i=0; i<noms.length; i++){
        console.log(noms[i]);
    }
}
var liste_Nom=["bob","marley","dylan"];
affNoms(liste_Nom);


// Exercice 1
function hello(){
    console.log("Hello");
}
function helloByTime(timeSec){
    setTimeout(hello, timeSec*1000);
}
let time=10;//sec
helloByTime(time);

// Exercice 2
function aumoins3(array, verifcallback) {
    verifCache=0;
    for(let elem=0;elem<array.length;elem++){
        if(verifcallback(array[elem])==true){
            verifCache+=1;
        }
    }
    if(verifCache>=3){
        return "Verifié";
    }
    else{
        return "Non verifié";
    }
}

function positif(elem){
    if(elem>=0){return true;}
}

let liste=[0,-1,-2,10,15];
console.log(aumoins3(liste, positif));

// Exercice 3
function filter(array, verifcallback) {
    verifCacheTable=[];
    for(let elem=0;elem<array.length;elem++){
        if(verifcallback(array[elem])==true){
            verifCacheTable.push(array[elem]);
        }
    }
    return verifCacheTable;
}

console.log(filter(liste, positif));


// Exo4 villag
