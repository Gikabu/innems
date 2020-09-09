package com.innovase.ems;

import com.innovase.ems.models.Unit;
import com.innovase.ems.property.FileStorageProperties;
import com.innovase.ems.repositories.UnitRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class InnEMSApplication {

	public static void main(String[] args) {
		SpringApplication.run(InnEMSApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(UnitRepository unitRepository) {
		return (String[] args) -> {
			Unit unit1 = new Unit();
			unit1.setTenantId(100L);
			unit1.setProperty_name("Spearnet Apartments");
			unit1.setProperty_short_code("842074");
			unit1.setName("DM3");
			unit1.setStatus(1);
			unit1.setLast_payment_date(System.currentTimeMillis());
			unit1.setRent(30000L);
			unit1.setRent_balance(30000L);

			Unit unit2 = new Unit();
			unit2.setStatus(1);
			unit2.setRent_balance(30000L);
			unit2.setRent(30000L);
			unit2.setName("DM4");
			unit2.setTenantId(101L);
			unit2.setProperty_name("Spearnet Apartments");
			unit2.setProperty_short_code("842074");
			unit2.setLast_payment_date(System.currentTimeMillis());
			unitRepository.save(unit1);
			unitRepository.save(unit2);
			unitRepository.findAll().forEach(System.out::println);
		};
	}
}
