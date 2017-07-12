package com.infy.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.infy.TOclasses.ModuleAnchorTO;
import com.infy.TOclasses.SubModuleTO;
import com.infy.TOclasses.VerticalTO;
import com.infy.entity.InitiatingGroup;
import com.infy.entity.Localization;
import com.infy.entity.Location;
import com.infy.entity.Module;
import com.infy.entity.ModuleSubModuleMapping;
import com.infy.entity.ProductVersion;
import com.infy.entity.Solution;
import com.infy.entity.Source;
import com.infy.entity.SubModule;
import com.infy.entity.Vertical;
import com.infy.entity.VerticalModuleMapping;
import com.infy.exceptions.AlreadyExistException;
import com.infy.exceptions.NoModuleAvailableException;
import com.infy.exceptions.UserDoesNotExistException;

public class AdminTasksService {
	// add Location
	public String addLocation(String locationName)
			throws AlreadyExistException, Exception {

		EntityManager em = null;
		Location entity = new Location();

		try {

			EntityManagerFactory emf = Persistence
					.createEntityManagerFactory("FRMS");
			em = emf.createEntityManager();
			Integer id = 100;
			Query query = em
					.createQuery("select l.locationId from Location l where l.locationName=?1");
			query.setParameter(1, locationName);
			List<Location> locationList = query.getResultList();

			if (locationList.isEmpty()) {

				Query query1 = em
						.createQuery("select max(l.locationId) from Location l");
				String locationId = (String) query1.getSingleResult();
				if (locationId != null) {
					id = Integer.parseInt(locationId.substring(2,
							locationId.length()));
					id++;
				}
				locationId = "LC" + String.valueOf(id);

				EntityTransaction et = em.getTransaction();

				entity.setLocationId(locationId);
				entity.setLocationName(locationName);

				et.begin();
				em.persist(entity);
				et.commit();

				return locationId;
			} else {

				throw new AlreadyExistException();
			}
		} catch (AlreadyExistException e) {

			throw e;
		} catch (Exception e) {

			throw e;

		} finally {

			if (em != null) {

				em.close();
			}
		}
	}

