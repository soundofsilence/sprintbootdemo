package com.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Administrator on 2018/1/26.
 */
@Entity
public class Blacklist {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String tenantId;
    private String schoolId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    protected Blacklist(){

    }

    public Blacklist(String tenantId, String schoolId){
        this.schoolId = schoolId;
        this.tenantId = tenantId;
    }

    @Override
    public String toString(){
        return String.format("BlackList[id=%d,tenantId='%s',schoolId='%s']",id,tenantId,schoolId);
    }

}
