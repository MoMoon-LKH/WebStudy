package play.dto;

public class Item {
    private int id;
    private int category_id;
    private String description;
    private String content;
    private String placeName;
    private String fileName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getDescription() {
        return description;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", category_id=" + category_id +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", placeName='" + placeName + '\'' +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
