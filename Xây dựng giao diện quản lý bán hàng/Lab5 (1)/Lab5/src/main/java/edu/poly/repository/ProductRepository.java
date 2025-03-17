package edu.poly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.poly.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
