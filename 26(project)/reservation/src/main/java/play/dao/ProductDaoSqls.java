package play.dao;

public class ProductDaoSqls {
    public static final String SELECT_PRODUCTS = "select product.id, product.category_id, product.description, " +
            "product.content, display_info.place_name, file_info.file_name from product " +
            "join display_info on product.id = display_info.product_id " +
            "join product_image on product.id = product_image.product_id and product_image.type = 'th' " +
            "join file_info on product_image.file_id = file_info.id " +
            "order by product.id limit :start, :limit";

    public static final String SELECT_CATEGORY_PRODUCTS = "select product.id, product.category_id, product.description, " +
            "product.content, display_info.place_name, file_info.file_name from product " +
            "join display_info on product.id = display_info.product_id " +
            "join product_image on product.id = product_image.product_id and product_image.type = 'th' " +
            "join file_info on product_image.file_id = file_info.id " +
            "where category_id = :id order by product.id limit :start, :limit";
}
