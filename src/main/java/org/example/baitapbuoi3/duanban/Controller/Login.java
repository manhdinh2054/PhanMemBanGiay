package org.example.baitapbuoi3.duanban.Controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.example.baitapbuoi3.duanban.Entity.Account;
import org.example.baitapbuoi3.duanban.Repository.AccountInterface;
import org.example.baitapbuoi3.duanban.Services.AccountServices;
import org.hibernate.Session;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class Login {
    final AccountInterface aci;
    final AccountServices acs;

    @RequestMapping("/login")
    public String loginForm() {
        return "login";
    }

    @GetMapping("/check")
    public String check(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model, HttpSession session) {
        Account account = acs.findByUsername(username);

        if (account != null && account.getPassword().trim().equals(password)) {
            session.setAttribute("loginuser", account);
            return "redirect:/trangchu.com/sanpham";
        } else {
            model.addAttribute("error", "Tài khoản hoặc mật khẩu không đúng");
            return "login";
        }
    }
}
