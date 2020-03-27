package app.easylink.healthMonitor.Retrofit;


import java.util.List;

import app.easylink.healthMonitor.model.Post;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface IMyAPI {

   // String BASEURL="https://wuhan-coronavirus-api.laeyoung.endpoint.ainize.ai/";
    @GET("jhu-edu/latest")
    Observable<List<Post>> getPosts();


}
