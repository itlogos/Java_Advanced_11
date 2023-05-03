package ua.lviv.lgs.domain;

import java.time.LocalDate;
import java.util.Objects;

public class Subscribe {

	private Integer id;
	private Integer userId;
	private Integer magazineId;
	private boolean subscribeStatus;
	private LocalDate subscribeDate;
	private Integer subscribePeriod;

	public Subscribe(Integer id, Integer userId, Integer magazineId, boolean subscribeStatus, LocalDate subscribeDate,Integer subscribePeriod) {
		this.id = id;
		this.userId = userId;
		this.magazineId = magazineId;
		this.subscribeStatus = subscribeStatus;
		this.subscribeDate = subscribeDate;
		this.subscribePeriod = subscribePeriod;
	}

	public Subscribe(Integer userId, Integer magazineId, boolean subscribeStatus, LocalDate subscribeDate,Integer subscribePeriod) {
		this.userId = userId;
		this.magazineId = magazineId;
		this.subscribeStatus = subscribeStatus;
		this.subscribeDate = subscribeDate;
		this.subscribePeriod = subscribePeriod;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getMagazineId() {
		return magazineId;
	}

	public void setMagazineId(Integer magazineId) {
		this.magazineId = magazineId;
	}

	public boolean isSubscribeStatus() {
		return subscribeStatus;
	}

	public void setSubscribeStatus(boolean subscribeStatus) {
		this.subscribeStatus = subscribeStatus;
	}

	public LocalDate getSubscribeDate() {
		return subscribeDate;
	}

	public void setSubscribeDate(LocalDate subscribeDate) {
		this.subscribeDate = subscribeDate;
	}

	public Integer getSubscribePeriod() {
		return subscribePeriod;
	}

	public void setSubscribePeriod(Integer subscribePeriod) {
		this.subscribePeriod = subscribePeriod;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, magazineId, subscribeDate, subscribePeriod, subscribeStatus, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subscribe other = (Subscribe) obj;
		return Objects.equals(id, other.id) && Objects.equals(magazineId, other.magazineId)
				&& Objects.equals(subscribeDate, other.subscribeDate)
				&& Objects.equals(subscribePeriod, other.subscribePeriod) && subscribeStatus == other.subscribeStatus
				&& Objects.equals(userId, other.userId);
	}

	@Override
	public String toString() {
		return "Subscribe id = " + id + ", userId = " + userId + ", magazineId = " + magazineId + ", subscribeStatus = "
				+ subscribeStatus + ", subscribeDate = " + subscribeDate + ", subscribePeriod = " + subscribePeriod + " months";
	}

}