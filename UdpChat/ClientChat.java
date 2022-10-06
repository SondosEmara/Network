
package clientchat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ClientChat {

    public static void main(String[] args) {
        
        
        try {
            
            DatagramSocket ClientSocket=new DatagramSocket();
            System.out.println("Client active now");
            
            InetAddress ServerIP=InetAddress .getByName("localhost");
            int ServerPort=4000;
            byte[]Request;
            byte[]Response=new byte[4096];
            
            Scanner SC=new Scanner(System.in);
            
            while(true){
                
                System.out.println("You are ready to communicate");


                String Input=SC.nextLine();
                

                Request=Input.getBytes();

                DatagramPacket ClientPacket=new DatagramPacket(Request,Request.length,ServerIP,ServerPort);
                ClientSocket.send(ClientPacket);//SEnd packet to server
                if(Input.equalsIgnoreCase("Close")||Input.equalsIgnoreCase("exit")){
                    System.out.println("Connection is closed");
                    ClientSocket.close();
                    break;
                }

                DatagramPacket ServerPacket=new DatagramPacket(Response,Response.length);
                ClientSocket.receive(ServerPacket);


                String ResponseFromServer=new String(ServerPacket.getData()).trim();
                System.out.println("Server:"+ResponseFromServer);   
                Response=new byte[4096];
                
            }
        } catch (IOException ex) {
            Logger.getLogger(ClientChat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
