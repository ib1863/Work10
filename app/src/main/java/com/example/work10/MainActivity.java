package com.example.work10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * The type Main activity.
 *
 * @author Idan Bunkin <idan.bunkin@gmail.com>
 * @version 1
 * @since 31 /01/2023 (the date of the package the class was added) 4 buttons with adb that each does something else
 */
public class MainActivity extends AppCompatActivity {
    /**
     * The Btn.
     */
    Button btn;
    /**
     * The Cl.
     */
    ConstraintLayout cl;
    /**
     * The Colors.
     */
    final String[] colors = {"Red", "Green", "Blue"};
    /**
     * The Color.
     */
    int[] color = new int[] {0, 0, 0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cl = (ConstraintLayout) findViewById(R.id.layoutC);
        btn = (Button) findViewById(R.id.button);


    }


    /**
     * Rgb.
     *
     * @param view the view
     */
    public void RGB(View view) {
        AlertDialog.Builder adb;

        adb = new AlertDialog.Builder(this);
        adb.setCancelable(false);
        adb.setTitle("Choose Color");
        adb.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                color[i] = 255;
                cl.setBackgroundColor(Color.rgb(color[0], color[1], color[2]));
                color[i] = 0;
            }
        });
        AlertDialog ad = adb.create();
        ad.show();
    }

    /**
     * Colors.
     *
     * @param view the view
     */
    public void Colors(View view) {
        AlertDialog.Builder adb;
        adb = new AlertDialog.Builder(this);
        adb.setCancelable(false);
        adb.setTitle("Choose Colors");
        adb.setMultiChoiceItems(colors, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                if(b)
                {
                    color[i] = 255;
                }
                else if(color[i] == 255)
                {
                    color[i] = 0;
                }

            }
        });
        adb.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                cl.setBackgroundColor(Color.rgb(color[0], color[1], color[2]));
            }
        });
        adb.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        color[0] = 0;
        color[1] = 0;
        color[2] = 0;
        AlertDialog ad = adb.create();
        ad.show();
    }

    /**
     * Reset.
     *
     * @param view the view
     */
    public void Reset(View view) {
        cl.setBackgroundColor(Color.rgb(255, 255, 255));
    }

    /**
     * Toast.
     *
     * @param view the view
     */
    public void Toast(View view) {
        AlertDialog.Builder adb;
        adb = new AlertDialog.Builder(this);
        adb.setCancelable(false);
        adb.setTitle("EditText widget");
        final EditText eT = new EditText(this);
        eT.setHint("type here");
        adb.setView(eT);
        adb.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String str = eT.getText().toString();
                Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
            }
        });
        adb.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog ad = adb.create();
        ad.show();
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        String st = item.getTitle().toString();
        if(st.equals("Credit Screen"))
        {
            Intent si = new Intent(this, MainActivity2.class);
            startActivity(si);
        }
        return true;
    }

}