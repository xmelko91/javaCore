package travel.countries.repo;

import travel.common.solutions.repo.BaseRepo;
import travel.countries.domain.BaseCountry;
import travel.countries.search.CountrySearchCondition;

import java.util.List;

public interface CountryRepo extends BaseRepo<BaseCountry, Long> {


    List<BaseCountry> search(CountrySearchCondition searchCondition);

}
