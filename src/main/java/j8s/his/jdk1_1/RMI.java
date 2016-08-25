package j8s.his.jdk1_1;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
/**
 * 需要将代码打包成jar : 
 * <br />
 * <code> jar cvfm ceddo.jar manifest.mf j8s/ . </code>
 * 
 * @author cedo
 *
 */
public class RMI implements _Hello {

	@Override
	public String sayHello() throws RemoteException {
		return "hello, rmi client";
	}

	public static void main(String[] args) {
		//权限异常 ：    Server exception: java.security.AccessControlException: access denied ("java.net.SocketPermission" "127.0.0.1:1099" "connect,resolve")
		/*if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}*/
		try {
			RMI obj = new RMI();
			_Hello stub = (_Hello) UnicastRemoteObject.exportObject(obj, 0);

			// Bind the remote object's stub in the registry
			Registry registry = LocateRegistry.getRegistry();
			registry.bind("Hello", stub);

			System.err.println("Server ready");
		} catch (Exception e) {
			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();
		}
	}

}
