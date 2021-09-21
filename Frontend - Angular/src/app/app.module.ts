import { from } from 'rxjs';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { FormsModule, ReactiveFormsModule  } from '@angular/forms';
import { HttpClientModule,HTTP_INTERCEPTORS } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import {MatCardModule} from '@angular/material/card';
import {MatMenuModule} from '@angular/material/menu';
import {MatDividerModule} from '@angular/material/divider';
import {MatToolbarModule} from '@angular/material/toolbar'

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { ProductOrderComponent } from './product-order/product-order.component';


import {WarehouseService} from './services/warehouse.service'
import {DistributorService} from './services/distributor.service'
import {ProductService} from './services/product.service';


import {LoginLogoutService} from './services/login.logout.service'
import { BasicAuthHttpInterceptorService } from './services/basic-auth-http-interceptor.service';

import { RawMaterialOrderService } from './services/raw-material-order.service';
import {SupplierService} from './services/supplier.service';

import { ProductServiceService } from './services/product-service.service';
import { RawMaterialServiceService } from './services/raw-material-service.service';
import {AuthGuard} from './guard/auth.guard'

import { routing } from './app.routing';
import { AppRoutingModule } from './app-routing.module';


import { OrderDetailsComponent } from './order-details/order-details.component';
import { DistributorDetailsComponent } from './distributor-details/distributor-details.component';
import { OrderUpdateComponent } from './order-update/order-update.component';
import { TrackOrdersComponent } from './track-orders/track-orders.component';
import { LogInComponent } from './log-in/log-in.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { AfterSignupComponent } from './after-signup/after-signup.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { RawMaterialOrderComponent } from './raw-material-order/raw-material-order.component';
import {SupplieDetailsComponent} from './supplie-details/supplie-details.component';
import { RmOrderUpdateComponent } from './rm-order-update/rm-order-update.component';
import { RmOrderDetailsComponent } from './rm-order-details/rm-order-details.component';
import { RmTrackOrderComponent } from './rm-track-order/rm-track-order.component';

import { UpRmStockComponent } from './up-rm-stock/up-rm-stock.component';
import { UpPrStockComponent } from './up-pr-stock/up-pr-stock.component';
import { TrackRmComponent } from './track-rm/track-rm.component';
import { TrackPrComponent } from './track-pr/track-pr.component';

import { MatRadioModule } from '@angular/material/radio';
import {FlexLayoutModule} from '@angular/flex-layout';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatCheckboxModule} from '@angular/material/checkbox';
import {MatSelectModule} from '@angular/material/select';




@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    ProductOrderComponent,
    OrderDetailsComponent,
    DistributorDetailsComponent,
    OrderUpdateComponent,
    TrackOrdersComponent,
    
    LogInComponent,
    SignUpComponent,
    AfterSignupComponent,
    ForgotPasswordComponent,
    PageNotFoundComponent,

    RawMaterialOrderComponent,
    SupplieDetailsComponent,
    RmOrderUpdateComponent,
    RmOrderDetailsComponent,
    RmTrackOrderComponent,

    UpRmStockComponent,
    UpPrStockComponent,
    TrackRmComponent,
    TrackPrComponent
  ],
  imports: [
    routing,
    BrowserModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatIconModule,
    MatMenuModule,
    MatCardModule,
    MatDividerModule,
    MatToolbarModule,
    
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,

    BrowserModule,
    AppRoutingModule,
    FlexLayoutModule,
    MatFormFieldModule,
    MatInputModule,
    MatCardModule,
    MatButtonModule,
    MatSelectModule,
    BrowserAnimationsModule,
    FormsModule,
    MatRadioModule,
    MatRadioModule,
    MatCheckboxModule,
    ReactiveFormsModule,
    HttpClientModule
    
    
   
  ],
  schemas: [
    CUSTOM_ELEMENTS_SCHEMA
],
  providers: [
    DistributorService,
    WarehouseService,
    ProductService,
    LoginLogoutService,
    AuthGuard,
    RawMaterialOrderService,
    SupplierService,
    ProductServiceService,
    RawMaterialServiceService,
    {provide: HTTP_INTERCEPTORS, 
      useClass: BasicAuthHttpInterceptorService, 
      multi: true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
