package mainLesson14;

import java.net.*;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

public class net {
    public static void main(String[] args) throws Exception {
        InetAddress iNet = InetAddress.getLocalHost();
        System.out.println(iNet);
        net n = new net();
        n.getHostAddresses();

        /*InetAddress address [] = InetAddress.getAllByName("");
        for (int i = 0; i < address.length; i++) {
            System.out.println(address[i]);
        }
        iNet = InetAddress.getLoopbackAddress();
        System.out.println(iNet);

        URL url = new URL("https://www.youtube.com/watch?v=jgh8CQK4K78");
        System.out.println(url.getProtocol());
        System.out.println(url.getHost());
        System.out.println(url.getPort());*/

    }
    private String[] getHostAddresses() {
        Set<String> HostAddresses = new HashSet<>();
        try {
            for (NetworkInterface ni : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (!ni.isLoopback() && ni.isUp() && ni.getHardwareAddress() != null) {
                    for (InterfaceAddress ia : ni.getInterfaceAddresses()) {
                        if (ia.getBroadcast() != null) {  //If limited to IPV4
                            HostAddresses.add(ia.getAddress().getHostAddress());
                        }
                    }
                }
            }
        } catch (SocketException e) { }
        return HostAddresses.toArray(new String[0]);
    }

    }

