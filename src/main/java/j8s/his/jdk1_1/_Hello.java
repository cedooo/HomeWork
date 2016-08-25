package j8s.his.jdk1_1;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface  _Hello extends Remote{
    String sayHello() throws RemoteException;
}
