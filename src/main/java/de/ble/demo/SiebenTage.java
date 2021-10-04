package de.ble.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * SiebenTage
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SiebenTage {
    private Double weekIncidence; 
    
    public Double getWeekIncidence(){
        return weekIncidence;
    }

    public void setWeekIncidence(Double weekIncidence){
        this.weekIncidence = weekIncidence; 
    }
}