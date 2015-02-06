
// this package is not used for base

package fileio;
import java.lang.reflect.*;
import java.util.Arrays;
import protocol.proto;

public class fio
{
    public static void execute()
    {
        int op=proto.op;
        
        System.out.println("in fio");
        String args[]={"chaitanya","ankur","mahak","dhanshri"};
	ClassLoader classLoader = fio.class.getClassLoader();
	try
	{
        	Class aClass;
                if (op==1)
                {
                    aClass= classLoader.loadClass("retrieve"); //obtaining objct
                }
                else 
                {
                    aClass= classLoader.loadClass("count"); //obtaining objct
                }
        	System.out.println("aClass.getName() = " + aClass.getName());
		Class[] argTypes = new Class[] { String[].class }; // obtaining argument type
	    Method main = aClass.getDeclaredMethod("main",argTypes); // obtaining required method
		String[] mainArgs = Arrays.copyOfRange(args, 0, args.length); // obtaining the argument
		main.invoke(null, (Object)mainArgs); // calling the required method
	}
    	catch (ClassNotFoundException e)
	{
            System.out.println("not found");
	}
	catch (NoSuchMethodException x)
	{
	}
	catch (IllegalAccessException x)
	{
	}
	catch (InvocationTargetException x)
	{
 	}
    }
}
