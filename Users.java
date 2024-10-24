package FM.AskMe;

public class Users {
    private String username;
    private String email;
    private String password;
    private static int usersNum=0;
    private final int userID;
    private int age;
    private int qCount;
    private char gender;

    public Users(String name, String email, String password, int age, int qCount, char gender) {
        this.username = name;
        this.email = email;
        this.password = password;
        this.age = age;
        this.qCount = qCount;
        this.gender = gender;
        usersNum++;
        userID = usersNum;
    }

    public Users( String name, String email, String password, int age, char gender) {
       this(name,email,password,age,0,gender);
    }


    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getUserName() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getQCount() {

        if(this.qCount == 0)
        {
            System.out.println("User Hasn't asked any Question yet");

        }

        return qCount;
    }

    public int getUserID() {
        return userID;
    }

    public void incrementQ() {
        this.qCount++;
    }

    public void printUser()
    {
        System.out.println("UserName: " + this.username);
        System.out.println("Email: " + this.email);
        System.out.println("Questions asked: " + this.getQCount());
    }

    public char getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }
}
