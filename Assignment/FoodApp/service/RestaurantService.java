package Assignment.FoodApp.service;


import Assignment.FoodApp.RestaurantApp.*;
import Assignment.FoodApp.Exception.*;

import java.util.ArrayList;
import java.util.List;

public class RestaurantService {

    private List<Restaurant> restaurants = new ArrayList<>();

    // Add restaurant
    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
    }

    // Get all restaurants
    public List<Restaurant> getAllRestaurants() {
        return restaurants;
    }

    // Get restaurant by id
    public Restaurant getRestaurantById(int id) {
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getId() == id) {
                return restaurant;
            }
        }
        throw new RestaurantNotFoundException(
                "Restaurant with id " + id + " not found"
        );
    }
    public void listRestaruant(){
        for(Restaurant res:restaurants){
            System.out.println(res);
        }
    }
}

