package de.ble.demo.todo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Todo{

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id; 

  @NotBlank(message="Task is mandatory")
  private String task; 

  private Date datum; 


  public Todo() {
  }

  public Todo(String task, Date datum) {
    this.task = task;
    this.datum = datum;
  }

  public long getId() {
    return this.id;
  }


  public String getTask() {
    return this.task;
  }

  public void setTask(String task) {
    this.task = task;
  }

  public Date getDatum() {
    return this.datum;
  }

  public void setDatum(Date datum) {
    this.datum = datum;
  }

  public Todo id(long id) {
    this.id = id;
    return this;
  }

  public Todo task(String task) {
    this.task = task;
    return this;
  }

  public Todo datum(Date datum) {
    this.datum = datum;
    return this;
  }


  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", task='" + getTask() + "'" +
      ", datum='" + getDatum() + "'" +
      "}";
  }

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((datum == null) ? 0 : datum.hashCode());
	result = prime * result + (int) (id ^ (id >>> 32));
	result = prime * result + ((task == null) ? 0 : task.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Todo other = (Todo) obj;
	if (datum == null) {
		if (other.datum != null)
			return false;
	} else if (!datum.equals(other.datum))
		return false;
	if (id != other.id)
		return false;
	if (task == null) {
		if (other.task != null)
			return false;
	} else if (!task.equals(other.task))
		return false;
	return true;
}
  

}