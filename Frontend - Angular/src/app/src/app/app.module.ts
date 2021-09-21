import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { ReactiveFormsModule } from '@angular/forms';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from  './material/material.module';

import { AddTrainingComponent } from './add-training/add-training.component';
import { EditTrainingComponent } from './edit-training/edit-training.component';
import { ViewTrainingComponent } from './view-training/view-training.component';
import { CoOrdinatorComponent } from './co-ordinator/co-ordinator.component';
import { HttpErrorInterceptor } from './http-error.interceptor';

@NgModule({
  declarations: [
    AppComponent,
    AddTrainingComponent,
    EditTrainingComponent,
    ViewTrainingComponent,
    CoOrdinatorComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    {

      provide: HTTP_INTERCEPTORS,
 
      useClass: HttpErrorInterceptor,
 
      multi: true
 
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
