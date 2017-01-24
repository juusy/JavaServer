package hello;

public class Money {

    private String id;
    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void removeSubstring(String str){
        if (getId().contains(str)) {
            int i = getId().indexOf(str);
            String s = getId().substring(0, i - 1) + getId().substring(i + str.length(), getId().length());
            setId(s);
        }
    }

}
