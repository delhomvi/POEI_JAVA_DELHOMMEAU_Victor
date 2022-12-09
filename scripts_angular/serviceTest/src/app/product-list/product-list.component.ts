import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.scss']
})
export class ProductListComponent implements OnInit{
  get productList(){
    return this.prodService.products;
  }

  constructor(private prodService: ProductService){}

  ngOnInit(): void {}

  onSelectProduct(prod: string){
    this.prodService.selectProduct(prod);
  }
}
