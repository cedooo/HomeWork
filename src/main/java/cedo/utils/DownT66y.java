package cedo.utils;

import java.io.IOException;

import static java.lang.System.out;
/**
 * Created by cedo on 2016/10/12.
 * as you know
 */
public class DownT66y {

    static final private String T66Y_URL ="HTTP://baidu.com";
    static private final String PROXY_IP = "192.168.1.1";
    static private final int PROXY_PORT = 99;

    static private java.net.URL t66yUrl;
    static private java.net.Proxy proxy;
    static {
        try {
            t66yUrl = new java.net.URL(T66Y_URL);

            byte[] addr = new byte[4];
            String[] ipAddr = PROXY_IP.split("\\.");
            for(int i=0; i<ipAddr.length; i++){
                addr[i] = (byte)(Integer.parseInt(ipAddr[i]) & 0xff);
            }
            out.println(PROXY_IP + " <=> " + java.util.Arrays.toString(addr));
            java.net.InetAddress inetAddress = java.net.InetAddress.getByAddress(addr);
            java.net.SocketAddress socketAddress = new java.net.InetSocketAddress(inetAddress, PROXY_PORT);

            proxy = new java.net.Proxy(java.net.Proxy.Type.SOCKS, socketAddress);
        } catch (java.net.MalformedURLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            out.printf("address maybe wrong!");
        }
    }

    static public void main(String[] args){
        try {
            java.net.URLConnection t66yConn = t66yUrl.openConnection(proxy);
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(t66yConn.getInputStream()));
            String line;
            while((line = bufferedReader.readLine())!=null){
                out.printf(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
