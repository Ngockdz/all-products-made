package assgiment.ass.DAO;

import assgiment.ass.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ProductDAO extends JpaRepository<Product, Long> {
    @Query(value = "SELECT * FROM products ORDER BY id OFFSET :offset ROWS FETCH NEXT :limit ROWS ONLY", 
           nativeQuery = true)
    List<Product> findProductsWithPagination(
        @Param("offset") int offset,
        @Param("limit") int limit
    );
}