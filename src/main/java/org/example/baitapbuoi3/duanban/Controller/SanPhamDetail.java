package org.example.baitapbuoi3.duanban.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/trangchu.com")
public class SanPhamDetail {

    @RequestMapping("detail")
    public String detail(Model model) {

        return "sanphamdetail";
    }
}
