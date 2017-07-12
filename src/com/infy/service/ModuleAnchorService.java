package com.infy.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.infy.TOclasses.ModuleAnchorTO;
import com.infy.TOclasses.SubModuleTO;
import com.infy.TOclasses.VerticalTO;
import com.infy.entity.Module;
import com.infy.entity.SubModule;
import com.infy.entity.Vertical;





   public class ModuleAnchorService {
	private EntityManagerFactory emf=Persistence.createEntityManagerFactory("FRMS");
	EntityManager em=null;
	public Map<String,String> getAllModules() throws Exception
	{
		try
		{
		Map<String, String> moduleMap=new TreeMap<String, String>();
		em=emf.createEntityManager();
		//Query query=em.createQuery("select p.moduleId, p.moduleName from ModuleAnchor p");
		Query query=em.createQuery("select m.moduleId, m.moduleName from Module m");
		List rs=query.getResultList();
		Iterator it=rs.iterator();
		while (it.hasNext()) {
			Object[] objectArray = (Object[]) it.next();
			String moduleId=(String)objectArray[0];
			String moduleName=(String)objectArray[1];
			moduleMap.put(moduleId, moduleName);
		}
		
		return moduleMap;
		}
		catch(Exception e)
		{
			throw e;
		}
		finally
		{
			
			if(em!=null) 
			{
				
				em.close();
			}
		}
		
	}
	
	/*public ModuleAnchorTO getModuleById(String moduleId) throws Exception
	{
		
		ModuleAnchor moduleAnchor=null;
		ModuleAnchorTO moduleAnchorTO=null;
		try
		{
			em=emf.createEntityManager();
			moduleAnchor=em.find(ModuleAnchor.class, moduleId);
			if(moduleAnchor!=null)
			{
				moduleAnchorTO=new ModuleAnchorTO();
				
				moduleAnchorTO.setAnchorEmployeeId(moduleAnchor.getAnchorEmployeeId());
				moduleAnchorTO.setAnchorName(moduleAnchor.getAnchorName());
				moduleAnchorTO.setModuleId(moduleAnchor.getModuleId());
				moduleAnchorTO.setModuleName(moduleAnchor.getModuleName());
				moduleAnchorTO.setSolutionId(moduleAnchor.getSolutionId());
			}
			
			return moduleAnchorTO;
			
			
		}
		catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		finally
		{
			
			if(em!=null) 
			{
				
				em.close();
			}
		}
	}*/
	
	public ModuleAnchorTO getModuleById(String moduleId) throws Exception
	{
		
		Module module=null;
		ModuleAnchorTO moduleAnchorTO=null;
		try
		{
			em=emf.createEntityManager();
			module=em.find(Module.class, moduleId);
			if(module!=null)
			{
				moduleAnchorTO=new ModuleAnchorTO();
				
				moduleAnchorTO.setAnchorEmployeeId(module.getAnchorEmployeeId());
				moduleAnchorTO.setAnchorName(module.getAnchorName());
				moduleAnchorTO.setModuleId(module.getModuleId());
				moduleAnchorTO.setModuleName(module.getModuleName());
				moduleAnchorTO.setSolutionId(module.getSolutionId());
				
			}
			
			return moduleAnchorTO;
			
			
		}
		catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		finally
		{
			
			if(em!=null) 
			{
				
				em.close();
			}
		}
	}

	
	public VerticalTO getVerticalById(String verticalId) throws Exception
	{
		
		Vertical vertical=null;
		VerticalTO verticalTO=null;
		try
		{
			em=emf.createEntityManager();
			vertical=em.find(Vertical.class, verticalId);
			if(vertical!=null)
			{
				verticalTO=new VerticalTO();
				verticalTO.setVerticalId(vertical.getVerticalId());
				verticalTO.setVerticalName(vertical.getVerticalName());				
			}
			
			return verticalTO;
			
			
		}
		catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		finally
		{
			
			if(em!=null) 
			{
				
				em.close();
			}
		}
	}
	
	public SubModuleTO getSubModuleById(String submoduleId) throws Exception
	{
		
		SubModule subModule=null;
		SubModuleTO subModuleTO=null;
		try
		{
			em=emf.createEntityManager();
			subModule=em.find(SubModule.class, submoduleId);
			if(subModule!=null)
			{
				subModuleTO=new SubModuleTO();
				
				subModuleTO.setAnchorEmployeeId(subModule.getAnchorEmployeeId());
				subModuleTO.setAnchorName(subModule.getAnchorName());
				//subModuleTO.setModuleId(subModule.getModuleId());
				//subModuleTO.setModuleName(subModule.getModuleName());
				//subModuleTO.setSolutionId(subModule.getSolutionId());
			}
			
			return subModuleTO;
			
			
		}
		catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		finally
		{
			
			if(em!=null) 
			{
				
				em.close();
			}
		}
	}

	/*public ModuleAnchorTO saveEditedModuleAnchor(ModuleAnchorTO moduleAnchorTO) throws Exception
	{
		
		ModuleAnchor moduleAnchor=null;
		try
		{
			em=emf.createEntityManager();
			moduleAnchor=(ModuleAnchor)em.find(ModuleAnchor.class, moduleAnchorTO.getModuleId());
			if(moduleAnchor!=null)
			{
				moduleAnchor=new ModuleAnchor();
				
				//moduleAnchor.setAnchorName(moduleAnchorTO.getAnchorName());
				moduleAnchor.setModuleId(moduleAnchorTO.getModuleId());
				moduleAnchor.setModuleName(moduleAnchorTO.getModuleName());
				moduleAnchor.setSolutionId(moduleAnchorTO.getSolutionId());
				EntityTransaction et= em.getTransaction();
				
				et.begin();
				em.merge(moduleAnchor);
				et.commit();
				
			}
			
			return moduleAnchorTO;
			
			
		}
		catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		finally
		{
			
			if(em!=null) 
			{
				
				em.close();
			}
		}
	}*/
	
	public VerticalTO saveEditedVertical(VerticalTO verticalTO) throws Exception
	{
		
		Vertical vertical=null;
		try
		{
			em=emf.createEntityManager();
			vertical=(Vertical)em.find(Vertical.class, verticalTO.getVerticalId());
			if(vertical!=null)
			{
				vertical=new Vertical();
				
				//moduleAnchor.setAnchorName(moduleAnchorTO.getAnchorName());
				vertical.setVerticalId(verticalTO.getVerticalId());
				vertical.setVerticalName(verticalTO.getVerticalName());
				vertical.setSolutionId(verticalTO.getSolutionId());
				EntityTransaction et= em.getTransaction();
				
				et.begin();
				em.merge(vertical);
				et.commit();
				
			}
			
			return verticalTO;
			
			
		}
		catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		finally
		{
			
			if(em!=null) 
			{
				
				em.close();
			}
		}
	}
	
	public ModuleAnchorTO saveEditedModuleAnchor(ModuleAnchorTO moduleAnchorTO) throws Exception
	{
		System.out.println("hello");
		Module module=null;
		try
		{
			em=emf.createEntityManager();
			module=(Module)em.find(Module.class, moduleAnchorTO.getModuleId());
			System.out.println("module in service: "+module);
			if(module!=null)
			{
				module=new Module();
				
				//moduleAnchor.setAnchorName(moduleAnchorTO.getAnchorName());
				module.setModuleId(moduleAnchorTO.getModuleId());
				System.out.println("moduleAnchorTO.getModuleId() "+moduleAnchorTO.getModuleId());
				module.setModuleName(moduleAnchorTO.getModuleName());
				System.out.println("moduleAnchorTO.getModuleName() "+moduleAnchorTO.getModuleName());
				module.setAnchorName(moduleAnchorTO.getAnchorName());
				System.out.println("moduleAnchorTO.getModuleAnchorName() "+moduleAnchorTO.getAnchorName());
				module.setSolutionId(moduleAnchorTO.getSolutionId());
				System.out.println("moduleAnchorTO.getSolutionId() "+moduleAnchorTO.getSolutionId());
				module.setVerticalId(moduleAnchorTO.getVerticalId());
				System.out.println("vertical id in service: "+moduleAnchorTO.getVerticalId());
				EntityTransaction et= em.getTransaction();
				
				et.begin();
				em.merge(module);
				et.commit();
				
			}
			
			return moduleAnchorTO;
			
			
		}
		catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		finally
		{
			
			if(em!=null) 
			{
				
				em.close();
			}
		}
	}
	
	
	
}
