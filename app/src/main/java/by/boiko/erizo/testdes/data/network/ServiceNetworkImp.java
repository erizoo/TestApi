package by.boiko.erizo.testdes.data.network;

import java.util.List;

import javax.inject.Inject;

import by.boiko.erizo.testdes.data.response.ResponseArticles;
import by.boiko.erizo.testdes.data.response.ResponseImages;
import io.reactivex.Observable;


public class ServiceNetworkImp implements ServiceNetwork {

    private ApiMethods apiMethods;
    private static final String LIMIT = "10";

    @Inject
    public ServiceNetworkImp(ApiMethods apiMethods) {
        this.apiMethods = apiMethods;
    }


    @Override
    public Observable<List<ResponseArticles>> getText() {
        return apiMethods.getText(LIMIT);
    }

    @Override
    public Observable<List<ResponseImages>> getImages() {
        return apiMethods.getImages(LIMIT);
    }
}
