/*
 * Copyright 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.example.android.bluetoothchat;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ViewAnimator;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.android.common.activities.SampleActivityBase;
import com.example.android.common.logger.Log;
import com.example.android.common.logger.LogFragment;
import com.example.android.common.logger.LogWrapper;
import com.example.android.common.logger.MessageOnlyLogFilter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A simple launcher activity containing a summary sample description, sample log and a custom
 * {@link Fragment} which can display a view.
 * <p>
 * For devices with displays with a width of 720dp or greater, the sample log is always visible,
 * on other devices it's visibility is controlled by an item on the Action Bar.
 */
public class MainActivity extends SampleActivityBase {

    public static final String TAG = "MainActivity";

    // Whether the Log Fragment is currently shown
    private boolean mLogShown;

    public static List<BagWord> bagOfWords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            BluetoothChatFragment fragment = new BluetoothChatFragment();
            transaction.replace(R.id.sample_content_fragment, fragment);
            transaction.commit();
        }

        bagOfWords = new ArrayList<>();
        bagOfWords.add(new BagWord("and", "duck"));
        bagOfWords.add(new BagWord("æble", "apple"));
        bagOfWords.add(new BagWord("bog", "book"));
        bagOfWords.add(new BagWord("bor", "live"));
        bagOfWords.add(new BagWord("bror", "brother"));
        bagOfWords.add(new BagWord("by", "city"));
        bagOfWords.add(new BagWord("citron", "lemon"));
        bagOfWords.add(new BagWord("cykel", "bike"));
        bagOfWords.add(new BagWord("dag", "day"));
        bagOfWords.add(new BagWord("de", "they"));
        bagOfWords.add(new BagWord("elsker", "love"));
        bagOfWords.add(new BagWord("fest", "party"));
        bagOfWords.add(new BagWord("fisk", "fish"));
        bagOfWords.add(new BagWord("frugt", "fruit"));
        bagOfWords.add(new BagWord("god", "good"));
        bagOfWords.add(new BagWord("goddag", "good day"));
        bagOfWords.add(new BagWord("grønstag", "vegetable"));
        bagOfWords.add(new BagWord("gul", "yellow"));
        bagOfWords.add(new BagWord("har", "have"));
        bagOfWords.add(new BagWord("hej", "hello"));
        bagOfWords.add(new BagWord("her", "here"));
        bagOfWords.add(new BagWord("hest", "horse"));
        bagOfWords.add(new BagWord("hjem", "home"));
        bagOfWords.add(new BagWord("huset", "house"));
        bagOfWords.add(new BagWord("hund", "dog"));
        bagOfWords.add(new BagWord("hvem", "who"));
        bagOfWords.add(new BagWord("hvid", "white"));
        bagOfWords.add(new BagWord("hvilken", "which"));
        bagOfWords.add(new BagWord("hvonår", "when"));
        bagOfWords.add(new BagWord("hygge", "cozy"));
        bagOfWords.add(new BagWord("I dag", "today"));
        bagOfWords.add(new BagWord("I morgen", "tomorrow"));
        bagOfWords.add(new BagWord("ingen", "no one"));
        bagOfWords.add(new BagWord("ja", "yes"));
        bagOfWords.add(new BagWord("jeg", "I"));
        bagOfWords.add(new BagWord("kat", "cat"));
        bagOfWords.add(new BagWord("kender", "know"));
        bagOfWords.add(new BagWord("klaver", "piano"));
        bagOfWords.add(new BagWord("ko", "cow"));
        bagOfWords.add(new BagWord("læser", "read"));
        bagOfWords.add(new BagWord("lukket", "closed"));
        bagOfWords.add(new BagWord("mad", "food"));
        bagOfWords.add(new BagWord("mælk", "milk"));
        bagOfWords.add(new BagWord("måske", "maybe"));
        bagOfWords.add(new BagWord("med", "with"));
        bagOfWords.add(new BagWord("min", "my"));
        bagOfWords.add(new BagWord("morgen", "morning"));
        bagOfWords.add(new BagWord("mus", "mouse"));
        bagOfWords.add(new BagWord("nat", "night"));
        bagOfWords.add(new BagWord("nej", "no"));
        bagOfWords.add(new BagWord("ny", "new"));
        bagOfWords.add(new BagWord("onkel", "uncle"));
        bagOfWords.add(new BagWord("ost", "cheese"));
        bagOfWords.add(new BagWord("sammen", "together"));
        bagOfWords.add(new BagWord("sjov", "funny"));
        bagOfWords.add(new BagWord("skole", "school"));
        bagOfWords.add(new BagWord("sort", "black"));
        bagOfWords.add(new BagWord("søster", "sister"));
        bagOfWords.add(new BagWord("stor", "big"));
        bagOfWords.add(new BagWord("tak", "thank you"));
        bagOfWords.add(new BagWord("tante", "aunt"));
        bagOfWords.add(new BagWord("tog", "train"));
        bagOfWords.add(new BagWord("undskyld", "sorry"));
        bagOfWords.add(new BagWord("vend", "friend"));

        // Make sublist
//        Collections.shuffle(bagOfWords);
//        bagOfWords = bagOfWords.subList(0, 5);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem logToggle = menu.findItem(R.id.menu_toggle_log);
        logToggle.setVisible(findViewById(R.id.sample_output) instanceof ViewAnimator);
        logToggle.setTitle(mLogShown ? R.string.sample_hide_log : R.string.sample_show_log);

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_toggle_log:
                mLogShown = !mLogShown;
                ViewAnimator output = findViewById(R.id.sample_output);
                if (mLogShown) {
                    output.setDisplayedChild(1);
                } else {
                    output.setDisplayedChild(0);
                }
                invalidateOptionsMenu();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Create a chain of targets that will receive log data
     */
    @Override
    public void initializeLogging() {
        // Wraps Android's native log framework.
        LogWrapper logWrapper = new LogWrapper();
        // Using Log, front-end to the logging chain, emulates android.util.log method signatures.
        Log.setLogNode(logWrapper);

        // Filter strips out everything except the message text.
        MessageOnlyLogFilter msgFilter = new MessageOnlyLogFilter();
        logWrapper.setNext(msgFilter);

        // On screen logging via a fragment with a TextView.
        LogFragment logFragment = (LogFragment) getSupportFragmentManager()
                .findFragmentById(R.id.log_fragment);
        msgFilter.setNext(logFragment.getLogView());

        Log.i(TAG, "Ready");
    }
}
