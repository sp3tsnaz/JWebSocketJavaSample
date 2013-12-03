package com.nst.tuple;

public class SectionRowQuantitiesTimeTuple
{
	private String eventID;
	private String section;
	private String row;
	private String time;
	private String quantities;
	
	public String getEventID()
	{
		return eventID;
	}
	
	public void setEventID(String eventID)
	{
		this.eventID = eventID;
	}
	
	public String getQuantities()
	{
		return quantities;
	}
	
	public void setQuantities(String quantities)
	{
		this.quantities = quantities;
	}
	
	public String getTime()
	{
		return time;
	}
	
	public void setTime(String time)
	{
		this.time = time;
	}	
	
	public String getSection()
	{
		return section;
	}
	
	public void setSection(String section)
	{
		this.section = section;
	}

	public String getRow() {
		return row;
	}

	public void setRow(String row) {
		this.row = row;
	}
}
