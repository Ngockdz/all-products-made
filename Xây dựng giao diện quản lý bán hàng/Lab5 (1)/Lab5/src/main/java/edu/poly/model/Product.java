package edu.poly.model;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "nvarchar(100) not null")
	private String name;
	
	@Temporal(TemporalType.DATE)
	private Date createDate;
	
	@Column(nullable = false)
	private Double price;
	
	@Column(length = 100)
	private String imageUrl;
	
	@Column(nullable = false)
	private Integer quantity;
	
	@Column(nullable = false)
	private Float discount;
	
	private ProductStatus status;
	
	@ManyToOne()
	@JoinColumn(name = "categoryId")
	Category category;
	
	@OneToMany(mappedBy = "product")
	Set<OrderDetail> orderDetails;
	
	@PrePersist
	public void prePersist() {
		createDate = new Date();
	}
}


