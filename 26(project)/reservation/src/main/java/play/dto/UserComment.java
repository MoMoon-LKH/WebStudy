package play.dto;

import java.util.Date;

public class UserComment {
    private int id;
    private int reservation__id;
    private String reservation_email;
    private String reservation_date;
    private Double score;
    private String comment;
    private String file_name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReservation__id() {
        return reservation__id;
    }

    public void setReservation__id(int reservation__id) {
        this.reservation__id = reservation__id;
    }

    public String getReservation_email() {
        return reservation_email;
    }

    public void setReservation_email(String reservation_email) {
        this.reservation_email = reservation_email;
    }

    public String getReservation_date() {
        return reservation_date;
    }

    public void setReservation_date(String reservation_date) {
        this.reservation_date = reservation_date;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    @Override
    public String toString() {
        return "UserComment{" +
                "id=" + id +
                ", reservation__id=" + reservation__id +
                ", reservation_email='" + reservation_email + '\'' +
                ", reservation_date='" + reservation_date + '\'' +
                ", score=" + score +
                ", comment='" + comment + '\'' +
                ", file_name='" + file_name + '\'' +
                '}';
    }
}
