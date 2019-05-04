package com.imut.javabean;

public class Car {
	  private String  name;
	  private String  driving_book_img ;
      private String  engine_img ;
      private String  buy_time ;
      private String  vehicle_type ;
      private float  mileage ;
      private float price ;
      private String  status ;
      private String address; 
      private String condition;
      private String iphone;
      private String car_brand;
      private int id;
      public void set(String attr, String value) {
    	  switch(attr) {
    	  	case "vehicleType": 
    	  		vehicle_type = value;break;
    	  	case"buyTime":
    	  		buy_time = value;break;
    	  	case"mileage":
    	  		mileage = Float.parseFloat(value);break;
    	  	case"price":
    	  		price = Float.parseFloat(value);break;
    	  	case"address":
    	  		address = value;break;
    	  	case"status":
    	  		status = value;break;
    	  	case"condition":
    	  		condition = value;break;
    	  	case"iphone":
    	  		iphone = value;break;
    	  	case"id":
    	  		name = value;break;
    	  	case"carBrand":
    	  		car_brand = value;break;
    	  		
    	  }
      }
      public int getId()
    	{
    		return id;
    	}
      public void setId(int id)
  	{
    	  this.id = id;
  	}
      public String getName()
  	{
  		return name;
  	}
      public void setName( String id )
  	{
  		this.name = id;
  	}

      public String getDriving_book_img()
    {
    	return driving_book_img;
    }
       public void setDriving_book_img( String driving_book_img )
    {
    	this.driving_book_img = driving_book_img;
    }
       public String getEngine_img()
    {
      	return engine_img;
    }
       public void setEngine_img( String engine_img )
    {
      	this.engine_img = engine_img;
   	}
       public String getBuy_time()
   	{
       	return buy_time;
   	}
       public void setBuy_time( String buy_time )
   	{
       	this.buy_time = buy_time;
   	}
    public String getVehicle_type()
  	{
      	return vehicle_type;
  	}
      public void setVehicle_type( String vehicle_type )
  	{
      	this.vehicle_type = vehicle_type;
  	}  
      public float getMileage()
    {
         return mileage;
    }
      public void setMileage( float mileage )
    {
         this.mileage = mileage;
    }          
       public float getPrice()
   	{
         return price;
   	}
       public void setPrice( float price )
    {
         this.price = price;
    }      
       public String getStatus()
    {
         return status;
    }
       public void setStatus( String status )
    {
        this.status = status;
    }
      public String getAdress()
    {
     	return address;
    }
    public void setAdress( String address )
    {
     	this.address = address;
    }
    public String getCondition()
 	{
 		return condition;
 	}
     public void setCondition( String condition )
 	{
 		this.condition = condition;
 	}
     public String getIphone()
  	{
  		return iphone;
  	}
      public void setIphone( String iphone )
  	{
  		this.iphone = iphone;
  	}
    public String getCar_brand()
	{
		return car_brand;
	}
    public void setCar_brand( String car_brand )
	{
		this.car_brand = car_brand;
	}
}
