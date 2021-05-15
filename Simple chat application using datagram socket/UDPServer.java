//importing the packages which we are going to use
import java.io.*;
import java.net.*;
class UDPServer{
	public static void main(String[] args) throws Exception {
		DatagramSocket serversocket = new DatagramSocket(1234);//intializing the socket with port number
		byte [] receiveData = new byte[1024];//byte type for receving data 
		byte [] sendData = new byte[1024];//byte type fot sending data
		while (true){//checks ip address
			DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);//stores values
			serversocket.receive(receivePacket);//recevies the data from client
			String sentence = new String(receivePacket.getData());//converting byte to string
			System.out.println("RECEIVED FROM CLIENT: \n" + sentence);
			InetAddress IPAddress = receivePacket.getAddress();//this is to get ip address from client
			int port = receivePacket.getPort();//get port number 
			String captailizedSentence = sentence.toUpperCase();//changes data to upper case
			sendData = captailizedSentence.getBytes();//converting string to bytes
			DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,IPAddress,port);//storing values to send packet
			serversocket.send(sendPacket);//sends packet to server
		}
	}
}