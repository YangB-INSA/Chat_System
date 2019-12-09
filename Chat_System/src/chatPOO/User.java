package chatPOO;
import java.util.*;
import java.net.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
//import java.io.*;

public class User {
	
	InetAddress UserAdress;
	String username;
	int poste;
	List<User> UserList = new ArrayList<User>();
	
	public User(String Username) {
		this.username = Username;
	}
	
	void Change_Username(String new_username) {
		this.username = new_username;
		//notify user apres Ã§a
	}
	
	void checkSession(int poste) {
		for (int i=0; i < SessionList.size(); i++) {
			if(SessionList.get(i).postedest == poste)
			{
				//show historique
			}
			else {
				Session new_session = new Session(poste);
				SessionList.add(new_session);
			}
		}
	}
	
	public void checkUserUnicity(User utilisateur ) {
		int username_ok=0;
		while(username_ok==0) {
			for (int i=0; i < utilisateur.UserList.size(); i++) {
				if(utilisateur.UserList.get(i).username == utilisateur.username)
				{
					System.out.println("Username déjà  existant ! veuillez changer votre nom");
				}
				else {
					utilisateur.UserList.add(utilisateur);
					username_ok=1;
				}
			}
		}
	}
	/*
	
	public void login(User utilisateur) {
		checkUserUnicity(utilisateur);
		// notify others users
		DatagramSocket client = new DatagramSocket();
		
		String envoi = "ok";
        byte[] buffer = envoi.getBytes();
        
        //On crée notre datagramme
        InetAddress adresse = InetAddress.getByName("127.0.0.1");
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, adresse, port);
        
        //On lui affecte les données à  envoyer
        packet.setData(buffer);
        
        //On envoie au serveur
        client.send(packet);
	}
	*/
}
