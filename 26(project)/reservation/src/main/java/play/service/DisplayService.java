package play.service;

import play.dto.Display;
import play.dto.ItemPrice;
import play.dto.UserComment;

import java.util.List;

public interface DisplayService {
    public List<Display> getDisplay(Integer displayId);
    public List<UserComment> getUserComment(Integer displayId);
    public String getAverageScore(List<UserComment> list);
    public List<String> getImages(Integer displayId);
    public String getMap(Integer displayId);
    public List<ItemPrice> getPrice(Integer displayId);
    public String getReservationDate();
}
