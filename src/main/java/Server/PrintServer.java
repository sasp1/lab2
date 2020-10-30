package Server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class PrintServer {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.createRegistry(5099);
        IPrinter printer = new PrinterImpl();
        registry.rebind("printservice", printer);
        System.out.println("Print server registered.");
    }
}
