package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.OffersRepository;
import com.app.pojos.Offers;


@Service
@Transactional
public class OffersServiceImpl implements IOffersService
{
	
	@Autowired
	private OffersRepository offersRepo;

	@Override
	public List<Offers> listAllOffers() {
		return offersRepo.findAll();
	}

	@Override
	public Offers addNewOffer(Offers newOffer) {
		return offersRepo.save(newOffer);
	}

	@Override
	public String deleteOffer(int id) {
		Offers o =offersRepo.findByOfferId(id);
		try{
			offersRepo.delete(o);
		}catch(Exception e) {
			System.out.println("Error in offer deletion "+e);
		}
		return "Offer Deleted Successfully";
	}

	@Override
	public Offers findByOfferId(Integer id) {
		return offersRepo.findByOfferId(id);
	}

	@Override
	public Offers updateOfferData(Offers updatedOfferData) {
		return offersRepo.save(updatedOfferData);
	}
	
	
	
	
	
}
