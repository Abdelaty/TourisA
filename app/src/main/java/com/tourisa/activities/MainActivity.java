package com.tourisa.activities;

import android.os.Bundle;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.tourisa.R;
import com.tourisa.adapters.AssestantAdapter;
import com.tourisa.models.Assesstant;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recommendedRecycler)
    RecyclerView recommendedRecycler;
    @BindView(R.id.topRecycler)
    RecyclerView topRecycler;
    AssestantAdapter assestantAdapter;
    List<Assesstant> recommended;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        recommended = new ArrayList<>();
        assestantAdapter = new AssestantAdapter(this, recommended);
        for (int i = 0; i < 10; i++) {

            Assesstant assesstant = new Assesstant();
            assesstant.setRate(5);
            assesstant.setDescription("Hello world \n Hello world \n Hello world \n Hello world \n Hello world \n ");
            assesstant.setName("Ahmed Mohamed");
            assesstant.setImage("http://blog.sight-management.com/wp-content/uploads/2015/02/juan_twinsforfashion-600x387.jpg");
            recommended.add(assesstant);
        }
        recommendedRecycler.setAdapter(assestantAdapter);
        topRecycler.setAdapter(assestantAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
