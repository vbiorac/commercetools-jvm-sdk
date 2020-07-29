package io.sphere.sdk.carts;

import com.fasterxml.jackson.annotation.JsonCreator;
import io.sphere.sdk.models.Base;

class CartsConfigurationImpl extends Base implements CartsConfiguration {
    
    private Integer deleteDaysAfterLastModification;
    private Boolean countryTaxRateFallbackEnabled;

    @JsonCreator
    public CartsConfigurationImpl(Integer deleteDaysAfterLastModification) {
        this.deleteDaysAfterLastModification = deleteDaysAfterLastModification;
    }

    @JsonCreator
    public CartsConfigurationImpl(Boolean countryTaxRateFallbackEnabled) {
        this.countryTaxRateFallbackEnabled = countryTaxRateFallbackEnabled;
    }

    @JsonCreator
    public CartsConfigurationImpl(Integer deleteDaysAfterLastModification, Boolean countryTaxRateFallbackEnabled) {
        this.deleteDaysAfterLastModification = deleteDaysAfterLastModification;
        this.countryTaxRateFallbackEnabled = countryTaxRateFallbackEnabled;
    }

    @Override
    public Integer getDeleteDaysAfterLastModification() {
        return this.deleteDaysAfterLastModification;
    }
    
    static CartsConfiguration of(final Integer deleteDaysAfterLastModification) {
        return new CartsConfigurationImpl(deleteDaysAfterLastModification);
    }
    @Override
    public Boolean getCountryTaxRateFallbackEnabled() {
        return this.countryTaxRateFallbackEnabled;
    }

    static CartsConfiguration of(final Boolean countryTaxRateFallbackEnabled) {
        return new CartsConfigurationImpl(countryTaxRateFallbackEnabled);
    }

    static CartsConfiguration of(final Integer deleteDaysAfterLastModification, final Boolean countryTaxRateFallbackEnabled) {
        return new CartsConfigurationImpl(deleteDaysAfterLastModification, countryTaxRateFallbackEnabled);
    }
}
