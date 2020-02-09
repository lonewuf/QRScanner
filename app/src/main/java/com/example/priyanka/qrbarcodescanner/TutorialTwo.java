package com.example.priyanka.qrbarcodescanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class TutorialTwo extends AppCompatActivity {

    private static Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_two);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_tutorial_two);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("SSS Village");

        findViewById(R.id.btn_next_two).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newItent = new Intent(TutorialTwo.this, TutorialThree.class);
                startActivity(newItent);
            }
        });

        findViewById(R.id.btn_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent intent;

        switch (item.getItemId()) {

            case R.id.action_admin:
                intent = new Intent(TutorialTwo.this, SelectYearActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_about:
                intent = new Intent(TutorialTwo.this, AboutActivity.class);
                startActivity(intent);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
