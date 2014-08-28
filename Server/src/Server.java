import java.util.Scanner;
import java.io.*;
import java.net.*;

public class Server
{
	public static ServerSocket				ss = null;
	public static Thread					ac, my_chat;
	public static volatile Clients[]		my_clients;
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Port : ");
		int port = sc.nextInt();
		sc.nextLine();
		sc.close();
		try 
		{
            ss = new ServerSocket(port);
            System.out.println("Server started.");
            my_clients = new Clients[250];
            ac = new Thread(new AcceptClients(ss, my_clients));
            ac.start();
            my_chat = new Thread(new MyChat(my_clients));
			my_chat.start();
        }
		catch (IOException e) 
		{
            e.printStackTrace();
        }
	}

}
