package com.imut.javabean;

public class admin {
	private String id ;
	private String password;
	private String phone;
	private String address;
	private String status;
	private String time;
	public String getId()
	{
		return id;
	}
	public String getPassword()
	{
		return password;
	}
	public String getPhone()
	{
		return  phone;
	}
	public String getAddress()
	{
		return address;
	}
	public String getStatus()
	{
		return status;
	}
	public String getTime()
	{
		return time;
	}
	public void setId( String id )
	{
		this.id = id;
	}
    public void setPassword(String password)
    {
    	this.password = password;
    }
    public void setPhone(String p)
    {
    	this.phone = p;
    }
    public void setAddress(String a)
    {
    	this.address = a;
    }
    public void setTime(String a)
    {
    	this.time = a;
    }
    public void setStatus(String a)
    {
    	this.status = a;
    }
}
