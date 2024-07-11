package com.restapi.restapi.model.dao;

import com.restapi.restapi.model.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDao extends CrudRepository<Cliente, Integer> {

}
