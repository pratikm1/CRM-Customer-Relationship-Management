package com.app.pojos;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "offers")
public class Offers {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "offer_id")
	private Integer offerId;
	@Column(length = 320, unique = true,nullable = false)
	private String offerName;
	@Column(length = 320, unique = true,nullable = false)
	private String offerDesc;
	@Column(name = "discount_percent")
	private double offerDiscountPercentage;
	@Column
	private Date startDate;
	@Column
	private Date endDate;
	
//	@OneToOne(mappedBy = "AvailableOffers",cascade = CascadeType.ALL)
//	private NewBooking offerBooking;
	
	@Lob
	private byte[] offerImage;
	
	@Column(name = "type")
	private String type;
	
	public Offers() {
	}

	
	public Offers(Integer offerId, String offerName, String offerDesc, double offerDiscountPercentage, Date startDate,
			Date endDate, byte[] offerImage) {
		super();
		this.offerId = offerId;
		this.offerName = offerName;
		this.offerDesc = offerDesc;
		this.offerDiscountPercentage = offerDiscountPercentage;
		this.startDate = startDate;
		this.endDate = endDate;
		this.offerImage = offerImage;
	}


	public Integer getOfferId() {
		return offerId;
	}

	public void setOfferId(Integer offerId) {
		this.offerId = offerId;
	}

	public String getOfferName() {
		return offerName;
	}

	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}

	public String getOfferDesc() {
		return offerDesc;
	}

	public void setOfferDesc(String offerDesc) {
		this.offerDesc = offerDesc;
	}

	public double getOfferDiscountPercentage() {
		return offerDiscountPercentage;
	}

	public void setOfferDiscountPercentage(double offerDiscountPercentage) {
		this.offerDiscountPercentage = offerDiscountPercentage;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

//	public NewBooking getOfferBooking() {
//		return offerBooking;
//	}
//
//	public void setOfferBooking(NewBooking offerBooking) {
//		this.offerBooking = offerBooking;
//	}
	public byte[] getOfferImage() {
		return offerImage;
	}


	public void setOfferImage(byte[] offerImage) {
		this.offerImage = offerImage;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}


	@Override
	public String toString() {
		return "Offers [offerId=" + offerId + ", offerName=" + offerName + ", offerDesc=" + offerDesc
				+ ", offerDiscountPercentage=" + offerDiscountPercentage + ", startDate=" + startDate + ", endDate="
				+ endDate + "]";
	}
	
	
	
}
