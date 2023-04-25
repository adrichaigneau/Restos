import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { HeaderComponent } from './components/header/header.component';
import { HomeComponent } from './pages/home/home.component';
import { RestaurantComponent } from './pages/restaurant/restaurant.component';
import { FooterComponent } from './components/footer/footer.component';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { TypeComponent } from './pages/type/type.component';
import { GoogleMapsModule } from '@angular/google-maps'
import { DomSanitizer } from '@angular/platform-browser';
import { RestaurantEditComponent } from './pages/restaurant-edit/restaurant-edit.component';
import { TypeEditComponent } from './pages/type-edit/type-edit.component';
import { ArrondissementComponent } from './pages/arrondissement/arrondissement.component';
import { LeafletModule } from '@asymmetrik/ngx-leaflet';
import { CarteComponent } from './pages/carte/carte.component';
import { TypesComponent } from './pages/types/types.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    FooterComponent,
    RestaurantComponent,
    TypeComponent,
    AppComponent,
    RestaurantEditComponent,
    TypeEditComponent,
    ArrondissementComponent,
    CarteComponent,
    TypesComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    RouterModule,
    CommonModule,
    LeafletModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
