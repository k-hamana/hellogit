package blog;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BlogController {
	private static BlogController controller = new BlogController();
/*	private int idCounter; */


	public static BlogController getInstance(){
		return controller;
	}
    private BlogController (){

    }
    public void postTopic(Topic topic){
    	String sql = "insert into topic(TITLE,CONTENT) VALUES("
                      + "'" + topic.getTitle() + "','"
    			      + topic.getContent() + "')";
    	Connection con = null;
        Statement smt = null;
        try {
        	con = ConnectionManager.getConnection();
        	smt = con.createStatement();
           smt.executeUpdate(sql);
    	} catch (SQLException e){
    		e.printStackTrace();

    	} finally{
    		if (smt != null){

    			try{
    			smt.close();
    			} catch (Exception Ignore){
    			}
    		}
    		if (con != null ){
    			try{
    				con.close();
    			} catch (Exception ignore){

    			}
    		}
    	}
    }

    public List<Topic> getTopics(){
    String sql = "SELECT * FROM topic";
    List<Topic> topics  = new ArrayList<Topic>();
    Connection con = null;
    Statement smt = null;
    ResultSet rs = null;
    try {
    	con = ConnectionManager.getConnection();
        smt = con.createStatement();
        rs = smt.executeQuery(sql);
        while (rs.next()){
             Topic topic = new Topic();
    	      topic.setid(rs.getInt("ID"));
    	      topic.setPostDate(rs.getTimestamp("POST_DATE"));
    	      topic.setContent(rs.getString("CONTENT"));
    	      topic.setTitle(rs.getString("TITLE"));
    	      topics.add(topic);
        }
     }  catch (SQLException e){
              e.printStackTrace();
     } finally {
    	        if (rs != null){
                    try{ rs.close();
     	    	    } catch (SQLException Igmore){}
    	        }
                if (smt != null){
        	       try{
                       smt.close();
        	        } catch (SQLException Igmore){}
                }
                if (con != null){
        	       try{
        		       con.close();
        	       } catch (SQLException Igmore){}
                }
     }

     return topics;
 }
public static void main(String[] args){
	BlogController ctrl = BlogController.getInstance();
	List<Topic> topics = ctrl.getTopics();
	for (int i = 0;i< topics.size();i++){
	   System.out.println(topics.get(i));
	}
 }
}
