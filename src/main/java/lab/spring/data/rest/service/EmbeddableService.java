package lab.spring.data.rest.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lab.spring.data.rest.dao.EmbeddableDAO;
import lab.spring.data.rest.entity.Address;
import lab.spring.data.rest.entity.Company;
import lab.spring.data.rest.entity.ContactPerson;

@Service
public class EmbeddableService {

	@Autowired
	private EmbeddableDAO embeddableDAO;

	public void createCompany() {
		try {
			ContactPerson cp = new ContactPerson("Latha", "Raja", "9965470181");

			Set<Address> addressSet = new HashSet<Address>();
			Address address = new Address("GuruDev PG", "Madiwala", "Babgalore", "Karnataka", "India", "560068");
			addressSet.add(address);

			Company company = new Company("HariHaran", addressSet, "8940005592", cp);
			company = embeddableDAO.save(company);
			System.out.println(company.toString());
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
