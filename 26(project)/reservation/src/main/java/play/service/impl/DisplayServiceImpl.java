package play.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import play.dao.DisplayDao;
import play.dto.Display;
import play.dto.ItemPrice;
import play.dto.UserComment;
import play.service.DisplayService;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Service
public class DisplayServiceImpl implements DisplayService {

    @Autowired
    DisplayDao displayDao;

    @Override
    @Transactional
    public List<Display> getDisplay(Integer displayId) {
        List<Display> list = displayDao.getDisplay(displayId);
        return list;
    }

    @Override
    @Transactional
    public List<UserComment> getUserComment(Integer displayId) {
        List<UserComment> list = displayDao.getUserComment(displayId);
        return list;
    }

    @Override
    @Transactional
    public String getAverageScore(List<UserComment> list) {
        float averageScore = 0f;
        for (int i = 0; i < list.size(); i++) {
            averageScore += list.get(i).getScore();
        }
        averageScore /= list.size();
        return String.format("%.1f",averageScore);
    }

    @Override
    @Transactional
    public List<String> getImages(Integer displayId) {
        List<String> list = displayDao.getImages(displayId);
        return list;
    }

    @Override
    @Transactional
    public String getMap(Integer displayId) {
        return displayDao.getMap(displayId);
    }

    @Override
    @Transactional
    public List<ItemPrice> getPrice(Integer displayId) {
        List<ItemPrice> list = displayDao.getPrice(displayId);
        return list;
    }

    @Override
    @Transactional
    public String getReservationDate() {
        int random = (int) (Math.random() * 5 + 1);
        int hourRan = (int) (Math.random() * 24 + 1);
        SimpleDateFormat nowFormat = new SimpleDateFormat("yyyy.MM.dd hh");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, random);
        cal.add(Calendar.HOUR, hourRan);
        String now = nowFormat.format(cal.getTime());

        return now;
    }
}
