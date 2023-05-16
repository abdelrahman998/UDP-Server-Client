import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Main {

    public static void main(String[] args) {
	    try {
            // accepts a port number
            DatagramSocket socket = new DatagramSocket(5000);

            while(true) {
                // accept data from the socket
                byte[] buffer = new byte[50];



                // populated with whatever is received from the socket
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                // fill that packet with the content
                socket.receive(packet);
                System.out.println("Text received is: " + new String(buffer, 0, packet.getLength()));

//                String returnString = new String(buffer, 0, packet.getLength());
//                byte[] buffer2 = returnString.getBytes();
//                InetAddress address = packet.getAddress();
//                int port = packet.getPort();
//                packet = new DatagramPacket(buffer2, buffer2.length, address, port);
//                socket.send(packet);

            }

         // represents an exception that occurred during a socket operation.
        } catch(SocketException e) {
            System.out.println("SocketException: " + e.getMessage());

         // an exception that occurred during an input or output operation.
        } catch(IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}
