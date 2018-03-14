
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

    static Scanner scanner = new Scanner(System.in);
    static String input;
    static String user;
    static String passwd;

    public static void main(String[] arg) throws Exception {
        Registry registry = LocateRegistry.getRegistry();
        ConsolI con = (ConsolI) Naming.lookup("rmi://ubuntu4.saluton.dk:3097/ConsolApplication");
        System.out.println(con.greetings());

        System.out.println("enter user");
        user = scanner.nextLine();
        System.out.println("enter password");
        passwd = scanner.nextLine();
        con.login(user, passwd);

        while (true) {
            System.out.println("enter a command or enter 'help'");
            input = scanner.nextLine();

            if (null == input) {
                System.err.println("unknown command");
            } else switch (input) {
                case "help":
                    System.out.println("type: 'add' to add a new name, 'remove' to remove a name");
                    break;
                case "add":
                    System.out.println("enter name");
                    input = scanner.nextLine();
                    con.addData(input);
                    System.out.println(con.getData());
                    break;
                case "remove":
                    System.out.println("enter name");
                    input = scanner.nextLine();
                    con.removeData(input);
                    System.out.println(con.getData());
                    break;
                default:
                    System.err.println("unknown command");
                    break;
            }

        }

    }

}
