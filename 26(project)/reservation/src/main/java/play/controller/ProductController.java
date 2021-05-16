package play.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import play.dto.Display;
import play.dto.Item;
import play.dto.UserComment;
import play.service.DisplayService;
import play.service.ViewService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    @Autowired
    ViewService viewService;

    @Autowired
    DisplayService displayService;

    @GetMapping
    public Map<String, Object> getProducts(@RequestParam(name = "category" , required = true, defaultValue = "0") int category
            , @RequestParam(name = "start" , required=false, defaultValue = "0") int start){
        List<Item> list = viewService.getProducts(category, start);
        int count = viewService.getCount(category);
        List<String> promotion = viewService.getPromotion();

        Map<String, Object> map = new HashMap<>();

        map.put("list",list);
        map.put("count", count);
        map.put("promotion", promotion);

        return map;
    }

    @GetMapping("/{displayId}")
    public Map<String, Object> getDisplays(@PathVariable(name = "displayId") int id){
        List<Display> display = displayService.getDisplay(id);
        List<UserComment> comments = displayService.getUserComment(id);
        String avgScore = displayService.getAverageScore(comments);
        List<String> images = displayService.getImages(id);
        String mapImage = displayService.getMap(id);

        Map<String, Object> map = new HashMap<>();

        map.put("display", display);
        map.put("comments", comments);
        map.put("avgScore", avgScore);
        map.put("images", images);
        map.put("mapImage", mapImage);

        return map;
    }



}
