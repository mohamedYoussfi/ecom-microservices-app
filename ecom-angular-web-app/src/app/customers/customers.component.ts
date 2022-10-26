import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.css']
})
export class CustomersComponent implements OnInit {
  customers : any;
  constructor(private http: HttpClient, private router: Router) { }

  ngOnInit(): void {
    this.http.get("http://localhost:8080/CUSTOMER-SERVICE/customers?projection=customerProj1")
      .subscribe({
        next : (data)=>{
          this.customers=data;
        },
        error : (err)=>{}
      });
  }

  handleGetBills(id:number) {
    this.router.navigateByUrl("/bills/"+id);
  }
}
