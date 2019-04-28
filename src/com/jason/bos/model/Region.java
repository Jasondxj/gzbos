package com.jason.bos.model;

import java.util.Objects;

public class Region {
    private String id;
    private String province;
    private String city;
    private String district;
    private String postcode;
    private String shortcode;
    private String citycode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getShortcode() {
        return shortcode;
    }

    public void setShortcode(String shortcode) {
        this.shortcode = shortcode;
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Region region = (Region) o;
        return Objects.equals(id, region.id) &&
                Objects.equals(province, region.province) &&
                Objects.equals(city, region.city) &&
                Objects.equals(district, region.district) &&
                Objects.equals(postcode, region.postcode) &&
                Objects.equals(shortcode, region.shortcode) &&
                Objects.equals(citycode, region.citycode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, province, city, district, postcode, shortcode, citycode);
    }
}
