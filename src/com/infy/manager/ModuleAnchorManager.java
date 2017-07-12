package com.infy.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.persistence.EntityTransaction;

import com.infy.TOclasses.GroupInfoTO;
import com.infy.TOclasses.ModuleAnchorTO;
import com.infy.TOclasses.SubModuleTO;
import com.infy.TOclasses.VerticalTO;
import com.infy.entity.ModuleAnchor;
import com.infy.exceptions.NoModuleFoundException;
import com.infy.service.ModuleAnchorService;

public class ModuleAnchorManager {
	public Map<String,String> getAllModules() throws NoModuleFoundException,Exception
	{
		try
		{
			Map<String, String> moduleMap=new TreeMap<String, String>();
			moduleMap=new ModuleAnchorService().getAllModules();
			if(moduleMap.isEmpty())
			{
				throw new NoModuleFoundException();
			}
			return moduleMap;
		}
		catch(NoModuleFoundException e)
		{
			throw e;

		}
		catch (Exception e) {
			throw e;
		}	
	}
	public ModuleAnchorTO getModuleById(String moduleId) throws Exception
	{
		
	
		ModuleAnchorTO moduleAnchorTO= new ModuleAnchorTO();
		try
		{
			
			ModuleAnchorService service = new ModuleAnchorService();
			moduleAnchorTO=service.getModuleById(moduleId);
			return moduleAnchorTO;
			
			
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			throw e;
		}
		
	}
	
	
	public VerticalTO getVerticalById(String verticalId) throws Exception
	{
		
	
		VerticalTO verticalTO= new VerticalTO();
		try
		{
			
			ModuleAnchorService service = new ModuleAnchorService();
			verticalTO=service.getVerticalById(verticalId);
			return verticalTO;
			
			
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			throw e;
		}
		
	}
	
	public SubModuleTO getSubModuleById(String submoduleId) throws Exception
	{
		
	
		SubModuleTO subModuleTO= new SubModuleTO();
		try
		{
			
			ModuleAnchorService service = new ModuleAnchorService();
			subModuleTO=service.getSubModuleById(submoduleId);
			return subModuleTO;
			
			
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			throw e;
		}
		
	}
	
	
	public ModuleAnchorTO saveEditedModuleAnchor(ModuleAnchorTO moduleAnchorTO) throws Exception
	{
		
		try
		{
			ModuleAnchorService service = new ModuleAnchorService();
			moduleAnchorTO=service.saveEditedModuleAnchor(moduleAnchorTO);
			return moduleAnchorTO;
				
		}
		catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		
	}
	
	public VerticalTO saveEditedVertical(VerticalTO verticalTO) throws Exception
	{
		
		try
		{
			ModuleAnchorService service = new ModuleAnchorService();
			verticalTO=service.saveEditedVertical(verticalTO);
			return verticalTO;
				
		}
		catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		
	}
}
