//importing the packages which we are going to use
import java.net.*;
import java.io.*;
public class ClientProgram{
	private Socket socket =  null;//intializing socket as null
	private DataInputStream input = null;//intializing input stream as null
	private DataOutputStream out = null;//intializing output stream as null
	public ClientProgram(String address, int port){//constructor  with ip address and port number as input
		try{//it will try to establish connection
			socket =  new Socket(address, port);//intializing socket with address and port number
			System.out.println("Connected");
			input = new DataInputStream(System.in);//it will takes input
			out = new DataOutputStream(socket.getOutputStream());//it will send output to socket
		}
		catch(UnknownHostException u){//it is for catching incorrect port number
			System.out.println(u);
		}
		catch(IOException i){//it is for catching incorrect input or output
			System.out.println(i);
		}
		String line = "";
		while(!line.equals("Over")){//loop for reading util client enters over
			try{
				line = input.readLine();//reads the line
				out.writeUTF(line);
			}
			catch(IOException i){
				System.out.println(i);
			}
		}
		try{//trying to close connection
			input.close();
			out.close();
			socket.close();
		}
		catch(IOException i){
			System.out.println(i);
		}
	}
	public static void main(String[] args) {
		ClientProgram client = new ClientProgram("192.168.0.103", 5000);//created a class with input ip Address and port number
	}
}