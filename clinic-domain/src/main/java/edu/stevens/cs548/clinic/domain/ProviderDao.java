package edu.stevens.cs548.clinic.domain;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import javax.persistence.Transient;
import javax.persistence.TypedQuery;

// TODO
@RequestScoped
public class ProviderDao implements IProviderDao {

	// TODO Use CDI producer
	@Inject
	@ClinicDomainProducer.ClinicDomain
	private EntityManager em;
	
	// TODO
	@Transient
	private ITreatmentDao treatmentDao;

	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(ProviderDao.class.getCanonicalName());

	@Override
	public void addProvider(Provider provider) throws ProviderExn {
		/*
		 * TODO add to database.
		 * Don't forget to initialize the Provider aggregate with a treatment DAO.
		 */
		UUID pid = provider.getProviderId();
		Query query = em.createNamedQuery("CountProviderByProviderId").setParameter("providerId", pid);
		Long numExisting = (Long) query.getSingleResult();
		if (numExisting < 1) {

			// TODO add to database, and initialize the patient aggregate with a treatment DAO.
			try {
				em.persist(provider);
				em.flush();
				provider.setTreatmentDAO(new TreatmentDao());
			} catch (Exception e) {
				throw new IllegalStateException("Unimplemented" + e.getMessage());
			}
		} else {
			throw new IProviderDao.ProviderExn("Insertion: Provider with provider id (" + pid + ") already exists.");
		}


	}

	@Override
	public Provider getProvider(UUID id) throws ProviderExn {
		/*
		 * TODO retrieve Provider using external key
		 */

		TypedQuery<Provider> query = em.createNamedQuery("SearchProviderByProviderId", Provider.class).setParameter("providerId",id);
		List<Provider> providers = query.getResultList();

		if (providers.size() > 1) {
			throw new IProviderDao.ProviderExn("Duplicate patient records: patient id = " + id);
		} else if (providers.size() < 1) {
			throw new IProviderDao.ProviderExn("Patient not found: patient id = " + id);
		} else {
			Provider p = providers.get(0);
			p.setTreatmentDAO(this.treatmentDao);
			return p;
		}
	}
	
	@Override
	public List<Provider> getProviders() {
		/*
		 * TODO Return a list of all providers (remember to set treatmentDAO)
		 */

		TypedQuery<Provider> query = em.createNamedQuery("SearchAllProviders", Provider.class);
		List<Provider> providers = query.getResultList();
		for (Provider p : providers) {
			p.setTreatmentDAO(treatmentDao);
		}
		return providers;
	}
	
	@Override
	public void deleteProviders() {
		Query update = em.createNamedQuery("RemoveAllTreatments");
		update.executeUpdate();
		update = em.createNamedQuery("RemoveAllProviders");
		update.executeUpdate();
	}

}
