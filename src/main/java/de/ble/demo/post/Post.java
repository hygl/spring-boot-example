package de.ble.demo.post;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Post {

	public Post() {
	}

	public Post(String title, String text, Date datum) {
		this.title = title;
		this.text = text;
		this.datum = datum;
	}

	public Long getId() {
		return this.id;
	}

	void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDatum() {
		return this.datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public Post id(Long id) {
		setId(id);
		return this;
	}

	public Post title(String title) {
		setTitle(title);
		return this;
	}

	public Post text(String text) {
		setText(text);
		return this;
	}

	public Post datum(Date datum) {
		setDatum(datum);
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Post)) {
			return false;
		}
		Post post = (Post) o;
		return Objects.equals(id, post.id) && Objects.equals(title, post.title) && Objects.equals(text, post.text) && Objects.equals(datum, post.datum);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, title, text, datum);
	}

	@Override
	public String toString() {
		return "{" +
			" id='" + getId() + "'" +
			", title='" + getTitle() + "'" +
			", text='" + getText() + "'" +
			", datum='" + getDatum() + "'" +
			"}";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String title;
	private String text;
	private Date datum;

}