package assgiment.ass.Model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "nvarchar(max)", nullable = false)
    private String nameproduct;

    @Column(columnDefinition = "nvarchar(max)", nullable = false)
    private String photo;

    @Column(precision = 10, scale = 2, nullable = false) // decimal(10,2) in SQL Server
    private BigDecimal price;

    @Column(columnDefinition = "nvarchar(max)")
    private String description;
}