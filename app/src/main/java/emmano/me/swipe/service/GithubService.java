package emmano.me.swipe.service;

import java.util.List;

import emmano.me.swipe.model.Repo;
import retrofit.http.GET;
import rx.Observable;

/**
 * Created by emmanuelortiguela on 1/31/15.
 */
public interface GithubService {
    
    @GET("/repos/emmano/scopes/stargazers")
    public Observable<List<Repo>> getStargazers();

}
