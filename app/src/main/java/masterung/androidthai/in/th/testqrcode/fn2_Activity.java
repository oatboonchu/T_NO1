package masterung.androidthai.in.th.testqrcode;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.File;
import java.io.FileOutputStream;

public class fn2_Activity extends AppCompatActivity {
    EditText qrvalue;
    Button genbtn,download;
    ImageView qrimg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fn2_);
        qrvalue = findViewById(R.id.editTextTextPersonName);
        genbtn = findViewById(R.id.button);
        qrimg = findViewById(R.id.imageView);
        download = findViewById(R.id.button3);
        Button back = (Button)findViewById(R.id.button2);

        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(fn2_Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
    private void save(){
        BitmapDrawable bitmapDrawable = (BitmapDrawable)qrimg.getDrawable();
        Bitmap bitmap = bitmapDrawable.getBitmap();
        FileOutputStream outputStream = null;
        File file = Environment.getExternalStorageDirectory();
        File dir = new File(file.getAbsolutePath()+"/MyPics");
        dir.mkdirs();

        String filename = String.format("%d.png",System.currentTimeMillis());
    }
    public void QRCodeButton(View v){
        QRCodeWriter qrCodeWriter = new QRCodeWriter();

        try {
            BitMatrix bitMatrix = qrCodeWriter.encode(qrvalue.getText().toString(), BarcodeFormat.QR_CODE,200,200);
            Bitmap bitmap = Bitmap.createBitmap(200,200,Bitmap.Config.RGB_565);
            for (int x =0;x<200;x++){
                for (int y=0;y<200;y++){
                    bitmap.setPixel(x,y,bitMatrix.get(x,y)? Color.BLACK :Color.WHITE);
                }
            }

            qrimg.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }



}