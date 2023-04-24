import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RestaurantComponent } from './pages/restaurant/restaurant.component'
import { HomeComponent } from './pages/home/home.component';
import { TypeComponent } from './pages/type/type.component';
import { RestaurantEditComponent } from './pages/restaurant-edit/restaurant-edit.component';
import { TypeEditComponent } from './pages/type-edit/type-edit.component';
import { ArrondissementComponent } from './pages/arrondissement/arrondissement.component';

const routes: Routes = [
  {
    path: 'accueil',
    component: HomeComponent
  },

  {
    path: 'restaurant/:id',
    component: RestaurantComponent
  },

  {
    path: 'type/:id',
    component: TypeComponent
  },

  {
    path: 'arrondissement/:id',
    component: ArrondissementComponent
  },

  {
    path:'',
    redirectTo:'/accueil',
    pathMatch: 'full'
  },

  {
    path: 'editresto',
    component: RestaurantEditComponent
  },

  {
    path: 'edittype',
    component: TypeEditComponent
  }

]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
