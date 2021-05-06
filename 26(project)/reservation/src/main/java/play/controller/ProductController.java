package play.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import play.dto.Item;
import play.service.ViewService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    @Autowired
    ViewService viewService;

    @GetMapping
    public Map<String, Object> getProducts(@RequestParam(name = "category" , required = true, defaultValue = "0") int category
            , @RequestParam(name = "start" , required=false, defaultValue = "0") int start){
        List<Item> list = viewService.getProducts(category, start);
        int count = viewService.getCount();

        Map<String, Object> map = new HashMap<>();
        map.put("list",list);
        map.put("count", count);

        return map;
    }
}
