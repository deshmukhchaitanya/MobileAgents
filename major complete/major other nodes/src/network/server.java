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
    public static void main(String args[]) throws IOException
    {
        call(); //this fucnt is also called on deploy btn click
    }        
    public void serve() throws IOException
    {   
        ServerSocket servsock = new ServerSocket(4000);
        while (true) 
        {
                System.out.println("waiting");
                Socket sock = servsock.accept();
                System.out.println("accepted");
                controller c =new controller();
                c.sock = sock;
                System.out.println("c.start");
                c.start();
        }   

    }
    public static void call() throws IOException
    {
        server s=new server();
        s.serve();
    }
    
}
