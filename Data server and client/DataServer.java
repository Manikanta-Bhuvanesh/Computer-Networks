//importing the packages which we are going to use
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
public class DataServer{
	public static void main(String[] args) throws IOException{
		try(ServerSocket listener = new ServerSocket(40010)){//It is listening weather the input is getting from the given port
			System.out.println("The date server is running. . .");
			while(true){//checks
				try(Socket socket = listener.accept()){//Listening the request
					PrintWriter out = new PrintWriter(socket.getOutputStream());//It will automatically flushes after printing thev output
					out.println(new Date().toString());//prints the date as a output in the client side
				}
			}
		}
	}
}