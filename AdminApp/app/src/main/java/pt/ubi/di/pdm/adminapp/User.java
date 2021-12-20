package pt.ubi.di.pdm.adminapp;

public class User {

        public String fullname, email, secure_password, salt;

        public User(){}

        public User(String fullname, String email, String secure_password, String salt){
            this.fullname = fullname;
            this.email = email;
            this.salt = salt;
            this.secure_password = secure_password;
        }


}
