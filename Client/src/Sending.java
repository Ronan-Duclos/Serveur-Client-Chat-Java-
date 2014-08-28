import java.io.PrintWriter;
import java.util.Scanner;

public class Sending implements Runnable
{
	private PrintWriter out = null;
	private String login = null;
	
	public Sending(PrintWriter out, String login)
	{
		this.login = login;
        this.out = out;
    }
	
	public void run()
	{
		Scanner sc = new Scanner(System.in);
        while(true)
        {
    		String msg = sc.nextLine();
            out.println(login+" : "+msg);
            out.flush();
        }
	}
}
