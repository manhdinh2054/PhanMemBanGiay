package org.example.baitapbuoi3.duanban.Controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.baitapbuoi3.duanban.Entity.Account;
import org.example.baitapbuoi3.duanban.Entity.Category;
import org.example.baitapbuoi3.duanban.Entity.Product;
import org.example.baitapbuoi3.duanban.Repository.CategoryInterface;
import org.example.baitapbuoi3.duanban.Repository.SanPhamInterface;
import org.example.baitapbuoi3.duanban.Services.SanPham;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/trangchu.com")
public class DanhMuc {
    private final SanPham sp;
    private final CategoryInterface cgi;

    @RequestMapping("/danhmuc/{id}")
    public String danhMuc(@PathVariable("id") String id, Model model, HttpSession session) {
        List<Category> lst1 = cgi.findAll();
        List<Product> lst = sp.getProductsByCategory(id);
        Account account = (Account) session.getAttribute("loginuser");
        if(account != null) {
            model.addAttribute("account1", account);

        }else {
            return "redirect:/login";
        }
        model.addAttribute("category",lst1);
        model.addAttribute("productsdanhmuc", lst);
        return "danhmuc";
    }
}
