package org.example.baitapbuoi3.duanban.Services;

import lombok.RequiredArgsConstructor;
import org.example.baitapbuoi3.duanban.Entity.Product;
import org.example.baitapbuoi3.duanban.Repository.SanPhamInterface;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SanPhamServices {
    private final SanPhamInterface spi;
    public Page<Product> getProductsByPage(int page,int size){
        Pageable pageable = PageRequest.of(page,size);
        return spi.getAllByPage(pageable);
    }
    public Page<Product> getProductsByCategoryPage(String category,int page,int size){
        Pageable pageable = PageRequest.of(page,size);
        return spi.getProductbyCategory(category,pageable);
    }


}
