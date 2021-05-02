package play.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import play.dao.ProductDao;
import play.dto.Item;
import play.dto.Product;
import play.service.ViewService;

import java.util.List;

@Service
public class ViewServiceImpl implements ViewService {

    @Autowired
    ProductDao productDao;

    @Override
    @Transactional
    public List<Item> getProducts(Integer tabNum, Integer start) {
        List<Item> list;
        list = productDao.products(tabNum, start, ViewService.LIMIT);
        return list;
    }

    @Override
    @Transactional
    public int getCount() {
        return 0;
    }
}

