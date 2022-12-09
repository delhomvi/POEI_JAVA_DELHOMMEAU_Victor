import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  products: string[] = ['playstation','xbox','pc','switch'];
  selectedProduct: string | null=null;

  constructor() { }

  selectProduct(prod: string): void{
    this.selectedProduct=prod;
  }
}
