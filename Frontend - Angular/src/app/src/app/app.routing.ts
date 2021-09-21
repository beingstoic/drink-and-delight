import { RouterModule,Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ProductOrderComponent } from './product-order/product-order.component';
import {DistributorDetailsComponent} from './distributor-details/distributor-details.component'
import {OrderDetailsComponent} from './order-details/order-details.component';
import {OrderUpdateComponent} from './order-update/order-update.component';
import {TrackOrdersComponent} from './track-orders/track-orders.component'
import { LogInComponent } from './log-in/log-in.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { AuthGuard } from './guard/auth.guard';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { AfterSignupComponent } from './after-signup/after-signup.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { RawMaterialOrderComponent } from './raw-material-order/raw-material-order.component';
import { RmOrderUpdateComponent } from './rm-order-update/rm-order-update.component';
import { SupplieDetailsComponent } from './supplie-details/supplie-details.component';
import { RmTrackOrderComponent } from './rm-track-order/rm-track-order.component';
import { RmOrderDetailsComponent } from './rm-order-details/rm-order-details.component';
import { UpRmStockComponent } from './up-rm-stock/up-rm-stock.component';
import { UpPrStockComponent } from './up-pr-stock/up-pr-stock.component';
import { TrackRmComponent } from './track-rm/track-rm.component';
import { TrackPrComponent } from './track-pr/track-pr.component';
const routes:Routes=[
   
    
//authentication routes
  {path:'', redirectTo:'/login', pathMatch:'full'},
  {path:'login',component:LogInComponent},
  {path:'sign-up',component:SignUpComponent},
  {path:'home',component:HomeComponent,canActivate: [AuthGuard]},
  {path:'forgot-password',component:ForgotPasswordComponent},
  {path:'after-signup', component:AfterSignupComponent,canActivate: [AuthGuard]},
  //
  //product order routes
  {path:'Porder' ,component:ProductOrderComponent,canActivate: [AuthGuard]},
  {path:'dist',component:DistributorDetailsComponent,canActivate: [AuthGuard]},
  {path:'Odetail',component:OrderDetailsComponent,canActivate: [AuthGuard]},
  {path:'Oupdate',component:OrderUpdateComponent,canActivate: [AuthGuard]},
  {path:'Torder',component:TrackOrdersComponent,canActivate: [AuthGuard]},
    
 
    {path:'rOrder' ,component:RawMaterialOrderComponent},
    {path:'rmupdate',component:RmOrderUpdateComponent},
    {path:'sup',component:SupplieDetailsComponent},
    {path:'rmtrack',component:RmTrackOrderComponent},
    {path:'rmdetails',component:RmOrderDetailsComponent},
  

    {path:'updateRM', component:UpRmStockComponent},
  {path:'updatePr', component:UpPrStockComponent},
  {path:'trackRmD', component:TrackRmComponent},
  {path:'trackPrD', component:TrackPrComponent},

  { path: '**', component: PageNotFoundComponent },
];
export const routing =RouterModule.forRoot(routes);