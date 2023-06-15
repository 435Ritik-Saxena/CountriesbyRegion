package com.techlabs.Region;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountryService {
	private List<Region> regions;
    private List<Country> countries;
    public CountryService() {
    	regions = new ArrayList<>();
        regions.add(new Region(1, "Europe"));
        regions.add(new Region(2, "Americas"));
        regions.add(new Region(3, "Asia"));
        regions.add(new Region(4, "Middle East and Africa"));
         countries = new ArrayList<>();
        countries.add(new Country("IT", "Italy", regions.get(0)));
        countries.add(new Country("JP", "Japan", regions.get(2)));
        countries.add(new Country("US", "United States of America", regions.get(1)));
        countries.add(new Country("CA", "Canada", regions.get(1)));
        countries.add(new Country("CN", "China", regions.get(2)));
        countries.add(new Country("IN", "India", regions.get(2)));
        countries.add(new Country("AU", "Australia", regions.get(2)));
        countries.add(new Country("ZW", "Zimbabwe", regions.get(3)));
        countries.add(new Country("SG", "Singapore", regions.get(2)));
        countries.add(new Country("UK", "United Kingdom", regions.get(0)));
        countries.add(new Country("FR", "France", regions.get(0)));
        countries.add(new Country("DE", "Germany", regions.get(0)));
        countries.add(new Country("ZM", "Zambia", regions.get(3)));
        countries.add(new Country("EG", "Egypt", regions.get(3)));
        countries.add(new Country("BR", "Brazil", regions.get(1)));
        countries.add(new Country("CH", "Switzerland", regions.get(0)));
        countries.add(new Country("NL", "Netherlands", regions.get(0)));
        countries.add(new Country("MX", "Mexico", regions.get(1)));
        countries.add(new Country("KW", "Kuwait", regions.get(3)));
        countries.add(new Country("IL", "Israel", regions.get(3)));
        countries.add(new Country("DK", "Denmark", regions.get(0)));
        countries.add(new Country("HK", "HongKong", regions.get(2)));
        countries.add(new Country("NG", "Nigeria", regions.get(3)));
        countries.add(new Country("AR", "Argentina", regions.get(1)));
        countries.add(new Country("BE", "Belgium", regions.get(0)));
    }
    public void printCountriesRegionWise() {
        Map<Region, List<Country>> countriesByRegion = groupCountriesByRegion();
        for (Map.Entry<Region, List<Country>> entry : countriesByRegion.entrySet()) {
            Region region = entry.getKey();
            List<Country> regionCountries = entry.getValue();
            System.out.println("Region: " + region.getName());
            for (Country country : regionCountries) {
                System.out.println("Country: "+country.getFullName());
            }
            System.out.println();
        }
    }
    private Map<Region, List<Country>> groupCountriesByRegion() {
        Map<Region, List<Country>> countriesByRegion = new HashMap<>();
        for (Country country : countries) {
            Region region = country.getRegion();
            List<Country> regionCountries = countriesByRegion.getOrDefault(region, new ArrayList<>());
            regionCountries.add(country);
            countriesByRegion.put(region, regionCountries);
        }
        return countriesByRegion;
    }
    public int countCountriesInRegion(int regionId) {
        Region region = getRegionById(regionId);
        if (region == null) {
            return 0;
        }

        int count = 0;
        for (Country country : countries) {
            if (country.getRegion().equals(region)) {
                count++;
            }
        }
        return count;
    }
    private Region getRegionById(int regionId) {
        for (Region region : regions) {
            if (region.getId() == regionId) {
                return region;
            }
        }
        return null;
    }
    // Printing all countries of a region
    public void printCountriesByRegion(int regionId) {
        Region region = getRegionById(regionId);
        if (region == null) {
            System.out.println("Invalid region ID.");
            return;
        }

        System.out.println("Countries belonging to region " + region.getId()+" (" + region.getName() + "):");
        for (Country country : countries) {
            if (country.getRegion().equals(region)) {
                System.out.println("Country: " + country.getFullName());
            }
        }
    }
    

}
