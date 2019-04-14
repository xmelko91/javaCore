package travel.cities.domain;


import travel.common.buisness.domain.BaseDomain;

public class City extends BaseDomain {
    private String name;
    private int population;
    private boolean isCapital;
    private Long countryId;


    public City(String name, int population, boolean isCapital) {
        this.name = name;
        this.population = population;
        this.isCapital = isCapital;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public boolean isCapital() {
        return isCapital;
    }

    public void setCapital(boolean capital) {
        isCapital = capital;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public City() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", population=" + population +
                ", isCapital=" + isCapital +
                ", id=" + id +
                '}';
    }
}
