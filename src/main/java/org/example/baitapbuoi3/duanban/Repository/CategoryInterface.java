package org.example.baitapbuoi3.duanban.Repository;

import org.example.baitapbuoi3.duanban.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryInterface extends JpaRepository<Category,Long> {
}
