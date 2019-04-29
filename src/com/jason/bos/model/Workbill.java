package com.jason.bos.model;

import java.sql.Timestamp;
import java.util.Objects;

public class Workbill {
    private String id;
    private String type;
    private String pickstate;
    private Timestamp buildtime;
    private Integer attachbilltimes;
    private String remark;
    private Noticebill noticebill;
    private Staff staff;

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Noticebill getNoticebill() {
        return noticebill;
    }

    public void setNoticebill(Noticebill noticebill) {
        this.noticebill = noticebill;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPickstate() {
        return pickstate;
    }

    public void setPickstate(String pickstate) {
        this.pickstate = pickstate;
    }

    public Timestamp getBuildtime() {
        return buildtime;
    }

    public void setBuildtime(Timestamp buildtime) {
        this.buildtime = buildtime;
    }

    public Integer getAttachbilltimes() {
        return attachbilltimes;
    }

    public void setAttachbilltimes(Integer attachbilltimes) {
        this.attachbilltimes = attachbilltimes;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Workbill workbill = (Workbill) o;
        return Objects.equals(id, workbill.id) &&
                Objects.equals(type, workbill.type) &&
                Objects.equals(pickstate, workbill.pickstate) &&
                Objects.equals(buildtime, workbill.buildtime) &&
                Objects.equals(attachbilltimes, workbill.attachbilltimes) &&
                Objects.equals(remark, workbill.remark);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, type, pickstate, buildtime, attachbilltimes, remark);
    }
}
