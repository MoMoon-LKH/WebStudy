package play.dao;

public class CommentSql {
    public static final String INSERT_IMAGE = " insert into reservation_user_comment_image" +
            "(reservation_info_id, reservation_user_comment_id, file_id) " +
            " value(:reservationId, :commentId, :fileId)";
}
