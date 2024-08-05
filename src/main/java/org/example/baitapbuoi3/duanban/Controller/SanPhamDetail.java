package org.example.baitapbuoi3.duanban.Controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.baitapbuoi3.duanban.Entity.Account;
import org.example.baitapbuoi3.duanban.Entity.Category;
import org.example.baitapbuoi3.duanban.Entity.Product;
import org.example.baitapbuoi3.duanban.Repository.CategoryInterface;
import org.example.baitapbuoi3.duanban.Repository.SanPhamDetailInterface;
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
public class SanPhamDetail {
    final SanPhamDetailInterface spdi;
    final CategoryInterface cgi;

    @RequestMapping("detail/{id}")
    public String detail(Model model, @PathVariable int id, HttpSession session) {
        List<Product> lst = spdi.FindById1(id);
        List<Category> lstct = cgi.findAll();
        Account account = (Account) session.getAttribute("loginuser");
        if(account != null) {
            model.addAttribute("account1", account);

        }else {
            return "redirect:/login";
        }
        model.addAttribute("productdetaillst", lst);
        model.addAttribute("category",lstct);
        return "sanphamdetail";
    }
}
