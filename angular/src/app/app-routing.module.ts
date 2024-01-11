import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';

const routes: Routes = [

  {
    path: 'login',
    loadChildren: () =>
      import('./pages/login/login.module').then(
        (module) => module.LoginModule
      ),
  },
  {
    path: 'register',
    loadChildren: () =>
      import('./pages/register/register.module').then(
        (module) => module.RegisterModule
      ),
  },
  {
    path: '',
    redirectTo: '/register',
    pathMatch: 'full',
  },
  {
    path: 'home',
    loadChildren: () =>
      import('./pages/home/home.module').then(
        (module) => module.HomeModule
      ),
  },

  

  {
    path: 'blood',
    loadChildren: () =>
      import('./pages/blood/blood.module').then(
        (module) => module.BloodModule
      ),
  },
  {
    path: 'donation',
    loadChildren: () =>
      import('./pages/donation/donation.module').then(
        (module) => module.DonationModule
      ),
  },
  {
    path: 'FAQ',
    loadChildren: () =>
      import('./pages/questions/questions.module').then(
        (module) => module.QuestionsModule
      ),
  },
  {
    path: 'about-us',
    loadChildren: () =>
      import('./pages/about-us/about-us.module').then(
        (module) => module.AboutUsModule
      ),
  },
  {
    path: 'contribution',
    loadChildren: () =>
      import('./pages/contributions/contributions.module').then(
        (module) => module.ContributionsModule
      ),
  },
  {
    path: 'volunteers-table',
    loadChildren: () =>
      import('./pages/volunteer-table-manage/volunteer-table-manage.module').then(
        (module) => module.VolunteerTableManageModule
      ),
  },
  {
    path: 'items',
    loadChildren: () =>
      import('./pages/items/items.module').then(
        (module) => module.ItemsModule
      ),
  },



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
