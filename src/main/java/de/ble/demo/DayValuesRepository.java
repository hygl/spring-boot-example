package de.ble.demo;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DayValuesRepository extends JpaRepository<Long,DayValues>{
    
    public DayValues selectByDateAndOrt(Date date, String Ort);
}
