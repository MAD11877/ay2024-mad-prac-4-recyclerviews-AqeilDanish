package sg.edu.np.mad.madpractical4;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Initialize a new User object
        User user = new User("John Doe", "MAD Developer",1,false);

        // Get the TextViews and buttons from the layout
        TextView tvName = findViewById(R.id.tvName);
        TextView tvDescription = findViewById(R.id.tvDescription);
        Button btnFollow = findViewById(R.id.btnFollow);

        // Set button text based on the followed status
        if (user.isFollowed()) {
            btnFollow.setText("Unfollow");
        } else {
            btnFollow.setText("Follow");
        }

        // Set onClickListener for the Follow button
        btnFollow.setOnClickListener(view -> {
            // Toggle the followed status
            user.setFollowed(!user.isFollowed());
            // Update the button text based on the new followed status
            if (user.isFollowed()) {
                btnFollow.setText("Unfollow");
                Toast t = Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_LONG);
                t.show();
            } else {
                btnFollow.setText("Follow");
                Toast t = Toast.makeText(getApplicationContext(), "Unfollowed", Toast.LENGTH_LONG);
                t.show();
            }
        });
        //Set the TextViews with the user's name, description and default button messgae
        tvName.setText(user.name);
        tvDescription.setText(user.description);
        btnFollow.setText("Follow");
    }
}