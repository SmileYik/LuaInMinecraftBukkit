package tk.smileyik;

import java.io.*;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class NetWorkTest {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 16666);
        Scanner in = new Scanner(System.in);
        InputStream inputStream = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        OutputStream outputStream = socket.getOutputStream();
        while (in.hasNextLine()) {
            String line = in.nextLine();
            outputStream.write((line + "\n").getBytes());
            outputStream.flush();
            if (br.ready()) {
                System.out.println("Got: " + br.readLine());
            }
        }
        socket.close();
    }
}
