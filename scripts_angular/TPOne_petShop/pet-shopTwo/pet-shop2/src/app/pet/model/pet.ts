export type Species = 'chien' | 'chat' | 'poisson' | 'lapin' | 'cochon_d_inde';

export interface IPet {
  id: number;
  name: string;
  species: Species;
  price: number;
  isAvailable: boolean;
  imageUrl?: string;
}
