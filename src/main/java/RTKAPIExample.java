import com.drdanick.McRKit.api.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class RTKAPIExample {
	
	public static void main(String[]args) {
		new RTKAPIExample().start();
	}
	
	public void start() {
		RTKInterface api = new RTKInterface(25561, "localhost", "user", "pass", "salt");

		try{
			api.executeCommand(RTKInterface.CommandType.VERSION, null);
		} catch(IOException e) {
			e.printStackTrace();
			System.exit(1);
		} catch(RTKInterfaceException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		System.out.println("Waiting for response. Press ctrl+c to exit.");
		try {
			System.out.println("Response from toolkit: "+api.getLastResponse());
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		System.exit(0);
	}

	private static String readInput(){
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			return in.readLine();
		} catch(IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return "";
	}
	
}