package model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="ventas")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Venta {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idVenta;
	private int idCliente;
	private int idLibro;
	private Date fecha;

}
