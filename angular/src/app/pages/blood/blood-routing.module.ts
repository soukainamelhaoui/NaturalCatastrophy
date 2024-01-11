import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BloodComponent } from './blood.component';
import { BloodInstructionComponent } from './blood-instruction/blood-instruction.component';
import { BloodFormComponent } from './blood-form/blood-form.component';

const routes: Routes = [
  {path: '', component:BloodComponent},
  {path: 'instructions', component:BloodInstructionComponent},
  {path: 'form', component:BloodFormComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BloodRoutingModule { }
