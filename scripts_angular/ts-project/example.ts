// primitives 
const myNum  : number = 1;
const myString  : string = "toto";
const myBool  : boolean = true;

// Complexes: tableaux et objets

const arrayOfString: string[] = ["toto","titi","tata"];
const myObj: {
    nom:string;
    prenom:string;
    classe:string} = 
    {nom:"toto",
    prenom:"durtonc",
    classe:"elem"}
;

// Fonctions
function addOne(num: number):number{
    return num+1;
}
console.log(addOne(myNum));

// type = classe en java
type myType= {
    nom:string;
    prenom:string;
    classe:string};

let typeOne : myType;
let typeTwo : myType;
type Species =  'dog' | 'rabbit';

// interface
interface IPet{
    id: number;
    name: string;
    species: Species;
};

const medor: IPet ={
    id: 1 ,
    name: 'Medor',
    species:'dog',
};

// Classes
class Rabbit implements IPet{
    id: number;
    name : string;
    species : Species;

    constructor(id:number,name:string){
        this.id=id;
        this.name=name;
        this.species='rabbit';
    }
};
const roger: IPet = new Rabbit(1,'Roger');

