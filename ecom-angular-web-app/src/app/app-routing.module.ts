import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {CustomersComponent} from "./customers/customers.component";
import {BillsComponent} from "./bills/bills.component";
import {BillDetailsComponent} from "./bill-details/bill-details.component";
import {ProductsComponent} from "./products/products.component";

const routes: Routes = [
  {
    path : "customers", component : CustomersComponent
  },
  {
    path : "bills/:customerId", component : BillsComponent
  },
  {
    path : "bill-details/:id", component : BillDetailsComponent
  },
  {
    path : "products", component : ProductsComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
