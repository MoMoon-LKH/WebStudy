package play.dao;

public class DisplaySqls {
    public static final String SELECT_DISPLAY = "select display_info.id, product.description, product.content, " +
            "product.event, display_info.place_name, display_info.opening_hours, display_info.place_lot, display_info.place_street, " +
            "display_info.tel from product " +
            "join display_info on product.id = display_info.product_id " +
            "where display_info.id = :id";

    public static final String SELECT_COMMENT = "select reservation_user_comment.id, concat(left(reservation_info.reservation_email,4), '****') as reservation_email, " +
            "DATE_FORMAT(reservation_info.reservation_date, '%Y.%m.%d') as reservation_date, reservation_user_comment.score, reservation_user_comment.comment, " +
            "file_info.file_name from display_info " +
            "join reservation_info on display_info.id = reservation_info.display_info_id " +
            "join reservation_user_comment on reservation_info.id = reservation_user_comment.reservation_info_id " +
            "join reservation_user_comment_image on reservation_user_comment.id = reservation_user_comment_id " +
            "join file_info on reservation_user_comment_image.file_id = file_info.id " +
            "where display_info.id = :id";

    public static final String SELECT_IMAGES = "select file_info.file_name from display_info " +
            "join product on product.id = display_info.product_id " +
            "join product_image on product_image.product_id = product.id " +
            "join file_info on file_info.id = product_image.file_id " +
            "where display_info.id = :id order by type != 'ma'";

    public static final String SELECT_MAP_IMAGE = "select file_info.file_name from display_info " +
            "join display_info_image on display_info_image.display_info_id = display_info.id " +
            "join file_info on display_info_image.file_id = file_info.id " +
            "where display_info.id = :id";

    public static final String SELECT_PRICE = "select product_price.id, product_price.price_type_name, " +
            "product_price.price , product_price.discount_rate from display_info " +
            "join product on display_info.product_id = product.id " +
            "join product_price on product.id = product_price.product_id " +
            "where display_info.id = :id";

    /*public static final String SELECT_COUNT = "select reservation_info_price.count from display_info " +
            "join reservation_info on reservation_info.display_info_id = display_info.id " +
            "join reservation_info_price on reservation_info_price.reservation_info_id = " +
            "reservation_info.id where display_info.id = :id";*/
}
