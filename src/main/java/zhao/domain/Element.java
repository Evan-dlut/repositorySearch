package zhao.domain;

/**
 * Created by Evan on 2015/5/31.
 */
public class Element {
    private Long id;
    private String description;
    private Long classId;
    private TYPE type;

    public enum TYPE{
        constructor,
        variable,
        function
    }

    public TYPE getType() {
        return type;
    }

    public void setType(TYPE type) {
        this.type = type;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
