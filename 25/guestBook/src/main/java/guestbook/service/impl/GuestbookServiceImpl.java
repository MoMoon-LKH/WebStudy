package guestbook.service.impl;

import guestbook.dao.GuestbookDao;
import guestbook.dao.LogDao;
import guestbook.dto.Guestbook;
import guestbook.dto.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import guestbook.service.GuestbookService;

import java.util.Date;
import java.util.List;

@Service
public class GuestbookServiceImpl implements GuestbookService {

    @Autowired
    GuestbookDao guestbookDao;

    @Autowired
    LogDao logDao;

    @Override
    @Transactional
    public List<Guestbook> getGuestbooks(Integer start) {
        List<Guestbook> list;
        list = guestbookDao.selectAll(start, GuestbookService.LIMIT);
        return list;
    }

    @Override
    @Transactional
    public int deleteGuestbook(Long id, String ip) {
        int deleteCount = guestbookDao.deleteById(id);
        Log log = new Log();
        log.setIp(ip);
        log.setMethod("delete");
        log.setRegdate(new Date());
        logDao.insertRow(log);
        return deleteCount;
    }

    @Override
    @Transactional
    public Guestbook addGuestbook(Guestbook guestbook, String ip) {
        guestbook.setRegdate(new Date());
        Long id = guestbookDao.insertRow(guestbook);
        guestbook.setId(id);

        Log log = new Log();
        log.setIp(ip);
        log.setMethod("insert");
        log.setRegdate(new Date());
        logDao.insertRow(log);

        return guestbook;
    }

    @Override
    public int getCount() {
        return guestbookDao.selectCount();
    }
}