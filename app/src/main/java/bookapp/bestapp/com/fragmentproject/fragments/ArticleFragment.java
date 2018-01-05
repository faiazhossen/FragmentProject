package bookapp.bestapp.com.fragmentproject.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import bookapp.bestapp.com.fragmentproject.MainInterface;
import bookapp.bestapp.com.fragmentproject.R;
import bookapp.bestapp.com.fragmentproject.activities.MainActivity;
import bookapp.bestapp.com.fragmentproject.adapters.ListViewAdapter;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ArticleFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class ArticleFragment extends Fragment implements MainInterface {

    private OnFragmentInteractionListener mListener;
    private ListView listView;
    private String[] names ={};
    private TextView textView;
    ArrayList<String> nameList = new ArrayList<>();

    public ArticleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_article, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listView = getActivity().findViewById(R.id.listView);
        textView = getActivity().findViewById(R.id.text_dummy);
        names = getResources().getStringArray(R.array.people_names);
        for(int i=0; i<names.length; i++){
            nameList.add(names[i]);
        }

        listView.setAdapter(new ListViewAdapter(nameList,getActivity()));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mListener.onItemClick(i,names[i]);
            }
        });

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void addItem(String item,Context context) {
        nameList.add(item);
        Toast.makeText(context, item, Toast.LENGTH_SHORT).show();

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);

        void onItemClick(int position, String name);
    }
}
