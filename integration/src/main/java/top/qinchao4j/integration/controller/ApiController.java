package top.qinchao4j.integration.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description
 *
 * @author djdgt
 * @since 2023/3/28 10:56
 */
@RestController
@AllArgsConstructor
public class ApiController {


    @GetMapping("api/{api}")
    public String api(@PathVariable String api) {
        return api;
    }

}
