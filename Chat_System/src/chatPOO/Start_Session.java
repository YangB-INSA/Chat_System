package chatPOO;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

//import java.util.*;
//import java.net.*;
//import java.io.*;
public class Start_Session {
	
	User utilisateur;
	List<Session> SessionList = new ArrayList<Session>();
	
	public  Start_Session(User utilisateur) {
	}
	public void checkSession(int poste) {
		for (int i=0; i < SessionList.size(); i++) {
			if(SessionList.get(i).postedest == utilisateur.poste)
			{
				//show historique
			}
			else {
				Session new_session = new Session(poste);
				utilisateur.SessionList.add(new_session);
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

}
