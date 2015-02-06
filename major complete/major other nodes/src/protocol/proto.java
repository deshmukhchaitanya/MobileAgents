
package protocol;
import control.controller;
import java.io.*;
import java.net.InetAddress;

public class proto 
{
    public static byte temp[];
    public static byte b_op[]=new byte[4];
    public static int plen,flen,op;
    public static int [] ips;
    public static byte[] client() throws IOException
    {
        int no;
        no=controller.no; // getting no. of destinations
        byte dest_ip[]=new byte[no*4];
        for(int i=0;i<no;i++)
        {
            byte[] b=intToByteArray(ips[i]);
            System.arraycopy(b, 0, dest_ip, i*4, b.length);
        }
        System.out.println("no"+ no);
        System.out.println("dest ip len"+dest_ip.length);
        
        // reinitalize no. of dest(decrease it by 1)  and dest-ip's (remove 1st 4 byte)
        //below 2 lines will not come in originators part

        no--;
        dest_ip=manipulate(no,dest_ip);

        temp=dest_ip;

        // getting task file into mybytearray

        FileInputStream fis;
        if (op==1)
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

        // will come only in node parts
        InetAddress ownIP=InetAddress.getLocalHost();
        String own_ip=ownIP.getHostAddress();
        try
        {
            BufferedWriter out = new BufferedWriter(new FileWriter("output.txt", true));
            out.newLine();
            out.write(own_ip);
            out.close();
        } catch (IOException e)
        {
        }
        
        //getting the output file into payload byte array

        FileInputStream fis1 = new FileInputStream("output.txt");
        plen =+ fis1.available();
        byte [] payload  = new byte [plen];
        BufferedInputStream bis1 = new BufferedInputStream(fis1);
        bis1.read(payload,0,payload.length);
        System.out.println("plen"+plen);
        
        byte [] b_flen = intToByteArray(flen); //getting the int file length into byte array
	byte [] b_no = intToByteArray(no);     // getting the int no. of destinations int byte array
        byte [] b_plen = intToByteArray(plen);

        // forming header
        byte[] head = new byte[b_no.length + b_flen.length + b_plen.length];
	System.arraycopy(b_no, 0, head, 0, b_no.length);
	System.arraycopy(b_flen, 0, head, b_no.length, b_flen.length);
	System.arraycopy(b_plen, 0, head, b_no.length+b_flen.length, b_plen.length);
        
        //forming the mobile agent(byte array)
        byte[] mob_ag=new byte[head.length + mybytearray.length + dest_ip.length + payload.length];
        System.arraycopy(head, 0, mob_ag, 0, head.length);
        System.arraycopy(dest_ip, 0, mob_ag, head.length,dest_ip.length);
        System.arraycopy(mybytearray, 0, mob_ag, head.length+dest_ip.length,mybytearray.length);
        System.arraycopy(payload, 0, mob_ag, head.length+dest_ip.length+mybytearray.length,payload.length);
        //adding total len field
        int tot_len=4+mob_ag.length;
        byte [] b_len = intToByteArray(tot_len);
        byte[] data=new byte[tot_len];
        System.arraycopy(b_len, 0, data, 0, b_len.length);
        System.arraycopy(mob_ag, 0, data, b_len.length,mob_ag.length);
        
        return data;
    }
    public static byte[] manipulate(int n,byte des_ip[])
    {
        int m=n*4;
        System.out.println("des_ip in man"+des_ip.length);
        byte temp1[]=new byte[m];
        System.out.println("tem1 :"+temp1.length);
        System.arraycopy(des_ip, 4, temp1, 0, temp1.length);
        return temp1;
    }

    
    // server part to disassemble the data
    public static int server(byte[] data) throws FileNotFoundException, IOException
    {
        int tot_len,dest_no;
	byte[] b_flen=new byte[4];
        byte[] b_plen=new byte[4];
	byte[] b_no=new byte[4];
        byte[] b_len=new byte[4];
        
        // getting tot len
        System.arraycopy(data, 0, b_len, 0, 4);
	tot_len= ByteArrayToint(b_len);
        System.out.println("tot "+tot_len);
        
        // getting no. of destinatn field
        for(int i=4;i<8;i++)
	{
		b_no[i-4]=data[i];
	}
        dest_no= ByteArrayToint(b_no);
        System.out.println("dest no"+dest_no);
        
        //getting file length
        for(int i=8;i<12;i++)
	{
		b_flen[i-8]=data[i];
	}
        flen= ByteArrayToint(b_flen);
        System.out.println("flen"+flen);

        //getting payload length
        for(int i=12;i<16;i++)
	{
		b_plen[i-12]=data[i];
	}
        plen= ByteArrayToint(b_plen);
        System.out.println("plen"+plen);
        
        //retrieving dest ip's
        ips = new int[dest_no];
        int index=16;
	for(int i=0;i<dest_no;i++)
        {
            byte[] b = new byte[4];
            b[0] = data[index++];
            b[1] = data[index++];
            b[2] = data[index++];
            b[3] = data[index++];
            ips[i]= ByteArrayToint(b);
        }
        // getting the op code
        int c=tot_len-4;
        for(int i=0;i<4;i++)
        {
            b_op[i]=data[i+c];
        }
        op=ByteArrayToint(b_op);
        System.out.println("op"+op);
        
        //writting the task file to the hard-disk
        index=28;
        System.out.println("index"+index);
        byte[] b_task=new byte[flen];
        for(int i=0;i<flen;i++)
	{
		b_task[i]=data[i+index];
	}
        File myfile;
        if (op==1)
        {
            myfile = new File("retrieve.class");
        }
        else
        {
            myfile = new File("count.class");
        }
             
        FileOutputStream fos = new FileOutputStream(myfile);
	BufferedOutputStream bos = new BufferedOutputStream(fos);
	bos.write(b_task, 0 ,flen);
	bos.flush();
        return dest_no;
        
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



