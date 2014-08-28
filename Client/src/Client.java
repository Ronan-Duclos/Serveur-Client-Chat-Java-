import java.util.Scanner;
import java.io.*;
import java.net.*;

public class Client
{
	public static Socket socket = null;
	public static Thread my_chat;
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez entrez un Pseudo : ");
		String login = sc.nextLine();
		System.out.println("Veuillez entrez une adresse IP :");
		String adr = sc.nextLine();
		System.out.println("Veuillez entrez un port :");
		int port = sc.nextInt();
		sc.nextLine();
		try
		{
            socket = new Socket(adr, port);
            System.out.println("Connexion réussis !");
            my_chat = new Thread(new MyChat(socket, login));
            my_chat.start();
		} catch (UnknownHostException e)
		{
			System.err.println("Impossible de se connecter à l'adresse "+adr);
		} catch (IOException e)
		{
			System.err.println("Aucun serveur à l'écoute du port "+port);
		}
	}

}
