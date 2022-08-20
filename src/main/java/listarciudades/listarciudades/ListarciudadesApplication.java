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
		String sql = "INSERT INTO Tercero(id, Documento, IdTipoDocumento, Nombre, Direccion, Telefono, IdCiudad, Correo) VALUES (nextval('tercero_id'), '44567489','13','Andrea Cifue','cll 24 80 33','34578954','5001','correo@correo.com')"; 
		int filas = jdbcTemplate.update(sql);
        if (filas > 0) {
            System.out.println("Se agregó un nuevo tercero.");
        }
	
		
	}



}
