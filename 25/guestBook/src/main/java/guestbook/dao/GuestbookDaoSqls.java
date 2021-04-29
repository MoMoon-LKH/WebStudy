package guestbook.dao;

public class GuestbookDaoSqls {
    public static final String SELECT_PAGING = "SELECT id, name, content, regdate FROM guestbook ORDER BY id DESC limit :start, :limit";
    public static final String DELETE_BY_ID = "delete from guestbook where id = :id";
    public static final String SELECT_COUNT = "select count(*) from guestbook";


}
