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
    	println("thread receiver démarré");
        try {
           
           //Création de la connexion coté serveur, en spécifiant un port d'écoute
           DatagramSocket server = new DatagramSocket(port);
           
           while(true){
              
              //On s'occupe maintenant de l'objet paquet
              byte[] buffer = new byte[8192];
              DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
              
                               
              //Cette méthode permet de récupérer le datagramme envoyé par le client
              //Elle bloque le thread jusqu'Ã  ce que celui-ci ait reÃ§u quelque chose.
              server.receive(packet);
              
              //nous récupérons le contenu de celui-ci et nous l'affichons
              String str = new String(packet.getData());
              // if str = 
              print("Reçu de la part de " + packet.getAddress() 
                                + " sur le port " + packet.getPort() + " : ");
              println(str);
              
              //On réinitialise la taille du datagramme, pour les futures réceptions
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