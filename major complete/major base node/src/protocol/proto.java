/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package protocol;
import control.controller;
import java.io.*;
import gui.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class proto 
{
    public static byte temp[];
    public static byte[] client() throws IOException
    {
        int no,flen,plen;
        no=enters_destinatn.count+1; // getting no. of destinations
        byte dest_ip[]=controller.forward_gui_data();// getting dest ip's in byte array
        temp=dest_ip;
        byte b_op[]=new byte[4];
        System.out.println("no"+no);
        // getting task file into mybytearray

        System.out.println("op"+Home_page.op);
        FileInputStream fis;
        if (Home_page.op==1)
        {
            fis = new FileInputStream("retrieve.class");
        }
        else
        {
            fis = new FileInputStream("count.class");
        }
        flen = fis.available();
        byte [] mybytearray  = new byte [flen];
        BufferedInputStream bis = new BufferedInputStream(fis);
        bis.read(mybytearray,0,mybytearray.length);
        System.out.println("flen"+flen);
        
        //getting the output file into payload byte array
        
        FileInputStream fis1 = new FileInputStream("output.txt");
        plen = fis1.available();
        byte [] payload  = new byte [plen];
        BufferedInputStream bis1 = new BufferedInputStream(fis1);
        bis1.read(payload,0,payload.length);
        System.out.println("plen"+plen);
        
        byte [] b_flen = intToByteArray(flen); //getting the int file length into byte array
	byte [] b_no = intToByteArray(no);     // getting the int no. of destinations int byte array
        byte [] b_plen = intToByteArray(plen);
        b_op=intToByteArray(Home_page.op); //getting the op into byte array

        //forming the header
        byte[] head = new byte[b_no.length + b_flen.length + b_plen.length];
	System.arraycopy(b_no, 0, head, 0, b_no.length);
	System.arraycopy(b_flen, 0, head, b_no.length, b_flen.length);
	System.arraycopy(b_plen, 0, head, b_no.length+b_flen.length, b_plen.length);

        //forming the mobile agent(byte array)
        byte[] mob_ag=new byte[head.length + mybytearray.length + dest_ip.length + payload.length+b_op.length];
        System.arraycopy(head, 0, mob_ag, 0, head.length);
        System.arraycopy(dest_ip, 0, mob_ag, head.length,dest_ip.length);
        System.arraycopy(mybytearray, 0, mob_ag, head.length+dest_ip.length,mybytearray.length);
        System.arraycopy(payload, 0, mob_ag, head.length+dest_ip.length+mybytearray.length,payload.length);
        System.arraycopy(b_op, 0, mob_ag,payload.length+ head.length+dest_ip.length+mybytearray.length,b_op.length);


        //adding total len field
        int tot_len=4+mob_ag.length;
        byte [] b_len = intToByteArray(tot_len);
        byte[] data=new byte[tot_len];
        System.arraycopy(b_len, 0, data, 0, b_len.length);
        System.arraycopy(mob_ag, 0, data, b_len.length,mob_ag.length);

        System.out.println("tot_len"+tot_len);

        return data;
        
    }
    
    // server part to disassemble the data
    public static void server(byte[] data) throws FileNotFoundException, IOException
    {
        System.out.println("server base");
        int tot_len,no,flen,plen;
	byte[] b_flen=new byte[4];
        byte[] b_plen=new byte[4];
	byte[] b_no=new byte[4];
        byte[] b_len=new byte[4];

        // getting total len
        System.arraycopy(data, 0, b_len, 0, 4);
	tot_len= ByteArrayToint(b_len) ;
        System.out.println("total len"+tot_len);

        //getting dest no.
	for(int i=4;i<8;i++)
	{
		b_no[i-4]=data[i];
	}
        no= ByteArrayToint(b_no);
        System.out.println("dest no"+no);

        //getting flen
        for(int i=8;i<12;i++)
	{
		b_flen[i-8]=data[i];
	}
        flen= ByteArrayToint(b_flen);
        System.out.println("flen"+flen);

        //getting plen
        for(int i=12;i<16;i++)
	{
		b_plen[i-12]=data[i];
	}
        plen= ByteArrayToint(b_plen);
        System.out.println("plen"+plen);
        
        int index=16+(no*4)+flen;
        
        //writting the output file to the hard-disk
        byte[] b_out=new byte[plen];
        
        for(int i=0;i<plen;i++)
	{
		b_out[i]=data[i+index];
	}
        File myfile1 = new File ("output.txt");
        System.out.println("final output file created");
        FileOutputStream fos1 = new FileOutputStream(myfile1);
	BufferedOutputStream bos1 = new BufferedOutputStream(fos1);
	bos1.write(b_out, 0 ,plen);
	bos1.flush();
        
        Home_page.statusflg=1;
        Home_page.result();
               
        // transfer the control from here to home page n make the result button visible
	//at this stage no will be = 1
    }
    
    public static byte[] intToByteArray(int value) // funct to convert an int to byte array
    {
        return new byte[] 
		{
                	(byte)(value >>> 24),
                	(byte)(value >>> 16),
                	(byte)(value >>> 8),
                	(byte)value
		};
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

    

}



