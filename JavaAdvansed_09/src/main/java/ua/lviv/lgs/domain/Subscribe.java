package ua.lviv.lgs.domain;

import java.util.Date;
import java.util.Objects;

public class Subscribe {

	private Integer id;
	private Integer userId;
	private Integer magazineId;
	private Date subscribeDate;

	public Subscribe(Integer id, Integer userId, Integer magazineId, Date subscribeDate) {
		this.id = id;
		this.userId = userId;
		this.magazineId = magazineId;
		this.subscribeDate = subscribeDate;
	}

	public Subscribe(Integer userId, Integer magazineId, Date subscribeDate) {
		this.userId = userId;
		this.magazineId = magazineId;
		this.subscribeDate = subscribeDate;
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

	public Date getSubscribeDate() {
		return subscribeDate;
	}

	public void setSubscribeDate(Date subscribeDate) {
		this.subscribeDate = subscribeDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, magazineId, subscribeDate, userId);
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
								&& Objects.equals(userId, other.userId);
	}

	@Override
	public String toString() {
		return "Subscribe id = " + id + ", userId = " + userId + ", magazineId = " + magazineId + ", subscribeDate = " + subscribeDate;
	}

}