package id.go.jabarprov.bp2apd.bukusaku.activities;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.ExpandableListView;


import java.util.ArrayList;

import id.go.jabarprov.bp2apd.bukusaku.R;
import id.go.jabarprov.bp2apd.bukusaku.Settings;
import id.go.jabarprov.bp2apd.bukusaku.activities.cariindikator.HeaderInfo;
import id.go.jabarprov.bp2apd.bukusaku.activities.cariindikator.IndikatorListAdapter;
import id.go.jabarprov.bp2apd.bukusaku.models.cariindikator.HasilPencarian;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class CariIndikatorActivity extends AppCompatActivity {

    private ProgressDialog progressDialog;
    private String queryString;

    private ArrayList<HeaderInfo> SectionList = new ArrayList<>();

    private IndikatorListAdapter indikatorListAdapter;
    private ExpandableListView expandableListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cari_indikator);

        Toolbar cariIndikatorToolbar = (Toolbar) findViewById(R.id.cari_indikator_toolbar);
        setSupportActionBar(cariIndikatorToolbar);

        cariIndikatorToolbar.setTitle("cari indikator");

        SearchView searchView = (SearchView) findViewById(R.id.cari_indikator_search_view);

        EditText searchEditText = (EditText) searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);
        searchEditText.setTextColor(getResources().getColor(R.color.bp2PrimaryLight));
        searchEditText.setHintTextColor(getResources().getColor(R.color.bp2SearchHintText));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                if(queryString.length() > 2){

                    progressDialog = new ProgressDialog(CariIndikatorActivity.this);
                    progressDialog.setMessage("mencari...");
                    progressDialog.show();


                    Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(Settings.apiBukusakuURL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                    ApiService api = retrofit.create(ApiService.class);

                    Call<HasilPencarian> call = api.getJson(queryString);

                    System.out.println(" Call toString :" + call.toString());

                    call.enqueue(new Callback<HasilPencarian>() {

                        @Override
                        public void onResponse(Call<HasilPencarian> call, Response<HasilPencarian> response) {
                            System.out.println("koneksi berhasil");

                            System.out.println("Kata kunci : " + response.body().getKataKunciPencarian());


                            progressDialog.dismiss();
                        }

                        @Override
                        public void onFailure(Call<HasilPencarian> call, Throwable t) {
                            System.out.println("koneksi gagal " + t.getMessage());
                            progressDialog.dismiss();
                        }
                    });

                }else{
                    System.out.println("Minimal 3 huruf");
                }

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(newText.length()>2){
                    System.out.println("Mengetik");
                    queryString = newText;
                }else{
                    queryString = null;
                }
                return true;
            }
        });

        expandableListView = (ExpandableListView) findViewById(R.id.cari_indikator_list);
        indikatorListAdapter = new IndikatorListAdapter(CariIndikatorActivity.this,SectionList);

    }

    public interface ApiService{
        @GET("cari_indikator/{katakunci}")
        Call<HasilPencarian> getJson(@Path("katakunci") String katakunci);
    }
}



// http://stackoverflow.com/questions/31489109/android-searchview-in-toolbar
// http://stackoverflow.com/questions/19680223/android-support-library-searchview-xml-attributes-queryhint-and-iconifiedbydefau
// http://stackoverflow.com/questions/10535176/how-to-set-searchview-textsize


// https://www.codeproject.com/Articles/1151814/Android-ExpandablelistView-Tutorial-with-Android-C
// http://www.androidhive.info/2013/07/android-expandable-list-view-tutorial/