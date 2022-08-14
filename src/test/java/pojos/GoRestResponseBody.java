package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GoRestResponseBody {
    //1) Tüm key'ler icin private variable'lar olusturuyoruz
    private Object meta;
    private GoRestDataPojo data;
    //2) Tüm parametrelerle ve parametresiz constructor' larımızı olusturuyoruz.

    public GoRestResponseBody(Object meta, GoRestDataPojo data) {
        this.meta = meta;
        this.data = data;
    }

    public GoRestResponseBody() {
    }
    //3) Getters ve Setters'larımızı olusturuyoruz

    public Object getMeta() {
        return meta;
    }

    public void setMeta(Object meta) {
        this.meta = meta;
    }

    public GoRestDataPojo getData() {
        return data;
    }

    public void setData(GoRestDataPojo data) {
        this.data = data;
    }

    //4) toString() methodumuzu olusturuyoruz.

    @Override
    public String toString() {
        return "GoRestResponseBody{" +
                "meta=" + meta +
                ", data=" + data +
                '}';
    }
}
