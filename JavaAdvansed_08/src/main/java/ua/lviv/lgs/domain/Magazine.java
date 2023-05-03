package ua.lviv.lgs.domain;

import java.time.LocalDate;
import java.util.Objects;

public class Magazine {

	private Integer id;
	private String name;
	private LocalDate publishDate;
	private Double subscribePrice;

	public Magazine(Integer id, String name, LocalDate publishDate, Double subscribePrice) {
		this.id = id;
		this.name = name;
		this.publishDate = publishDate;
		this.subscribePrice = subscribePrice;
	}

	public Magazine(String name, LocalDate publishDate2, Double subscribePrice) {
		this.name = name;
		this.publishDate = publishDate2;
		this.subscribePrice = subscribePrice;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}

	public Double getSubscribePrice() {
		return subscribePrice;
	}

	public void setSubscribePrice(Double subscribePrice) {
		this.subscribePrice = subscribePrice;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, publishDate, subscribePrice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Magazine other = (Magazine) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(publishDate, other.publishDate)
				&& Objects.equals(subscribePrice, other.subscribePrice);
	}

	@Override
	public String toString() {
		return "Magazine id = " + id + ", name = " + name + ", publishDate = " + publishDate + ", subscribePrice = "
				+ subscribePrice;
	}

}