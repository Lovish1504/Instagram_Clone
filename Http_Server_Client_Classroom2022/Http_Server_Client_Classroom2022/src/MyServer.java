
import com.vmm.JHTTPServer;
import java.io.IOException;
import java.net.HttpRetryException;
import java.util.Date;
import java.util.Properties;

public class MyServer extends JHTTPServer
{   
    public MyServer(int port) throws IOException 
    {
        super(port);
    }

    @Override
    public Response serve(String uri, String method, Properties header, Properties parms, Properties files) 
    {
          System.out.println(uri);
     
          Response res = null;
          
          if(uri.equals("/"))
          {
              res = new Response(HTTP_OK, "text/plain", "welcome to my server");
          }
          else if(uri.contains("/one"))
          {
              res = new Response(HTTP_OK, "text/plain", "random number is "+Math.random());
          }
          else if(uri.contains("/two"))
          {
              res = new Response(HTTP_OK, "text/plain", new Date().toString());
          }
          
          return res;
    
    }
    
    public static void main(String[] args) 
    {
       try
       {
           MyServer obj = new MyServer(9000);
           
           Thread.sleep(1000000); 
       }
       catch(Exception ex)
       {
           ex.printStackTrace();
       }
    }
    
}
