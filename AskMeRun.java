package FM.AskMe;

import java.util.*;

public class AskMeRun {

    private final SysQs sysQ;
    private final SysUsers sysU;
    private Users loggedInUser;
    private final Scanner in = new Scanner(System.in);


 public AskMeRun()
 {
     sysQ = new SysQs();
     sysU = new SysUsers();
 }

  protected void askQ()
 {
     System.out.println("Enter Username or Email to ask your Question: ");
     String s = in.next();
    Users to =  sysU.findUser(s);
    if(to != null){
        System.out.println("Ask Your Question: ");
        String q = in.next();
        sysQ.addQ(loggedInUser,to,q);
        System.out.println("\nQuestion Added Successfully");
   }

     System.out.println("Wrong input ,Please try again");
 }

    protected void editQ()
    {
        System.out.println("Please Enter Question ID:");
        int id = in.nextInt();
        Questions editedQ = sysQ.findQ(id);

        if(editedQ != null) {
            System.out.println("Enter New Question Text");
            String s = in.next();
            editedQ.setQ_text(s);
            System.out.println("Question Edited Successfully");
        }
        else{
            System.out.println("Wrong Question ID ,Please try again");
        }

    }

    protected Users editUser(int id)
    {
        Users editedUser = sysU.findUser(id);
        if(editedUser != null)
        {
            System.out.println("Enter which attribute you want to edit (name,email,password): ");
            String ans  = in.next();
            ans = ans.toLowerCase();

            switch (ans) {
                case "name": {
                    System.out.println("\nEnter New Username");
                    String s = in.next();
                    editedUser.setUsername(s);
                    break;
                }
                case "email": {
                    System.out.println("\nEnter New Email");
                    String s = in.next();
                    editedUser.setEmail(s);
                    break;
                }
                case "password": {
                    System.out.println("\nEnter New Password");
                    String s = in.next();
                    editedUser.setPassword(s);
                    break;
                }
                case "gender":
                    System.out.println("\nEnter New Gender");
                    char c = in.nextLine().charAt(0);
                    editedUser.setGender(c);
                    break;
                case "age": {
                    System.out.println("\nEnter New Age");
                    int s = in.nextInt();
                    editedUser.setAge(s);
                    break;
                }
                default:
                {
                    System.out.println("Wrong Input ,Please try again");
                }
            }

        }

        else {
            System.out.println("Wrong Input ,Please try again");
        }

        return editedUser;
    }

    protected Users editUser(){

        System.out.println("Enter Username/Email and Password:");
        String emailOrUserName = in.next();
        String password = in.next();

        Users editedUser = sysU.findUser(emailOrUserName,password);
        if(editedUser != null)
        {
            System.out.println("Enter which attribute you want to edit (name,email,password): ");
            String ans  = in.next();
            ans = ans.toLowerCase();

            switch (ans) {
                case "name": {
                    System.out.println("\nEnter New Username");
                    String s = in.next();
                    editedUser.setUsername(s);
                    break;
                }
                case "email": {
                    System.out.println("\nEnter New Email");
                    String s = in.next();
                    editedUser.setEmail(s);
                    break;
                }
                case "password": {
                    System.out.println("\nEnter New Password");
                    String s = in.next();
                    editedUser.setPassword(s);
                    break;
                }
                case "gender":
                    System.out.println("\nEnter New Gender");
                    char c = in.nextLine().charAt(0);
                    editedUser.setGender(c);
                    break;
                case "age": {
                    System.out.println("\nEnter New Age");
                    int s = in.nextInt();
                    editedUser.setAge(s);
                    break;
                }
                default:
                {
                    System.out.println("Wrong Input ,Please try again");
                }
            }

        }

        else {
            System.out.println("Wrong Input ,Please try again");
        }

        return editedUser;
    }




    protected void login()
    {
        int trys = 0;
        while(trys <= 3 ) {
            System.out.println("Enter Username/Email and password");
            String s1 = in.next(), s2 = in.next();

            Users user = sysU.findUser(s1, s2);

            if (user != null) {
                System.out.println("Logged In Successfully");
                loggedInUser = user;
                runUserMenu();
            }

                System.out.println("Wrong input ,Please try again");
            trys++;
        }
    }

    protected void signUp()
    {
        System.out.println("Enter UserName:");
        String n = in.next();
        System.out.println("Enter Email:");
        String e = in.next();
        System.out.println("Enter Password:");
        String p = in.next();

        System.out.println("Enter your Age:");
        int age = in.nextInt();
        System.out.println("Enter Gender(m/f):");
        String c = in.next();
       c =  c.toLowerCase();

       loggedInUser = sysU.addUser(n,e,p,age,c.charAt(0));

       runUserMenu();

       // new User added to users list and is assigned as the new Logged-in user
        // (LoggedIn user = null when signed out )

    }

    protected int MainMenu(){

        int ans = -1;
        while(!(1<= ans && ans <=3)) {
            System.out.println("Enter A valid choice");
            System.out.println("1)Log In");
            System.out.println("2)Sign Up");
            System.out.println("3)Exit");

            ans = in.nextInt();

        }
        return ans;

    }

    protected void searchUser()
    {
        System.out.println("Enter Username/Email:");
        String emailOrUserName = in.next();

        Users u = sysU.findUser(emailOrUserName);

        u.printUser();
    }

    protected int Menu(){

        int ans = -1;
        while(ans == -1) {
            System.out.println("Enter A valid choice");
            System.out.println("1)Ask a Question");
            System.out.println("2)edit a Question");
            System.out.println("3)Print All Questions");
            System.out.println("4)find your Friend");
            System.out.println("5)Show My Friends");
            System.out.println("6)Sign out");
            ans = in.nextInt();

            if(ans<1||ans >6)
            {
                ans = -1;
                System.out.println("Invalid input ,Please try again");
            }
        }
        return ans;

    }

    protected void signOut()
    {
        loggedInUser = null;
        runMainMenu();
    }

    public void runMainMenu()
    {
        int ans = this.MainMenu();

        while(true)
        {
            switch (ans){

                case 1:
                {
                    login();
                }
                case 2:
                    signUp();
                case 3:
                    System.exit(0);
            }
        }

    }

    protected void runUserMenu()
    {
        int ans = this.Menu();


            switch (ans){

                case 1:
                    askQ();
                case 2:
                    editQ();
                case 3:
                    sysQ.printAllQs();
                case 4:
                    searchUser();
                case 5:
                    sysU.printAllUsers();
                case 6:
                signOut();
                default:
                    System.out.println("Wrong input Please try again");
            }


    }

}
