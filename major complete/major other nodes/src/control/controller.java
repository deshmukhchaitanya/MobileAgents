/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control;
import fileio.fio;
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
    public static byte dest_ip_gui[];
    public static int no;
    public Socket sock;
            public byte[] read() throws IOException
            {       
                    byte [] data;
                    int current=0,bytesRead;
                    int tot_len;
                    InputStream is = sock.getInputStream();
                    byte [] size=new byte[4];
                    // receive file size
                    is.read(size,0,1);
                    is.read(size,1,1);
                    is.read(size,2,1);
                    is.read(size,3,1);
                    tot_len=ByteArrayToint(size);
                    System.out.println("tot:"+tot_len);
                    
                    // receiving mob_ag
                    data  = new byte [tot_len];
                    data[0]=size[0];
                    data[1]=size[1];
                    data[2]=size[2];
                    data[3]=size[3];
                    
                    bytesRead = is.read(data,4,data.length-4);
                    //System.out.println("byte"+bytesRead);
                    //System.out.println("cun"+current);
                    current = bytesRead+4;
                    //System.out.println("cun"+current);
                    do 
                    {
                            bytesRead = is.read(data, current, (data.length-current));
                            if(bytesRead==0)
                                break;
                            if(bytesRead > 0) 
                                current += bytesRead;
                            //System.out.println("byte"+bytesRead);
                            //System.out.println("cun"+current);

                    }while(bytesRead > -1);
                    
                    sock.close();
                    return data;
            }    
    @Override
            public void run()
            {        
                try {
                    System.out.println("run");
                    byte[] data = read();
                    System.out.println("data len"+data.length);
                    process(data);
                    forward();
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
        no=proto.server(data);
        fio.execute();
    }
    public static void forward() throws IOException
    {

        byte data[]=proto.client();
        byte dest_ip[]=proto.temp;
        InetAddress next=next_ip(dest_ip);
        System.out.println("data len"+data.length);
        client.send(data,next);
    }
    
    // get the next destination ip add

    public static InetAddress next_ip(byte dest_ip[]) throws UnknownHostException
    {
        byte[] next=new byte[4];
        System.arraycopy(dest_ip, 0, next, 0, 4);
        InetAddress nextip=InetAddress.getByAddress(next);
        return nextip;
    }
}
