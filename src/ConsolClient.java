
import java.rmi.Naming;
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
        ConsolI con = (ConsolI) Naming.lookup("rmi://188.166.168.107:1099/ConsolApplication");
        
        System.out.println("enter user");
        user = scanner.nextLine();
        System.out.println("enter password");
        passwd = scanner.nextLine();
        System.out.println(con.login(user, passwd));
        
        while (true) {
            System.out.println("enter command");
            input = scanner.nextLine();

            if ("add".equals(input)) {
                System.out.println("enter name");
                input = scanner.nextLine();
                con.addData(input);
                System.out.println(con.getData());
            } else if ("remove".equals(input)) {
                System.out.println("enter name");
                input = scanner.nextLine();
                con.removeData(input);
                System.out.println(con.getData());
            } else {
                System.err.println("unknown command");
            }

        }

    }

}
