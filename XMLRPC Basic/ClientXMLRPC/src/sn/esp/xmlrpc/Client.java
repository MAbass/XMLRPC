package sn.esp.xmlrpc;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;

public class Client {
    public static void main(String[] args) {
        try {

            XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
            config.setServerURL(new URL("http://localhost:8282/xmlrpc"));
            XmlRpcClient client = new XmlRpcClient();
            client.setConfig(config);
            Object[] sum = new Object[]{6,2};
            String result = (String) client.execute("sample.sum", sum);
            System.out.println("The sum is: " + result);
        } catch (Exception exception) {
            System.err.println("JavaClient: " + exception);
        }
    }
}


