package com.imut.javabean;

public class Users {
	private String id ;
	private String password;
	private String name;
	private String headimg;
	
	public String getId()
	{
		return id;
	}
	public String getname()
	{
		return name;
	}
	public String getheadimg()
	{
		return headimg ;
	}
	public String getPassword()
	{
		return password;
	}
	public void setId( String id )
	{
		this.id = id;
	}
    public void setName(String na)
    {
    	name = na;
    }
    public void setHeadimg(String headimg)
    {
    	this.headimg = headimg;
    }
    public void setPassword(String password)
    {
    	this.password = password;
    }
}
