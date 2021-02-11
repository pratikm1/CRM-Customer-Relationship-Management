package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.pojos.Offers;
import com.app.pojos.Vehicle;
import com.app.service.OffersServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/offers")
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class OffersController {

	@Autowired
	private OffersServiceImpl service;

	public OffersController() {
		System.out.println("IN OFFERS CONTROLLER....!!!");
	}

	@GetMapping
	public ResponseEntity<?> getAllOffers() {
		System.out.println("IN GET ALL OFFERS " + getClass().getName());
		List<Offers> offers = service.listAllOffers();
		if (offers.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else
			return new ResponseEntity<>(offers, HttpStatus.OK);
	}

//	@PostMapping
//	public ResponseEntity<?> addNewOffer(@RequestBody Offers o) {
//		System.out.println("In add new offer " + o);
//		try {
//
//			Offers newOffer = service.addNewOffer(o);
//			System.out.println(newOffer);
//			return new ResponseEntity<>(newOffer, HttpStatus.CREATED);
//
//		} catch (RuntimeException e) {
//			System.out.println("ERROR in adding new Offer" + e);
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable int id) {
		System.out.println("IN DELETE OFFERS COTROLLER");

		try {
			service.deleteOffer(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}

	}
	
//	@PutMapping("/update/{offerId}")
//	public ResponseEntity<?> updateVehicleDetails(@RequestBody Offers o, @PathVariable int offerId) {
//
//		Offers ofr = service.findByOfferId(offerId);
//
//		System.out.println("IN UPDATE Offer " + o + "         " + offerId);
//		if (ofr != null) {
//			Offers existingOffer = ofr;
//			existingOffer.setOfferName(o.getOfferName());
//			existingOffer.setOfferDesc(o.getOfferDesc()); 
//			existingOffer.setStartDate(o.getStartDate());
//			existingOffer.setEndDate(o.getEndDate());
//			existingOffer.setOfferDiscountPercentage(o.getOfferDiscountPercentage()); 
//			existingOffer.setOfferImage(o.getOfferImage());
//
//			try {
//				service.updateOfferData(existingOffer);
//				return ResponseEntity.ok(existingOffer);
//			} catch (RuntimeException e) {
//				System.out.println("Error in updating offer" + e);
//				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//			}
//
//		}
//		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	}
	@PostMapping
	public ResponseEntity<?> addNewOfferWithImage(@RequestParam("offer") String ofr,
			@RequestParam("imageFile") MultipartFile imageFile) {
		try {

			// To convert string data of employee into employee object
			Offers offer = new ObjectMapper().readValue(ofr, Offers.class);

			offer.setOfferImage(imageFile.getBytes());
			offer.setType(imageFile.getContentType());
			service.addNewOffer(offer);

		} catch (Exception e) {
			System.out.println("ERROR in adding new offer " + e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/update/{offerId}")
	public ResponseEntity<?> updateVehicleDetails(@RequestParam("offer") String ofr,
			@RequestParam("imageFile") MultipartFile imageFile/*@RequestBody Offers o*/, @PathVariable int offerId) throws JsonMappingException, JsonProcessingException {

		Offers existingOffer = service.findByOfferId(offerId);
		Offers o = new ObjectMapper().readValue(ofr, Offers.class);
		System.out.println("IN UPDATE Offer " + o + "         " + offerId);
		if (o != null) {
//			Offers existingOffer = ofr;
			existingOffer.setOfferName(o.getOfferName());
			existingOffer.setOfferDesc(o.getOfferDesc()); 
			existingOffer.setStartDate(o.getStartDate());
			existingOffer.setEndDate(o.getEndDate());
			existingOffer.setOfferDiscountPercentage(o.getOfferDiscountPercentage()); 
			existingOffer.setOfferImage(o.getOfferImage());

			try {
				service.updateOfferData(existingOffer);
				return ResponseEntity.ok(existingOffer);
			} catch (RuntimeException e) {
				System.out.println("Error in updating offer" + e);
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}

		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}