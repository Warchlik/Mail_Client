package src.models;

public class Email {
    private String email;
    private String title;
    private String text;

    public Email(String email , String title , String text){
        this.email = email;
        this.title = title;
        this.text = text;
    }

    @Override
    public String toString() {
        return title.toUpperCase();
    }

    public String getText() {
        return text;
    }

    public String getTitle() {
        return title;
    }

    public String getEmail() {
        return email;
    }
}
