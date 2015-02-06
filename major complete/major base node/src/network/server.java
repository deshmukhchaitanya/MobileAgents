/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package network;

import control.controller;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author impadmin
 */
public class server 
{
            
    public void serve() throws IOException
    {   
        ServerSocket servsock = new ServerSocket(4000);
                System.out.println("waiting");
                Socket sock = servsock.accept();
                System.out.println("accepted");
                controller c =new controller();
                c.sock = sock;
                c.start();
                System.out.println("strt");
           

    }
    public static void call() throws IOException
    {
        server s=new server();
        s.serve();
    }
    
}