	// add Initiating Group
	public String addInitiatingGroup(String initiatingGroupName)
			throws Exception, AlreadyExistException {

		EntityManager em = null;
		try {

			EntityManagerFactory emf = Persistence
					.createEntityManagerFactory("FRMS");
			em = emf.createEntityManager();
			Integer id = 100;
			InitiatingGroup entity = new InitiatingGroup();
			Query query = em
					.createQuery("select ig.initiatingGroupId from InitiatingGroup ig where ig.initiatingGroupName=?1");
			query.setParameter(1, initiatingGroupName);
			List<InitiatingGroup> initiatingGroupList = query.getResultList();
			if (initiatingGroupList.isEmpty()) {
				Query query1 = em
						.createQuery("select max(ig.initiatingGroupId) from InitiatingGroup ig");
				String initiatingGroupId = (String) query1.getSingleResult();
				if (initiatingGroupId != null) {
					id = Integer.parseInt(initiatingGroupId.substring(2,
							initiatingGroupId.length()));
					id++;
				}
				initiatingGroupId = "IG" + String.valueOf(id);

				EntityTransaction et = em.getTransaction();

				entity.setInitiatingGroupId(initiatingGroupId);
				entity.setInitiatingGroupName(initiatingGroupName);

				et.begin();
				em.persist(entity);
				et.commit();

				return initiatingGroupId;
			} else {
				throw new AlreadyExistException();
			}
		} catch (AlreadyExistException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	// add Source
	public String addSource(String sourceName) throws Exception,
			AlreadyExistException, AlreadyExistException {

		EntityManager em = null;
		try {

			EntityManagerFactory emf = Persistence
					.createEntityManagerFactory("FRMS");
			em = emf.createEntityManager();
			Integer id = 100;
			Source entity = new Source();

			Query query = em
					.createQuery("select s.sourceId from Source s where s.sourceName=?1");
			query.setParameter(1, sourceName);
			List<Source> sourceList = query.getResultList();

			if (sourceList.isEmpty()) {
				Query query1 = em
						.createQuery("select max(src.sourceId) from Source src");
				String sourceId = (String) query1.getSingleResult();
				if (sourceId != null) {
					id = Integer.parseInt(sourceId.substring(2,
							sourceId.length()));
					id++;
				}
				sourceId = "SR" + String.valueOf(id);

				EntityTransaction et = em.getTransaction();

				entity.setSourceId(sourceId);
				entity.setSourceName(sourceName);

				et.begin();
				em.persist(entity);
				et.commit();

				return sourceId;
			} else {
				throw new AlreadyExistException();
			}
		} catch (AlreadyExistException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	// add Localization
	public String addLocalization(String localizationName) throws Exception,
			AlreadyExistException {

		EntityManager em = null;
		try {

			EntityManagerFactory emf = Persistence
					.createEntityManagerFactory("FRMS");
			em = emf.createEntityManager();
			Integer id = 100;
			Localization entity = new Localization();

			Query query = em
					.createQuery("select l.localizationId from Localization l where l.localizationName=?1");
			query.setParameter(1, localizationName);
			List<Localization> localizationList = query.getResultList();

			if (localizationList.isEmpty()) {
				Query query1 = em
						.createQuery("select max(lo.localizationId) from Localization lo");
				String localizationId = (String) query1.getSingleResult();
				if (localizationId != null) {
					id = Integer.parseInt(localizationId.substring(2,
							localizationId.length()));
					id++;
				}
				localizationId = "LO" + String.valueOf(id);

				EntityTransaction et = em.getTransaction();

				entity.setLocalizationId(localizationId);
				entity.setLocalizationName(localizationName);

				et.begin();
				em.persist(entity);
				et.commit();

				return localizationId;
			} else {
				throw new AlreadyExistException();
			}
		} catch (AlreadyExistException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	// add Solution
	public String addSolution(String solutionName) throws Exception,
			AlreadyExistException {

		EntityManager em = null;
		try {

			EntityManagerFactory emf = Persistence
					.createEntityManagerFactory("FRMS");
			em = emf.createEntityManager();
			Integer id = 100;
			Solution entity = new Solution();
			Query query = em
					.createQuery("select s.solutionId from Solution s where s.solutionName=?1");
			query.setParameter(1, solutionName);
			List<Solution> solutionList = query.getResultList();
			if (solutionList.isEmpty()) {
				Query query1 = em
						.createQuery("select max(sol.solutionId) from Solution sol");
				String solutionId = (String) query1.getSingleResult();
				if (solutionId != null) {
					id = Integer.parseInt(solutionId.substring(2,
							solutionId.length()));
					id++;
				}
				solutionId = "SL" + String.valueOf(id);

				EntityTransaction et = em.getTransaction();

				entity.setSolutionId(solutionId);
				entity.setSolutionName(solutionName);

				et.begin();
				em.persist(entity);
				et.commit();

				return solutionId;
			} else {
				throw new AlreadyExistException();
			}
		} catch (AlreadyExistException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	// add product version
	public String addProductVersion(String productVersion) throws Exception,
			AlreadyExistException {

		EntityManager em = null;
		try {

			EntityManagerFactory emf = Persistence
					.createEntityManagerFactory("FRMS");
			em = emf.createEntityManager();
			Integer id = 100;
			ProductVersion entity = new ProductVersion();
			System.out.println(" Entity Name: " + entity.getVersionName());
			Query query = em
					.createQuery("select p.versionId from ProductVersion p where p.versionName=?1");
			query.setParameter(1, productVersion);
			List<ProductVersion> versionList = query.getResultList();
			if (versionList.isEmpty()) {
				Query query1 = em
						.createQuery("select max(pr.versionId) from ProductVersion pr");
				String versionId = (String) query1.getSingleResult();
				if (versionId != null) {
					id = Integer.parseInt(versionId.substring(2,
							versionId.length()));
					id++;
				}
				versionId = "PV" + String.valueOf(id);

				EntityTransaction et = em.getTransaction();

				entity.setVersionId(versionId);
				entity.setVersionName(productVersion);

				et.begin();
				em.persist(entity);
				et.commit();

				return versionId;
			} else {
				throw new AlreadyExistException();
			}
		} catch (AlreadyExistException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	// add Module And Assign Module Anchor
	public String addModuleAndAssignModuleAnchor(ModuleAnchorTO moduleTo)
			throws Exception, AlreadyExistException {

		EntityManager em = null;
		try {

			EntityManagerFactory emf = Persistence
					.createEntityManagerFactory("FRMS");
			em = emf.createEntityManager();
			Integer id = 100;
			Module entity = new Module();

			Query query = em
					.createQuery("select ma.moduleId from Module ma where ma.moduleName=?1");
			query.setParameter(1, moduleTo.getModuleName());
			List<Module> moduleList = query.getResultList();

			if (moduleList.isEmpty()) {
				Query query1 = em
						.createQuery("select max(ma.moduleId) from Module ma");
				String moduleId = (String) query1.getSingleResult();
				if (moduleId != null) {
					id = Integer.parseInt(moduleId.substring(2,
							moduleId.length()));
					id++;
				}
				moduleId = "MD" + String.valueOf(id);

				EntityTransaction et = em.getTransaction();

				entity.setModuleId(moduleId);
				entity.setModuleName(moduleTo.getModuleName());
				entity.setSolutionId(moduleTo.getSolutionId());
				entity.setAnchorName(moduleTo.getAnchorName());

				et.begin();
				em.persist(entity);
				et.commit();

				return moduleId;
			} else {
				throw new AlreadyExistException();
			}
		} catch (AlreadyExistException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	// changes done by Bhuvana starts
	// add new sub module
	public String addMoreSubModules(ModuleAnchorTO subModuleTo)
			throws Exception, AlreadyExistException {

		EntityManager em = null;
		try {

			EntityManagerFactory emf = Persistence
					.createEntityManagerFactory("FRMS");
			em = emf.createEntityManager();
			Integer id = 100;
			SubModule entity = new SubModule();

			Query query = em
					.createQuery("select sm.subModuleId from SubModule sm where sm.subModuleName=?1");
			query.setParameter(1, subModuleTo.getSubModuleName());
			List<SubModule> subModuleList = query.getResultList();

			if (subModuleList.isEmpty()) {
				Query query1 = em
						.createQuery("select max(sm.subModuleId) from SubModule sm");
				String subModuleId = (String) query1.getSingleResult();
				if (subModuleId != null) {
					id = Integer.parseInt(subModuleId.substring(2,
							subModuleId.length()));
					id++;
				}
				subModuleId = "SD" + String.valueOf(id);

				EntityTransaction et = em.getTransaction();

				entity.setSubModuleId(subModuleId);
				entity.setSubModuleName(subModuleTo.getSubModuleName());

				et.begin();
				em.persist(entity);
				et.commit();

				return subModuleId;
			} else {
				throw new AlreadyExistException();
			}
		} catch (AlreadyExistException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public String addSubModule(SubModuleTO subModuleTo) throws Exception,
			AlreadyExistException

	{

		EntityManager em = null;

		try

		{

			EntityManagerFactory emf = Persistence
					.createEntityManagerFactory("FRMS");

			em = emf.createEntityManager();

			Integer id = 100;

			SubModule entity = new SubModule();

			Query query = em
					.createQuery("select sm.subModuleId from SubModule sm where sm.subModuleName=?1");

			query.setParameter(1, subModuleTo.getSubModuleName());

			List<SubModule> subModuleList = query.getResultList();

			if (subModuleList.isEmpty())

			{

				Query query1 = em
						.createQuery("select max(sm.subModuleId) from SubModule sm");

				String subModuleId = (String) query1.getSingleResult();

				if (subModuleId != null)

				{

					id = Integer.parseInt(subModuleId.substring(2,
							subModuleId.length()));

					id++;

				}

				subModuleId = "SD" + String.valueOf(id);

				EntityTransaction et = em.getTransaction();

				entity.setSubModuleId(subModuleId);

				entity.setSubModuleName(subModuleTo.getSubModuleName());
				// changes done by Bhuvana starts
				entity.setAnchorName(subModuleTo.getAnchorName());
				// changes completed

				et.begin();

				em.persist(entity);

				et.commit();

				return subModuleId;

			}

			else

			{

				throw new AlreadyExistException();

			}

		}

		catch (AlreadyExistException e)

		{

			throw e;

		}

		catch (Exception e)

		{

			throw e;

		}

		finally

		{

			if (em != null)

			{

				em.close();

			}

		}

	}

	// changes done by sanket mehta

	public void addModuleSubModuleMapping(String subModuleId, String moduleId)
			throws Exception, AlreadyExistException

	{

		EntityManager em = null;

		try

		{

			EntityManagerFactory emf = Persistence
					.createEntityManagerFactory("FRMS");

			em = emf.createEntityManager();

			Query query = em.createQuery("select sm from ModuleSubModuleMapping sm where sm.subModuleId=?1 and sm.moduleId=?2");

			query.setParameter(1, subModuleId);

			query.setParameter(2, moduleId);

			List<ModuleSubModuleMapping> mappingList = query.getResultList();

			if (mappingList.isEmpty())

			{

				ModuleSubModuleMapping mapping = new ModuleSubModuleMapping();

				mapping.setSubModuleId(subModuleId);

				mapping.setModuleId(moduleId);

				EntityTransaction et = em.getTransaction();

				et.begin();

				em.persist(mapping);

				et.commit();

			}

			else

			{

				throw new AlreadyExistException();

			}

		}

		catch (AlreadyExistException e)

		{

			throw e;

		}

		catch (Exception e)

		{

			throw e;

		}

	}

	// changes completed
	// add Vertical
	public String addVertical(VerticalTO verticalTO) throws Exception,
			AlreadyExistException {

		EntityManager em = null;
		try {

			EntityManagerFactory emf = Persistence
					.createEntityManagerFactory("FRMS");
			em = emf.createEntityManager();
			Integer id = 100;
			Vertical entity = new Vertical();

			Query query = em
					.createQuery("select v.verticalId from Vertical v where v.verticalName=?1");
			query.setParameter(1, verticalTO.getVerticalName());
			List<Vertical> verticalList = query.getResultList();

			if (verticalList.isEmpty()) {
				Query query1 = em
						.createQuery("select max(v.verticalId) from Vertical v");
				String verticalId = (String) query1.getSingleResult();
				if (verticalId != null) {
					id = Integer.parseInt(verticalId.substring(2,
							verticalId.length()));
					id++;
				}
				verticalId = "VL" + String.valueOf(id);

				EntityTransaction et = em.getTransaction();

				entity.setVerticalId(verticalId);
				entity.setVerticalName(verticalTO.getVerticalName());
				entity.setSolutionId(verticalTO.getSolutionId());
				// entity.setAnchorName(moduleTo.getAnchorName());

				et.begin();
				em.persist(entity);
				et.commit();

				return verticalId;
			} else {
				throw new AlreadyExistException();
			}
		} catch (AlreadyExistException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	// changes done by Bhuvana starts
	// add module
	public String addModule(ModuleAnchorTO moduleAnchorTO) throws Exception,
			AlreadyExistException, UserDoesNotExistException

	{

		EntityManager em = null;

		String empId = null;

		try

		{

			EntityManagerFactory emf = Persistence
					.createEntityManagerFactory("FRMS");

			em = emf.createEntityManager();

			Integer id = 100;

			Module entity = new Module();

			Query query = em
					.createQuery("select m.moduleId from Module m where m.moduleName=?1");

			query.setParameter(1, moduleAnchorTO.getModuleName());

			List<Module> modulesList = query.getResultList();

			if (modulesList.isEmpty())

			{

				Query query1 = em
						.createQuery("select max(m.moduleId) from Module m");

				String moduleId = (String) query1.getSingleResult();

				if (moduleId != null)

				{

					id = Integer.parseInt(moduleId.substring(2,
							moduleId.length()));

					id++;

				}

				moduleId = "MD" + String.valueOf(id);

				EntityTransaction et = em.getTransaction();

				entity.setModuleId(moduleId);
				entity.setModuleName(moduleAnchorTO.getModuleName());
				entity.setAnchorName(moduleAnchorTO.getAnchorName());
				// added for empid mapping
				// entity.setMasterRequirementId(moduleAnchorTO.getMasterRequirementId());

				if ((moduleAnchorTO.getAnchorEmployeeId() == null)) {
					Query query2 = em.createQuery("select l.empId from Login l where l.emailId=?1");
					System.out.println("Query2 " + query2);
					query2.setParameter(1, moduleAnchorTO.getAnchorName());
					try {

						empId = (String) query2.getSingleResult();

						System.out.println("Anchor Id: " + empId);
						entity.setAnchorEmployeeId(empId);
						// empId=(String) query2.getSingleResult();
					} catch (Exception e) {
						throw new UserDoesNotExistException();
					}
				}

				// entity.setAnchorEmployeeId(moduleAnchorTO.getAnchorEmployeeId());
				entity.setSolutionId(moduleAnchorTO.getSolutionId());
				entity.setVerticalId(moduleAnchorTO.getVerticalId());
				System.out.println("vertical Id in service class: "+ moduleAnchorTO.getVerticalId());
				// changes completed

				et.begin();

				em.persist(entity);

				et.commit();

				moduleAnchorTO.setModuleId(entity.getModuleId());
				System.out.println("module id in service: "+ entity.getModuleId());
				moduleAnchorTO.setModuleName(entity.getModuleName());
				moduleAnchorTO.setAnchorName(entity.getAnchorName());
				moduleAnchorTO.setVerticalId(entity.getVerticalId());

				return moduleId;

			}

			else

			{

				throw new AlreadyExistException();

			}

		}

		catch (AlreadyExistException e)

		{

			throw e;

		}

		catch (Exception e)

		{

			throw e;

		}

		finally

		{

			if (em != null)

			{

				em.close();

			}

		}

	}

	// changes complted

	// changes done by sanket mehta

	public void addVerticalModuleMapping(String moduleId, String verticalId)
			throws Exception, AlreadyExistException

	{

		EntityManager em = null;

		try

		{

			EntityManagerFactory emf = Persistence
					.createEntityManagerFactory("FRMS");

			em = emf.createEntityManager();

			Query query = em
					.createQuery("select vm from VerticalModuleMapping vm where vm.moduleId=?1 and vm.verticalId=?2");

			query.setParameter(1, moduleId);

			query.setParameter(2, verticalId);

			List<VerticalModuleMapping> mappingList = query.getResultList();

			if (mappingList.isEmpty())

			{

				VerticalModuleMapping mapping = new VerticalModuleMapping();

				mapping.setModuleId(moduleId);

				mapping.setVerticalId(verticalId);

				EntityTransaction et = em.getTransaction();

				et.begin();

				em.persist(mapping);

				et.commit();

			}

			else

			{

				throw new AlreadyExistException();

			}

		}

		catch (AlreadyExistException e)

		{

			throw e;

		}

		catch (Exception e)

		{

			throw e;

		}

	}

	// get group details by group id
	@SuppressWarnings("unchecked")
	public ModuleAnchorTO getModuleDetailsById(String moduleId)
			throws NoModuleAvailableException, Exception {
		EntityManager em = null;
		ModuleAnchorTO toObj = new ModuleAnchorTO();
		try {
			EntityManagerFactory emf = Persistence
					.createEntityManagerFactory("FRMS");
			em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();

			et.begin();
			Query query = em
					.createQuery("select m from Module m where m.moduleId= ?1");
			query.setParameter(1, moduleId);

			List<Module> rs1 = query.getResultList();

			if (!rs1.isEmpty()) {
				for (Module module : rs1) {
					toObj.setModuleId(moduleId);
					toObj.setModuleName(module.getModuleName());
					toObj.setSolutionId(module.getSolutionId());
					toObj.setVerticalId(module.getVerticalId());
					toObj.setAnchorName(module.getAnchorName());

				}
			} else {
				throw new NoModuleAvailableException();
			}
			et.commit();

			return toObj;

		}

		catch (NoModuleAvailableException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	// update Module
	/*
	 * public void updateModule(ModuleAnchorTO moduleAnchorTO)throws Exception {
	 * 
	 * EntityManager em=null; Module module = new Module();
	 * 
	 * try { EntityManagerFactory
	 * emf=Persistence.createEntityManagerFactory("FRMS");
	 * em=emf.createEntityManager(); EntityTransaction et= em.getTransaction();
	 * module= em.find(Module.class,moduleAnchorTO.getModuleId());
	 * System.out.println("module name: "+moduleAnchorTO.getModuleName());
	 * if(module!=null) { et.begin();
	 * module.setSolutionId(moduleAnchorTO.getSolutionId());
	 * module.setVerticalId(moduleAnchorTO.getVerticalId());
	 * module.setModuleId(moduleAnchorTO.getModuleId());
	 * module.setModuleName(moduleAnchorTO.getModuleName());
	 * System.out.println("module name after updation: "
	 * +moduleAnchorTO.getModuleName());
	 * module.setAnchorName(moduleAnchorTO.getAnchorName());
	 * 
	 * System.out.println("module anchor name after updation: "+moduleAnchorTO.
	 * getAnchorName());
	 * 
	 * et.commit();
	 * 
	 * } }
	 * 
	 * catch(Exception e) { throw e; } finally { if(em!=null) { em.close(); } }
	 * }
	 */

	public boolean updateModule(ModuleAnchorTO moduleAnchorTO) throws Exception {

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("FRMS");
		EntityManager em = null;
		try {

			/*
			 * try { em=emf.createEntityManager(); em.getTransaction().begin();
			 * Module module = new Module();
			 * module.setSolutionId(moduleAnchorTO.getSolutionId());
			 * module.setVerticalId(moduleAnchorTO.getVerticalId());
			 * module.setModuleId(moduleAnchorTO.getModuleId());
			 * module.setModuleName(moduleAnchorTO.getModuleName());
			 * module.setAnchorName(moduleAnchorTO.getAnchorName());
			 * 
			 * em.merge(module); em.getTransaction().commit();
			 * 
			 * 
			 * } catch(Exception e) { throw e; } finally { if(em!=null) {
			 * em.close(); } }
			 */

			System.out.println("inside update module function of service");
			String empId = null;
			em = emf.createEntityManager();
			em.getTransaction().begin();
			Module module = em.find(Module.class, moduleAnchorTO.getModuleId());
			System.out.println("module id before updation: "+ moduleAnchorTO.getModuleId());
			System.out.println("module name before updation: "+ moduleAnchorTO.getModuleName());
			if (module != null) {
				module.setSolutionId(moduleAnchorTO.getSolutionId());
				module.setVerticalId(moduleAnchorTO.getVerticalId());
				System.out.println("vertical Id after updation: "+ moduleAnchorTO.getVerticalId());

				module.setModuleId(moduleAnchorTO.getModuleId());
				module.setModuleName(moduleAnchorTO.getModuleName());
				System.out.println("module name after updation: "+ moduleAnchorTO.getModuleName());
				module.setAnchorName(moduleAnchorTO.getAnchorName());
				// module.setAnchorEmployeeId(moduleAnchorTO.getAnchorEmployeeId());
				// System.out.println("module anchor id after updation: "+moduleAnchorTO.getAnchorEmployeeId());

				if ((moduleAnchorTO.getAnchorEmployeeId() == null)) {
					Query query2 = em.createQuery("select l.empId from Login l where l.emailId=?1");
					System.out.println("Query2 " + query2);
					query2.setParameter(1, moduleAnchorTO.getAnchorName());
					empId = (String) query2.getSingleResult();
					System.out.println("Anchor Id: " + empId);
					module.setAnchorEmployeeId(empId);
					// empId=(String) query2.getSingleResult();
				}
				
				VerticalModuleMapping verticalModuleMapping = em.find(VerticalModuleMapping.class, moduleAnchorTO.getModuleId());
				if(verticalModuleMapping!=null)
				{
					verticalModuleMapping.setVerticalId(moduleAnchorTO.getVerticalId());
					verticalModuleMapping.setModuleId(moduleAnchorTO.getModuleId());
				}

				// em.merge(module);
				em.getTransaction().commit();
				return true;
			}
						
			// em.merge(module);

			em.getTransaction().commit();
			return false;

		}

		catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (em != null) {
				em.close();
			}
		}

	}
	
	
	public boolean updateVerticalModuleMapping(String moduleId, String verticalId) throws Exception {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("FRMS");
		EntityManager em = null;
		ModuleAnchorTO anchorTO = new ModuleAnchorTO();
		try {

			VerticalModuleMapping verticalModule = em.find(VerticalModuleMapping.class, anchorTO.getModuleId());

			//List<ModuleSubModuleMapping> mappingList = query.getResultList();

			if (((List<VerticalModuleMapping>) verticalModule).isEmpty())

			{

				VerticalModuleMapping mapping = new VerticalModuleMapping();

				mapping.setModuleId(moduleId);

				mapping.setVerticalId(verticalId);

				EntityTransaction et = em.getTransaction();

				et.begin();

				//em.persist(mapping);

				et.commit();

			}
						
			// em.merge(module);

			em.getTransaction().commit();
			return false;

		}

		catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (em != null) {
				em.close();
			}
		}

	}
	

}
