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
    public int getCount(Integer tabNum) {
        int count = 0;
        List<Integer> countList = productDao.productCount();
        if(tabNum > 0){
            count = countList.get(tabNum - 1);
        } else{
            for (int i = 0; i < countList.size(); i++) {
                count += countList.get(i);
            }
        }
        return count;
    }

    @Override
    @Transactional
    public List<String> getPromotion() {
        List<String> list;
        list = productDao.promotion();
        return list;
    }
}

