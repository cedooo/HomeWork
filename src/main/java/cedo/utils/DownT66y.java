package cedo.utils;

import javax.swing.text.html.HTML;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;
/**
 * Created by cedo on 2016/10/12.
 * as you know
 */
public class DownT66y {

    static final private String T66Y_URL ="http://commons.apache.org/proper/commons-net/";
    static private final String PROXY_IP = "192.168.1.1";
    static private final int PROXY_PORT = 99;

    static private URL t66yUrl;
    static private Proxy proxy;
    static {
        try {
            t66yUrl = new URL(T66Y_URL);

            byte[] addr = new byte[4];
            String[] ipAddr = PROXY_IP.split("\\.");
            for(int i=0; i<ipAddr.length; i++){
                addr[i] = (byte)(Integer.parseInt(ipAddr[i]) & 0xff);
            }
            out.println(PROXY_IP + " <=> " + java.util.Arrays.toString(addr));
            InetAddress inetAddress = InetAddress.getByAddress(addr);
            SocketAddress socketAddress = new InetSocketAddress(inetAddress, PROXY_PORT);

            proxy = new Proxy(Proxy.Type.SOCKS, socketAddress);
        } catch  (MalformedURLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            out.printf("address maybe wrong!");
        }
    }

    static public void main(String[] args){
        try {
            boolean saved = Spider.saveHTML(t66yUrl.openStream(),"temp/aa.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}

/**
 * 简单的爬虫
 */
class Spider implements Runnable{

    private List<HTMLLink> htmlLib = new ArrayList<>();

    @Override
    public void run() {

    }

    static boolean saveHTML(java.io.InputStream inStream, String fileName){
        java.io.File file = new java.io.File(fileName);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inStream));
            String line;
            while((line = bufferedReader.readLine())!=null){
                fileWriter.append(line);
            }
            fileWriter.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}

class HTMLLink {

}
