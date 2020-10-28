import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Base64;
import java.util.HashMap;

public class PrinterImpl extends UnicastRemoteObject implements PrinterI {

    HashMap<String, String> currentSessionsToUsername = new HashMap<>();

    public PrinterImpl() throws RemoteException { }

    @Override
    public String print(String filename, String printer, String session) {
        if (currentSessionsToUsername.get(session) == null) {
            return "You are not authorized to this command";
        } else {
            String result = "Printing " + filename + " on printer " + printer+"\n";
            System.out.println(result + "called by the user: " + currentSessionsToUsername.get(session)+"\n");

            return result;
        }
    }

    @Override
    public String queue(String printer,  String session) {
        if (currentSessionsToUsername.get(session) == null) {
            return "You are not authorized to this command";
        } else {
            String result = "JOB\tFILENAME\n323\t02239_lab1.pdf\n324\t02233_lab1.pdf" +
                    "\n325\tinternet-cat.png\n326\tmy-credit-card-details.pdf\n327\tdata-security.pdf\n";
            System.out.println(result + " called by: " + currentSessionsToUsername.get(session));
            return result;
        }
    }

    @Override
    public String topQueue(String printer, int job, String session) {
        if (currentSessionsToUsername.get(session) == null) {
            return "You are not authorized to this command";
        } else {
            String result = "Moving job " + job + " to the top of the queue on printer " + printer + "...\nDone!\n";
            System.out.println(result + " called by: " + currentSessionsToUsername.get(session));
            return result;
        }
    }

    @Override
    public String start(String session) {
        if (currentSessionsToUsername.get(session) == null) {
            return "You are not authorized to this command";
        } else {
            String result = "Starting print server...\n";
            System.out.println(result + " called by: " + currentSessionsToUsername.get(session));
            return result;
        }
    }

    @Override
    public String stop(String session) {
        if (currentSessionsToUsername.get(session) == null) {
            return "You are not authorized to this command";
        } else {
            String result = "Stopping print server...\n";
            System.out.println(result + " called by: " + currentSessionsToUsername.get(session));
            return result;
        }
    }

    @Override
    public String restart(String session) {
        if (currentSessionsToUsername.get(session) == null) {
            return "You are not authorized to this command";
        } else {
            String result = "Restart initiated...\nPrint queue cleared...\nRebooting...\n";
            System.out.println(result + " called by: " + currentSessionsToUsername.get(session));
            return result;
        }
    }

    @Override
    public String status(String printer, String session) {
        if (currentSessionsToUsername.get(session) == null) {
            return "You are not authorized to this command";
        } else {
            String result = "Status of printer " + printer + ": Online and available.\n";
            System.out.println(result + " called by: " + currentSessionsToUsername.get(session));
            return result;
        }
    }

    @Override
    public String readConfig(String parameter, String session) {
        if (currentSessionsToUsername.get(session) == null) {
            return "You are not authorized to this command";
        } else {
            String result = parameter + " = " + "TRUE\n";
            System.out.println(result + " called by: " + currentSessionsToUsername.get(session));
            return result;
        }
    }

    @Override
    public String setConfig(String parameter, String value, String session) {
        if (currentSessionsToUsername.get(session) == null) {
            return "You are not authorized to this command";
        } else {
            String result = "Setting parameter " + parameter + " equal to " + value + "...\nDone!\n";
            System.out.println(result + " called by: " + currentSessionsToUsername.get(session));
            return result;
        }
    }

    @Override
    public String login(String inputUsername, String inputPassword) {

        try {
            File file = new File("password.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while((line = br.readLine())!=null){
                String[] parts = line.split(":");

                String username = parts[0];
                String salt = parts[1];
                String encryptedPassword = parts[2];

                if (inputUsername.equals(username) && Secure.getSecurePassword(inputPassword, Base64.getDecoder().decode(salt)).equals(encryptedPassword)) {
                    System.out.println("A login request was granted\n");
                    String session = Base64.getEncoder().encodeToString(Secure.getSalt());
                    currentSessionsToUsername.put(session, username);
                    return session;
                }
            }
            fr.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("A log in request was denied\n");
        return null;
    }
}
