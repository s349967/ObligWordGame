package com.example.obligwordgame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

    }


    protected void setup(){
        Button continueKnapp    =(Button)findViewById(R.id.continueKnapp);
        Button newgameKnapp     =(Button)findViewById(R.id.newgameKnapp);
        Button rulesKnapp       =(Button)findViewById(R.id.rulesKnapp);
        Button allSolutionKnapp =(Button)findViewById(R.id.allsolutionsKnapp);
        Button wordsFoundKnapp   =(Button)findViewById(R.id.wordsfoundKnapp);
        Button changeifficultyKnapp =(Button)findViewById(R.id.changeifficultyKnapp);

        continueKnapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent playIntent = new Intent(MainActivity.this,PlayActivity.class);
                startActivity(playIntent);
            }
        });
        newgameKnapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent playIntent = new Intent(MainActivity.this,PlayActivity.class);
                SharedPreferences.Editor editor = getSharedPreferences(getPackageName(), MODE_PRIVATE).edit();
                editor.putInt("points", 0).apply();
                editor.putStringSet("solutionsFound",new HashSet<String>()).apply();
                startActivity(playIntent);
            }
        });
        rulesKnapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rulesIntent = new Intent(MainActivity.this,RulesActivity.class);
                startActivity(rulesIntent);
            }
        });
        allSolutionKnapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent allSolutionsIntent = new Intent(MainActivity.this,AllSolutionsActivity.class);
                startActivity(allSolutionsIntent);
            }
        });
        wordsFoundKnapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent wordsFoundIntent = new Intent(MainActivity.this,WordFoundActivity.class);
                startActivity(wordsFoundIntent);
            }
        });
        changeifficultyKnapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent changedifficultyIntent = new Intent(MainActivity.this,ChangeDifficultyActivity.class);
                startActivity(changedifficultyIntent);
            }
        });


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);

                setContentView(R.layout.activity_main);
                setup();



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater(); inflater.inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                Intent homeIntent = new Intent(MainActivity.this, PlayActivity.class);
                startActivity(homeIntent);
                return true;
            case R.id.allsolutions:

                return true;
            case R.id.wordsfound:
                Intent wordsfoundIntent = new Intent(MainActivity.this,WordFoundActivity.class);
                startActivity(wordsfoundIntent);
                return true;
            case android.R.id.home:
                finish();
                return true;
            case R.id.changeDifficulty:
                Intent changedifficultyIntent = new Intent(MainActivity.this,ChangeDifficultyActivity.class);
                startActivity(changedifficultyIntent);
                return true;

            case R.id.rules:
                Intent rulesIntent = new Intent(MainActivity.this,RulesActivity.class);
                startActivity(rulesIntent);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }


}