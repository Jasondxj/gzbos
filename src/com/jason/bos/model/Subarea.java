package com.jason.bos.model;

import java.util.Objects;

public class Subarea {
    private String id;
    private String addresskey;
    private String startnum;
    private String endnum;
    private String single;
    private String position;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddresskey() {
        return addresskey;
    }

    public void setAddresskey(String addresskey) {
        this.addresskey = addresskey;
    }

    public String getStartnum() {
        return startnum;
    }

    public void setStartnum(String startnum) {
        this.startnum = startnum;
    }

    public String getEndnum() {
        return endnum;
    }

    public void setEndnum(String endnum) {
        this.endnum = endnum;
    }

    public String getSingle() {
        return single;
    }

    public void setSingle(String single) {
        this.single = single;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subarea subarea = (Subarea) o;
        return Objects.equals(id, subarea.id) &&
                Objects.equals(addresskey, subarea.addresskey) &&
                Objects.equals(startnum, subarea.startnum) &&
                Objects.equals(endnum, subarea.endnum) &&
                Objects.equals(single, subarea.single) &&
                Objects.equals(position, subarea.position);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, addresskey, startnum, endnum, single, position);
    }
}
