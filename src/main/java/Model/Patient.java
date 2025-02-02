package Model;

public class Patient {
    private int id;
    private String name;
    private int age;
    private int gender;
    private String contact;
    private String Email;
    private String visitDate;

    public Patient(int id, String name, int age, int gender, String contact, String address, String visitDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.contact = contact;
        this.Email = address;
        this.visitDate = visitDate;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public int getGender() { return gender; }
    public String getContact() { return contact; }
    public String getAddress() { return Email; }
    public String getVisitDate() { return visitDate; }
    public String getEmail() {
        return Email;
    }
}
