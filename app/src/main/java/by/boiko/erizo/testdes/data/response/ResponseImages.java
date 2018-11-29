package by.boiko.erizo.testdes.data.response;

import com.google.gson.annotations.SerializedName;

public class ResponseImages {

    @SerializedName("thumbnailUrl")
    private String smallImage;
    @SerializedName("url")
    private String bigImage;

    public String getSmallImage() {
        return smallImage;
    }

    public void setSmallImage(String smallImage) {
        this.smallImage = smallImage;
    }

    public String getBigImage() {
        return bigImage;
    }

    public void setBigImage(String bigImage) {
        this.bigImage = bigImage;
    }
}
