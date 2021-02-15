package sn.esp.xmlrpc;


import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.server.XmlRpcServerConfigImpl;
import org.apache.xmlrpc.webserver.WebServer;

public class JavaServer {
    public static final int DEFAULT_PORT = 8282;

    public String sum(int x, int y) {
        return "La somme est egale à :"+ (x + y);
    }

    public static void main(String[] args) {
        try {
            System.out.println("Attempting to start XML-RPC Server...");
            WebServer server = new WebServer(DEFAULT_PORT);
            XmlRpcServer xmlRpcServer = server.getXmlRpcServer();
            PropertyHandlerMapping mapping = new PropertyHandlerMapping();
            mapping.addHandler("sample", JavaServer.class);
            xmlRpcServer.setHandlerMapping(mapping);
            XmlRpcServerConfigImpl serverConfig = (XmlRpcServerConfigImpl) xmlRpcServer.getConfig();
            serverConfig.setEnabledForExtensions(true);
            serverConfig.setContentLengthOptional(false);
            server.start();
            System.out.println("Started successfully.");
            System.out.println("Accepting requests. (Halt program to stop.)");
        } catch (Exception exception) {
            System.err.println("JavaServer: " + exception);
        }
    }
}