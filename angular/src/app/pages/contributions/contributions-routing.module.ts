import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateContributionComponent } from './create-contribution/create-contribution.component';
import { ContributionsComponent } from './contributions.component';

const routes: Routes = [
  { path: '', component:ContributionsComponent},
 { path: 'save', component:CreateContributionComponent}

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ContributionsRoutingModule { }
