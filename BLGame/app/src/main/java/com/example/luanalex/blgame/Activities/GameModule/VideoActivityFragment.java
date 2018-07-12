package com.example.luanalex.blgame.Activities.GameModule;

import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.luanalex.blgame.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class VideoActivityFragment extends Fragment implements View.OnClickListener{

    private GridView memberV;

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
        memberV = (GridView)view.findViewById(R.id.list);
        memberV.setNumColumns(10);//总长度
        BaseAdapter adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return 10;
            }

            @Override
            public Object getItem(int i) {
                return null;
            }

            @Override
            public long getItemId(int i) {
                return 0;
            }


            @SuppressLint("ResourceAsColor")
            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                MemberC content = null;
                if (view == null){
                    content = new MemberC();
                    view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_member,null);
                    content.member_avator = view.findViewById(R.id.member);
                    content.textView = view.findViewById(R.id.content_t);
                    view.setTag(content);
                }else {
                    content = (MemberC)view.getTag();
                }
                content.textView.setText("index:"+i);
                return view;
            }
        };
        memberV.setAdapter(adapter);
        return view;
    }

    public class MemberC{
        public ImageView member_avator;
        public TextView textView;
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
