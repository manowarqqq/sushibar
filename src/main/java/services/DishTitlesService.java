package services;

import dao.DishTitlesDao;
import models.DishTitles;

public class DishTitlesService {

    private DishTitlesDao dishTitles = new DishTitlesDao();

    public DishTitlesService() {

    }

    public DishTitles findDishTitle(int id) {
        return dishTitles.findById(id);
    }

    public DishTitles findWithMaxId() {
        return dishTitles.findWithMaxId();
    }

}
