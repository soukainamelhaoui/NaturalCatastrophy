import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { VolunteerTableManageComponent } from './volunteer-table-manage.component';
import { VolunteerFormComponent } from './volunteer-form/volunteer-form.component';

const routes: Routes = [
  {path: '', component:VolunteerTableManageComponent},
  {path: 'form', component:VolunteerFormComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class VolunteerTableManageRoutingModule { }
