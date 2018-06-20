package com.kcsj.gwglxt.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(value = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"})
public class CountUserByMouth {
    @JsonProperty("Jan")
    private int Jan;
    @JsonProperty("Feb")
    private int Feb;
    @JsonProperty("Mar")
    private int Mar;
    @JsonProperty("Apr")
    private int Apr;
    @JsonProperty("May")
    private int May;
    @JsonProperty("Jun")
    private int Jun;
    @JsonProperty("Jul")
    private int Jul;
    @JsonProperty("Aug")
    private int Aug;
    @JsonProperty("Sep")
    private int Sep;
    @JsonProperty("Oct")
    private int Oct;
    @JsonProperty("Nov")
    private int Nov;
    @JsonProperty("Dec")
    private int Dec;

    public int getJan() {
        return Jan;
    }

    public void setJan(int jan) {
        Jan = jan;
    }

    public int getFeb() {
        return Feb;
    }

    public void setFeb(int feb) {
        Feb = feb;
    }

    public int getMar() {
        return Mar;
    }

    public void setMar(int mar) {
        Mar = mar;
    }

    public int getApr() {
        return Apr;
    }

    public void setApr(int apr) {
        Apr = apr;
    }

    public int getMay() {
        return May;
    }

    public void setMay(int may) {
        May = may;
    }

    public int getJun() {
        return Jun;
    }

    public void setJun(int jun) {
        Jun = jun;
    }

    public int getJul() {
        return Jul;
    }

    public void setJul(int jul) {
        Jul = jul;
    }

    public int getAug() {
        return Aug;
    }

    public void setAug(int aug) {
        Aug = aug;
    }

    public int getSep() {
        return Sep;
    }

    public void setSep(int sep) {
        Sep = sep;
    }

    public int getOct() {
        return Oct;
    }

    public void setOct(int oct) {
        Oct = oct;
    }

    public int getNov() {
        return Nov;
    }

    public void setNov(int nov) {
        Nov = nov;
    }

    public int getDec() {
        return Dec;
    }

    public void setDec(int dec) {
        Dec = dec;
    }

    @Override
    public String toString() {
        return "CountUserByMouth{" +
                "Jan=" + Jan +
                ", Feb=" + Feb +
                ", Mar=" + Mar +
                ", Apr=" + Apr +
                ", May=" + May +
                ", Jun=" + Jun +
                ", Jul=" + Jul +
                ", Aug=" + Aug +
                ", Sep=" + Sep +
                ", Oct=" + Oct +
                ", Nov=" + Nov +
                ", Dec=" + Dec +
                '}';
    }
}
