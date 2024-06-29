package uni;

public abstract class Person {
    private String ID;
    private String Date_Of_Birth;

    public Person(String ID, String  Date_Of_Birth) {
        this.ID = ID;
        this.Date_Of_Birth = Date_Of_Birth;
    }
    public Person() {
    }
    public String getID() {
        return ID;
    }

    public String getDateOfBirth() {
        return Date_Of_Birth;
    }

    @Override
    public String toString() {
        return "ID =" + ID + ", Date Of Birth =" + Date_Of_Birth;
    }
}
