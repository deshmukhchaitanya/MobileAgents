/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package network;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author impadmin
 */
public class client 
{
    public static void send(byte[] data,InetAddress ad) throws UnknownHostException, IOException
    {
        Socket sock = new Socket(ad.getHostAddress(), 4000);
        // sendfile
        OutputStream os = sock.getOutputStream();
        os.write(data,0,data.length);
        System.out.println("sent data");
        String str=ad.getHostAddress();
        System.out.println(str);
        os.flush();
        sock.close();
    } 
}
