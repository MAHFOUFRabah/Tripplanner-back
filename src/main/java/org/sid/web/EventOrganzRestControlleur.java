package org.sid.web;

import java.util.List;

import org.sid.dao.ItemRepository;
import org.sid.dao.TripRepository;
import org.sid.entities.Item;
import org.sid.entities.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventOrganzRestControlleur {
	
	@Autowired
	ItemRepository itemRepository;
	@Autowired
	TripRepository tripRepository;
	
	// Charger tous les voyages
	@CrossOrigin
	@RequestMapping(value="/allTrips",method=RequestMethod.GET)
	public List<Trip> AllTrip(){
		return tripRepository.findAll();
	}
	
	//Charger Tous les articles
	@CrossOrigin
	@RequestMapping(value="/allItems/{id}",method=RequestMethod.GET)
	public List<Item>AllItems(@PathVariable Long id){
		System.out.println("id = "+id);
		return itemRepository.listItemOfTrip(id);
	}
	
	//Charger un article spécifique
	@RequestMapping(value="/oneItem/{id}",method=RequestMethod.GET)
	public Item getItem(@PathVariable Long id){
		return itemRepository.findById(id).orElse(null);
	}
	
	//Charger un voyage spécifique
	@CrossOrigin
	@RequestMapping(value="/oneTrip/{id}",method=RequestMethod.GET)
	public Trip getTrip(@PathVariable Long id){
		return tripRepository.findById(id).orElse(null);
	}
	
	
	//Ajouter un voyage
	@CrossOrigin
	@RequestMapping(value="/oneTrip",method=RequestMethod.POST)	
	public Trip addTrip(@RequestBody Trip trip){
		return tripRepository.save(new Trip(trip.getNomTrip()));
	}
	
	//Ajouter un article
	@CrossOrigin
	@RequestMapping(value="/oneItem/{id}",method=RequestMethod.POST)
	public Item addItem(@RequestBody  Item item,@PathVariable Long id){
		Trip trip =tripRepository.findById(id).orElse(null);
		item.setTrip(trip);
		return itemRepository.save(item);
	} 
	
	// Supprimer un voyage
	@CrossOrigin
	@RequestMapping(value="/oneTrip/{id}",method=RequestMethod.DELETE)
	public void deleteTrip(@PathVariable Long id){
		tripRepository.deleteById(id); 
	} 
	
	//supprimer un article
	@CrossOrigin
	@RequestMapping(value="/oneItem/{id}",method=RequestMethod.DELETE)
	public void deleteItem(@PathVariable Long id){
		itemRepository.deleteById(id);
	}
	
	//mettre à jour le nom d'un voyage
	@RequestMapping(value="/oneTrip/{id}",method=RequestMethod.PUT)
	public Trip updateTrip(@PathVariable Long id,@RequestBody Trip tripT){
		
		Trip trip =tripRepository.findById(id).orElse(null);
		trip.setNomTrip(tripT.getNomTrip());
		
		return tripRepository.save(trip);
		 
	}
	// Ajouter un article aux favori
	@CrossOrigin
	@RequestMapping(value="/oneItem/{idItem}",method=RequestMethod.PUT)
	public Item updateItem(@PathVariable Long idItem,@RequestBody Item itemT){
		
		Item item =itemRepository.findById(idItem).orElse(null);
		System.out.println(itemT.getBelongsTo());
		item.setBelongsTo(itemT.getBelongsTo());
		
		return itemRepository.save(item);
		 
	}

 
	
	

}
