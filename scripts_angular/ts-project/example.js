// primitives 
var myNum = 1;
var myString = "toto";
var myBool = true;
// Complexes: tableaux et objets
var arrayOfString = ["toto", "titi", "tata"];
var myObj = { nom: "toto",
    prenom: "durtonc",
    classe: "elem" };
// Fonctions
function addOne(num) {
    return num + 1;
}
console.log(addOne(myNum));
var typeOne;
var typeTwo;
;
var medor = {
    id: 1,
    name: 'Medor',
    species: 'dog'
};
// Classes
var Rabbit = /** @class */ (function () {
    function Rabbit(id, name) {
        this.id = id;
        this.name = name;
        this.species = 'rabbit';
    }
    return Rabbit;
}());
;
var roger = new Rabbit(1, 'Roger');
