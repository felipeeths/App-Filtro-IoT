package com.example.eths.filtro_iot.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;

import com.example.eths.filtro_iot.Adapter.FiltroAdapter;
import com.example.eths.filtro_iot.R;
import com.example.eths.filtro_iot.bo.Dispositivo;
import com.example.eths.filtro_iot.bo.MQTTop;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.util.ArrayList;
import java.util.zip.Inflater;


public class FiltroFragment extends Fragment {

    ArrayList<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
    ListView listView;
    View rootView;
    MQTTop mqtTop = new MQTTop();


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
        int id = 1;
        String name = "Dispositivo Relay 1                                         ";
        boolean status = true;
        float consumoAtual = 0;
        float consumoTotal = 0;
        dispositivos.add(new Dispositivo(consumoTotal,consumoAtual,status,name,id));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_filtro_list, container, false);

        View opview = inflater.inflate(R.layout.fragment_settings,container,false);

        EditText broker = (EditText) opview.findViewById(R.id.ed_Broker);
        EditText cliente = (EditText) opview.findViewById(R.id.ed_idCliente);
        EditText sub = (EditText) opview.findViewById(R.id.ed_topicsub);
        EditText pub = (EditText) opview.findViewById(R.id.ed_topicpub);


        String BrokerName = broker.getText().toString();
        String ClientId = cliente.getText().toString();
        String Sub = sub.getText().toString();
        String Pub = pub.getText().toString();

        mqtTop.setBroker(BrokerName);
        mqtTop.setIDclient(ClientId);
        mqtTop.setSub(Sub);
        mqtTop.setPub(Pub);


        listView = (ListView) rootView.findViewById(R.id.listView);
        FiltroAdapter filtroAdapter = new FiltroAdapter(rootView.getContext(),R.layout.item_list_filtro,dispositivos,mqtTop,getActivity().getSupportFragmentManager().beginTransaction());
        listView.setAdapter(filtroAdapter);
        return rootView;
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


    public interface OnFiltroFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFiltroFragmentInteraction(Uri uri);
    }

}
