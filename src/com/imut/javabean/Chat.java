
package com.imut.javabean;
public class Chat {
	private String id ;
	private String time;
	private String from_id;
	private String to_id;
	private String chat_content;
	private String status;
	   public String getId()
	  	{
	  		return id;
	  	}
	      public void setId( String id )
	  	{
	  		this.id = id;
	  	}
	   public String getTime()
    	{
		  		return time;
	  	}
      public void setTime( String time )
	  	{
	  		this.time = time;
	  	}
      public String getFromId()
	  	{
	  		return from_id;
	  	}
	      public void setFromId( String FromId )
	  	{
	  		this.from_id = FromId;
	  	}
	     public String getToId()
	  	{
	  		return to_id;
	  	}
        public void setToId( String ToId )
	 	{
	 		this.to_id = ToId;
	  	}	   
        public String getChatContent()
	  	{
	  		return chat_content;
	  	}
	      public void setChatContent( String content )
	  	{
	  		this.chat_content = content;
	  	}    
	      public String getStatus()
		  	{
		  		return status;
		  	}
		      public void setStatus( String s )
		  	{
		  		this.status = s;
		  	}    
}
