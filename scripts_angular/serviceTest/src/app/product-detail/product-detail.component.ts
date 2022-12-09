import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.scss']
})
export class ProductDetailComponent implements OnInit{
  get product(){
    return this.prodService.selectedProduct
  }

  constructor(private prodService: ProductService){}

  ngOnInit(): void {
  }
}
