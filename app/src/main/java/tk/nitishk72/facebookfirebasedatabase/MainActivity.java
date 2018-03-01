package tk.nitishk72.facebookfirebasedatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText name, mobile;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        mobile = findViewById(R.id.mobile);
        b1 = findViewById(R.id.save);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Contacts");
                String n = name.getText().toString();
                String m = mobile.getText().toString();
                Map<String,String> data = new HashMap<>();
                data.put("Name",n);
                data.put("Mobile",m);
                String key = ref.push().getKey();
                ref.child(key).setValue(data);
                Log.e("Tag","Data inserted ID: "+key);
            }
        });
    }

}
