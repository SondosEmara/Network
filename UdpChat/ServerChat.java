//Name:Sondos Emara Gomaa
//id:20190249
//G:G1


package serverchat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ServerChat {

    public static void main(String[] args) {
        
        try{
        
            
            //listen request using  the port(4000)
            DatagramSocket ServerSocket=new DatagramSocket(4000);
            
            Scanner SC=new Scanner (System.in);
            System.out.println("Server is Up");

            //This RequestBytes will have the client message 
            byte[] RequestBytes=new byte[4096];
            byte [] ResponseBytes;
            
            
            
            while(true){
                
                System.out.println("Server is ready to communicte");
                
                //Make Object datagram (ClientPacket)
                DatagramPacket ClientPacket=new DatagramPacket(RequestBytes,RequestBytes.length);

                //Receive the Client Request and save the Message in  object(ClientPacket)
                ServerSocket.receive(ClientPacket);

                //Convert data (that send from Client) to String and print it
                String Request=new String(ClientPacket.getData()).trim();
                if(Request.equalsIgnoreCase("Close")||Request.equalsIgnoreCase("exit")){
                    
                    System.out.println("Connection is closed");
                    ServerSocket.close();
                    break;
                }
                System.out.println("Client:"+Request);

                //Take Input From Console
                String Input=SC.nextLine();
                ResponseBytes=Input.getBytes();//convert the String to byte


                //ClientIp that save the clientIp that in the ClientPacket that send from client
                InetAddress ClientIp= ClientPacket.getAddress();
                int ClientPort=ClientPacket.getPort();

                DatagramPacket ServerPacket=new DatagramPacket(ResponseBytes,ResponseBytes.length,ClientIp,ClientPort);

                ServerSocket.send(ServerPacket);

                RequestBytes=new byte[4096];
            }
        }
        catch(IOException e){
            Logger.getLogger(ServerChat.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
}
