package by.boiko.erizo.testdes.data.network;

import java.util.List;

import by.boiko.erizo.testdes.data.response.ResponseArticles;
import by.boiko.erizo.testdes.data.response.ResponseImages;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiMethods {

    @GET("posts")
    Observable<List<ResponseArticles>> getText(@Query("_limit") String limit);

    @GET("photos")
    Observable<List<ResponseImages>> getImages(@Query("_limit") String limit);
}
