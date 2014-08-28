import java.io.*;
import java.net.*;

public class Clients 
{
	private Socket			sc = null;
	private boolean			chat = false;
	private PrintWriter		out;

	public Clients(Socket clients)
	{
		sc = clients;
		try
		{
			out = new PrintWriter(sc.getOutputStream());
		} catch (IOException e) 
		{
			chat = false;
			System.err.println("Client disconnected.");
		}
	}
	
	public Socket getSocket()
	{
		return sc;
	}
	
	public void sendMsg(String msg)
	{
		out.println(msg);
        out.flush();
	}
	
	public boolean getChating()
	{
		return chat;
	}
	
	public void setChating(boolean chat)
	{
		this.chat = chat;
	}
	
	public void clear()
	{
		this.chat = false;
		try
		{
			this.sc.close();
		} catch (IOException e)
		{
			
		}
	}
	
}
