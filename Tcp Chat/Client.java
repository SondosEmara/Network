
package runtest;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Client {
    
    Client(){
        
        try {
            //Get Ip address of  host
            InetAddress  IP=InetAddress.getLocalHost();
            
            System.out.println(IP);
            
            Socket Server=new Socket(IP,22000);
            Scanner INPUT=new Scanner (System.in);
            
            // Read from  Server using (Input)
            DataInputStream Input=new DataInputStream(Server.getInputStream());
            
            //Write to Server using (Output)
            DataOutputStream Output=new  DataOutputStream(Server.getOutputStream());
            
            String Str;
            while(true){
                Str=Input.readUTF();
                System.out.println(Str);
                Str=Input.readUTF();
                System.out.println(Str);

                //Write to Server
                Str=INPUT.nextLine();
                Output.writeUTF(Str);

                
                if (Str.equalsIgnoreCase("exist")){break;}
                Str=Input.readUTF();//Read the input from server
                System.out.println(Str);
            }
            Server.close();
            Input.close();
            Output.close();
      
            
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}

