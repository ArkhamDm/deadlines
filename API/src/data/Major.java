package data;

import java.io.Serializable;

public class Major implements Serializable {
    private String id;
    private String name;
    private boolean is_exam;

    public void setName(String name) {
        this.name = name;
    }

    public void setIs_exam(boolean is_exam) {
        this.is_exam = is_exam;
    }

    public String getName() {
        return name;
    }

    public boolean isIs_exam() {
        return is_exam;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
