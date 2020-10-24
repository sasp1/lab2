import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class PrinterImpl extends UnicastRemoteObject implements PrinterI {

    ArrayList<String> currentSessions = new ArrayList<>();

    public PrinterImpl() throws RemoteException { }

    @Override
    public String print(String filename, String printer, String session) {
        if (!currentSessions.contains(session)) {
            return "You are not authorized to this command";
        } else {
            String result = "Printing " + filename + " on printer " + printer+"\n";
            System.out.println(result);
            return result;
        }
    }

    @Override
    public String queue(String printer,  String session) {
        if (!currentSessions.contains(session)) {
            return "You are not authorized to this command";
        } else {
            String result = "JOB\tFILENAME\n323\t02239_lab1.pdf\n324\t02233_lab1.pdf" +
                    "\n325\tinternet-cat.png\n326\tmy-credit-card-details.pdf\n327\tdata-security.pdf\n";
            System.out.println(result);
            return result;
        }
    }

    @Override
    public String topQueue(String printer, int job, String session) {
        if (!currentSessions.contains(session)) {
            return "You are not authorized to this command";
        } else {
            String result = "Moving job " + job + " to the top of the queue on printer " + printer + "...\nDone!\n";
            System.out.println(result);
            return result;
        }
    }

    @Override
    public String start(String session) {
        if (!currentSessions.contains(session)) {
            return "You are not authorized to this command";
        } else {
            String result = "Starting print server...\n";
            System.out.println(result);
            return result;
        }
    }

    @Override
    public String stop(String session) {
        if (!currentSessions.contains(session)) {
            return "You are not authorized to this command";
        } else {
            String result = "Stopping print server...\n";
            System.out.println(result);
            return result;
        }
    }

    @Override
    public String restart(String session) {
        if (!currentSessions.contains(session)) {
            return "You are not authorized to this command";
        } else {
            String result = "Restart initiated...\nPrint queue cleared...\nRebooting...\n";
            System.out.println(result);
            return result;
        }
    }

    @Override
    public String status(String printer, String session) {
        if (!currentSessions.contains(session)) {
            return "You are not authorized to this command";
        } else {
            String result = "Status of printer " + printer + ": Online and available.\n";
            System.out.println(result);
            return result;
        }
    }

    @Override
    public String readConfig(String parameter, String session) {
        if (!currentSessions.contains(session)) {
            return "You are not authorized to this command";
        } else {
            String result = parameter + " = " + "TRUE\n";
            System.out.println(result);
            return result;
        }
    }

    @Override
    public String setConfig(String parameter, String value, String session) {
        if (!currentSessions.contains(session)) {
            return "You are not authorized to this command";
        } else {
            String result = "Setting parameter " + parameter + " equal to " + value + "...\nDone!\n";
            System.out.println(result);
            return result;
        }
    }

    @Override
    public String login(String password) {
        try {
            File file = new File("password.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while((line = br.readLine())!=null){
                String[] parts = line.split(":");

                String salt = parts[0];
                String encryptedPassword = parts[1];

                if (Secure.getSecurePassword(password, Base64.getDecoder().decode(salt)).equals(encryptedPassword)) {
                    System.out.println("A login request was granted");
                    String session = Base64.getEncoder().encodeToString(Secure.getSalt());
                    currentSessions.add(session);
                    return session;
                }
            }
            fr.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("A log in request was denied");
        return null;
    }
}
