package com.example.JpaCRUD.Repository;

import com.example.JpaCRUD.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
                                          // Can also use CrudRepository<Product,Integer>
                                          // JpaRepository itself extends CrudRepository.
                                          // In some cases we can get some errors while using CrudRepository.
                                          // So use JpaRepository to avoid some errors.
}
