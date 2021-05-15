//importing the packages which we are going to use
import java.io.*;
import java.net.*;
class UDPClient {
	public static void main(String[] args) throws Exception {
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));//it will reads the inputstream
		DatagramSocket clientSocket = new DatagramSocket();//intializing datagram socket
		InetAddress IPAddress = InetAddress.getByName("localhost");//intializinfg host name to ipAddress for getting ip address
		byte [] sendData = new byte[1024];//to read content in byte formst
		byte[] receiveData =  new byte[1024];
		String sentence = inFromUser.readLine();//takes the information from the user
		sendData = sentence.getBytes();//converts into byte type
		DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,IPAddress,1234);//storing the values 
		clientSocket.send(sendPacket);//sends information to server
		DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);//this will recevie data from server
		clientSocket.receive(receivePacket);
		String modifiedSentence = new String(receivePacket.getData());//convets data into string type
		System.out.println("FROM SERVER: " + modifiedSentence);
		clientSocket.close();//closes the socket
	}
}