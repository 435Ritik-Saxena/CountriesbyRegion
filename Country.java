package com.techlabs.Region;

public class Country {
	private String shortName;
    private String fullName;
    private Region region;

    public Country(String shortName, String fullName, Region region) {
        this.shortName = shortName;
        this.fullName = fullName;
        this.region = region;
    }

    public String getShortName() {
        return shortName;
    }
    public String getFullName() {
        return fullName;
    }

    public Region getRegion() {
        return region;
    }


}
