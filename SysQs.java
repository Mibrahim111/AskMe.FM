package FM.AskMe;
import java.util.ArrayList;

public class SysQs {

    private final ArrayList<Questions> qList ;


    SysQs()
    {
        qList = new ArrayList<>();
    }

    public void addQ(Users from , Users to , String q )
    {
        Questions Question = new Questions(from,to,q);

        qList.add(Question);
        from.incrementQ();

    }

    public Questions findQ(int id)
    {
     for(Questions Question : qList)
         if(Question.getQID() == id)
             return  Question;

     return null;
    }
    public Questions findQ(Users from , Users to)
    {
        for(Questions q : qList)
            if(from.equals(q.getUserFrom()) && to.equals(q.getUserTo()))
                return q;

        return null;
    }
    public void showUsersQuestions(Users user)
    {
        for(Questions q : qList)
            if(user.getEmail().equals(q.getUserFrom().getEmail()) &&
                    user.getPassword().equals(q.getUserFrom().getPassword()))
                q.printQ();
    }

    public void printAllQs()
    {
        for(Questions Q : qList)
            Q.printQ();
    }

}
