package by.boiko.erizo.testdes.data.response;

import java.util.List;

public class ResponseInfo {

    private List<ResponseArticles> responseArticles;
    private List<ResponseImages> responseImages;

    public ResponseInfo() {
    }

    public ResponseInfo(List<ResponseArticles> responseArticles, List<ResponseImages> responseImages) {
        this.responseArticles = responseArticles;
        this.responseImages = responseImages;
    }

    public List<ResponseArticles> getResponseArticles() {
        return responseArticles;
    }

    public void setResponseArticles(List<ResponseArticles> responseArticles) {
        this.responseArticles = responseArticles;
    }

    public List<ResponseImages> getResponseImages() {
        return responseImages;
    }

    public void setResponseImages(List<ResponseImages> responseImages) {
        this.responseImages = responseImages;
    }
}
