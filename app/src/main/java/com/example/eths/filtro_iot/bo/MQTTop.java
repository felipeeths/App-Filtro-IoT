package com.example.eths.filtro_iot.bo;

/**
 * Created by eths on 9/18/16.
 */
public class MQTTop {

    String Broker;
    String IDclient;
    String Pub;
    String Sub;

    public MQTTop(){}

    public MQTTop(String pub, String IDclient, String broker, String sub) {
        Pub = pub;
        this.IDclient = IDclient;
        Broker = broker;
        Sub = sub;
    }


    public String getBroker() {
        return Broker;
    }

    public void setBroker(String broker) {
        Broker = broker;
    }

    public String getPub() {
        return Pub;
    }

    public void setPub(String pub) {
        Pub = pub;
    }

    public String getSub() {
        return Sub;
    }

    public void setSub(String sub) {
        Sub = sub;
    }

    public String getIDclient() {
        return IDclient;
    }

    public void setIDclient(String IDclient) {
        this.IDclient = IDclient;
    }

}
