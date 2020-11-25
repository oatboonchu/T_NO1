package masterung.androidthai.in.th.testqrcode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import masterung.androidthai.in.th.testqrcode.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {
    EditText qrvalue;
    Button genbtn;
    ImageView qrimg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentMainFragment, new MainFragment()).commit();
        }

    }
}
