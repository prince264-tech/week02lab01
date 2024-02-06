package ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mylab01.R;


import data.MainViewModel;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding variableBinding;
    private MainViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        variableBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(variableBinding.getRoot());

        // setContentView(R.layout.activity_main);
        EditText myedit=findViewById(R.id.myedittext);
        Button mybutton=findViewById(R.id.mybutton);
        //TextView mytext= findViewById(R.id.textView);
        TextView mytext= variableBinding.textView;
        mybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String editTextContent = myedit.getText().toString();
                mytext.setText("Your Name Is: " + editTextContent);
            }
        });

        model = new ViewModelProvider(this).get(MainViewModel.class);

        model.isSelected.observe(this,selected->{
            variableBinding.chk1.setChecked(selected);
            variableBinding.rd1.setChecked(selected);
            variableBinding.swt1.setChecked(selected);
        });


        variableBinding.chk1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Respond to the checked state change
                if (isChecked) {
                    // Checkbox is checked
                    Toast.makeText(MainActivity.this, "Checkbox Checked", Toast.LENGTH_SHORT).show();
                } else {
                    // Checkbox is unchecked
                    Toast.makeText(MainActivity.this, "Checkbox Unchecked", Toast.LENGTH_SHORT).show();
                }
            }
        });

        variableBinding.rd1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Respond to the checked state change
                if (isChecked) {
                    // Checkbox is checked
                    Toast.makeText(MainActivity.this, "Radio Button Checked", Toast.LENGTH_SHORT).show();
                } else {
                    // Checkbox is unchecked
                    Toast.makeText(MainActivity.this, "Radio Button Unchecked", Toast.LENGTH_SHORT).show();
                }
            }
        });

        variableBinding.swt1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Respond to the checked state change
                if (isChecked) {
                    // Checkbox is checked
                    Toast.makeText(MainActivity.this, "Switch Checked", Toast.LENGTH_SHORT).show();
                } else {
                    // Checkbox is unchecked
                    Toast.makeText(MainActivity.this, "Switch Unchecked", Toast.LENGTH_SHORT).show();
                }
            }
        });

        variableBinding.imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get width and height of the ImageButton
                int width = view.getWidth();
                int height = view.getHeight();

                // Show Toast message with width and height
                Toast.makeText(MainActivity.this, "The width = " + width + " and height = " + height, Toast.LENGTH_SHORT).show();
            }
        });
        variableBinding.imageView.setOnClickListener(view -> {
            int width = view.getWidth();
            int height = view.getHeight();
            Toast.makeText(MainActivity.this, "The width = " + width + " and height = " + height, Toast.LENGTH_SHORT).show();
        });


    }
}