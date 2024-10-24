package FM.AskMe;

import java.util.ArrayList;

public class SysUsers {
    private final ArrayList<Users> uList ;


    SysUsers()
    {
        uList = new ArrayList<>();
    }



    public Users findUser(int id)
    {
        for(Users user : uList)
        {
            if(id == user.getUserID())
                return user;
        }
        return null;

    }

    public  Users findUser(String emailOrUserName , String password)
    {
        for(Users user : uList)
            if ((emailOrUserName.equals(user.getEmail()) || emailOrUserName.equals(user.getUserName()))
                    && password.equals(user.getPassword()))
                return user;
        return null;
    }



    public Users deleteUser(String emailOrUserName , String password ){

        Users u = findUser(emailOrUserName,password);

        uList.remove(u);

        return u;

    }

    public Users deleteUser(int id){

        Users u = findUser(id);

        uList.remove(u);

        return u;

    }

    public void printAllUsers()
    {
        for(Users user : uList) if(user != null)
        {
            user.printUser();
        }
    }
}
