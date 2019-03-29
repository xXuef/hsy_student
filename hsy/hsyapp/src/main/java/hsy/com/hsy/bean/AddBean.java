package hsy.com.hsy.bean;

public class AddBean {
    Integer icon;
    String name;
    Boolean state;

    public AddBean(Integer icon, String name, Boolean state) {
        this.icon = icon;
        this.name = name;
        this.state = state;
    }

    public boolean isState() {
        return state;
    }

    public Integer getIcon() {
        return icon;
    }

    public void setIcon(Integer icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }


}
