package de.ble.demo.employee;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Employee {
    
    private @Id @GeneratedValue Long id;
    private String name; 
    private String role; 

    Employee(String name, String role) {  
      this.name = name;
      this.role = role;
    }
}
