package play.dto;

import java.util.List;

public class ReservationInfo {
    private int id;
    private int productId;
    private int displayInfoId;
    private String reservationName;
    private String reservationTel;
    private String reservationEmail;
    private String reservationDate;
    private int cancelFlag;
    private String createDate;
    private String modifyDate;
    private List<ReservationPrice> prices;
    private Display display;


    public ReservationInfo(){

    }

    public ReservationInfo(ReservationUser user){
        this.id = user.getId();
        this.productId = user.getProductId();
        this.displayInfoId = user.getDisplayInfoId();
        this.reservationName = user.getReservationName();
        this.reservationTel = user.getReservationTel();
        this.reservationEmail = user.getReservationEmail();
        this.reservationDate = user.getReservationDate();
        this.cancelFlag = user.getCancelFlag();
        this.createDate = user.getCreateDate();
        this.modifyDate = user.getModifyDate();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getDisplayInfoId() {
        return displayInfoId;
    }

    public void setDisplayInfoId(int displayInfoId) {
        this.displayInfoId = displayInfoId;
    }

    public String getReservationName() {
        return reservationName;
    }

    public void setReservationName(String reservationName) {
        this.reservationName = reservationName;
    }

    public String getReservationTel() {
        return reservationTel;
    }

    public void setReservationTel(String reservationTel) {
        this.reservationTel = reservationTel;
    }

    public String getReservationEmail() {
        return reservationEmail;
    }

    public void setReservationEmail(String reservationEmail) {
        this.reservationEmail = reservationEmail;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    public int getCancelFlag() {
        return cancelFlag;
    }

    public void setCancelFlag(int cancelFlag) {
        this.cancelFlag = cancelFlag;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }

    public List<ReservationPrice> getPrices() {
        return prices;
    }

    public void setPrices(List<ReservationPrice> prices) {
        this.prices = prices;
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    @Override
    public String toString() {
        return "ReservationInfo{" +
                "id=" + id +
                ", productId=" + productId +
                ", displayInfoId=" + displayInfoId +
                ", reservationName='" + reservationName + '\'' +
                ", reservationTel='" + reservationTel + '\'' +
                ", reservationEmail='" + reservationEmail + '\'' +
                ", reservationDate='" + reservationDate + '\'' +
                ", cancelFlag=" + cancelFlag +
                ", createDate='" + createDate + '\'' +
                ", modifyDate='" + modifyDate + '\'' +
                ", prices=" + prices +
                ", display=" + display +
                '}';
    }
}
