package play.dto;

import java.util.Date;

public class CommentEntity {
    private int productId;
    private int reservationInfoId;
    private double score;
    private String comment;
    private String createDate;
    private String modifyDate;

    public CommentEntity() {

    }

    public CommentEntity(int reservationInfoId, double score, String comment, String createDate, String modifyDate) {
        this.reservationInfoId = reservationInfoId;
        this.score = score;
        this.comment = comment;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getReservationInfoId() {
        return reservationInfoId;
    }

    public void setReservationInfoId(int reservationInfoId) {
        this.reservationInfoId = reservationInfoId;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

    @Override
    public String toString() {
        return "CommentEntity{" +
                "productId=" + productId +
                ", reservationInfoId=" + reservationInfoId +
                ", score=" + score +
                ", comment='" + comment + '\'' +
                ", createDate=" + createDate +
                ", modifyDate=" + modifyDate +
                '}';
    }
}
