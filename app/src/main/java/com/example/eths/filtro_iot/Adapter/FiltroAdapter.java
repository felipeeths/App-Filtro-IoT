package com.example.eths.filtro_iot.Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.example.eths.filtro_iot.Fragment.FiltroFragment;
import com.example.eths.filtro_iot.R;
import com.example.eths.filtro_iot.bo.Dispositivo;
import com.example.eths.filtro_iot.bo.MQTTop;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.util.ArrayList;

/**
 * Created by eths on 9/18/16.
 */
public class FiltroAdapter extends ArrayAdapter<Dispositivo> {

    ArrayList<Dispositivo> dispositivos;
    Context context;
    private final LayoutInflater inflater;
    FragmentTransaction ft;
    MQTTop mqtTop;

    MqttAndroidClient mqttAndroidClient;


    public FiltroAdapter(Context context, int resource, ArrayList<Dispositivo> dispositivos,MQTTop mqtTop, FragmentTransaction ft) {
        super(context, resource);
        this.context = context;
        this.ft = ft;
        inflater = LayoutInflater.from(context);
        this.dispositivos =  dispositivos;
        this.mqtTop = mqtTop;

    }

    String serverUri = "tcp://iot.eclipse.org:1883";
    String clientId = "ExampleAndroidClient";
    String publishTopic = "filipecavalcanteenvia";

    static class ViewHolder {
        private TextView textViewNameDispositivo;
        private Switch switchld;
        private LinearLayout itemListLayout;
        private TextView textViewLabelConsumo;
        private TextView textViewConsumo;
        private TextView textViewLabelConsumoTotal;
    }

    public int getCount() {
        return dispositivos.size();
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        final Dispositivo dispositivo = dispositivos.get(position);

        mqttAndroidClient = new MqttAndroidClient(getContext(), serverUri, clientId);

        try {
            IMqttToken token = mqttAndroidClient.connect();
            token.setActionCallback(new IMqttActionListener() {
                @Override
                public void onSuccess(IMqttToken asyncActionToken) {
                    // We are connected
                    System.out.printf("onSuccess");
                }

                @Override
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    // Something went wrong e.g. connection timeout or firewall problems
                    System.out.print("onFailure");

                }
            });
        } catch (MqttException e) {
            e.printStackTrace();
        }




        final ViewHolder holder;

        if (view == null) {
            view = inflater.inflate(R.layout.item_list_filtro, null);
            holder = new ViewHolder();
            holder.textViewNameDispositivo = (TextView) view.findViewById(R.id.label_name_dispositivo);
            holder.switchld = (Switch) view.findViewById(R.id.ed_switch);
            holder.textViewLabelConsumo = (TextView)view.findViewById(R.id.label_consumo);
            holder.textViewLabelConsumoTotal = (TextView)view.findViewById(R.id.label_consumo_total);
            holder.itemListLayout = (LinearLayout) view.findViewById(R.id.iten_lista_filtro);
            view.setTag(holder);
        }
        else{
            holder = (ViewHolder) view.getTag();
        }

        if(dispositivo.getIdDisposivio() != 0){
            holder.textViewNameDispositivo.setText(dispositivo.getNome());
            holder.switchld.setChecked(dispositivo.getEstado());
            holder.switchld.setText("Ligado");
            holder.switchld.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        publishMessage("L");
                        holder.switchld.setText("Ligado");
                    }else{
                        publishMessage("D");
                        holder.switchld.setText("Desligado");
                    }
                }
            });
            holder.textViewLabelConsumo.setText("Consumo Atual: " + dispositivo.getConsumoAtual());
            holder.textViewLabelConsumoTotal.setText("Consumo Total: " + dispositivo.getConsumoTotal());
           // holder.itemRoomListLayout.setOnClickListener(new View.OnClickListener() {
               // @Override
               // public void onClick(View v) {
           ///         roomClick(room);
             //   }
            //});
        }

        return view;
    }

   // public void roomClick(Dispositivo r){
  //      Fragment f = FiltroFragment.newInstance();
   //     ft.replace(R.id.your_placeholder, f);
    //    ft.commit();
   // }
   public void publishMessage(String pMessage){

       try {
           MqttMessage message = new MqttMessage();
           message.setPayload(pMessage.getBytes());
           mqttAndroidClient.publish(publishTopic, message);

           if(!mqttAndroidClient.isConnected()){

           }
       } catch (MqttException e) {
           System.err.println("Error Publishing: " + e.getMessage());
           e.printStackTrace();
       }
   }
}
