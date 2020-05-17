package app.easylink.healthMonitor.Retrofit;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.ListView;
import java.util.List;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import app.easylink.healthMonitor.R;
import app.easylink.healthMonitor.model.Post;
import app.easylink.healthMonitor.model.PostAdapteer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;


public class RetrofitActivity extends AppCompatActivity {

    ListView mListView1;
    ListView mListView2;
    PostAdapteer adapteer;
    IMyAPI myAPI;
    RecyclerView recyler_posts;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    ProgressDialog progressBar;

    //calliing Retrofit Api
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retrofit_activity);

        progressBar = new ProgressDialog(this);
        progressBar.setMessage("Loading....");
        progressBar.show();


        //calliing Retrofit Api
        Retrofit retrofit=RetrofitClient.getInstance();
        myAPI=retrofit.create(IMyAPI.class);
        recyler_posts=(RecyclerView)findViewById(R.id.recycler_posts);
        recyler_posts.setHasFixedSize(true);
        recyler_posts.setLayoutManager(new LinearLayoutManager( this));
        ConnectivityManager cm =
                (ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        if(isConnected == true){
            fetchDat();
        }
        else {
            finish();
        }

    }

    private void fetchDat() {
        compositeDisposable.add(myAPI.getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Post>>() {
                    @Override
                    public void accept(List<Post> posts) throws Exception {
                        progressBar.dismiss();
                        displayData(posts);
                    }
                }));

    }

    //for Searching Value from GSON Files
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R. menu.filter_menu, menu);
        MenuItem searchItem = menu.findItem(R. id.action_search);
        SearchView searchView = (SearchView)
                searchItem.getActionView();
        searchView.setIconifiedByDefault(true);
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
       // SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                adapteer.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
               // adapter.getFilter().filter(newText);
                // filter recycler view when query submitted
                adapteer.getFilter().filter(newText);
                return false;
            }


        });
        return true;
    }


    private void displayData(List<Post> posts) {
        adapteer=new PostAdapteer(this,posts);
        recyler_posts.setAdapter(adapteer);

    }

    @Override
    protected void onStop() {
        compositeDisposable.clear();
        super.onStop();
    }



    }



