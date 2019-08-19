package web.blog.model;

public class Blog {
    private int id;
    private String title,post, introduce,content;

    public Blog() {
    }

    public Blog(int id, String title, String post, String introduct, String content) {
        this.id = id;
        this.title = title;
        this.post = post;
        this.introduce = introduct;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getIntroduct() {
        return introduce;
    }

    public void setIntroduct(String introduct) {
        this.introduce = introduct;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
