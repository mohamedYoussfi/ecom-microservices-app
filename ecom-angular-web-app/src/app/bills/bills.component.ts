import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-bills',
  templateUrl: './bills.component.html',
  styleUrls: ['./bills.component.css']
})
export class BillsComponent implements OnInit {
   bills : any;
   customerId!:number;
  constructor(private http:HttpClient, private router : Router, private  route:ActivatedRoute) {
    this.customerId=route.snapshot.params['customerId'];
  }

  ngOnInit(): void {
    this.http.get("http://localhost:8080/BILLING-SERVICE/bills/search/billsByCustomerId?projection=billProj1&id="+this.customerId)
      .subscribe({
        next : (data)=>{
          this.bills=data;
        },
        error : (err)=>{}
      });
  }


  handleBillDetails(id:number) {
    this.router.navigateByUrl('/bill-details/'+id)
  }
}
