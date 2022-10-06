//Name :Sondos Emara gomaa
//id: 20190249
//G:G1
package runtest;

import java.util.Scanner;

public class RunTest {

    public static void main(String[] args) {
        
        
        Scanner Input=new Scanner (System.in);
        if (Input.next().equals("server")){
            
            Server ObjServer=new Server();
        }
        else {
            Client ObjClient=new Client();
        }
    }
    
}
