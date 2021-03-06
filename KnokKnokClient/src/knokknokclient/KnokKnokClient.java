/* @author chad */
package knokknokclient;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KnokKnokClient {

    private SocketAddress serverSocketAddress;
    private DatagramSocket socket;

    public KnokKnokClient() throws UnknownHostException, SocketException {
        Random random = new Random(new Date().getTime());
        socket = new DatagramSocket(random.nextInt(60000) + 10000);
        this.serverSocketAddress = new InetSocketAddress(InetAddress.getLocalHost(), 8888);
    }

    public static void main(String[] args) throws UnknownHostException, SocketException {
        KnokKnokClient aClient = new KnokKnokClient();
        for (int i = 0; i < 10; i++) {
            aClient.sendMessage("abc");
        }
        //abc
    }

    private void sendMessage(String mes) {
        try {
            byte[] buf = mes.getBytes();
            DatagramPacket packet = new DatagramPacket(buf, buf.length, serverSocketAddress);
            socket.send(packet);
        } catch (IOException ex) {
            Logger.getLogger(KnokKnokClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
