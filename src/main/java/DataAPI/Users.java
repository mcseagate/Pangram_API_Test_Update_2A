package DataAPI;

public class Users {

    String pangram;


    public Users(){

    }


    public Users(String pangram){

        this.pangram = "The quick brown fox jumped over the lazy brown dog";

    }


    public String getPangram() {
        return pangram;
    }


    public void setPangram(String pangram) {
        this.pangram = pangram;
    }



}
