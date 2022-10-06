//Name:Sondos Emara Gomaa 
//id:20190249
//G:G1

package serverchat1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerChat1 {

    public static void main(String[] args) {
      
        try{
        
          
            //listen request using  the port(4000)
            DatagramSocket ServerSocket=new DatagramSocket(4000);
           
            System.out.println("Server is Up and  ready to communicte");

            //This RequestBytes will have the client message 
            byte[] RequestBytes=new byte[4096];
            byte [] ResponseBytes;
            String Output;
            
            while(true){
                
                
                
                //Make Object datagram (ClientPacket)
                //ClientPacket tha packet send from client

                DatagramPacket ServerPacket;
                //Receive the Client Request and save the Message in  object(ClientPacket)
                DatagramPacket ClientPacket=new DatagramPacket(RequestBytes,RequestBytes.length);
                ServerSocket.receive(ClientPacket);
                
                InetAddress ClientIb =ClientPacket.getAddress();
                int ClientPort=ClientPacket.getPort();

                //Convert data (that send from Client) to String and print it
                String Request=new String(ClientPacket.getData()).trim();
                System.out.println("Client said:"+Request);

                if (Request.equalsIgnoreCase("weather"))
                {
                    ResponseBytes="Intermittent clouds 14/24˚C".getBytes();
                    ServerPacket=new DatagramPacket(ResponseBytes,ResponseBytes.length,ClientIb,ClientPort);
                    ServerSocket.send(ServerPacket);
                }
                
                else  if(Request.equalsIgnoreCase("Ip"))
                {
                    Output=ClientIb.getHostAddress();
                    ResponseBytes=Output.getBytes();
                    ServerPacket=new DatagramPacket(ResponseBytes,ResponseBytes.length,ClientIb,ClientPort);
                    ServerSocket.send(ServerPacket);
                }
                else if(Request.equalsIgnoreCase("time"))
                {
                    //Object(CurrentDate) contain the data
                    DateFormat CurrentDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    Calendar Date = Calendar.getInstance();
                    Output=CurrentDate.format(Date.getTime());
                    ResponseBytes=Output.getBytes();
                    ServerPacket=new DatagramPacket(ResponseBytes,ResponseBytes.length,ClientIb,ClientPort);
                    ServerSocket.send(ServerPacket);
                }
                else if(Request.equalsIgnoreCase("exit")||Request.equalsIgnoreCase("close"))
                {
                    System.out.println("Connection is close");
                    break;
                }

                else{
                    
                    ResponseBytes="Wrong Question".getBytes();
                    ServerPacket=new DatagramPacket(ResponseBytes,ResponseBytes.length,ClientIb,ClientPort);
                    ServerSocket.send(ServerPacket);
                }
                RequestBytes=new byte[4096];
            }
        }
        catch(IOException e){
            Logger.getLogger(ServerChat1.class.getName()).log(Level.SEVERE, null,e);
        }
    }
    
}
