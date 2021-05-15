//importing the packages which we are going to use
import java.net.*;
import java.io.*;
public class MultiServer{
	 public static void main(String[]args) throws Exception {
		 try{
		   ServerSocket server=new ServerSocket(20202);//itializing socket with port number
		   int counter =0;//counter is for counting number of clients connectd to server
		   System.out.println("Server Started.... ");
		   while(true){//util it is true
		   	counter++;//incrment of clients
			Socket serverClient=server.accept(); //server accept the client connections
			System.out.print(" >> "+ "Client NO:" +counter+ " started!");
			ServerClientThread sct=new ServerClientThread(serverClient,counter);//this class thread is used to do arthemetic operations
			sct.start();//it will starts thread
		   }
		 }
		 catch(Exception e){
		    System.out.println(e);
		 }
	 }
}