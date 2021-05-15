//importing the packages which we are going to use
import java.net.*;
import java.io.*;
public class ServerSide{
	private Socket socket =  null;//intializing socket as null
	private ServerSocket server =  null;//intializing server cocket as null
	private DataInputStream in = null;
	public ServerSide(int port){//constructor with port number as input
		try{//Trying for the connection
			server = new ServerSocket(port);//intializing socket with port number
			System.out.println("Server started");
			System.out.println("Waiting for client....");
			socket=server.accept();//accepting the connection for client and stoers in socket
			System.out.println("Client accepted");
			in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));//it takes input from client
			String line = "";
			while(!line.equals("Over")){//this loops runs until client enters Over
				try{//it will try to read the input
					line = in.readUTF();//reads input
					System.out.println(line);
				}
				catch(IOException i){
					System.out.println(i);
				}
			}
			System.out.println("Closing Connection");
			socket.close();//closing connection
			in.close();
		}
		catch(IOException i){
			System.out.println(i);
		}
	}
	public static void main(String[] args) {
		ServerSide server = new ServerSide(5000);//created a class with port number as input
	}
}