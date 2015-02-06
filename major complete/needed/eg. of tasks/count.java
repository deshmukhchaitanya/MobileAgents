import java.io.*;


public class count
{
    public static void main(String[] args) throws FileNotFoundException
    {
        FileOutputStream out=new FileOutputStream("output.txt");
        PrintStream p=new PrintStream(out);
        count w = new count();
        File dir = new File("D:\\Mp3");
        p.print("size= ");
        p.print(w.getDirSizeInMegabytes(dir));
        p.println("mb");
        File[] subFiles1 = dir.listFiles();
        int s=subFiles1.length;
        p.print(s);
        p.println(" no. of files");
        int i=1;
        while(i<s)
        {
            p.println(subFiles1[i]);
            i++;
        }
        
    }

    float getDirSize(File dir)
    {
        float size = 0;
        if (dir.isFile()) {
        size = dir.length();
    }
    else
    {
        File[] subFiles = dir.listFiles();
        for (File file : subFiles)
        {
            if (file.isFile())
            {
                size += file.length();
            }
            else
            {
            size += this.getDirSize(file);
            }

        }
    }
    return size;
    }

    float getDirSizeInMegabytes(File dir)
    {
        return this.getDirSize(dir) / 1024 / 1024;
    }
}
