package play.service;

import play.dto.Display;
import play.dto.UserComment;

import java.util.List;

public interface DisplayService {
    public List<Display> getDisplay(Integer displayId);
    public List<UserComment> getUserComment(Integer displayId);
    public String getAverageScore(List<UserComment> list);
}
