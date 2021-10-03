package de.ble.demo;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class ColorServiceBonn {
    
    private DayValuesRepository repository;
    private final String ort ="Bonn";
    private final String code = "05314";

    public ColorServiceBonn(DayValuesRepository repo){
        this.repository = repo;
    }

    private DayValues checkEntryForToday(){
        Date heute  = Date.from(LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        return new DayValues(heute, 0,0,0, ort, code);
    }
}
