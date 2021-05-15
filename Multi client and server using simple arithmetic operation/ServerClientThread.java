//importing the packages which we are going to use
import java.net.*;
import java.io.*;
class ServerClientThread extends Thread{
  Socket serverClient;
  int clientNo;
  int square;
  ServerClientThread(Socket insocket,int counter){//contructor with socket and client number as input
    serverClient =insocket;
    clientNo=counter;
  }
  public void run(){//thread start method
    try{
      DataInputStream input1 = new DataInputStream(serverClient.getInputStream());//initializing the data input stram from socket
      DataInputStream inStream = new DataInputStream(serverClient.getInputStream());//initializing the data input stram from socket
      DataInputStream inStream1 = new DataInputStream(serverClient.getInputStream());//initializing the data output stram from socket
      DataOutputStream outStream = new DataOutputStream(serverClient.getOutputStream());//initializing the data output stram from socket
      String clientMessage="",clientMessage1="", serverMessage="",input="",output="";
      while(clientMessage.equals("bye"))//loop runs until message is bye
      {
      input = input1.readUTF();//reads the input foe which operation
      serverMessage= "From Server to client-" + clientNo +" Square of" + clientMessage + "is" +square;
      outStream.writeUTF(serverMessage);
      ////
      clientMessage=inStream.readUTF();//reads 1st number
      clientMessage1=inStream1.readUTF();//reads 2md number
      System.out.println("Enter your option 1.Add \t 2.sub \t 3.Mul \t 4.Div \t 5.Square \t 6.exit");
      System.out.println("Enter two numbers");
      int abc,add,sub,mul,div;
      abc=Integer.parseInt(input);//converts utf to integer
      //checks which opration has to be done
      if(abc == 1)
      {
      System.out.println("From client-" +clientNo+": Number1 is:" +clientMessage+ ": Number2 is :" +clientMessage1);
      add=Integer.parseInt(clientMessage) + Integer.parseInt(clientMessage1);//here it undergose addition
      output="From server to Client-" + clientNo + "ADD of "+ clientMessage + "\t"+clientMessage1+ "is "+add;
      outStream.writeUTF(output);
      }else if(abc == 2)
      {
        System.out.println("From Client-" +clientNo+ ": Number1 is :" +clientMessage+ ": Number2 is :" +clientMessage1);
        sub = Integer.parseInt(clientMessage) - Integer.parseInt(clientMessage1);//here it undergoes substraction
        output="From Server to Client-" + clientNo + " SUB of "+ clientMessage + "\t"+clientMessage1+ "is "+sub;
        outStream.writeUTF(output);
      }else if(abc == 3)
      {
        System.out.println("From Client-" +clientNo+ ": Number1 is :" +clientMessage+ ": Number2 is :" +clientMessage1);
        mul = Integer.parseInt(clientMessage) * Integer.parseInt(clientMessage1);//here it undergoes multiplication
        output="From Server to Client-" + clientNo + " MUL of "+ clientMessage + "\t"+clientMessage1+ "is "+mul;
        outStream.writeUTF(output);
      }else if(abc == 4)
      {
        System.out.println("From Client-" +clientNo+ ": Number1 is :" +clientMessage+ ": Number2 is :" +clientMessage1);
        div = Integer.parseInt(clientMessage) / Integer.parseInt(clientMessage1);//here it underges divison
        output="From Server to Client-" + clientNo + " DIV of "+ clientMessage + "\t"+clientMessage1+ "is "+div;
        outStream.writeUTF(output);
      }else if(abc == 5)
      {
        System.out.println("From Client-" +clientNo+ ": Number1 is :" +clientMessage);
        square = Integer.parseInt(clientMessage) * Integer.parseInt(clientMessage);//here it undergoes square
        output="From Server to Client-" + clientNo + " Square of "+ clientMessage + "\t"+clientMessage+ "is "+square;
        outStream.writeUTF(output);
      }else if(abc==6){
        System.exit(0);//here opertion will exit
      }

      //outStream.writeUTF(output);
      outStream.flush();
      }
      //connection will get closed
      inStream.close();
      outStream.close();
      serverClient.close();
    }catch(Exception e){
      System.out.println(e);
    }finally{
      System.out.println("client -" + clientNo + "exit!! ");
    }
  }
}