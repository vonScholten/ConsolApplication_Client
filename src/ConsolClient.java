
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Alt
 */
public class ConsolClient {

    private static ConsolI con;
    private static Scanner scanner = new Scanner(System.in);
    private static String input;
    private static String user;
    private static String passwd;

    public static void main(String[] arg) throws Exception {
        Registry registry = LocateRegistry.getRegistry();

        con = (ConsolI) Naming.lookup("rmi://ubuntu4.saluton.dk:3097/ConsolApplication");
        //con = (ConsolI) Naming.lookup("rmi://192.168.1.7:3097/ConsolApplication");
        System.out.println(con.greetings());

        System.out.println("enter user");
        user = scanner.nextLine();
        System.out.println("enter password");
        passwd = scanner.nextLine();

            try {
                con.login(user, passwd);
                System.out.println("bruger blev verificeret");
            } catch (Exception e) {
                System.err.println("login kunne ikke autoriseret " + e);
                System.out.println("prøv igen");
            }

        System.out.println(con.help());

        while (true) {
            System.out.println("enter a command or enter 'help'");
            input = scanner.nextLine();

            if (null == input) {
                System.err.println("unknown command");
            } else {
                switch (input) {
                    case "help":
                        System.out.println(con.help());
                        break;
                    case "add":
                        System.out.println("skriv det navn der skal tilføjes");
                        input = scanner.nextLine();
                        con.addData(input);
                        System.out.println(con.getData());
                        break;
                    case "remove":
                        System.out.println("skriv det navn skal fjernes");
                        input = scanner.nextLine();
                        con.removeData(input);
                        System.out.println(con.getData());
                        break;
                    case "show*":
                        System.out.println(con.getData());
                        break;
                    case "c":

                        break;
                    case "exit":
                        System.out.println("farvel");
                        System.exit(0);
                        break;
                    default:
                        System.err.println("unknown command \n" + con.help());
                        break;

                }
            }

        }

    }
}
