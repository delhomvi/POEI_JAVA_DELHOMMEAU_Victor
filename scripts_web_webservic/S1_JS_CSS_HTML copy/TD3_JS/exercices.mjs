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
    let verifCache=0;
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
    let verifCacheTable=[];
    for(let elem=0;elem<array.length;elem++){
        if(verifcallback(array[elem])==true){
            verifCacheTable.push(array[elem]);
        }
    }
    return verifCacheTable;
}

console.log(filter(liste, positif));




// Exercice 4
class village{
    constructor(nbVillageois,nbBois,nbPierre,nbOr,bat){
        this.villa=nbVillageois;
        this.bois=nbBois;
        this.pierre=nbPierre;
        this.or=nbOr;
        this.bat=bat;
    }
    getAll(){
        console.log('Dans le village il y a '+this.villa+' villageois, les ressources du village sont de'+this.bois+' bois,'+this.pierre+' pierre,'+this.or+' or.\n Ces ressources se divisent parmis les batiments:');
        for(let batindex=0;batindex<this.bat.length;batindex++){
            console.log(this.bat[batindex])
        }
    }
}
let village1 = new village(100,400,400,500000,["HDV"]);
village1.getAll();





// Exercice 5: Heritage
import './Personnages.mjs';

let av = new aventurier("toto",10,5,5,10);
let gu = new guerrier("titi",10,5,5,10);
let pa = new paladin("tutu",10,5,5,10);
let ma = new mage("tata",10,5,5,10);
av.toString();
gu.toString();
pa.toString();
ma.toString();