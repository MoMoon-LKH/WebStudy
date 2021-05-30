package play.dto;

public class ReservationPrice {
    String priceTypeName;
    String price;
    int count;

    @Override
    public String toString() {
        return "ReservationPrice{" +
                "priceTypeName='" + priceTypeName + '\'' +
                ", price='" + price + '\'' +
                ", count=" + count +
                '}';
    }

    public String getPriceTypeName() {
        return priceTypeName;
    }

    public void setPriceTypeName(String priceTypeName) {
        this.priceTypeName = priceTypeName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
