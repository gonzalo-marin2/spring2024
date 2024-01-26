package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="items")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Resultado {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idItem;
	private String url;
	private String tematica;
	private String descripcion;
}
