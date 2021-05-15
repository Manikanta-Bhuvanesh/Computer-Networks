//importing the packages which we are going to use
import java.net.*;
import java.io.*;
public class MultiClient{
	public static void main(String[] args) throws Exception{
		try{
			Socket socket = new Socket("127.0.0.1",20202);//intializing the socket
			DataInputStream option = new DataInputStream(socket.getInputStream());//initializing the data input stram from socket
			DataInputStream inStream = new DataInputStream(socket.getInputStream());//initializing the data input stram from socket
			DataOutputStream outOption = new DataOutputStream(socket.getOutputStream());//initializing the data output stram from socket
			DataOutputStream outStream1 = new DataOutputStream(socket.getOutputStream());//initializing the data output stram from socket
			DataOutputStream outStream2 = new DataOutputStream(socket.getOutputStream());//initializing the data output stram from socket
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//It will read input from user
			BufferedReader num1 = new BufferedReader(new InputStreamReader(System.in));//It will read input from user
			BufferedReader num2 = new BufferedReader(new InputStreamReader(System.in));//It will read input from user
			String clientMessage = "",serverMessage="",serverOutput="",input1="",input2="";
			while(!clientMessage.equals("bye")){//loop runs until client message is bye
				System.out.println("Enter your option 1.Add \t 2.Sub \t 3.Mul \t 4.Div \t 5.Square \t 6.exit");
				clientMessage=br.readLine();//reads the line from user for choosing
				outOption.writeUTF(clientMessage);//this will sed option to server
				serverOutput=inStream.readUTF();
				System.out.println(serverOutput);
				System.out.println("Enter first number :");
				input1=num1.readLine();//reads input foe 1st number
				System.out.println("Enter second number :");
				input2=num2.readLine();//reads input for 2nd number
				outStream1.writeUTF(input1);//send data to server
				outStream2.writeUTF(input2);//sends data to server
				serverOutput=inStream.readUTF();//reads data which is coming from server
				System.out.println(serverOutput);
				outOption.flush();//it will flush all our data
			}
			//for closing the connection
			outOption.close();
			outStream1.close();
			outStream2.close();
			socket.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}