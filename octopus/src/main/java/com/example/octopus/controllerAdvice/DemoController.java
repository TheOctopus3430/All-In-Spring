package com.example.octopus.controllerAdvice;

import com.example.octopus.controllerAdvice.exception.CustomException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class DemoController {

    /**
     * 关于@ModelAttribute,
     * 可以使用ModelMap以及@ModelAttribute()来获取参数值。
     */
    @GetMapping("/one")
    public String testError(ModelMap modelMap) {
        throw new CustomException(500L, "系统发生500异常！" + modelMap.get("attribute"));
    }

    @GetMapping("/two")
    public String testTwo(@ModelAttribute("attribute") String attribute) {
        throw new CustomException(500L, "系统发生500异常！" + attribute);
    }
}