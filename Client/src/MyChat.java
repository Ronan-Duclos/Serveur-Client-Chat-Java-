import java.io.*;
import java.net.*;

public class MyChat implements Runnable
{
	private Socket socket;
	private PrintWriter out = null;
	private BufferedReader in = null;
	private Thread send, receive;
	private String login;
	
	public MyChat(Socket sc, String login)
	{
		socket = sc;
		this.login = login;
	}
	
	public void run()
	{
		try
		{
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
            send = new Thread(new Sending(out, login));
            send.start();
            receive = new Thread(new Receiving(in));
            receive.start();
		} catch (IOException e)
		{
			System.err.println("Le serveur distant s'est déconnecté !");
		}
	}

}