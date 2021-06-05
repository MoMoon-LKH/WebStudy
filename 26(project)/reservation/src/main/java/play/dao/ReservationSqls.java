package play.dao;

public class ReservationSqls {

    public static final String INSERT_RESERVATION_PRICE =
            "insert into reservation_info_price (reservation_info_id, product_price_id, count) " +
                    "values( :reservation_info_id, :product_price_id, :count)";

    public static final String SELECT_PRODUCT_ID =
            "select product.id from display_info " +
                    "join product on product.id = display_info.product_id " +
                    "where display_info.id = :id";
    public static final String SELECT_PRODUCT_PRICE_ID =
            "select id from product_price " +
                    "where product_id = :product_id and price_type_name = :price_type";

    public static final String SELECT_RESERVATION_USER =
            "select id, product_id, display_info_id, reservation_name, reservation_tel, " +
                    "reservation_email, reservation_date, cancel_flag, create_date, modify_date " +
                    "from reservation_info where reservation_email = :email";

    public static final String SELECT_RESERVATION_PRICE =
            "select product_price.price_type_name, product_price.price, reservation_info_price.count " +
                    "from reservation_info " +
                    "join reservation_info_price on reservation_info.id = reservation_info_price.reservation_info_id " +
                    "join product_price on reservation_info_price.product_price_id = product_price.id " +
                    "where reservation_info.id = :id";

    public static final String SELECT_RESERVATION_EMAIL =
            "select distinct reservation_email from reservation_info " +
                    "where reservation_email = :email";

    public static final String UPDATE_CANCEL_FLAG =
            "update reservation_info set cancel_flag = 1 where id = :id";
}
