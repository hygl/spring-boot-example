package de.ble.demo;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ColorServiceBonn {
    
    private DayValuesRepository repository;
    private RestTemplate restTemplate;
    private final String ort ="Bonn";
    private final String code = "05314";

    public ColorServiceBonn(DayValuesRepository repo,RestTemplate restTemplate){
        this.repository = repo;
        this.restTemplate = restTemplate;
    }

    /**
     * Gibt den Wert aus der Datenbank zurück oder holt ihn aus dem Internet. 
     * @return The Value for the day
     */
    private DayValues checkEntryForToday(){
        Date heute  = Date.from(LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        DayValues heuteValue = repository.getByDateAndOrt(heute, ort);
        if( heuteValue == null){
            Double siebenTageInzidenz= siebenTageInzidenz(ort);
            return new DayValues(heute, 0,0,0, ort, code);
        }
        return heuteValue;
    }

    private Double siebenTageInzidenz(String ort){

        SiebenTage sTage = restTemplate.getForObject(
					"https://api.corona-zahlen.org/districts/" +code , SiebenTage.class);
       
        return sTage.getWeekIncidence();
    }
}
