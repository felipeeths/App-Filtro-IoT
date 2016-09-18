package com.example.eths.filtro_iot.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.eths.filtro_iot.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FiltroFragment.OnFiltroFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FiltroFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FiltroFragment extends Fragment {


    private OnFiltroFragmentInteractionListener mListener;

    public FiltroFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static FiltroFragment newInstance() {
        FiltroFragment fragment = new FiltroFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_filtro, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFiltroFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFiltroFragmentInteractionListener) {
            mListener = (OnFiltroFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFiltroFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFiltroFragmentInteraction(Uri uri);
    }
}
