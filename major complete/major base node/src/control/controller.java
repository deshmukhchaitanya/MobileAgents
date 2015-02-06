/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control;
import gui.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import network.client;
import protocol.proto;

/**
 *
 * @author impadmin
 */
public class controller extends Thread
{
    static byte dest_ip_gui[];
    public Socket sock;
            public byte[] read() throws IOException
            {        
                    
                    int current=0,bytesRead,tot_len;
                    byte [] size=new byte[4];
                    InputStream is = sock.getInputStream();
                    // receive total len
                    is.read(size,0,1);
                    is.read(size,1,1);
                    is.read(size,2,1);
                    is.read(size,3,1);
                    tot_len=ByteArrayToint(size);
                    System.out.println("tot:"+tot_len);

                    // receiving mob_ag
                    byte [] data  = new byte [tot_len];
                    data[0]=size[0];
                    data[1]=size[1];
                    data[2]=size[2];
                    data[3]=size[3];
                    
                    // receiving mob_ag
                    
                    bytesRead = is.read(data,4,data.length-4);
                    current = bytesRead+4;
                    do 
                    {
                        bytesRead = is.read(data, current, (data.length-current));
                        if(bytesRead==0)
                            break;
                        if(bytesRead > 0) current += bytesRead;
                        
                    }while(bytesRead > -1);
                    sock.close();
                    System.out.println("return data");
                    return data;
            }    
    @Override
            public void run()
            {
                    System.out.println("run");
                try {
                    byte[] data = read();
                    process(data);
                    

                } catch (IOException ex) {
                    Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    public static int ByteArrayToint(byte[] b) 
    {
	int value = 0;
	for (int i = 0; i < b.length; i++)
	{
	   value = (value << 8) + (b[i] & 0xff);
	}
	return value;
    }
    public void process(byte[] data) throws FileNotFoundException, IOException
    {
        System.out.println("process");
        proto.server(data);
    }
    public static void forward() throws IOException
    {

        byte data[]=proto.client();
        byte dest_ip[]=proto.temp;
        InetAddress next=next_ip(dest_ip);
        //String str=next.getHostAddress();
        //System.out.println(str);
        client.send(data,next);
    }
    //below 2 functs only for base
    public static void get_gui_data() throws UnknownHostException
    {
            dest_ip_gui= enters_destinatn.destIP();
            

    }
    public static byte[] forward_gui_data()
    {
        return dest_ip_gui;
    }

    // get the next destination ip address
    
    public static InetAddress next_ip(byte dest_ip[]) throws UnknownHostException
    {
        byte[] next=new byte[4];
        System.arraycopy(dest_ip, 0, next, 0, 4);
        InetAddress nextip=InetAddress.getByAddress(next);
        return nextip;
    }
}
