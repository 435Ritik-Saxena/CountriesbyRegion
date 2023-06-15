package com.techlabs.Region;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountryService countryService = new CountryService();
        countryService.printCountriesRegionWise();
        Scanner scanner= new Scanner(System.in);
        System.out.print("Enter id of region in which you want to count countries:");
        int regionId = scanner.nextInt();
        int countryCount = countryService.countCountriesInRegion(regionId);
        System.out.println("Number of countries in region " +regionId + ": "+countryCount);
        System.out.print("Enter id of region of which you want to see countries:");
        int selectedRegionId = scanner.nextInt();
        countryService.printCountriesByRegion(selectedRegionId);

	}

}
