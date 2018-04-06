package de.kumal.curxchger.ModelClasses;

/**
 * Created by Amit on 2018-04-06.
 */

public class Country {
    private String countryname, capital, language, countryAlpha2Code, currencyCode;

    public Country(String countryname, String countryAlpha2Code, String currencyCode) {
        this.countryname = countryname;
        this.countryAlpha2Code = countryAlpha2Code;
        this.currencyCode = currencyCode;
    }

    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountryAlpha2Code() {
        return countryAlpha2Code;
    }

    public void setCountryAlpha2Code(String countryAlpha2Code) {
        this.countryAlpha2Code = countryAlpha2Code;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
}
