package com.kodinor.repository.product;

import org.springframework.data.repository.CrudRepository;

import com.kodinor.entity.product.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	//
}
