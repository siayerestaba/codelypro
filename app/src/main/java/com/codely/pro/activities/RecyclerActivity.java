package com.codely.pro.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.codely.pro.R;
import com.codely.pro.adapters.CourseAdapter;
import com.codely.pro.model.Course;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Perez on 05/03/2018.
 */

public class RecyclerActivity extends Activity {

    private List<Course> courses;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler);

        courses = initObjectList();

        mRecyclerView = findViewById(R.id.recyclerlist);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setHasFixedSize(true);

        CourseAdapter adapter = new CourseAdapter(this, courses);
        adapter.setOnClickListener(listListener);
        mRecyclerView.setAdapter(adapter);
    }

    private View.OnClickListener listListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Course item = courses.get(mRecyclerView.getChildAdapterPosition(view));
            showSelected(item);
        }
    };

    public void showSelected(Course item) {
        Intent mainIntent = new Intent(RecyclerActivity.this, DetailActivity.class);
        startActivity(mainIntent);
        overridePendingTransition(0, 0);
    }

    private List<Course> initObjectList() {
        List<Course> listViewItems = new ArrayList<>();
        String[] titles = getResources().getStringArray(R.array.courses_titles);
        String[] authors = getResources().getStringArray(R.array.courses_authors);

        for (int i = 0; i < titles.length; i++) {
            int id = getResources().getIdentifier("codely_" + i, "mipmap", getPackageName());
            listViewItems.add(new Course(titles[i], id, authors[i]));
        }

        return listViewItems;
    }


}

