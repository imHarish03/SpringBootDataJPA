package lab.spring.data.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lab.spring.data.rest.dao.OneToOneDAO;

@Service
public class OneToOneUniService {

	@Autowired
	private OneToOneDAO oneToOneDAO;

}
