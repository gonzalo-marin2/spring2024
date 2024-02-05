package model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	private Date fecha;
	
	@ManyToOne()
	@JoinColumn(name="idCliente",referencedColumnName = "idCliente")
	private Cliente cliente;
	
	@ManyToOne()
	@JoinColumn(name="idLibro",referencedColumnName = "isbn")
	private Libro libro;
	

}
