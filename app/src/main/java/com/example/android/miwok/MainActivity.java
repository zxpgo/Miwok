/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        //找到number目录对应的View
        TextView numbers = (TextView) findViewById(R.id.numbers);

        //将创建的实例附加到View
        numbers.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View View) {
                //创建一个intent来打开numberActivity
                Intent numberIntent = new Intent(MainActivity.this, NumbersActivity.class);
                //启动新创建的activity
                startActivity(numberIntent);
                }
        });

        //找到colors目录对应的View
        TextView colors = (TextView) findViewById(R.id.colors);

        //将创建的实例附加到View
        colors.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View View) {
                //创建一个intent来打开numberActivity
                Intent colorIntent = new Intent(MainActivity.this, ColorsActivity.class);
                //启动新创建的activity
                startActivity(colorIntent);
            }
        });

        //找到family目录对应的View
        TextView family = (TextView) findViewById(R.id.family);

        //将创建的实例附加到View
        family.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View View) {
                //创建一个intent来打开numberActivity
                Intent familyIntent = new Intent(MainActivity.this, FamilyActivity.class);
                //启动新创建的activity
                startActivity(familyIntent);
            }
        });

        //找到phrases目录对应的View
        TextView phrases = (TextView) findViewById(R.id.phrases);

        //将创建的实例附加到View
        phrases.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View View) {
                //创建一个intent来打开numberActivity
                Intent phrasesIntent = new Intent(MainActivity.this, PhrasesActivity.class);
                //启动新创建的activity
                startActivity(phrasesIntent);
            }
        });
    }

   /** public void openNumbersList(View View)
    {
        Intent numbersList = new Intent(this, NumbersActivity.class);
        startActivity(numbersList);
    }*/
}
