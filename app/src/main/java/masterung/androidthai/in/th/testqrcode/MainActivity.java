package masterung.androidthai.in.th.testqrcode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.view.View;
import android.widget.Button;

import masterung.androidthai.in.th.testqrcode.fragment.MainFragment;
import masterung.androidthai.in.th.testqrcode.fragment.ScanActivity;

public class MainActivity extends AppCompatActivity {
    EditText qrvalue;
    Button genbtn;
    ImageView qrimg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn_scan = (Button)findViewById(R.id.btn_scan);
        btn_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ScanActivity.class);
                startActivity(intent);

            }
        });

        Button btn_fn2 = (Button)findViewById(R.id.btn_fn2);
        btn_fn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, fn2_Activity.class);
                startActivity(intent);
            }
        });


    }
}
