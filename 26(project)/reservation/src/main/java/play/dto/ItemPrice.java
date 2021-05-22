package play.dto;

public class ItemPrice {
    private int id;
    private String priceTypeName;
    private String price;
    private Double discountRate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Double discountRate) {
        this.discountRate = discountRate;
    }


    @Override
    public String toString() {
        return "ItemPrice{" +
                "id=" + id +
                ", priceTypeName='" + priceTypeName + '\'' +
                ", price='" + price + '\'' +
                ", discountRate=" + discountRate +
                '}';
    }
}
