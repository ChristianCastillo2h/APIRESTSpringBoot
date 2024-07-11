package com.restapi.restapi.service;

import com.restapi.restapi.model.dto.ClienteDto;
import com.restapi.restapi.model.entity.Cliente;

import java.util.List;

public interface IClienteService {

    List<Cliente> listAll();

    Cliente save(ClienteDto cliente);

    Cliente findById(Integer id);

    void delete(Cliente cliente);

    boolean existById(Integer id);
}
