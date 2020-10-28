import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Base64;

public class Client {

    private static String session;
    private static PrinterI printer;


    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        printer = (PrinterI) Naming.lookup("rmi://localhost:5099/printservice");

        // generate private key
        // generate public key

        // LOG IN DENIED
        login("lewandowski", "12345");

        System.out.println(printer.print("myfile.pdf", "HP-officejet-printer",session));

        System.out.println();
        // LOG IN GRANTED -- see the passwords that can be used in "the_passwords_in_plain_text
        login("neymar", "123456");
//        System.out.println(printer.start(session));
        System.out.println(printer.print("myfile.pdf", "HP-officejet-printer",session));
    }

    public static void login(String username, String password) throws RemoteException {
        String tmpSession = printer.login(username, password);
        if (tmpSession == null) {
            System.out.println("Login denied");
        } else {
            System.out.println("Login successful");
            session = tmpSession;
        }
    }
}
