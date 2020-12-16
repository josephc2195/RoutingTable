import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.Dimension.*;
import java.awt.event.*;


public class RoutingGUI {
    public JFrame frame;
    JButton button1;
    JTextField searchIP, ip1, ip2, ip3, mask1, mask2, mask3, hop1, hop2, hop3, hop4;
    JLabel defaultLabel = new JLabel("Default");
    JPanel searchPanel, routeTablePanel1, routeTablePanel2, routeTablePanel3, defaultRoute, submit;
    String ip_address;
    int num = 4;
    String routing_table[] = new String[num];
    String mask[] = new String[num];
    String hop[] = new String[num];

    public RoutingGUI() {
        frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        searchPanel = new JPanel();
        routeTablePanel1 = new JPanel();
        routeTablePanel2 = new JPanel();
        routeTablePanel3 = new JPanel();
        defaultRoute = new JPanel();
        submit = new JPanel();

        BoxLayout boxyY = new BoxLayout(searchPanel, BoxLayout.Y_AXIS);
        BoxLayout xAxis1 = new BoxLayout(routeTablePanel1, BoxLayout.X_AXIS);
        BoxLayout xAxis2 = new BoxLayout(routeTablePanel2, BoxLayout.X_AXIS);
        BoxLayout xAxis3 = new BoxLayout(routeTablePanel3, BoxLayout.X_AXIS);
        BoxLayout xAxis4 = new BoxLayout(defaultRoute, BoxLayout.X_AXIS);
        searchPanel.setBorder(BorderFactory.createTitledBorder("Enter IP to search:"));
        searchPanel.setLayout(boxyY);
        routeTablePanel1.setBorder(BorderFactory.createTitledBorder("Enter route table in this format: Address/Mask/Next Hop"));
        routeTablePanel2.setBorder(BorderFactory.createTitledBorder(""));
        routeTablePanel3.setBorder(BorderFactory.createTitledBorder(""));
        defaultRoute.setBorder(BorderFactory.createTitledBorder(""));
        routeTablePanel1.setLayout(xAxis1);
        routeTablePanel2.setLayout(xAxis2);
        routeTablePanel3.setLayout(xAxis3);
        defaultRoute.setLayout(xAxis4);

        searchIP = new JTextField(10);
        ip1 = new JTextField(10);
        mask1 = new JTextField(10);
        hop1 = new JTextField(10);
        ip2 = new JTextField(10);
        mask2 = new JTextField(10);
        hop2 = new JTextField(10);
        ip3 = new JTextField(10);
        mask3 = new JTextField(10);
        hop3 = new JTextField(10);
        hop4 = new JTextField(10);
        button1 = new JButton("Submit routing table");

        button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                ip_address = searchIP.getText();
                routing_table[0] = ip1.getText();
                routing_table[1] = ip2.getText();
                routing_table[2] = ip3.getText();
                mask[0] = mask1.getText();
                mask[1] = mask2.getText();
                mask[2] = mask3.getText();
                //andOperation();
            }
        });

        searchPanel.add(searchIP);
        routeTablePanel1.add(ip1);
        routeTablePanel1.add(mask1);
        routeTablePanel1.add(hop1);
        routeTablePanel2.add(ip2);
        routeTablePanel2.add(mask2);
        routeTablePanel2.add(hop2);
        routeTablePanel3.add(ip3);
        routeTablePanel3.add(mask3);
        routeTablePanel3.add(hop3);
        defaultRoute.add(defaultLabel);
        defaultRoute.add(hop4);
        submit.add(button1);
        frame.setLayout(new FlowLayout());
        frame.add(searchPanel);
        frame.add(routeTablePanel1);
        frame.add(routeTablePanel2);
        frame.add(routeTablePanel3);
        frame.add(defaultRoute);
        frame.add(submit);

        }

    public static void main (String args[]) {
        new RoutingGUI();
        Scanner scan = new Scanner (System.in);


        // reading the desired routing table size
        //System.out.print("Enter the desired size of the routing table: ");
        //num = scan.nextInt ();

        // clicking "enter" to start entering data
        /*String str;
        System.out.println("***Click 'Enter'***");
        str = scan.nextLine ();
        String routing_table[] = new String[num];

        // begin entering the data (in this case - from Exercise 33 Chapter 5)
        System.out.println("Enter the contents of the table in the following format:");

        // binary and subnet mask with the input IP address to extract the network part of the address
        System.out.println("Address/Subnet mask Next hop");

        for (int i = 0; i < num; i++) {
          routing_table[i] = scan.nextLine();
        }
        */
        // split the IP addresses by a period


        // split the routing table

    }

    /*public void andOperation() {
      String split_ip[];
      split_ip = ip_address.split("[.]");
      String routingtab_split[][] = new String[num][];
      for (int i = 0; i < num - 1; i++) {
        routingtab_split[i] = routing_table[i].split("[.]");
      }

      int same = 0;
      for(int i = 0; i < num-1; i++) {
          int block = Integer.parseInt(mask[i]);
          int address[] = {0, 0, 0, 0};
          int max = 7;
          int count = 0;
          while(block > 0){
              if(max != 0) {
                  address[count] += (int)Math.pow(2, max);
                  max--;
              }
              else {
                  address[count] += 1;
                  count ++;
                  max = 7;
              }
              block --;
          }
          for(int x = 0; x < split_ip.length; x++) {
              int holder = Integer.parseInt(split_ip[x]);
              if(holder != Integer.parseInt(routingtab_split[i][])) {
                  same = 0;
                  break;
              }
              else {
                  same ++;
              }
              if(same == split_ip.length) {
                  System.out.println("IP found in routing table. Routing packet to: " +  hop[i]);
              }
          }
      }
      System.out.println("IP not found. Routing packet to: " + routingtab_split[num - 1][routingtab_split[num - 1].length - 2] + " " + routingtab_split[num - 1][routingtab_split[num - 1].length - 1]);

  }*/
}
