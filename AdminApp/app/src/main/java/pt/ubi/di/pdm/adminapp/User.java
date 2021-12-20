package pt.ubi.di.pdm.adminapp;

public class User {

        public String fullname, email, password, salt;

        public User(){}

        public User(String fullname, String email, String password){
            this.fullname = fullname;
            this.email = email;
            //this.salt = salt;
            this.password = password;
        }


}
