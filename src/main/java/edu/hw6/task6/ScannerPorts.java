package edu.hw6.task6;

import java.io.IOException;
import java.io.PrintStream;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScannerPorts {
    private static final Map<Integer, String> descriptionTCP = new HashMap<>() {
        {
            put(21, "FTP");
            put(22, "SSH");
            put(23, "Telnet");
            put(25, "SMTP");
            put(43, "WHOIS");
            put(53, "DNS");
            put(110, "POP3");
            put(139, "NetBIOS Session Service");
            put(443, "HTTPS");
            put(445, "Microsoft-DS (Directory Services) Active Directory");
        }
    };

    private static final Map<Integer, String> descriptionUDP = new HashMap<>(){{
        put(137, "NetBIOS Name Service");
        put(138, "NetBIOS Datagram Service");
        put(500, "ISAKMP");
        put(1900, "Simple Service Discovery Protocol (SSDP)");
        put(3702, "Web Services Dynamic Discovery (WS-Discovery)");
    }};

    public static void main(String[] arg) {
        scanPorts(System.out);
    }

    public static void scanPorts(PrintStream printStream) {
        List<Integer> openTCPPorts = new ArrayList<>();
        List<Integer> openUDPPorts = new ArrayList<>();

        for (int port = 0; port <= 49151; port++) {
            try (ServerSocket socket = new ServerSocket(port)) {
            } catch (IOException e) {
                openTCPPorts.add(port);
            }
            try (DatagramSocket datagramSocket = new DatagramSocket(port)) {
            } catch (SocketException e) {
                openUDPPorts.add(port);
            }
        }


        printStream.println("TCP");
        printStream.println("Port  Service");

        openTCPPorts.stream().forEach((x) -> printStream.println(x + " " + descriptionTCP.getOrDefault(x, "")));

        printStream.println("UDP");
        printStream.println("Port  Service");

        openUDPPorts.stream().forEach((x) -> printStream.println(x + " " + descriptionUDP.getOrDefault(x, "")));
    }
}
