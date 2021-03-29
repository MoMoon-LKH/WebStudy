
public class ToDo {
    private Long id;
    private String name;
    private String regData;
    private int sequence;
    private String title;
    private String type;

    public ToDo(Long id, String name, String regData, int sequence, String title, String type) {
        this.id = id;
        this.name = name;
        this.regData = regData;
        this.sequence = sequence;
        this.title = title;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegData() {
        return regData;
    }

    public void setRegData(String regData) {
        this.regData = regData;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", regData='" + regData + '\'' +
                ", sequence=" + sequence +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

