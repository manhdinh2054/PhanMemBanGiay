package org.example.baitapbuoi3.duanban.Controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.example.baitapbuoi3.duanban.Entity.Account;
import org.example.baitapbuoi3.duanban.Entity.Category;
import org.example.baitapbuoi3.duanban.Entity.Product;
import org.example.baitapbuoi3.duanban.Repository.CategoryInterface;
import org.example.baitapbuoi3.duanban.Repository.SanPhamInterface;
import org.example.baitapbuoi3.duanban.Services.AccountServices;
import org.example.baitapbuoi3.duanban.Services.SanPhamServices;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/trangchu.com")

public class TrangChu {

    final SanPhamInterface spi;
    final CategoryInterface cgi;
    final SanPhamServices sps;
    @RequestMapping("/sanpham")
    public String Product( Model model, HttpSession session,@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue ="8")int size) {
        Page<Product> pagelst = sps.getProductsByPage(page, size);
        List<Category> lstct = cgi.findAll();
        Account account = (Account) session.getAttribute("loginuser");
        if(account != null) {
            model.addAttribute("account1", account);
        }else {
            return "redirect:/login";
        }
        model.addAttribute("products",pagelst);
        model.addAttribute("category",lstct);
        return "trangchu";
    }

}
