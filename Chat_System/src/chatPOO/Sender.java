package chatPOO;

import java.io.DataInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.*;
import java.net.*;


public class Sender implements Runnable{
	public int port = 2000;
    String name = "";
    long sleepTime = 1000;
    
    public Sender(String Name, long sleep){
       name = Name;
       sleepTime = sleep;
    }
    
    public void run(){
       int nbre = 0;
       while(true){
          String envoi = name + "-" + (++nbre);
          byte[] buffer = envoi.getBytes();
          
          try {
             //On initialise la connexion côté client
             DatagramSocket client = new DatagramSocket();
             
             //On crée notre datagramme
             InetAddress adresse = InetAddress.getByName("127.0.0.1");
             DatagramPacket packet = new DatagramPacket(buffer, buffer.length, adresse, port);
             
             //On lui affecte les données à envoyer
             packet.setData(buffer);
             
             //On envoie au serveur
             client.send(packet);
             
             try {
                Thread.sleep(sleepTime);
             } catch (InterruptedException e) {
                e.printStackTrace();
             }
             
          } catch (SocketException e) {
             e.printStackTrace();
          } catch (UnknownHostException e) {
             e.printStackTrace();
          } catch (IOException e) {
             e.printStackTrace();
          }
       }
    }

	public static synchronized void print(String str){
      System.out.print(str);
    }
    public static synchronized void println(String str){
      System.err.println(str);
    } 
 }   

	
