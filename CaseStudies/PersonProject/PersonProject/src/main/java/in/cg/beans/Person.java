package in.cg.beans;

public class Person {

    private String address;
    private String city;
    private int pincode;

    // constructor
    public Person(String address, String city, int pincode) {
        this.address = address;
        this.city = city;
        this.pincode = pincode;
    }

    public void display() {

        System.out.println("Address: " + address);
        System.out.println("City: " + city);
        System.out.println("Pincode: " + pincode);

    }

}