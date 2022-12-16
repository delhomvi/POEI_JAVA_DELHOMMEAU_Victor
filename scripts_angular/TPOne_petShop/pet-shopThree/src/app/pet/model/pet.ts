export type Species = 'chien' | 'chat' | 'poisson' | 'lapin';

export interface IPet {
  id: string;
  name: string;
  species: Species;
  price: number;
  isAvailable: boolean;
  imageUrl?: string;
}
