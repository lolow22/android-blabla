package fr.wildcodeschool.quete;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        CheckBox check = findViewById(R.id.checkBox_yes);
        check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                EditText editfirstname = findViewById(R.id.edit_firstname);
                String firstname = editfirstname .getText().toString();
                EditText editlastname = findViewById(R.id.edit_lastname);
                String lastname = editlastname .getText().toString();
                Button buttonlogin = findViewById(R.id.button_accept);
                if (isChecked) {
                    editlastname.setEnabled(true);
                    editfirstname.setEnabled(true);
                    buttonlogin.setEnabled(true);
                }
                else {
                    editlastname.setEnabled(false);
                    editfirstname.setEnabled(false);
                    buttonlogin.setEnabled(false);

                }

            }
        });

        Button buttonlogin = findViewById(R.id.button_accept);
        buttonlogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                EditText editfirstname = findViewById(R.id.edit_firstname);
                String firstname = editfirstname .getText().toString();
                EditText editlastname = findViewById(R.id.edit_lastname);
                String lastname = editlastname .getText().toString();
                if (lastname.length()==0) {
                    Toast.makeText(MainActivity.this, "Please fill your firstname and lastname!", Toast.LENGTH_SHORT).show();
                }
                else {
                    TextView textinvisible = findViewById(R.id.invisbletext);
                    textinvisible.setVisibility(View.VISIBLE);
                    final TextView textViewToChange = (TextView) findViewById(R.id.invisbletext);
                    textViewToChange.setText(
                            "Congratulations " + lastname + " " + firstname);
                }

            }
        });
    }
}
