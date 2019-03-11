package com.imut.javabean;

public class Users {
	
	private String password;
	private String name;
	private String headimg;
	private int dark;
	private String phone;
	private String address;
	private String time;
	public String getAddress()
	{
		return address;
	}
    public void setAddress(String na)
	{
		  address = na;
	 }
    public String getTime()
	{
		return time;
	}
    public void setTime(String na)
	{
		  time = na;
	 }
	public int getDarke()
	{
		return dark;
	}
    public void setDark(int na)
	{
		  dark = na;
	 }
    public String getPhone()
	{
		return phone;
	}
    public void setPhone(String na)
	{
    	phone = na;
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
