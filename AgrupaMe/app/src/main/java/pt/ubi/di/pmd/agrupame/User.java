package pt.ubi.di.pmd.agrupame;

public class User {

    public String fullname, email, gender, dateOfBirth;

    public User(){

    }

    public User(String fullname, String email, String gender, String dateOfBirth){
        this.fullname = fullname;
        this.email = email;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "User{" +
                "fullname='" + fullname + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }
}
