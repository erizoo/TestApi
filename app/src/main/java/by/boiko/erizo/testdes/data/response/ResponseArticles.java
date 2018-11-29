package by.boiko.erizo.testdes.data.response;

import com.google.gson.annotations.SerializedName;

public class ResponseArticles {

    @SerializedName("title")
    private String title;
    @SerializedName("body")
    private String body;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
