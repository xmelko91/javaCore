package travel.cities.repo;

import travel.cities.domain.City;
import travel.cities.search.CitySearchCondition;
import travel.common.solutions.repo.BaseRepo;

import java.util.List;

public interface CityRepo extends BaseRepo<City, Long> {
    List<City> search(CitySearchCondition searchCondition);

}
