package sg.edu.np.mad.madpractical4;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        User user = new User("John Doe", "MAD Developer", 1, false);

        TextView tvName = findViewById(R.id.tvName);
        TextView tvDescription = findViewById(R.id.tvDescription);
        Button btnFollow = findViewById(R.id.btnFollow);

        if (user.isFollowed()) {
            btnFollow.setText("Unfollow");
        } else {
            btnFollow.setText("Follow");
        }

        btnFollow.setOnClickListener(view -> {
            user.setFollowed(!user.isFollowed());
            if (user.isFollowed()) {
                btnFollow.setText("Unfollow");
                Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_LONG).show();
            } else {
                btnFollow.setText("Follow");
                Toast.makeText(getApplicationContext(), "Unfollowed", Toast.LENGTH_LONG).show();
            }
        });

        Intent receivingEnd = getIntent();
        String message = receivingEnd.getStringExtra("User");
        tvName.setText("User " + message);
        tvDescription.setText(user.description);
        btnFollow.setText(user.isFollowed() ? "Unfollow" : "Follow");
    }
}
