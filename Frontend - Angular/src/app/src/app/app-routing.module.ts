import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddTrainingComponent } from './add-training/add-training.component';
import { EditTrainingComponent } from './edit-training/edit-training.component';
import { ViewTrainingComponent } from './view-training/view-training.component';


const routes: Routes = [
  {path:'addtraining',component:AddTrainingComponent},
  {path:'viewtrainings',component:ViewTrainingComponent},
  {path:'edittraining/:id',component:EditTrainingComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
