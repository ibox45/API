package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonPlaceHolderPojo {

    /*
    1) Tüm key'ler icin private variable'lar olusturuyoruz
    2) Tüm parametrelerle ve parametresiz constructor' larımızı olusturuyoruz.
    3) Getters ve Setters'larımızı olusturuyoruz
    4) toString() methodumuzu olusturuyoruz.
     */

    //1) Tüm key'ler icin private variable'lar olusturuyoruz
    private Integer userId;
    private String title;
    private Boolean completed;


    //2) Tüm parametrelerle ve parametresiz constructor' larımızı olusturuyoruz.

    public JsonPlaceHolderPojo(Integer userId, String title, Boolean completed) {
        this.userId = userId;
        this.title = title;
        this.completed = completed;
    }

    public JsonPlaceHolderPojo() {
    }

    //3) Getters ve Setters'larımızı olusturuyoruz

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    //4) toString() methodumuzu olusturuyoruz.

    @Override
    public String toString() {
        return "JsonPlaceHolderPojo{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }

    //Farklı key-value ikililerinin uyusmazlıgını @JsonIgnoreProperties(ignoreUnknown = true)
    //anotation'ını Pojo Class'ımızın basına yazarak cozebılırız.

}
