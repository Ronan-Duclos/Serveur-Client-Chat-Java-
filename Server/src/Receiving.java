import java.io.BufferedReader;
import java.io.IOException;

public class Receiving implements Runnable 
{
    private BufferedReader 				in;
    private String 						message = null;
    public static volatile Clients		clients[];
    
    public Receiving(BufferedReader in, Clients clients[])
    {
        this.in = in;
        Receiving.clients = clients;
    }
    
    public void run()
    {
        while (true)
        {
        	int i = 0;
            try
            {  
            	message = in.readLine();
            	System.out.println(message);
            	while (i < 250)
            	{
            		if (clients[i] != null && clients[i].getChating() == true)
            		{
            			clients[i].sendMsg(message);
            		}
            		i++;
            	}
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