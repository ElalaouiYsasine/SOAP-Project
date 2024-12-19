package Serveur;

import WS.CardValidater;
import jakarta.xml.ws.Endpoint;

public class ServeurJWS {

    //deploye le web serveur
    public static void main(String[] args) {
        String url = "http://0.0.0.0:8084/" ;
        Endpoint.publish(url , new CardValidater()) ;
        System.out.println("le web service est deplouyé sur "+url);

    }
}
