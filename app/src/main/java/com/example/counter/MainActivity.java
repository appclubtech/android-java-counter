package com.example.counter;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView counter;

    // Setting counter initial value to 0
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Finding the counter value view
        counter = findViewById(R.id.counting_value);

        // Setting value of counter to counter view
        updateUI();
    }

    // Increase counter value
    public void IncreaseValue(View view) {
        // Increasing Value
        count++;
        updateUI();
    }

    // If value greater than 0, decrease counter value
    public void DecreaseValue(View view) {
        // Checking if value is greater than 0
        if (count > 0) {
            count--;
            updateUI();
        } else {
            showToast(R.string.below_zero_err);
        }
    }

    // Set counter value to 0 if value is not 0
    public void ResetValue(View view) {
        if (count != 0) {
            count = 0;
            updateUI();
        } else {
            showToast(R.string.already_at_zero);
        }
    }

    // Helper function for setting text to counter view
    private void updateUI() {
        counter.setText(String.format(Locale.getDefault(), "%d", count));
    }

    // Helper function for showing Toast
    private void showToast(@StringRes int stringId) {
        Toast.makeText(this, stringId, Toast.LENGTH_SHORT).show();
    }

}
