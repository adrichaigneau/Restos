import { Component, OnInit } from '@angular/core';
import { RestaurantService } from 'src/app/services/restaurant-service.service';
import { Restaurant } from 'src/app/entites/restaurant';
import { Type } from 'src/app/entites/type';
import { ActivatedRoute } from '@angular/router';
import { TypeService } from 'src/app/services/type-service.service';

@Component({
  selector: 'app-type',
  templateUrl: './type.component.html',
  styleUrls: ['./type.component.scss']
})
export class TypeComponent implements OnInit {
  id: number = 0;
  restaurants: Restaurant[] = [];
  type: Type = {};
  nomType: any;
    constructor(private router: ActivatedRoute, private restaurantService: RestaurantService, private typeService: TypeService) {}

  ngOnInit(): void {
    const idStr= this.router.snapshot.paramMap.get("id");
    this.id = idStr ? +idStr : 0;
    this.typeService.read(this.id)
      .subscribe((data: Type)=> this.type = data);
  }

  suggestion(saisie: string) {
    this.nomType = this.type?.nom;
    this.restaurantService
    .searchType(this.nomType, saisie)
    .subscribe((data: Restaurant[])=>this.restaurants = data );
    }

}
