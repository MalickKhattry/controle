import {APP_INITIALIZER, NgModule, OnInit} from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProductsComponent } from './products/products.component';
import {HttpClientModule} from "@angular/common/http";
import { CustomersComponent } from './customers/customers.component';
import { BillsComponent } from './bills/bills.component';
import { BillDetailsComponent } from './bill-details/bill-details.component';
import {KeycloakAngularModule, KeycloakService} from "keycloak-angular";
export function kcFactory(kcService:KeycloakService){
  return()=>{
    kcService.init({
       config:{
         realm:"bill-realm",
         clientId:"bill-client",
         url:"http://localhost:8080"
       },
      initOptions:{
         onLoad:'check-sso',
        checkLoginIframe:true

      }
    })
  }
}

@NgModule({
  declarations: [
    AppComponent,
    ProductsComponent,
    CustomersComponent,
    BillsComponent,
    BillDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    KeycloakAngularModule
  ],
  providers: [{provide:APP_INITIALIZER,deps:[KeycloakService],useFactory:kcFactory,multi:true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
