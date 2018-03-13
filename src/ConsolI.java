
import java.rmi.Remote;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alt
 */
public interface ConsolI extends Remote {
    
    public void addData(String name) throws java.rmi.RemoteException; 
    public void removeData(String name) throws java.rmi.RemoteException;
    public ArrayList<String> getData() throws java.rmi.RemoteException;
    public String login(String user, String passwd) throws java.rmi.RemoteException;
    
    
}
