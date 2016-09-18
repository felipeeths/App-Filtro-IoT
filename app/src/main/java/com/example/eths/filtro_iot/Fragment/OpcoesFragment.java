package com.example.eths.filtro_iot.Fragment;

import android.content.Context;
import android.content.res.ObbInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.eths.filtro_iot.R;
import com.example.eths.filtro_iot.bo.MQTTop;


public class OpcoesFragment extends Fragment {

    View rootView;
    private OnOpcoesFragmentInteractionListener mListener;

    public OpcoesFragment() {
        // Required empty public constructor
    }


    public static OpcoesFragment newInstance() {
        OpcoesFragment fragment = new OpcoesFragment();
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
        rootView = inflater.inflate(R.layout.fragment_settings, container, false);
        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onOpcoesFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnOpcoesFragmentInteractionListener) {
            mListener = (OnOpcoesFragmentInteractionListener) context;
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
    public interface OnOpcoesFragmentInteractionListener {
        // TODO: Update argument type and name
        void onOpcoesFragmentInteraction(Uri uri);
    }
}
