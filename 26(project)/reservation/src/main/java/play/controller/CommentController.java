package play.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import play.service.CommentService;
import play.service.ReservationService;

import java.io.File;

@Controller
public class CommentController {

    @Autowired
    CommentService commentService;

    @Autowired
    ReservationService reservationService;

    @PostMapping("/commentForm")

    public String commentForm(@RequestParam(name = "description") String description,
                              @RequestParam(name = "id") int reservationId,
                              ModelMap model) {
        model.addAttribute("description", description);
        model.addAttribute("reservationId", reservationId);
        return "commentForm";
    }

    @PostMapping("/commentUpload")
    public String upload(@RequestParam(name = "reservationId") int id,
                         @RequestParam(name = "score") double score,
                         @RequestParam(name = "comment") String comment,
                         @RequestParam(name = "file") MultipartFile file,
                         @CookieValue(value = "email") String email,
                         ModelMap model) {


        try {
            commentService.setComment(id,score,comment,file);
            if (file.getContentType() == "image/png" || file.getContentType() == "image/jpg") {
                file.transferTo(new File("c:/MyProject/WebStudy/26(project)/reservation/src/main/webapp/img/" + file.getOriginalFilename()));
            }
        } catch (Exception exception) {
            throw new RuntimeException("file save error");
        }

        model.addAttribute("email", email);
        return "myReservation";
    }

}
