import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RestaurantComponent } from './pages/restaurant/restaurant.component'
import { HomeComponent } from './pages/home/home.component';
import { TypeComponent } from './pages/type/type.component';

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
    path:'',
    redirectTo:'/accueil',
    pathMatch: 'full'
  }

]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
