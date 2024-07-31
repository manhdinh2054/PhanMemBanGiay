package org.example.baitapbuoi3.duanban.Repository;

import org.example.baitapbuoi3.assignmentj6.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface SanPhamInterface extends JpaRepository<Product,Long> {
    @Query(value = "select * from products where categoryId = :category1",nativeQuery = true)
    List<Product> getProductbyCategory(String category1);
}
