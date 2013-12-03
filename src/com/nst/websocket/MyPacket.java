package com.nst.websocket;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.jwebsocket.api.WebSocketPacket;
import org.jwebsocket.kit.WebSocketFrameType;

public class MyPacket implements WebSocketPacket
{
	String message = "mohsin default";
	
	public MyPacket(String hello)
	{
		super();
		this.message = hello;
	}
	
	@Override
	public String getASCII() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] getByteArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getCreationDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WebSocketFrameType getFrameType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getString() {
		// TODO Auto-generated method stub
		return this.message;
	}

	@Override
	public String getString(String arg0) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUTF8() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isFragment() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setASCII(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setByteArray(byte[] arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCreationDate(Date arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setFrameType(WebSocketFrameType arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setString(String arg0) {
		
		this.message = arg0;
	}

	@Override
	public void setString(String arg0, String arg1)
			throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUTF8(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer size() {
		// TODO Auto-generated method stub
		return null;
	}

}
