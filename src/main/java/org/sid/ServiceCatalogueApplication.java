package org.sid;

import org.sid.dao.ItemRepository;
import org.sid.dao.TripRepository;
import org.sid.entities.Item;
import org.sid.entities.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServiceCatalogueApplication implements CommandLineRunner {
	@Autowired
	private TripRepository tripRepository;

	@Autowired
	private ItemRepository itemRepository;


	public static void main(String[] args) {
	SpringApplication.run(ServiceCatalogueApplication.class, args);
    }
	@Override
	public void run(String... args) throws Exception {

		Trip trip1=tripRepository.save(new Trip("USA TRIP"));
		Trip trip2=tripRepository.save(new Trip("EU TRIP"));
		Item item1 =itemRepository.save(new Item("Papiers",trip1));
		Item item2 =itemRepository.save(new Item("Chargeurs",trip1));
		Item item3 =itemRepository.save(new Item("Papiers",trip2));
		Item item4 =itemRepository.save(new Item("Chargeurs",trip2));
		System.out.println("l'application a démarré !!!");

	}


}
