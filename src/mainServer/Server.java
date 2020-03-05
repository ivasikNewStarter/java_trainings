package mainServer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

public class Server {
    ArrayList clientArrayList; //zmienne globalne
    PrintWriter printWriter;

    // main
    public static void main(String[] args) {

        Server s = new Server();
     s.startServer();
    }

     // startServer
    public void startServer(){
        clientArrayList = new ArrayList();

        try {
            ServerSocket serverSocket = new ServerSocket( 5000);
            while(true) {
                Socket socket = serverSocket.accept();
                System.out.println("Listen" + serverSocket); // server slucha IP
                printWriter = new PrintWriter(socket.getOutputStream()); // strumien wyjsciowy -- wysylamy komunikaty do klinetow
                clientArrayList.add(printWriter); // dodajemy klienta

                Thread t = new Thread(new SerwerClient(socket));
                t.start();

            }

        } catch (Exception e){
            e.printStackTrace();
        }

    }

    // klasa wewnetrzna -- zwykla klasa bo nie moze byc 2 public
    class SerwerClient  implements Runnable  {

        Socket socket; // przechwycenia co przyjdzie do tej klasy
        BufferedReader bufferedReader;  // odczytanie wiadomosci od klienta

        // konstruktot
        public SerwerClient(Socket socketClient) {
            try {
                System.out.println("Connected"); // kots sie podlaczony jak bedize uruchomiany konstruktor
                socket = socketClient;
                bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));// pozwala odczytac wiadomosc ktora weszla;

            } catch (Exception e){
                    e.printStackTrace();
          }
        }
        // odczytanie co wpada do serwera
        @Override
        public void run() {
            String str;
            PrintWriter pw =null; // rozsylanie osobnego watku, ktory jest pusty;
            try {

                while ((str = bufferedReader.readLine()) != null) // string nie jest pusty
                {
                    System.out.println("Odebrane >>");

                    Iterator it = clientArrayList.iterator();  //lista podlaczonych klientow i rozsylamy wiadomosc
                    while (it.hasNext()){
                        pw = (PrintWriter) it.next();
                        pw.println(str); // wyrzuca co jest w bufferedReader
                        pw.flush(); //clear strumien
                    }
                }
            } catch (Exception e){
                //e.printStackTrace();
            }

        }
    }
}
