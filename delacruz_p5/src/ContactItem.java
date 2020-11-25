public class ContactItem {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    ContactItem() {
            this.firstName = "";
            this.lastName = "";
            this.phoneNumber = "";
            this.email = "";
        }
    ContactItem(String firstName, String lastName, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        if(checkIfAllNull()){
            throw new IllegalArgumentException("All null, please make it so it's not");
        }
    }

    @Override
    public String toString() {
        return "firstName='" + this.firstName + '\'' +
                ", lastName='" + this.lastName + '\'' +
                ", phoneNumber='" + this.phoneNumber + '\'' +
                ", email='" + this.email + '\'';
    }

    public String getFirstName() { return this.firstName;}
    public String getLastName() { return this.lastName;}
    public String getPhoneNumber() {return this.phoneNumber;}
    public String getEmail(){ return this.email;}
    public void setFirstName(String firstName){
            this.firstName = firstName;
    }
    public void setLastName(String lastName){
            this.lastName = lastName;
    }
    public void setPhoneNumber(String phoneNumber){
            this.phoneNumber = phoneNumber;
    }
    public void setEmail(String email){
            this.email  = email;
    }
    public Boolean checkIfAllNull(){
        if(this.firstName.equals("") &&
        this.lastName.equals("")&&
        this.phoneNumber.equals("")&&
        this.email.equals("")){
            return true;
        } else {
            return false;
        }
    }
}


