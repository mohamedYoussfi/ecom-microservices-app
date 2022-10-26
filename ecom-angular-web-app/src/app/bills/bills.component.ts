import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-bills',
  templateUrl: './bills.component.html',
  styleUrls: ['./bills.component.css']
})
export class BillsComponent implements OnInit {
   bills : any;
  constructor(private http:HttpClient, private router : Router) { }

  ngOnInit(): void {
    this.http.get("http://localhost:8080/BILLING-SERVICE/bills?projection=billProj1")
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
