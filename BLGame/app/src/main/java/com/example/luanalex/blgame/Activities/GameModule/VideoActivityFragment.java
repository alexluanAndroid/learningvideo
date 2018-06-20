package com.example.luanalex.blgame.Activities.GameModule;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.luanalex.blgame.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class VideoActivityFragment extends Fragment implements View.OnClickListener{

    public VideoActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video, container, false);
        view.findViewById(R.id.gift).setOnClickListener(this);
        view.findViewById(R.id.share).setOnClickListener(this);
        view.findViewById(R.id.message).setOnClickListener(this);
        view.findViewById(R.id.close).setOnClickListener(this);
        view.findViewById(R.id.send_message).setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        int clickid = view.getId();

        switch (clickid){
            case R.id.gift:
                FragmentGiftDialog.newInstance().show(this.getChildFragmentManager(),"dialog");
//                Toast.makeText(getActivity(),"gift clicked",Toast.LENGTH_LONG).show();
                break;
            case R.id.share:
                Toast.makeText(getActivity(),"share clicked",Toast.LENGTH_LONG).show();
                break;
            case R.id.message:
                Toast.makeText(getActivity(),"message clicked",Toast.LENGTH_LONG).show();
                break;
            case R.id.send_message:
                Toast.makeText(getActivity(),"send_message clicked",Toast.LENGTH_LONG).show();
                break;
            case R.id.close:
                Toast.makeText(getActivity(),"close clicked",Toast.LENGTH_LONG).show();
                break;
        }
    }
}
