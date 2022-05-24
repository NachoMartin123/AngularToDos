package com.example.demo.helloworld.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.helloworld.model.ToDo;
import com.example.demo.helloworld.model.User;
import com.example.demo.helloworld.repository.ToDoJpaRepository;
import com.example.demo.helloworld.repository.UserJpaRepository;
import com.example.demo.helloworld.service.UserService;
import com.example.demo.util.BusinessException;
import com.example.demo.util.Check;


@Service
public class ToDoServiceImpl extends UserService{
	
	@Autowired
	private ToDoJpaRepository toDoJpaRepository;
	
	@Autowired
	private UserJpaRepository userJpaRepository;
	
	
	public List<ToDo> findByUsername(String username) throws BusinessException {
		
//		ClienteRepository c = Factory.repository.forCliente();
//		Cliente cliente = c.findById(id);
//		Check.isNotNull(cliente, "El cliente no existe");
//		MedioPagoRepository mp = Factory.repository.forMedioPago();
//		List<MedioPago> mediosPago = mp.findPaymentMeansByClientId(id);
//		List<Bono> soloBonos = new ArrayList<Bono>();
//		for (MedioPago m : mediosPago) {
//			if (m instanceof Bono)
//				soloBonos.add((Bono) m);
//		}
//		return DtoAssembler.toVoucherDtoList(soloBonos);
		
		
		User u = userJpaRepository.findByUsername(username);
		List<ToDo> todos = toDoJpaRepository.findByUserId(u.getId());
		Check.isNotNull(u, "El usuario no existe");
		return toDoJpaRepository.findByUsername(username);
	}
	
	public Optional<ToDo> findById(long id) {
		return toDoJpaRepository.findById(id);
	}	

	public ToDo save(ToDo t) {
		return toDoJpaRepository.save(t);
	}

	public void deleteById(long id) {
		toDoJpaRepository.deleteById(id);		
	}




}
