package play.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import play.dao.DisplayDao;
import play.dto.Display;
import play.dto.UserComment;
import play.service.DisplayService;

import java.text.Format;
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
}
