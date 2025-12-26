
package EventEsae;

import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the participant details");
        String input = sc.nextLine().trim();

        
            if (input.startsWith("Organizer:")) {
        
                String[] parts = input.split(":");
                if (parts.length != 8) {
                    
                    System.out.println("Invalid input format for Organizer");
                    
                }

                String participantId = parts[1];
                String name = parts[2];
                String email = parts[3];
                long phoneNumber = Long.parseLong(parts[4]);
                int ticketsAvailable = Integer.parseInt(parts[5]);
                int ticketsToSell = Integer.parseInt(parts[6]);
                double pricePerTicket = Double.parseDouble(parts[7]);

                Organizer organizer = new Organizer(participantId, name, email, phoneNumber, ticketsAvailable);
                double revenue = organizer.calculateSellingRevenue(ticketsToSell, pricePerTicket);

                if (revenue == -1) {
                    System.out.println("Not enough tickets to sell!");
                } else {
                    System.out.println("Calculated ticket selling revenue is " + revenue);
                }

            } else if (input.startsWith("Attendee:")) {
                // Expected format:
                // Attendee:<participantId>:<name>:<email>:<phoneNumber>:<walletBalance>:<ticketsToBuy>:<pricePerTicket>
                String[] parts = input.split(":");
                if (parts.length != 8) {
                    System.out.println("Invalid input format for Attendee");
                   
                }

                String participantId = parts[1];
                String name = parts[2];
                String email = parts[3];
                long phoneNumber = Long.parseLong(parts[4]);
                double walletBalance = Double.parseDouble(parts[5]);
                int ticketsToBuy = Integer.parseInt(parts[6]);
                double pricePerTicket = Double.parseDouble(parts[7]);

                Attendee attendee = new Attendee(participantId, name, email, phoneNumber, walletBalance);
                double cost = attendee.calculateBuyingCost(ticketsToBuy, pricePerTicket);

                if (cost == -1) {
                    System.out.println("Not enough funds to buy tickets!");
                } else {
                    System.out.println("Calculated ticket buying cost is " + cost);
                }
            } else {
                System.out.println("Invalid participant type");
            }
            sc.close();
        } 
    }



