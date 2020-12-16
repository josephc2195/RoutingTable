import java.util.Scanner;

public class Routing {
public static void main (String args[]) {
    Scanner scan = new Scanner (System.in);
    int num;

    // reading the IP Address
    String ip_address;
    System.out.print("Enter a 32-bit IP Address: ");
    ip_address = scan.nextLine ();

    // reading the desired routing table size
    System.out.print("Enter the desired size of the routing table: ");
    num = scan.nextInt ();

    // clicking "enter" to start entering data
    String str;
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

    // split the IP addresses by a period
    String split_ip[];
    split_ip = ip_address.split("[.]");

    // split the routing table
    String routingtab_split[][] = new String[num][];
    for (int i = 0; i < num; i++) {
      routingtab_split[i] = routing_table[i].split("[./ ]");
    }

    // print the split values
    /*for (String new_str : split_ip) {
      System.out.print(new_str + " ");
    }
    System.out.println();

    for (int i = 0; i < num; i++) {
        for (String new_str : routingtab_split[i]) {
          System.out.print(new_str + " ");
        }
    System.out.println();
    }
*/
    int same = 0;
    for(int i = 0; i < num - 1; i++) {
        int block = Integer.parseInt(routingtab_split[i][4]);
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
            if(holder != Integer.parseInt(routingtab_split[i][x])) {
                same = 0;
                break;
            }
            else {
                same ++;
            }
            if(same == split_ip.length) {
                System.out.println("IP found in routing table. Routing packet to: " + routingtab_split[i][routingtab_split[i].length - 2] + " " + routingtab_split[x][routingtab_split[x].length - 1]);
            }
        }
    }
    System.out.println("IP not found. Routing packet to: " + routingtab_split[num - 1][routingtab_split[num - 1].length - 2] + " " + routingtab_split[num - 1][routingtab_split[num - 1].length - 1]);
}
}
