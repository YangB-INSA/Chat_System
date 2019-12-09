package chatPOO;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Receive implements Runnable{
   	 public final static int port = 2500;
   	 public Receive(){
     }
     public void run(){
    	println("thread receiver d�marr�");
        try {
           
           //Cr�ation de la connexion cot� serveur, en sp�cifiant un port d'�coute
           DatagramSocket server = new DatagramSocket(port);
           
           while(true){
              
              //On s'occupe maintenant de l'objet paquet
              byte[] buffer = new byte[8192];
              DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
              
                               
              //Cette m�thode permet de r�cup�rer le datagramme envoy� par le client
              //Elle bloque le thread jusqu'à ce que celui-ci ait reçu quelque chose.
              server.receive(packet);
              
              //nous r�cup�rons le contenu de celui-ci et nous l'affichons
              String str = new String(packet.getData());
              // if str = 
              print("Re�u de la part de " + packet.getAddress() 
                                + " sur le port " + packet.getPort() + " : ");
              println(str);
              
              //On r�initialise la taille du datagramme, pour les futures r�ceptions
              packet.setLength(buffer.length);
           }
           
        } catch (SocketException e) {
           e.printStackTrace();
        } catch (IOException e) {
           // TODO Auto-generated catch block
               e.printStackTrace();
            }
         }  
   
   public static synchronized void print(String str){
      System.out.print(str);
   }
   public static synchronized void println(String str){
      System.err.println(str);
   }
}