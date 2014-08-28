import java.io.*;
import java.net.*;


public class MyChat implements Runnable
{
	private BufferedReader				in = null;
	private Thread						receive;
	public static volatile Clients[]	clients;
	private Socket						sc = null;
	
	public MyChat(Clients[] clients)
	{
		MyChat.clients = clients;
	}
	
	public void run()
	{
		int i = 0;
		while(true)
		{
			try 
			{
				if (clients[i] != null && clients[i].getChating() == false)
				{
					clients[i].setChating(true);
					sc = clients[i].getSocket();
					in = new BufferedReader(new InputStreamReader(sc.getInputStream()));
					receive = new Thread(new Receiving(in, clients));
					receive.start();
					System.out.println("Client start chating : "+i);
				}
				if (i == 249)
					i = 0;
				else
					i++;
			} catch (IOException e) 
			{
				if (clients[i] != null)
	        	{
	        		clients[i].clear();
	        		clients[i] = null;
	        		System.err.println("Client disconnected.");
	        	}
			}
		} 
	}
}
