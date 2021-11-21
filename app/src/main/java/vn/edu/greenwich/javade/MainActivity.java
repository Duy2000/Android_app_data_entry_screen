package vn.edu.greenwich.javade;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Link to the layout
        setContentView(R.layout.activity_main);

        // Get the content to string "btnSubmit".
        String btnLoginName = getResources().getString(R.string.btn_login);

        String notification_01 = getResources().getString(R.string.notification_01);

        // Like "alert" in JavaScript.
        Toast.makeText(this, notification_01, Toast.LENGTH_LONG).show();

        // Get button "Login" from current Layout using id of button.
        Button btnLogin = findViewById(R.id.btnSubmit);
        // Set the name of the button.
        btnLogin.setText(btnLoginName);
        // Add an event "Click" to the button.
        btnLogin.setOnClickListener(btnLogin_Click);
    }

    private View.OnClickListener btnLogin_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Boolean isValid = true;
            TextView tvError = findViewById(R.id.tvError);
            TextView PropertyID = findViewById(R.id.PropertyID);
            TextView PriceID = findViewById(R.id.PriceID);
            TextView BedroomID = findViewById(R.id.BedroomID);
            TextView tvUsername = findViewById(R.id.tvUsername);
            TextView PhoneID = findViewById(R.id.PhoneID);


            String error = "";
            // Get content of texview property
            String property = PropertyID.getText().toString();
            // Get content of texview property
            String price = PriceID.getText().toString();
            // Get content of texview Bedroom
            String bedroom = BedroomID.getText().toString();
            // Get content of textview "Username".
            String username = tvUsername.getText().toString();
            // Get content of textview "Phone".
            String Phone = PhoneID.getText().toString();

            String notification_02 = getResources().getString(R.string.notification_02);

            // alert.
            Toast.makeText(v.getContext(), notification_02, Toast.LENGTH_LONG).show();
            // Check  empty or not.
            if (TextUtils.isEmpty(property)) {
                isValid = false;
                error += "* You need to enter information on the property!.\n";
            }
            // Check whether Price is empty or not.
            if (TextUtils.isEmpty(price)) {
                isValid = false;
                error += "* You need to enter information on the price!.\n";
            }
            // Check whether bedroom is empty or not.
            if (TextUtils.isEmpty(bedroom)) {
                isValid = false;
                error += "* You need to enter information on the bedroom!.\n";
            }

            // Check whether username is empty or not.
            if (TextUtils.isEmpty(username)) {
                isValid = false;
                error += "* You must declare your name.\n";
            }

            // Check whether password is empty or not.
            if (TextUtils.isEmpty(Phone)) {
                isValid = false;
                error += "* You need to enter the date of posting in the form.\n";
            }



            // Check whether form is valid or not.
            if (isValid) {
                // Show alerts.
                Toast.makeText(v.getContext(), property, Toast.LENGTH_LONG).show();
                Toast.makeText(v.getContext(), price, Toast.LENGTH_LONG).show();
                Toast.makeText(v.getContext(), bedroom, Toast.LENGTH_LONG).show();
                Toast.makeText(v.getContext(), username, Toast.LENGTH_LONG).show();
                Toast.makeText(v.getContext(), Phone, Toast.LENGTH_LONG).show();


                // Show logs.
                Log.w("Main Activity", "This is a Warning Log.");
                Log.i("Main Activity", "This is an Information Log.");
                Log.d("Main Activity", "This is a Debug Log.");
                Log.v("Main Activity", "This is a Verbose Log.");

                Bundle accountInfo = new Bundle();
                accountInfo.putString("property", property);
                accountInfo.putString("price", price);
                accountInfo.putString("bedroom", bedroom);
                accountInfo.putString("username", username);
                accountInfo.putString("date", Phone);


                // Create a new activity and start it.
                Intent testActivity = new Intent(v.getContext(), TestActivity.class);

                // method to transfer data.
                testActivity.putExtras(accountInfo);


                startActivity(testActivity);

                // Terminate current activity.
                finish();
            } else {
                // Display errors.
                tvError.setText(error);

                Log.e("Main Activity", error);
            }
        }
    };
}