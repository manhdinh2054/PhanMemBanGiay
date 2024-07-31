package org.example.baitapbuoi3.duanban.Services;

import lombok.RequiredArgsConstructor;
import org.example.baitapbuoi3.assignmentj6.Entity.Product;
import org.example.baitapbuoi3.assignmentj6.Repository.SanPhamInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SanPham {
    private final SanPhamInterface spi;
    public List<Product> getProductsByCategory(String category){
        return spi.getProductbyCategory(category);
    }

}
