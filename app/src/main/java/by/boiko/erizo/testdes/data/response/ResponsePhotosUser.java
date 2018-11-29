package by.boiko.erizo.testdes.data.response;

import com.google.gson.annotations.SerializedName;

public class ResponsePhotosUser {

    @SerializedName("imageId")
    private String id;
    private String imageUrl;
    @SerializedName("likeCount")
    private int countLikes;

    public ResponsePhotosUser(String id, String imageUrl, int countLikes) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.countLikes = countLikes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getCountLikes() {
        return countLikes;
    }

    public void setCountLikes(int countLikes) {
        this.countLikes = countLikes;
    }
}
