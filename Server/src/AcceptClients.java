import java.io.*;
import java.net.*;


public class AcceptClients implements Runnable
{
	private ServerSocket				ss = null;
	public Thread 						my_chat;
	public static volatile Clients[]	clients;
	
	public AcceptClients(ServerSocket ss, Clients[] cs)
	{
		this.ss = ss;
		AcceptClients.clients = cs;
	}
	
	public void run()
	{
		try 
		{
			int i = 0;
			while(i < 250)
			{
				clients[i] = null;
				i++;
			}
			while(true)
			{
				i = 0;
				while(clients[i] != null)
					i++;
				System.out.println("Waiting for a client.");
				Socket sc = ss.accept();
				clients[i] = new Clients(sc);
				System.out.println("Clients connected : "+i);
			}
		} catch (IOException e) 
		{
			System.err.println("Error of server");
		}
	}
	
}