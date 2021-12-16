package pt.ubi.di.pmd.agrupame;

public class User {

    public String fullname, username, email, gender, dateOfBirth;

    public User(){

    }

    public User(String fullname, String username, String email, String gender, String dateOfBirth){
        this.fullname = fullname;
        this.username = username;
        this.email = email;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }
}
