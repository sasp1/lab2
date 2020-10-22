import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        PrinterI printer = (PrinterI) Naming.lookup("rmi://localhost:5099/printservice");

        System.out.println(printer.print("myfile.pdf", "HP-officejet-printer"));
        System.out.println(printer.queue("HP-officejet-printer"));
        System.out.println(printer.topQueue("HP-officejet-printer", 83));
        System.out.println(printer.start());
        System.out.println(printer.stop());
        System.out.println(printer.restart());
        System.out.println(printer.status("HP-officejet-printer"));
        System.out.println(printer.readConfig("two-sided-print"));
        System.out.println(printer.setConfig("two-sided-print", "false"));
    }
}
