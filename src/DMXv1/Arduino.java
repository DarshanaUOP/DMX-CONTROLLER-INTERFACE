package DMXv1;

import com.fazecast.jSerialComm.SerialPort;

import javax.swing.*;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by acer on 20-Nov-17.
 */
public class Arduino {

    static SerialPort choosenPort;

    public static boolean CreateConn(String portName) {
        choosenPort = SerialPort.getCommPort(portName);
        choosenPort.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0, 0);
        try {
            if (choosenPort.openPort()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, "Communication Error", "Error", JOptionPane.PLAIN_MESSAGE);
        }
    return false;
    }

    public static void closeArduino(){
        choosenPort.closePort();
    }
    public static void sendAll(int pattern,int delay,int R,int G,int B){
        try{
            PrintWriter output = new PrintWriter(choosenPort.getOutputStream());
            output.print(pattern+","+delay*10+","+R*10+","+G*10+","+B*100);
            //System.out.println(pattern+","+delay*10+","+R*100+","+G*100+","+B*100+",");
            /**
             * THE OUT PUT BIT STREAM IS
             *      PATTERN NUMBER
             *      DELAY TIME
             *      RED
             *      GREEN and
             *      BLUE
             */
            //output.print(pattern-1);
            //System.out.println(pattern-1);
            output.flush();
            try {Thread.sleep(10);} catch (Exception e) {}


        }catch (Exception e){}
    }

    public static int receive(){
        try {
            int request;
            Scanner scanner = new Scanner(choosenPort.getInputStream());
            while (scanner.hasNextLine()){
                try {
                    request = scanner.nextInt();
                    return request;
                }catch (Exception e){}
            }

        }catch (Exception e){}
    return 0;
    }
}


