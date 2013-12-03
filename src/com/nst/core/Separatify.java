package com.nst.core;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Separatify
{	
	private ArrayList<String> _filePaths;
	private Scanner _stream;
	
	public Separatify()
	{
		_filePaths = new ArrayList<String>();
	}
	
	private ArrayList<String> getTuples() 
	{	
		try
		{
			for(String tmp : _filePaths)
			{
				_stream = new Scanner(new File(tmp));			
				int i = 0;
				while (_stream.hasNextLine())
				{
					String line = _stream.nextLine();	
					
					BufferedWriter _writer = new BufferedWriter(new FileWriter(new File(line.split("_")[0] + ".1"),true));
					
					//PrintWriter _writer = new PrintWriter(new File(line.split("_")[0] + ".1"));				
					_writer.write(line + "\n");					
					_writer.close();
					
					
					
				}
				
				_stream.close();
				break;
			}
		}
		catch(Exception e)
		{
			
		}
		
		return null;		
	}
	
	public void getFilesList(String path)
	{
		File [] _listOfFiles = new File(path).listFiles();	
		
		
		for (int i = 0 ; i < _listOfFiles.length ; i++)
		{
			_filePaths.add(_listOfFiles[i].getAbsolutePath());
		}
		
		getTuples();
	}
}
