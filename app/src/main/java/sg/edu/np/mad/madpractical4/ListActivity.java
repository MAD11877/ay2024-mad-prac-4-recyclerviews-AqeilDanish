package sg.edu.np.mad.madpractical4;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageView icon = findViewById(R.id.icon);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Profile");
        builder.setMessage("MADness");
        builder.setCancelable(true);

        builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });

        builder.setNegativeButton("View", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                Log.d("ListActivity", "View button clicked, launching MainActivity");
                Random random = new Random();
                int min = 100000;
                int max = 999999;
                int randomNumber = random.nextInt((max - min) + 1) + min;
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                intent.putExtra("User", Integer.toString(randomNumber));
                startActivity(intent);
            }
        });

        icon.setOnClickListener(view -> {
            AlertDialog alert = builder.create();
            alert.show();
        });
    }
}

