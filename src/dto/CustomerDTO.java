package dto;

public class CustomerDTO {

    private long customerId;
    private int nip;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    public CustomerDTO(long customerId, int nip, String firstName, String lastName, String email, String phone) {
        this.customerId = customerId;
        this.nip = nip;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public long getCustomerId() {
        return customerId;
    }

    public int getNip() {
        return nip;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}