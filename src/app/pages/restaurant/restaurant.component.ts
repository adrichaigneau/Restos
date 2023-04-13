import { Component, OnInit } from '@angular/core';
import { RestaurantService } from 'src/app/services/restaurant-service.service';
import { Restaurant } from 'src/app/entites/restaurant';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-evenement',
  templateUrl: './restaurant.component.html',
  styleUrls: ['./restaurant.component.scss']
})
export class RestaurantComponent implements OnInit {

  id: number = 0;
  restaurant: Restaurant = {};
    constructor(private router: ActivatedRoute, private restaurantService: RestaurantService) {}
    
    ngOnInit(): void {
      const idStr= this.router.snapshot.paramMap.get("id");
      this.id = idStr ? +idStr : 0;
      this.restaurantService
        .read(this.id)
        .subscribe((data: Restaurant)=> this.restaurant = data)
    }
}
