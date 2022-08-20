package listarciudades.listarciudades;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

@SpringBootApplication
public class ListarciudadesApplication implements CommandLineRunner {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(ListarciudadesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String sql = "INSERT INTO tercero(id, documento, idtipodocumento, nombre, direccion, telefono, idciudad, correo) VALUES (nextval('tercero_id'), '1069456789','13','Daniel Gonzalez','cll 24 80 33','34578954','5001','correo@correo.com')";
		int filas = jdbcTemplate.update(sql);
		if (filas > 0) {
			System.out.println("Se agregó un nuevo tercero.");
			sql = "Select T.id, nombre, TD.sigla || ' ' || T.documento documentoCompleto" +
					" from tercero T" +
					" JOIN tipodocumento TD" +
					" ON T.idtipodocumento = TD.id";

			jdbcTemplate.query(sql, new RowCallbackHandler() {
				public void processRow(ResultSet resultSet) throws SQLException {
					while (resultSet.next()) {
						System.out.println(resultSet.getString("id") + " " + resultSet.getString("nombre") + " "
								+ resultSet.getString("documentoCompleto"));
					}

				}
			});
		} else {
			System.out.println("No se agregaron terceros");
		}

	}

}
