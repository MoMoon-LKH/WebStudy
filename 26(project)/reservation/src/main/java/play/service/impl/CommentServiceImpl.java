package play.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import play.dao.CommentDao;
import play.dao.FileDao;
import play.dao.ReservationDao;
import play.dto.CommentEntity;
import play.dto.FileEntity;
import play.service.CommentService;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentDao commentDao;

    @Autowired
    FileDao fileDao;

    @Autowired
    ReservationDao reservationDao;

    @Override
    public void setComment(int reservationId, double score, String comment, MultipartFile file) {
        int productId = reservationDao.getProductId(reservationId);
        List<String> date = reservationDao.dateSet();

        CommentEntity commentEntity = new CommentEntity(reservationId, score, comment, date.get(0), date.get(1));
        int commentId = commentDao.insertComment(commentEntity, productId);
        if(file.getContentType() == "image/png" || file.getContentType() == "image/jpg") {
            int file_id = fileDao.insertFile(file, date.get(0), date.get(1));
            commentDao.insertCommentImage(reservationId, commentId, file_id);
        }
    }
}
