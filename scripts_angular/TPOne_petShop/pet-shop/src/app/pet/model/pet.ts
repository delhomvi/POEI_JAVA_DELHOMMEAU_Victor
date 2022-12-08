export type speciesType =  'chien' | 'chat' | 'poisson' | 'lapin' ;

export interface IPet{
    id : number;
    name : string;
    species : speciesType;
    price : number;
    isAvailable : boolean;

}
