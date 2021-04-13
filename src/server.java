import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class server {

	public static void main(String [] args) {
		
		System.out.println("waiting for client connection..");
		try (
			ServerSocket ss = new ServerSocket(5000);
				Socket s = ss.accept();
				
				DataInputStream dis = new DataInputStream(s.getInputStream());
				DataOutputStream dos = new DataOutputStream(s.getOutputStream());
				)
		{
			System.out.println("Client connected");
			
			boolean done = false;
			while(!done) {
				
				String message = dis.readUTF();
				System.out.println("Client says: " + message);
				
				dos.writeUTF(message.toUpperCase());
				dos.flush();
				
				if(message.equalsIgnoreCase("quit")) {}
				
			}
		}
		catch (IOException e) {
			
			System.out.println(e);
			
		}
		
	}
	
}