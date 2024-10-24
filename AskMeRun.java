package FM.AskMe;

import java.util.Scanner;

public class AskMeRun {

    private final SysQs sysQ;
    private final SysUsers sysU;

 public AskMeRun()
 {
     sysQ = new SysQs();
     sysU = new SysUsers();
 }

    public Questions editQ(int id , Scanner in)
    {
        Questions editedQ = sysQ.findQ(id);

        if(editedQ != null) {
            System.out.println("Enter New Question Text");
            String s = in.next();
            editedQ.setQ_text(s);
        }
        else{
            System.out.println("Wrong Question ID ,Please try again");
        }
        return editedQ;

    }

    public Users editUser(int id , Scanner in)
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

    public Users editUser(String emailOrUserName , String password , Scanner in){
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



}
