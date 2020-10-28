import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Base64;
import java.util.Scanner;

public class Client {

    private static final String fileName = "myfile.pdf";
    private static final int job = 1;
    private static String session;
    private static IPrinter printer;
    private static Scanner scanner;
    private static final String printerName = "HP-officejet-printer";


    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException, InterruptedException {
        printer = (IPrinter) Naming.lookup("rmi://localhost:5099/printservice");
        scanner = new Scanner(System.in);

        // generate private key
        // generate public key

        login();
        mainMenu();
    }

    private static void mainMenu() throws InterruptedException, RemoteException {
        int input = -1;
        while (true) {
            System.out.println("\n1  - print\n" +
                    "2  - queue\n" +
                    "3  - top queue\n" +
                    "4  - start\n" +
                    "5  - stop\n" +
                    "6  - restart\n" +
                    "7  - status\n" +
                    "8  - read configuration\n" +
                    "9  - set configuration\n" +
                    "0  - exit");
            System.out.print("Please enter desired action: ");
            String inputStr = scanner.nextLine();
            try {
                input = Integer.parseInt(inputStr);
            } catch (Exception ignored) {
            }

            if (input < 0 || input > 9) {
                System.out.println("Entered input was not valid..");
                Thread.sleep(1500);
            } else if (input == 0) {
                System.out.println("Exiting... Bye!");
                Thread.sleep(800);
                break;
            } else {
                chooseAction(input);
            }
        }
    }

    private static void chooseAction(int input) throws RemoteException, InterruptedException {
        switch (input) {
            case 1:
                System.out.println(printer.print(fileName, printerName, session));
                break;
            case 2:
                System.out.println(printer.queue(printerName, session));
                break;
            case 3:
                System.out.println(printer.topQueue(printerName, job, session));
                break;
            case 4:
                System.out.println(printer.start(session));
                break;
            case 5:
                System.out.println(printer.stop(session));
                break;
            case 6:
                System.out.println(printer.restart(session));
                break;
            case 7:
                System.out.println(printer.status(printerName, session));
                break;
            case 8:
                System.out.println(printer.readConfig("param", session));
                break;
            case 9:
                System.out.println(printer.setConfig("param", "TRUE", session));
                break;
        }

        Thread.sleep(2000);
    }

    public static void login() throws RemoteException, InterruptedException {

        System.out.println("Please enter credentials to login...");

        while (true) {
            System.out.print("Username: ");
            String userName = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();
            session = printer.login(userName, password);
            if (session != null) break;
            System.out.println("Incorrect username or password. Please try again..");
            Thread.sleep(1200);
        }
        System.out.println("Successfully logged in!");
        Thread.sleep(1200);
    }
}
