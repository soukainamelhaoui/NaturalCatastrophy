import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DonationComponent } from './donation.component';
import { DonationFormComponent } from './donation-form/donation-form.component';
import { MoneyFormComponent } from './money-form/money-form.component';
const routes: Routes = [
  {
    path: '',
    component: DonationComponent,
  },
  {
    path: 'all-form',
    component: DonationFormComponent,
  },
  {
    path: 'money-form',
    component: MoneyFormComponent,
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DonationRoutingModule { }
