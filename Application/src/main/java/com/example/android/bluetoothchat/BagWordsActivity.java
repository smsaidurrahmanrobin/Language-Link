package com.example.android.bluetoothchat;

import android.app.Activity;
import android.os.BadParcelableException;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.widget.ListView;
import android.widget.ArrayAdapter;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class BagWordsActivity extends Activity {
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Setup the window
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_bag_words);

        // Set result CANCELED in case the user backs out
        setResult(Activity.RESULT_CANCELED);

        ArrayAdapter<String> bagOfWordsAdapter = new ArrayAdapter<>(this, R.layout.word);
        ArrayList<String> bagOfWords = new ArrayList<>();
        for (BagWord word : MainActivity.bagOfWords) {
            bagOfWords.add(word.toString());
        }
        bagOfWordsAdapter.addAll(bagOfWords);

        ListView wordsList = findViewById(R.id.words_list);
        wordsList.setAdapter(bagOfWordsAdapter);
    }
}
