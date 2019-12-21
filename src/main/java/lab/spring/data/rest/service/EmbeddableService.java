package lab.spring.data.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lab.spring.data.rest.dao.EmbeddableDAO;
import lab.spring.data.rest.entity.Company;
import lab.spring.data.rest.entity.ContactPerson;

@Service
public class EmbeddableService {

	@Autowired
	private EmbeddableDAO embeddableDAO;

	public void createCompany() {
		try {
			ContactPerson cp = new ContactPerson("Latha", "Raja", "9965470181");

			Company company = new Company("HariHaran", "Raja", "8940005592", cp);
			company = embeddableDAO.save(company);
			System.out.println(company.toString());
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
