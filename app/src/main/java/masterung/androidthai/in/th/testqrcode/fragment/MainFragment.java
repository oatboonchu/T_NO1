package masterung.androidthai.in.th.testqrcode.fragment;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.Result;

import masterung.androidthai.in.th.testqrcode.R;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

/**
 * Created by masterung on 12/3/2018 AD.
 */

public class MainFragment extends Fragment{

    private ZXingScannerView zXingScannerView;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        QR scan Controller
        Button button = getView().findViewById(R.id.btnQRscan);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                zXingScannerView = new ZXingScannerView(getActivity());
                getActivity().setContentView(zXingScannerView);
                zXingScannerView.startCamera();

                zXingScannerView.setResultHandler(new ZXingScannerView.ResultHandler() {
                    @Override
                    public void handleResult(Result result) {

                        zXingScannerView.stopCamera();
                        getActivity().setContentView(R.layout.activity_main);
                        String resultString = result.getText().toString();
                        Toast.makeText(getActivity(), "QR code = " + resultString,
                                Toast.LENGTH_LONG).show();
                        Log.d("12MarchV1", "QR code ==> " + resultString);
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.contentMainFragment, new MainFragment()).commit();

                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(resultString));
                        startActivity(browserIntent);
                    }
                });

            }
        });


    }   // Main Method



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        return view;
    }


}
