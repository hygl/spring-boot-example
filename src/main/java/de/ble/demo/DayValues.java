package de.ble.demo;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DayValues{

    @Id
    @GeneratedValue
    private long id;
    private Date tag; 
    private double siebentageInzidenz; 
    private double krankenhausbetten;

    private double beatmet;
    private String ort; 
    private String code;

    private DayValues(){
        
    }

    public DayValues(Date tag, double siebentageInzidenz, double krankenhausbetten, double beatmet, String ort, String code) {
      
        this.tag = tag;
        this.siebentageInzidenz = siebentageInzidenz;
        this.krankenhausbetten = krankenhausbetten;
        this.beatmet = beatmet;
        this.ort = ort;
        this.code = code;
    }

    public long getId() {
        return this.id;
    }


    public Date getTag() {
        return this.tag;
    }

    public void setTag(Date tag) {
        this.tag = tag;
    }

    public double getSiebentageInzidenz() {
        return this.siebentageInzidenz;
    }

    public void setSiebentageInzidenz(double siebentageInzidenz) {
        this.siebentageInzidenz = siebentageInzidenz;
    }

    public double getKrankenhausbetten() {
        return this.krankenhausbetten;
    }

    public void setKrankenhausbetten(double krankenhausbetten) {
        this.krankenhausbetten = krankenhausbetten;
    }

    public double getBeatmet() {
        return this.beatmet;
    }

    public void setBeatmet(double beatmet) {
        this.beatmet = beatmet;
    }

    public String getOrt() {
        return this.ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof DayValues)) {
            return false;
        }
        DayValues dayValue = (DayValues) o;
        return id == dayValue.id && Objects.equals(tag, dayValue.tag) && siebentageInzidenz == dayValue.siebentageInzidenz && krankenhausbetten == dayValue.krankenhausbetten && beatmet == dayValue.beatmet && Objects.equals(ort, dayValue.ort) && Objects.equals(code, dayValue.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tag, siebentageInzidenz, krankenhausbetten, beatmet, ort, code);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", tag='" + getTag() + "'" +
            ", siebentageInzidenz='" + getSiebentageInzidenz() + "'" +
            ", krankenhausbetten='" + getKrankenhausbetten() + "'" +
            ", beatmet='" + getBeatmet() + "'" +
            ", ort='" + getOrt() + "'" +
            ", code='" + getCode() + "'" +
            "}";
    }
    
}