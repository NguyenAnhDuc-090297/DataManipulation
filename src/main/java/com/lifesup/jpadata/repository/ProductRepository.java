package com.lifesup.jpadata.repository;

import com.lifesup.jpadata.dto.ProductDto;
import com.lifesup.jpadata.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query(value =
            "   SELECT " +
            "       p.name as name, p.description as description, p.price as price, p.qty_available as quantity, c.category_type as categoryType " +
            "   FROM test.product p " +
            "   JOIN test.category c ON p.category_id = c.category_id ", nativeQuery = true)
    Page<ProductDto> getAllNested(Pageable pageable);
}
