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
import java.io.*;


public class Main {
	public final static int port = 2000;
	static long sleepTime = 1000;
	public static void main(String[] args){
	
		Thread t = new Thread(new Receive());
	    t.start();
	    
	    String envoi = "ok";
        byte[] buffer = envoi.getBytes();
        
        try {
           //On initialise la connexion cot client
           DatagramSocket client = new DatagramSocket();
           System.out.println("thread envoie ");
           
           //On crée notre datagramme
           InetAddress adresse = InetAddress.getByName("127.0.0.1");
           DatagramPacket packet = new DatagramPacket(buffer, buffer.length, adresse, port);
           
           //On lui affecte les données à envoyer
           packet.setData(buffer);
           
           //On envoie au serveur
           client.send(packet);
           
           System.out.println("le message a été envoyé à " + packet.getAddress());
           
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
