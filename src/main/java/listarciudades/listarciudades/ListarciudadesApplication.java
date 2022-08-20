package listarciudades.listarciudades;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class ListarciudadesApplication implements CommandLineRunner {

	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(ListarciudadesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.print("Buenas noches a todos!");
		
	}



}
