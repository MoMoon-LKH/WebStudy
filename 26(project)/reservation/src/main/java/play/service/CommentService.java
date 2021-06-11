package play.service;
import org.springframework.web.multipart.MultipartFile;


public interface CommentService {
    public void setComment(int reservationId, double score, String comment, MultipartFile file);

}
