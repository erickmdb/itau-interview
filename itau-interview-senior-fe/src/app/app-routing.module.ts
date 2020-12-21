import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { CreateComponent } from './employee/components/create/create.component';
import { DetailComponent } from './employee/components/detail/detail.component';
import { ListComponent } from './employee/components/list/list.component';
import { UpdateComponent } from './employee/components/update/update.component';


const routes: Routes = [
  { path: '', redirectTo: 'employees', pathMatch: 'full' },
  { path: 'employees', component: ListComponent },
  { path: 'create-employee', component: CreateComponent },
  { path: 'update-employee/:id', component: UpdateComponent },
  { path: 'employee-details/:id', component: DetailComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
