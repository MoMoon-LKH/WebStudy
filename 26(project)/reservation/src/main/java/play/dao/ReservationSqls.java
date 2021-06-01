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

    public static final String SELECT_RESERVATION_INFO = "";
}
