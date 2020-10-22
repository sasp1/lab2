import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class PrinterImpl extends UnicastRemoteObject implements PrinterI {


    public PrinterImpl() throws RemoteException {

    }

    @Override
    public String print(String filename, String printer) {
        String result = "Printing " + filename + " on printer " + printer+"\n";
        System.out.println(result);
        return result;
    }

    @Override
    public String queue(String printer) {
        String result = "JOB\tFILENAME\n323\t02239_lab1.pdf\n324\t02233_lab1.pdf" +
                "\n325\tinternet-cat.png\n326\tmy-credit-card-details.pdf\n327\tdata-security.pdf\n";
        System.out.println(result);
        return result;
    }

    @Override
    public String topQueue(String printer, int job) {
        String result = "Moving job " + job  + " to the top of the queue on printer " + printer +"...\nDone!\n";
        System.out.println(result);
        return result;
    }

    @Override
    public String start() {
        String result = "Starting print server...\n";
        System.out.println(result);
        return result;
    }

    @Override
    public String stop() {
        String result = "Stopping print server...\n";
        System.out.println(result);
        return result;
    }

    @Override
    public String restart() {
        String result = "Restart initiated...\nPrint queue cleared...\nRebooting...\n";
        System.out.println(result);
        return result;
    }

    @Override
    public String status(String printer) {
        String result = "Status of printer " + printer +": Online and available.\n";
        System.out.println(result);
        return result;
    }

    @Override
    public String readConfig(String parameter) {
        String result = parameter + " = " + "TRUE\n";
        System.out.println(result);
        return result;

    }

    @Override
    public String setConfig(String parameter, String value) {
        String result = "Setting parameter " + parameter  + " equal to " + value +"...\nDone!\n";
        System.out.println(result);
        return result;
    }
}
