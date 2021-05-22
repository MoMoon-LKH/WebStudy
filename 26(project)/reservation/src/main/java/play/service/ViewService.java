package play.service;

import play.dto.Item;
import play.dto.ItemPrice;

import java.util.List;

public interface ViewService {
    public static final Integer LIMIT = 4;
    public List<Item> getProducts(Integer tabNum, Integer start);
    public int getCount(Integer tabNum);
    public List<String> getPromotion();
}
