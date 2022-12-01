class Personnage{
    nom='';
    health=0;
    strength=0;
    endurence=0;
    opponent=null;
    attaques= new Map();
    constructor(n,hp,str,end){
        this.nom=n;
        this.health=hp;
        this.strength=str;
        this.endurence=end;
    }
    // Getters
    getNom(){
        return this.nom;
    }
    getHP(){
        return this.health;
    }
    getStr(){
        return this.strength;
    }
    getEnd(){
        return this.endurence;
    }
    getAtks(){
        return this.attaques;
    }
    // Setters
    setNom(n){
        this.nom=n;
    }
    setHP(h){
        this.health=h;
    }
    setStr(s){
        this.strength=s;
    }
    setEnd(e){
        this.endurence=e;
    }
    // Autres fonctions
    subirDommage(lostHP){
        this.health-=lostHP;
    }
    attaquer(target){
        target.subirDommage(this.strength);
        this.endurence-=2;
    }
    annonce(){
        console.log(`Je suis ${this.nom}, mes statistiques sont les suivantes\n--------\nHP ${this.health}\nSTR ${this.strength}\nEND ${this.endurence}\n--------\n`);
    }
    addAtks(name,value){
        this.attaques.set(name,value);
    }
    seeAtks(){
        for (var [key, value] of this.attaques) {
            console.log(`Attaque:  ${key}  Puissance: ${value}`);
        }
    }
    jouerTour(choix){
        return this.attaques.get(choix);
    }
}

class Spell{
    constructor(nom,damage,staminacost,callback){
        this.nom=nom;
        this.damage=damage;
        this.staminacost=staminacost;
        this.callback=callback;

    }

    cast(caster,target){
        caster.setEnd(caster.getEnd()-this.staminacost);
        target.subirDommage(this.damage);
        console.log(`\n--------------\n${caster.getNom()} attaque ${target.getNom()}:  ${this.nom} \nPuissance: ${this.damage}\nEndurence consommée: ${this.staminacost}\n--------------\n`);
        setTimeout(() => {  this.callback(p1,p2); }, 5000);
    }

}

var p1 = new Personnage("toto",10,10,10);
var p2 = new Personnage("tata",10,10,10);

p1.addAtks("Deferlement",10);
p1.addAtks("Melee",5);
p1.addAtks("GangnamStyle",0);

p2.addAtks("Deferlement",10);
p2.addAtks("Melee",5);
p2.addAtks("GangnamStyle",0);


function retourSpell(caster,target){
    console.log("Orararararararararara");
    console.log(`\n--------------\nBilan de l'attaque\n${caster.getNom()} \nHP: ${caster.getHP()}\nEnd: ${caster.getEnd()}\n\n${target.getNom()}\nHP: ${target.getHP()}\nEnd: ${target.getEnd()}\n--------------\n`);
}
var s1 = new Spell("Furie","10","5",retourSpell);
s1.cast(p1,p2);