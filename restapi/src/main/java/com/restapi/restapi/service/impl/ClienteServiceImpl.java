package com.restapi.restapi.service.impl;

import com.restapi.restapi.model.dao.ClienteDao;
import com.restapi.restapi.model.dto.ClienteDto;
import com.restapi.restapi.model.entity.Cliente;
import com.restapi.restapi.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service //Se usa para construir una clase de Servicio que habitualmente se conecta a varios repositorios y agrupa su funcionalidad
public class ClienteServiceImpl implements IClienteService {

    @Autowired //Nos proporciona control a la hora de querer inyectar nuestras dependencias o instancias que se almancenan en el contexto de Spring
    private ClienteDao clienteDao;

    @Override
    public List<Cliente> listAll() {
        return (List) clienteDao.findAll();
    }

    @Transactional
    @Override
    public Cliente save(ClienteDto clienteDto) {
        Cliente cliente = Cliente.builder()
                .idCliente(clienteDto.getIdCliente())
                .nombre(clienteDto.getNombre())
                .apellido(clienteDto.getApellido())
                .correo(clienteDto.getCorreo())
                .fechaRegistro(clienteDto.getFechaRegistro())
                .build();
        return clienteDao.save(cliente);
    }

    @Transactional(readOnly = true)
    @Override
    public Cliente findById(Integer id) {
        return clienteDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);
    }

    @Override
    public boolean existById(Integer id) {
        return clienteDao.existsById(id);
    }
}
