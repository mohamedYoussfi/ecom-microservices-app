import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  products : any;
  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.http.get("http://localhost:8080/INVENTORY-SERVICE/products?projection=p1")
      .subscribe({
        next : (data)=>{
          this.products=data;
        },
        error : (err)=>{}
      });
  }

}
