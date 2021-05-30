package play.dao;

public class ReservationSqls {
    public static final String INSERT_RESERVATION_INFO =
            "insert into reservation_info (product_id, display_info_id, " +
                    "reservation_name, reservation_tel, reservation_email, reservation_date) " +
                    "values(:product_id, :display_info_id, :reservation_name, :reservation_tel, " +
                    ":reservation_date)";

    public static final String INSERT_RESERVATION_PRICE =
            "insert into reservation_info_price (reservation_info_id, product_price_id, count) " +
                    "values((select last_insert_id()), (select id from product_price where " +
                    "product_id = :productId and price_type_name = :priceType), :count) ";

    public static final String SELECT_PRODUCT_ID =
            "select product.id from display_info " +
                    "join product on product.id = display_info.product_id " +
                    "where display_info.id = :id";

    public static final String SELECT_RESERVATION_INFO = "";
}
