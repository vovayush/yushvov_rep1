package com.yush.entity.components;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.yush.entity.SceletonEntity;

@Entity
@Table(name = "characteristics")
public class Characteristic extends SceletonEntity {

    @Column(name = "c_name")
    private String characteristicName;

    @Column(name = "c_value")
    private String characteristicValue;

    public String getCharacteristicName() {
        return characteristicName;
    }

    public void setCharacteristicName(String characteristicName) {
        this.characteristicName = characteristicName;
    }

    public String getCharacteristicValue() {
        return characteristicValue;
    }

    public void setCharacteristicValue(String characteristicValue) {
        this.characteristicValue = characteristicValue;
    }

    @Override
    public String toString() {
        return  "characteristicName='" + characteristicName + '\'' +
                ", characteristicValue='" + characteristicValue;
    }
}
