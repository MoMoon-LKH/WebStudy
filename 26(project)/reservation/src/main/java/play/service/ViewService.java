package play.service;

import play.dto.Product;

import java.util.List;

public interface ViewService {
    public static final Integer LIMIT = 4;
    public List<Product> getProducts(Integer start);
    public int getCount();
}
