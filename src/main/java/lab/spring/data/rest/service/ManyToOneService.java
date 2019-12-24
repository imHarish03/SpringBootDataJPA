package lab.spring.data.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lab.spring.data.rest.dao.ManyToOneDAO;
import lab.spring.data.rest.entity.EmergencyInfo;

@Service
public class ManyToOneService {

	@Autowired
	private ManyToOneDAO manyToOneDAO;

	public void getEmergencyInfo() {
		List<EmergencyInfo> list = manyToOneDAO.findAll();

		for (EmergencyInfo info : list) {
			System.out.println("UserID        : " + info.getUser().getId());
			System.out.println("Contact Number: " + info.getContactNumber());
			System.out.println("Contact Person: " + info.getContactPerson());

		}

	}

}
