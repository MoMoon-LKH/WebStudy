package play.dao;

public class DisplaySqls {
    public static final String SELECT_DISPLAY = "select display_info.id, product.description, product.content, " +
            "product.event, display_info.place_name, display_info.place_lot, display_info.place_street, " +
            "display_info.tel from product " +
            "join display_info on product.id = display_info.product_id " +
            "where display_info.id = :id";

    public static final String SELECT_COMMENT = "select reservation_user_comment.id, reservation_info.reservation_email, " +
            "reservation_info.reservation_date, reservation_user_comment.score, reservation_user_comment.comment, " +
            "file_info.file_name from display_info " +
            "join reservation_info on display_info.id = reservation_info.display_info_id " +
            "join reservation_user_comment on reservation_info.id = reservation_user_comment.reservation_info_id " +
            "join reservation_user_comment_image on reservation_user_comment.id = reservation_user_comment_id " +
            "join file_info on reservation_user_comment_image.file_id = file_info.id " +
            "where display_info.id = :id";
}
