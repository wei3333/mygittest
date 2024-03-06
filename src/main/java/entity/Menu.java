package entity;

public class Menu {
    private Integer id;
    private String name;
    private String icon;
    private String url;
    private Integer parentId;

    public Menu() {

    }

    public Menu(String name, String icon, String url, Integer parentId) {
        this.name = name;
        this.icon = icon;
        this.url = url;
        this.parentId = parentId;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }

    public String getUrl() {
        return url;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}