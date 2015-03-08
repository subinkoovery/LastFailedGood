package in.dreamseed.thanbee.push;

/**
 * Created by subin on 21/11/14.
 */
public class LatestNews {
    String head;
    String tail;
    public LatestNews(String aHd,String bTai)
    {
        this.head=aHd;
        this.tail=bTai;
    }
    public String getHead()
    {
        return head;
    }
    public String getTail()
    {
        return tail;
    }
}
