public class Benutzer {
    String userID;
    char[] passwort;

    Benutzer(){}

    Benutzer(String id, char[] pw){
        userID = id;
        passwort = pw.clone();
    }

    protected boolean equals(Benutzer benutzer){
        String password1 = "";
        password1 = password1.copyValueOf(passwort);
        String password2 = "";
        password2 = password2.copyValueOf(benutzer.passwort);
        return (userID.equals(benutzer.userID) && password1.equals(password2));
    }

    public String toString(){
        String password = "";
        password = password.copyValueOf(this.passwort);
        return ("UserID: " + userID + " ;Passwort: " + password);
    }
}
