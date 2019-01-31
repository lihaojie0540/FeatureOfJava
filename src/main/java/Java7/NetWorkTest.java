package Java7;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @Author: haojie
 * @Description:
 * @Date: Created in 8:37 PM 2019/1/22
 */
public class NetWorkTest {
    public static void main(String[] args){
        System.out.println(isHostConnectable("192.168.0.101",8080));
    }

    public static boolean isHostConnectable(String host,int port){
        Socket socket = new Socket();
        try{
            socket.connect(new InetSocketAddress(host,port));
            socket.close();
        }catch (IOException e){
            //e.printStackTrace();
            return false;
        }
        return true;
    }
}
