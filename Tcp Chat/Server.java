
package runtest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {

    Server(){
   
        try {
           
                //Reserveing port number (22000) that will listen the request from Client
                ServerSocket server=new ServerSocket(22000);
         
                Socket client=server.accept(); //The server waiting to receive the request.

                // Read from  Client using Input Variable
                DataInputStream Input=new DataInputStream(client.getInputStream());

                //Write to Client using Output Variable
                DataOutputStream Output=new  DataOutputStream(client.getOutputStream());

                while(true){
                    //Output Messages to the Client
                    Output.writeUTF("You are Connected with Server");
                    Output.writeUTF("You can ask me");

                    //Receiving Messages From Client
                    String StrInput=Input.readUTF();
                    
                    System.out.println("Client Said:"+StrInput);
                    //if the client need to close connection with server
                    if(StrInput.equalsIgnoreCase("exist")){break;}
                    Output.writeUTF("No Services Now");
                }
                Input.close();
                Output.close();
                client.close();
            
        } catch (IOException ex) {
            //variable ex
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
}

