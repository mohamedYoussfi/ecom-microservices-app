import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {FormBuilder, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  products : any;
  productFormGroup! : FormGroup;
  searchProductsForm! : FormGroup;
  constructor(private http: HttpClient, private fb: FormBuilder) { }

  ngOnInit(): void {
    this.productFormGroup=this.fb.group({
      "name" : this.fb.control(''),
      "price":this.fb.control(0),
      "quantity":this.fb.control(0)
    });
    this.searchProductsForm=this.fb.group({
      keyword : this.fb.control('')
    });
    this.http.get("http://localhost:8080/INVENTORY-SERVICE/products?projection=p1")
      .subscribe({
        next : (data)=>{
          this.products=data;
        },
        error : (err)=>{}
      });
  }

  addProduct() {
    this.http.post("http://localhost:8080/INVENTORY-SERVICE/products",this.productFormGroup.value)
      .subscribe({
        next : value => {
          this.products._embedded.products.push(value);
          this.productFormGroup.reset();
        },
        error : err => {
          console.log(err);
        }
      })
  }

  searchProducts() {
    let kc=this.searchProductsForm.value['keyword'];
    this.http.get("http://localhost:8080/INVENTORY-SERVICE/products/search/byName?keyword="+kc)
      .subscribe({
        next : value => {
          this.products=value;
        },
        error : err => {
          console.log(err);
        }
      })
  }
}
