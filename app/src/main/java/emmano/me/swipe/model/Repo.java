package emmano.me.swipe.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by emmanuelortiguela on 1/31/15.
 */
public class Repo {

    private String login;

    @SerializedName("avatar_url")
    private String avatarUrl;

    public String getLogin() {
        return login;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

}
