package blog;
import java.util.Date;
public class Topic {

	/** 連番 */
private int id;
private String  title;
private String  content;
private Date postDate;

public String toString(){
	return super.toString() + ",id=" + id
			                + ",title=" + title
			                + ",content=" + content
			                + ",postDate=" + postDate;
}
public int getId(){
	return id;
}
public void setid(int id){
	this.id = id;
}

public String getContent(){
	return content;
}

public void setContent(String content){
	this.content = content;
}
public Date getPostDate(){
	return postDate;
}

public void setPostDate(Date postDate){
	this.postDate = postDate;
}
public String  getTitle(){
	return title;
}

public void setTitle(String title){
	this.title = title;
}



}
