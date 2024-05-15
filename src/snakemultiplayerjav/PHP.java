package snakemultiplayerjav;

import java.io.*;
import java.net.*;

public class PHP {
    
    public static HttpURLConnection connection = null;
    
    
    static boolean phpString(String... params) throws MalformedURLException {
        
        URL url;
        
        if(params[0]=="Login")
        {
            String param=new String();
            param="username="+params[1]+"&password="+params[2];
            url = new URL("http://g3n3t1ccsgo.altervista.org/php/login.php");
            return usePHP(param,url);
        }
        if(params[0]=="Register")
        {
            String param=new String();
            param="username="+params[1]+"&password="+params[2]+"&email="+params[3];
            url = new URL("http://g3n3t1ccsgo.altervista.org/php/registrazione.php");
            return usePHP(param,url);
        }
        if(params[0]=="controlloUtente")
        {
            String param=new String();
            param="username="+params[1];
            url = new URL("http://g3n3t1ccsgo.altervista.org/php/controlloUtente.php");
            return usePHP(param,url);
        }
        if(params[0]=="controlloMail")
        {
            String param=new String();
            param="email="+params[1];
            url = new URL("http://g3n3t1ccsgo.altervista.org/php/controlloMail.php");
            return usePHP(param,url);
        }
        
        
        return false;
    }
    
    static boolean usePHP(String urlParameters,URL url)
    {
               
        try
        {
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);            
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.close();
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));

            if(rd.readLine().equals("true"))
            {
                return true;
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    
    return false;
    }
   
}   
