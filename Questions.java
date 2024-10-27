package FM.AskMe;

public class Questions {

    private final Users userTo;
    private final Users userFrom;
    private String q_text;
    private final int QID;
    private static int QNum;

    public Questions(Users userFrom , Users userTo, String q_text) {
        this.userFrom = userFrom;
        this.userTo = userTo;
        this.q_text = q_text;
        QNum++;
        QID = QNum;
    }

    public Users getUserFrom() {
        return userFrom;
    }

    public Users getUserTo() {
        return userTo;
    }


    public String getQ_text() {

        return q_text;
    }

    public void setQ_text(String q_text) {

        this.q_text = q_text;
    }

    public int getQID() {
        return QID;
    }


    public void printQ()
    {
        System.out.println("Asked By: " + this.getUserFrom().getUserName());
        System.out.println("To:" + this.getUserTo().getUserName());
        System.out.println("Questions asked: " + this.getQ_text());
        System.out.println("ID:" + this.QID);
    }

}
