//importing the packages which we are going to use
import java.util.Scanner;
import java.net.Socket;
import java.io.IOException;
public class DataClient{
	public static void main(String[] args) throws IOException {//if the coming output or given input  has an error that exception eill be thrown
		if(args.length!=1){//checking weather the length passing argument is null or not
			System.err.println("Pass the server IP as the sole command");
			return;
		}
		Socket socket = new Socket(args[0], 40010);//this class is used to connect two computers using ip adress and port number
	    Scanner in = new Scanner(socket.getInputStream());//Here ip adress is getting read and store it in "in" variabel
		System.out.println("Server response:" + in.nextLine());//It will send the informantion to next line
	}
}