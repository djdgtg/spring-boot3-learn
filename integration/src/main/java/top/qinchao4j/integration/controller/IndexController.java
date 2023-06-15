package top.qinchao4j.integration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Description
 *
 * @author djdgt
 * @since 2023/3/28 10:56
 */
@Controller
public class IndexController {

    @GetMapping("{page}.html")
    public String page(@PathVariable String page) {
        return page;
    }

    @PostMapping("loginSuccess")
    public String loginSuccess() {
        return "redirect:index.html";
    }

}
