package bookapp.bestapp.com.fragmentproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

import bookapp.bestapp.com.fragmentproject.R;

/**
 * Created by FAIAZ on 1/5/2018.
 */

public class ListViewAdapter extends BaseAdapter {
    ArrayList<String> mNames;
    Context mContext;

    public ListViewAdapter(ArrayList<String> names, Context context){
        mNames = names;
        mContext = context;
    }
    @Override
    public int getCount() {
        return mNames.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView = null;
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.single_row,null);
            textView= view.findViewById(R.id.id_name);
        }
        textView.setText(mNames.get(i));
        return view;
    }
}
