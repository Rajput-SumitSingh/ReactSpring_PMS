package com.monst3r.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monst3r.Model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
}
