package com.practicaJaveriana.spring_js_advance;

import com.practicaJaveriana.spring_js_advance.domain.Address;
import com.practicaJaveriana.spring_js_advance.domain.Client;
import com.practicaJaveriana.spring_js_advance.domain.Product;
import com.practicaJaveriana.spring_js_advance.domain.User;
import com.practicaJaveriana.spring_js_advance.repository.AddressRepository;
import com.practicaJaveriana.spring_js_advance.repository.ClientRepository;
import com.practicaJaveriana.spring_js_advance.repository.ProductRepository;
import com.practicaJaveriana.spring_js_advance.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Set;

@SpringBootApplication
public class SpringJsAdvanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJsAdvanceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(
			UserRepository userRepository,
			ClientRepository clientRepository,
			AddressRepository addressRepository,
			ProductRepository productRepository
	){
		return args ->{
			User user1 = userRepository.save(new User(null, "leo","1234"));
			Client client1 = clientRepository.save(new Client(null,"Leonardo Davila",user1,null,null));

			//addresses
			Address address1 = addressRepository.save(new Address(null,"Av.La Esperanza","Av 50",client1));
			Address address2 = addressRepository.save(new Address(null,"Calle 1","2530",client1));
			Address address3 = addressRepository.save(new Address(null,"Av.9","140",client1));
			Address address4 = addressRepository.save(new Address(null,"Calle Norte","125",client1));
			client1.setAddresses(Set.of(address1,address2,address3,address4));


			//products
			Product p1 = productRepository.save(new Product(null,"MacBook Pro 16gb",2500.00));
			Product p2 = productRepository.save(new Product(null,"Iphone 13 Pro",1300.00));
			Product p3 = productRepository.save(new Product(null,"Magic Mouse",150.00));
			Product p4 = productRepository.save(new Product(null,"Hub USB",70.00));
			//Guardamos los productos en la instancia client1
			client1.setProducts(Set.of(p1,p2,p3,p4));


			//Se vuelve a guardar client1 con el set de direcciones y productos declarados anteriormente
			Client leo= clientRepository.save(client1);
			//Mostramos la información en consola
			System.out.println(	"Client name: "+ leo.getName());
			System.out.println("User name: "+ leo.getUser().getUsername());
			System.out.println("======================================");
			leo.getAddresses().forEach( a -> System.out.println(
					"Address: " + a.getStreet() + " " + a.getNumber()
			));
			System.out.println("======================================");
			leo.getProducts().forEach(p -> System.out.println(
					"Product: " + p.getName() + " - Value: " + p.getPrice()
			));
		};
	}

}
