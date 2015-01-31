package emmano.me.swipe;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import emmano.me.swipe.service.GithubService;
import emmano.me.swipe.widget.StrikeThroughAdapter;
import retrofit.RestAdapter;
import rx.android.schedulers.AndroidSchedulers;


public class MainActivity extends Activity {

    @InjectView(R.id.list)
    protected ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint("https://api.github.com")
                .build();

        final GithubService githubService = adapter.create(GithubService.class);

        githubService.getStargazers()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(repoList -> listView.setAdapter(new StrikeThroughAdapter(repoList)));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
