package com.app.service;

import java.util.List;

import com.app.pojos.Offers;

public interface IOffersService {

	List<Offers> listAllOffers();
	Offers addNewOffer(Offers newOffer);
	String deleteOffer(int offerId);
	Offers findByOfferId(Integer id);
	Offers updateOfferData(Offers updatedOfferData);
}
