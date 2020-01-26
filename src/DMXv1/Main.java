package DMXv1;

import com.fazecast.jSerialComm.SerialPort;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

import static java.awt.Font.BOLD;

/**
 * Created by acer on 19-Nov-17.
 */
class Main {
    public static void main(String[] args) {

        Interface dmxInterface=new Interface();
        dmxInterface.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        dmxInterface.setLayout(new GridBagLayout());
        dmxInterface.setSize(930,500);
        dmxInterface.setVisible(true);
        dmxInterface.setEnabled(true);
        dmxInterface.setResizable(true);
        dmxInterface.setTitle("DMX-UOP v1(CNDU)");
        dmxInterface.setBackground(Color.BLUE);

    }
}

  class Interface extends JFrame{

      public int selectedButton=1;
      GridBagConstraints con=new GridBagConstraints();

            private JPanel panBg,panArduino;
            private JLabel lblRed,lblGreen,lblBlue,lblDelay,lblName,lblSelectedptn,lblArdConn,lblArd,lblComPort,lblCompany;
            private JSlider slRed , slGreen , slBlue , slDelay;
            private JRadioButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16;
            private ButtonGroup group;
            private JComboBox cmbArduino;
            private JButton btnArdConn;

    public Interface (){

        panBg = new JPanel(new GridBagLayout());
        panBg.setBackground(Color.GRAY);
        add(panBg);

        lblName = new JLabel("CNDU");
        lblName.setVisible(true);
        lblName.setEnabled(true);
        lblName.setFont(new Font(null,Font.TYPE1_FONT,25));
        lblName.setForeground(Color.WHITE);
        con.gridx = 1;
        con.gridy = 0;
        con.weightx = 4;
        con.weighty = 1;
        con.gridwidth = 4;
        con.gridheight = 1;
        con.fill = GridBagConstraints.BOTH;
        panBg.add(lblName,con);

        slRed = new JSlider(JSlider.VERTICAL,0,10,10);
        slRed.setVisible(true);
        slRed.setEnabled(true);
        slRed.setMajorTickSpacing(1);
        slRed.setPaintTicks(true);
        slRed.setFont(new Font(null,Font.PLAIN,13));
        slRed.setSnapToTicks(true);
        slRed.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        con.gridx = 0;
        con.gridy = 1;
        con.weightx = 1;
        con.weighty = 4;
        con.gridwidth = 1;
        con.gridheight = 4;
        con.fill = GridBagConstraints.BOTH;
        panBg.add(slRed,con);

        slGreen = new JSlider(JSlider.VERTICAL,0,10,10);
        slGreen.setVisible(true);
        slGreen.setEnabled(true);
        slGreen.setMajorTickSpacing(1);
        slGreen.setPaintTicks(true);
        slGreen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        con.gridx = 1;
        con.gridy = 1;
        con.weightx = 1;
        con.weighty = 4;
        con.gridwidth = 1;
        con.gridheight = 4;
        con.fill = GridBagConstraints.BOTH;
        panBg.add(slGreen,con);

        slBlue = new JSlider(JSlider.VERTICAL,0,10,10);
        slBlue.setVisible(true);
        slBlue.setEnabled(true);
        slBlue.setMajorTickSpacing(1);
        slBlue.setPaintTicks(true);
        slBlue.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        con.gridx = 2;
        con.gridy = 1;
        con.weightx = 1;
        con.weighty = 4;
        con.gridwidth = 1;
        con.gridheight = 4;
        con.fill = GridBagConstraints.BOTH;
        panBg.add(slBlue,con);


        slDelay = new JSlider(JSlider.VERTICAL,0,10,10);
        slDelay.setVisible(true);
        slDelay.setEnabled(true);
        slDelay.setMajorTickSpacing(1);
        slDelay.setPaintTicks(true);
        slDelay.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        con.gridx = 3;
        con.gridy = 1;
        con.weightx = 1;
        con.weighty = 4;
        con.gridwidth = 1;
        con.gridheight = 4;
        con.fill = GridBagConstraints.BOTH;
        panBg.add(slDelay,con);

        Font radioButtonFont = new Font(null,Font.PLAIN,20);
        Cursor handCursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);

        b1 = new JRadioButton("Pattern 1",true);
        b1.setFont(radioButtonFont);
        b1.setCursor(handCursor);
        con.gridx = 5;
        con.gridy = 1;
        con.weightx = 1;
        con.weighty = 2;
        con.gridwidth = 1;
        con.gridheight = 1;
        con.fill = GridBagConstraints.BOTH;
        panBg.add(b1,con);

        b2 = new JRadioButton("Pattern 2",false);
        b2.setFont(radioButtonFont);
        b2.setCursor(handCursor);
        con.gridx = 6;
        con.gridy = 1;
        con.weightx = 1;
        con.weighty = 2;
        con.gridwidth = 1;
        con.gridheight = 1;
        con.fill = GridBagConstraints.BOTH;
        panBg.add(b2,con);

        b3 = new JRadioButton("Pattern 3",false);
        b3.setFont(radioButtonFont);
        b3.setCursor(handCursor);
        con.gridx = 7;
        con.gridy = 1;
        con.weightx = 1;
        con.weighty = 2;
        con.gridwidth = 1;
        con.gridheight = 1;
        con.fill = GridBagConstraints.BOTH;
        panBg.add(b3,con);

        b4 = new JRadioButton("Pattern 4",false);
        b4.setFont(radioButtonFont);
        b4.setCursor(handCursor);
        con.gridx = 8;
        con.gridy = 1;
        con.weightx = 1;
        con.weighty = 2;
        con.gridwidth = 1;
        con.gridheight = 1;
        con.fill = GridBagConstraints.BOTH;
        panBg.add(b4,con);

        b5 = new JRadioButton("Pattern 5",false);
        b5.setFont(radioButtonFont);
        b5.setCursor(handCursor);
        con.gridx = 5;
        con.gridy = 2;
        con.weightx = 1;
        con.weighty = 2;
        con.gridwidth = 1;
        con.gridheight = 1;
        con.fill = GridBagConstraints.BOTH;
        panBg.add(b5,con);

        b6 = new JRadioButton("Pattern 6",false);
        b6.setFont(radioButtonFont);
        b6.setCursor(handCursor);
        con.gridx = 6;
        con.gridy = 2;
        con.weightx = 1;
        con.weighty = 2;
        con.gridwidth = 1;
        con.gridheight = 1;
        con.fill = GridBagConstraints.BOTH;
        panBg.add(b6,con);

        b7 = new JRadioButton("Pattern 7",false);
        b7.setFont(radioButtonFont);
        b7.setCursor(handCursor);
        con.gridx = 7;
        con.gridy = 2;
        con.weightx = 1;
        con.weighty = 2;
        con.gridwidth = 1;
        con.gridheight = 1;
        con.fill = GridBagConstraints.BOTH;
        panBg.add(b7,con);

        b8 = new JRadioButton("Pattern 8",false);
        b8.setFont(radioButtonFont);
        b8.setCursor(handCursor);
        con.gridx = 8;
        con.gridy = 2;
        con.weightx = 1;
        con.weighty = 2;
        con.gridwidth = 1;
        con.gridheight = 1;
        con.fill = GridBagConstraints.BOTH;
        panBg.add(b8,con);

        b9 = new JRadioButton("Pattern 9",false);
        b9.setFont(radioButtonFont);
        b9.setCursor(handCursor);
        con.gridx = 5;
        con.gridy = 3;
        con.weightx = 1;
        con.weighty = 2;
        con.gridwidth = 1;
        con.gridheight = 1;
        con.fill = GridBagConstraints.BOTH;
        panBg.add(b9,con);

        b10 = new JRadioButton("Pattern 10",false);
        b10.setFont(radioButtonFont);
        b10.setCursor(handCursor);
        con.gridx = 6;
        con.gridy = 3;
        con.weightx = 1;
        con.weighty = 2;
        con.gridwidth = 1;
        con.gridheight = 1;
        con.fill = GridBagConstraints.BOTH;
        panBg.add(b10,con);

        b11 = new JRadioButton("Pattern 11",false);
        b11.setFont(radioButtonFont);
        b11.setCursor(handCursor);
        con.gridx = 7;
        con.gridy = 3;
        con.weightx = 1;
        con.weighty = 2;
        con.gridwidth = 1;
        con.gridheight = 1;
        con.fill = GridBagConstraints.BOTH;
        panBg.add(b11,con);

        b12 = new JRadioButton("Pattern 12",false);
        b12.setFont(radioButtonFont);
        b12.setCursor(handCursor);
        con.gridx = 8;
        con.gridy = 3;
        con.weightx = 1;
        con.weighty = 2;
        con.gridwidth = 1;
        con.gridheight = 1;
        con.fill = GridBagConstraints.BOTH;
        panBg.add(b12,con);

        b13 = new JRadioButton("Pattern 13",false);
        b13.setFont(radioButtonFont);
        b13.setCursor(handCursor);
        con.gridx = 5;
        con.gridy = 4;
        con.weightx = 1;
        con.weighty = 2;
        con.gridwidth = 1;
        con.gridheight = 1;
        con.fill = GridBagConstraints.BOTH;
        panBg.add(b13,con);

        b14 = new JRadioButton("Pattern 14",false);
        b14.setFont(radioButtonFont);
        b14.setCursor(handCursor);
        con.gridx = 6;
        con.gridy = 4;
        con.weightx = 1;
        con.weighty = 2;
        con.gridwidth = 1;
        con.gridheight = 1;
        con.fill = GridBagConstraints.BOTH;
        panBg.add(b14,con);

        b15 = new JRadioButton("Pattern 15",false);
        b15.setFont(radioButtonFont);
        b15.setCursor(handCursor);
        con.gridx = 7;
        con.gridy = 4;
        con.weightx = 1;
        con.weighty = 2;
        con.gridwidth = 1;
        con.gridheight = 1;
        con.fill = GridBagConstraints.BOTH;
        panBg.add(b15,con);

        b16 = new JRadioButton("Pattern 16",false);
        b16.setFont(radioButtonFont);
        b16.setCursor(handCursor);
        con.gridx = 8;
        con.gridy = 4;
        con.weightx = 1;
        con.weighty = 2;
        con.gridwidth = 1;
        con.gridheight = 1;
        con.fill = GridBagConstraints.BOTH;
        panBg.add(b16,con);

        group = new ButtonGroup();
        group.add(b1);
        group.add(b2);
        group.add(b3);
        group.add(b4);
        group.add(b5);
        group.add(b6);
        group.add(b7);
        group.add(b8);
        group.add(b9);
        group.add(b10);
        group.add(b11);
        group.add(b12);
        group.add(b13);
        group.add(b14);
        group.add(b15);
        group.add(b16);

        lblSelectedptn = new JLabel();
        lblSelectedptn.setFont(new Font(null,Font.BOLD,22));
        lblSelectedptn.setForeground(Color.BLACK);
        lblSelectedptn.setText("Pattern 1 is Rinning");
        lblSelectedptn.setHorizontalAlignment(0);
        con.gridx = 5;
        con.gridy = 5;
        con.weightx = 4;
        con.weighty = 1;
        con.gridwidth = 4;
        con.gridheight = 1;
        con.fill = GridBagConstraints.BOTH;
        panBg.add(lblSelectedptn,con);

        lblRed = new JLabel("| Red "+slRed.getValue()+" |");
        lblRed.setForeground(Color.RED);
        lblRed.setFont(new Font(null, Font.BOLD,18));
        con.gridx = 0;
        con.gridy = 5;
        con.weightx = 1;
        con.weighty = 1;
        con.gridwidth = 1;
        con.gridheight = 1;
        con.fill = GridBagConstraints.BOTH;
        panBg.add(lblRed,con);

        lblGreen = new JLabel("| Green "+slGreen.getValue()+" |");
        lblGreen.setForeground(Color.green);
        lblGreen.setFont(new Font(null,Font.BOLD,18));
        con.gridx = 1;
        con.gridy = 5;
        con.weightx = 1;
        con.weighty = 1;
        con.gridwidth = 1;
        con.gridheight = 1;
        con.fill = GridBagConstraints.BOTH;
        panBg.add(lblGreen,con);


        lblBlue  = new JLabel("| Blue "+slBlue.getValue()+" |");
        lblBlue.setForeground(Color.BLUE);
        lblBlue.setFont(new Font(null,Font.BOLD,18));
        con.gridx = 2;
        con.gridy = 5;
        con.weightx = 1;
        con.weighty = 1;
        con.gridwidth = 1;
        con.gridheight = 1;
        con.fill = GridBagConstraints.BOTH;
        panBg.add(lblBlue,con);

        lblDelay  = new JLabel("| Delay "+slDelay.getValue()+"ms |");
        lblDelay.setForeground(Color.BLACK);
        lblDelay.setFont(new Font(null,Font.BOLD,18));
        con.gridx = 3;
        con.gridy = 5;
        con.weightx = 1;
        con.weighty = 1;
        con.gridwidth = 1;
        con.gridheight = 1;
        con.fill = GridBagConstraints.BOTH;
        panBg.add(lblDelay,con);

        panArduino = new JPanel(new GridBagLayout());
        panArduino.setEnabled(true);
        panArduino.setVisible(true);
        panArduino.setBackground(Color.BLACK);
        con.gridx = 0;
        con.gridy = 6;
        con.weightx = 8;
        con.weighty = 4;
        con.gridwidth = 9;
        con.gridheight = 4;
        con.fill = GridBagConstraints.BOTH;
        panBg.add(panArduino,con);

        lblArd = new JLabel("Arduino Connection");
        lblArd.setFont(new Font(null,Font.BOLD,19));
        lblArd.setVisible(true);
        lblArd.setForeground(Color.WHITE);
        con.gridx = 0;
        con.gridy = 0;
        con.weightx = 8;
        con.weighty = 1;
        con.gridwidth = 8;
        con.gridheight = 1;
        con.fill = GridBagConstraints.BOTH;
        panArduino.add(lblArd,con);

        lblArdConn = new JLabel("Create Connection");
        lblArdConn.setVisible(true);
        lblArdConn.setFont(new Font(null,Font.PLAIN,15));
        lblArdConn.setForeground(Color.WHITE);
        con.gridx = 1;
        con.gridy = 1;
        con.weightx = 8;
        con.weighty = 1;
        con.gridwidth = 8;
        con.gridheight = 1;
        con.fill = GridBagConstraints.BOTH;
        panArduino.add(lblArdConn,con);

        lblComPort =new JLabel("Com Port : ");
        lblComPort.setVisible(true);
        lblComPort.setFont(new Font(null,Font.BOLD,14));
        lblComPort.setForeground(Color.WHITE);
        con.gridx = 2;
        con.gridy = 2;
        con.weightx = 1;
        con.weighty = 1;
        con.gridwidth = 1;
        con.gridheight = 1;
        con.fill = GridBagConstraints.BOTH;
        panArduino.add(lblComPort,con);

        cmbArduino = new JComboBox();
        cmbArduino.setEnabled(true);
        cmbArduino.setVisible(true);
        cmbArduino.setFont(new Font(null,Font.PLAIN,14));
        cmbArduino.setBackground(Color.black);
        cmbArduino.setForeground(Color.WHITE);
        con.gridx = 4;
        con.gridy = 2;
        con.weightx = 1;
        con.weighty = 1;
        con.gridwidth = 1;
        con.gridheight = 1;
        con.fill = GridBagConstraints.BOTH;
        panArduino.add(cmbArduino,con);

        /**
         * ADD AVAILABLE COM PORTS TO cmbArduino;
         */
        try{
            SerialPort[] portNames = SerialPort.getCommPorts();
            for (int i = 0; i < portNames.length; i++)
                cmbArduino.addItem(portNames[i].getSystemPortName());
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error Loading COm Ports:\n"+e.getCause(),"Error",JOptionPane.ERROR_MESSAGE);
        }

        btnArdConn = new JButton("Connect");
        btnArdConn.setVisible(true);
        btnArdConn.setEnabled(true);
        btnArdConn.setBackground(Color.gray);
        btnArdConn.setForeground(Color.WHITE);
        btnArdConn.setFont(new Font(null,Font.BOLD,15));
        con.gridx = 6;
        con.gridy = 2;
        con.weightx = 2;
        con.weighty = 1;
        con.gridwidth = 2;
        con.gridheight = 1;
        con.fill = GridBagConstraints.BOTH;
        panArduino.add(btnArdConn,con);

        lblCompany = new JLabel("Created by Darshana Ariyarathna and Sajith Chamara");
        lblCompany.setEnabled(true);
        lblCompany.setVisible(true);
        lblCompany.setForeground(Color.green);
        lblCompany.setBackground(Color.black);
        lblCompany.setFont(new Font(null,Font.ITALIC,15));
        con.gridx = 0;
        con.gridy = 4;
        con.weightx = 8;
        con.weighty = 1;
        con.gridwidth = 6;
        con.gridheight = 1;
        con.fill = GridBagConstraints.BOTH;
        panArduino.add(lblCompany,con);

        /**
         * END OF ADDING COMPONENTS..
         *
         * START TO SET ACTION LISTENERS..
         */

        slRed.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lblRed.setText("| Red "+slRed.getValue()+" |");
                slRed.setToolTipText(String.valueOf(slRed.getValue()));
            }
        });

        slGreen.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lblGreen.setText("| Green "+slGreen.getValue()+" |");
            }
        });

        slBlue.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lblBlue.setText("| Blue "+slBlue.getValue()+" |");
            }
        });

        slDelay.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lblDelay.setText("| Delay "+slDelay.getValue()+"ms |");

            }
        });

        slRed.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                slRed.setToolTipText(String.valueOf(slRed.getValue()));
            }
        });

        slGreen.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                slGreen.setToolTipText(String.valueOf(slGreen.getValue()));
            }
        });
        slBlue.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                slBlue.setToolTipText(String.valueOf(slBlue.getValue()));
            }
        });
        slDelay.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                slDelay.setToolTipText(String.valueOf(slDelay.getValue()));
            }
        });

        b1.addItemListener(new HandlerClass("1"));
        b2.addItemListener(new HandlerClass("2"));
        b3.addItemListener(new HandlerClass("3"));
        b4.addItemListener(new HandlerClass("4"));
        b5.addItemListener(new HandlerClass("5"));
        b6.addItemListener(new HandlerClass("6"));
        b7.addItemListener(new HandlerClass("7"));
        b8.addItemListener(new HandlerClass("8"));
        b9.addItemListener(new HandlerClass("9"));
        b10.addItemListener(new HandlerClass("10"));
        b11.addItemListener(new HandlerClass("11"));
        b12.addItemListener(new HandlerClass("12"));
        b13.addItemListener(new HandlerClass("13"));
        b14.addItemListener(new HandlerClass("14"));
        b15.addItemListener(new HandlerClass("15"));
        b16.addItemListener(new HandlerClass("16"));

        btnArdConn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (btnArdConn.getText().equals("Connect")){

                    boolean arduinoConnDone = Arduino.CreateConn(cmbArduino.getSelectedItem().toString());

                    if (arduinoConnDone==true){
                        lblArdConn.setText("Connected");
                        btnArdConn.setText("Disconnect");
                        cmbArduino.setEnabled(false);

                        Thread thread =new Thread() {
                            @Override
                            public void run() {
                                try{Thread.sleep(1000);}catch (Exception e1){} //WAIT TO ARDUINO SEND INITIAL REQUEST DATA TO JAVA.
                                //System.out.println("Inside Thread");
                                while (btnArdConn.getText().equals("Disconnect")){
                                    //Arduino.send(selectedButton, slDelay.getValue(), slRed.getValue(), slGreen.getValue(), slBlue.getValue());
                                    //try {Thread.sleep(600);} catch (Exception e) {}

                                    int requested=Arduino.receive();
                                    //System.out.println("Received :"+requested);
                                    //requested==1 is requesting all data;
                                    if (requested==1){
                                        Arduino.sendAll(selectedButton, slDelay.getValue(), slRed.getValue(), slGreen.getValue(), slBlue.getValue());
                                    }
                                    if (requested==2){

                                    }
                                    try{Thread.sleep(50);}catch (Exception e1){} //WAIT TO ARDUINO SEND REQUEST DATA TO JAVA.
                                }
                            }
                        };thread.start();
                        //System.out.println("out");
                    }
                }else if(btnArdConn.getText().equals("Disconnect")){
                    Arduino.closeArduino();
                    lblArdConn.setText("Create Connection");
                    cmbArduino.setEnabled(true);
                    btnArdConn.setText("Connect");
                }
            }
        });
    }

      private class HandlerClass implements ItemListener{
          private String slcted;
          public HandlerClass(String selected){
              slcted = selected;
          }

          @Override
          public void itemStateChanged(ItemEvent e) {
              lblSelectedptn.setText("Pattern "+slcted+ " is Running");
              selectedButton = Integer.valueOf(slcted);
          }
      }
}