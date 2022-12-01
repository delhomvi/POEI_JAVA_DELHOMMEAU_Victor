export class perso{
    static nomm="";
    static santee=0;
    static forcee=0;
    constructor(nomm,santee,forcee){
        this.nom=nomm;
        this.sante=santee;
        this.force=forcee;
    }
}
export class aventurier extends perso{
    static exp=0;
    constructor(nomm,santee,forcee,xp){
        super(nomm,santee,forcee);
        this.exp=xp;
    }
    toString(){
        console.log("\n==============\nAventurier\nNom "+this.nom+"\nSanté "+this.sante+"\nForce "+this.force+"\nExp "+this.exp);
    }
}
export class guerrier extends perso{
    static ragee=0;
    constructor(nomm,santee,forcee,rage){
        super(nomm,santee,forcee);
        this.ragee=rage;
    }
    toString(){
        console.log("\n==============\nGuerrier\nNom "+this.nom+"\nSanté "+this.sante+"\nForce "+this.force+"\nRage "+this.rage);
    }
}
export class paladin extends perso{
    static vertuee=0;
    constructor(nomm,santee,forcee,vertue){
        super(nomm,santee,forcee);
        this.vertuee=vertue;
    }
    toString(){
        console.log("\n==============\nPaladin\nNom "+this.nom+"\nSanté "+this.sante+"\nForce "+this.force+"\nExp "+this.vertuee);
    }
}
export class mage extends perso{
    static manaa=0;
    constructor(nomm,santee,forcee,mana){
        super(nomm,santee,forcee);
        this.manaa=mana;
    }
    toString(){
        console.log("\n==============\nMage\nNom "+this.nom+"\nSanté "+this.sante+"\nForce "+this.force+"\nMana "+this.manaa);
    }
}