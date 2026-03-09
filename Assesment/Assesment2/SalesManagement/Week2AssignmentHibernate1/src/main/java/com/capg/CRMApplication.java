package com.capg;

import com.capg.service.*;

import java.util.*;

public class CRMApplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        CustomerService customerService = new CustomerService();
        ProductService productService = new ProductService();
        LeadService leadService = new LeadService();
        OrderService orderService = new OrderService();
        TicketService ticketService = new TicketService();

        while(true) {

            System.out.println("\n===== CRM MENU =====");

            System.out.println("1. Register Customer");
            System.out.println("2. Add Address");
            System.out.println("3. Create Lead");
            System.out.println("4. Assign Lead");
            System.out.println("5. Add Product");
            System.out.println("6. Place Order");
            System.out.println("7. Raise Ticket");
            System.out.println("8. Exit");

            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {

                case 1:

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Phone: ");
                    String phone = sc.nextLine();

                    customerService.registerCustomer(
                            name, email, phone);

                    break;

                case 2:

                    System.out.print("Customer ID: ");
                    Long cid = sc.nextLong();
                    sc.nextLine();

                    System.out.print("Street: ");
                    String street = sc.nextLine();

                    System.out.print("City: ");
                    String city = sc.nextLine();

                    System.out.print("State: ");
                    String state = sc.nextLine();

                    System.out.print("Zip: ");
                    String zip = sc.nextLine();

                    customerService.addAddressToCustomer(
                            cid, street, city, state, zip);

                    break;

                case 3:

                    System.out.print("Lead Name: ");
                    String lname = sc.nextLine();

                    System.out.print("Source: ");
                    String source = sc.nextLine();

                    System.out.print("Contact Info: ");
                    String contact = sc.nextLine();

                    leadService.createLead(
                            lname, source, contact);

                    break;

                case 4:

                    System.out.print("Lead ID: ");
                    Long leadId = sc.nextLong();

                    System.out.print("Employee ID: ");
                    Long empId = sc.nextLong();

                    leadService.assignLeadToEmployee(
                            leadId, empId);

                    break;

                case 5:

                    System.out.print("Product Name: ");
                    String pname = sc.nextLine();

                    System.out.print("Price: ");
                    double price = sc.nextDouble();

                    productService.addProduct(
                            pname, price);

                    break;

                case 6:

                    System.out.print("Customer ID: ");
                    Long custId = sc.nextLong();

                    System.out.print("Number of Products: ");
                    int n = sc.nextInt();

                    List<Long> productIds =
                            new ArrayList<>();

                    for(int i = 0; i < n; i++) {

                        System.out.print("Product ID: ");

                        productIds.add(sc.nextLong());
                    }

                    orderService.placeOrder(
                            custId, productIds);

                    break;

                case 7:

                    System.out.print("Order ID: ");
                    Long orderId = sc.nextLong();
                    sc.nextLine();

                    System.out.print("Issue: ");
                    String issue = sc.nextLine();

                    ticketService.raiseTicket(
                            orderId, issue);

                    break;

                case 8:

                    System.out.println("Exiting...");

                    sc.close();

                    System.exit(0);

                default:

                    System.out.println("Invalid choice");
            }
        }
    }
}