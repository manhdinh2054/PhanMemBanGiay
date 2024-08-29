package org.example.baitapbuoi3.duanban.Repository;

import org.example.baitapbuoi3.duanban.Entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SanPhamDetailInterface extends JpaRepository<Product,Integer> {
    @Query(value = "select * from Products where id = :id",nativeQuery = true)
    List<Product> FindById1(int id);

}
