package by.boiko.erizo.testdes.data.network;

import java.util.List;

import by.boiko.erizo.testdes.data.response.ResponseArticles;
import by.boiko.erizo.testdes.data.response.ResponseImages;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;

public interface ServiceNetwork {

    Observable<List<ResponseArticles>> getText();

    Observable<List<ResponseImages>> getImages();
}
