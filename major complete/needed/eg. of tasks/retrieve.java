import java.io.*;
import java.lang.Object.*;
public class retrieve
{
	public static void main(String[] args) throws Exception
	{
                String name;
                                        String rev = null;
                                        name="E:\\test.txt";//file to b search
                                        int len=name.length();
                                        //System.out.println(len);
                                        StringBuffer dest = new StringBuffer(len);
                                        for (int i = (len - 1); i >= 0; i--)
                                        dest.append(name.charAt(i));
                                        //System.out.println(dest);
                                        int a=dest.indexOf(".");
                                        //System.out.println(a);
                                        rev=dest.substring(0, a);
                                        //System.out.println(rev);
                                        int ext_len=rev.length();
                                        File search1=new File(name);
                                        StringBuffer ext = new StringBuffer(ext_len);
                                        for (int i = (ext_len - 1); i >= 0; i--)
                                        ext.append(rev.charAt(i));
                                        System.out.println(ext);
					long i=search1.length();

                FileOutputStream out;
                PrintStream p = null;
                try
                {
                                        
                                        if(i==0)
					{      out=new FileOutputStream("output.txt");//output file
                                               p=new PrintStream(out);
                                               p.println("file not found");


					}
					else
					{
                                                File f1 = new File("output.txt");//output file
                                                InputStream in = new FileInputStream(search1);
                                                out = new FileOutputStream(f1);
                                                byte[] buf = new byte[1024];
                                                int len1;
                                                while ((len1 = in.read(buf)) > 0){
                                                out.write(buf, 0, len1);
                                                }
                                                in.close();
                                                out.close();
                                                
      
					}



				}
                     catch (Exception e)
                {
                        System.err.println ("Error writing to file");
			p.println("file not found");

                }
				
	}
}
