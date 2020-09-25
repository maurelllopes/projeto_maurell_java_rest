package com.maurelllopes.projeto_maurell.service;

import com.maurelllopes.projeto_maurell.DTO.ClienteDTO;
import com.maurelllopes.projeto_maurell.DTO.ClienteNewDTO;
import com.maurelllopes.projeto_maurell.domain.*;
import com.maurelllopes.projeto_maurell.domain.Cliente;
import com.maurelllopes.projeto_maurell.domain.Endereco;
import com.maurelllopes.projeto_maurell.repositories.CidadeRepository;
import com.maurelllopes.projeto_maurell.repositories.ClienteRepository;
import com.maurelllopes.projeto_maurell.service.exception.DataIntegrityService;
import com.maurelllopes.projeto_maurell.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.maurelllopes.projeto_maurell.repositories.EnderecoRepository;
import com.maurelllopes.projeto_maurell.service.ClienteService;

import java.util.List;
import java.util.Optional;
@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Cliente find(Integer id){
        Optional<Cliente> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));

    }
    @Transactional
    public Cliente insert(Cliente obj) {
        obj.setId(null);
        obj = repo.save(obj);
        enderecoRepository.saveAll(obj.getEnderecos());
        return obj;
    }
    public Cliente update(Cliente obj) {
        Cliente newObj = find(obj.getId());
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    public void delete(Integer id) {
        find(id);
        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityService("Não é possível excluir porque há entidades relacionadas");

        }
    }
    public List<Cliente> findAll() {
        return repo.findAll();

    }
    public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }
    public Cliente fromDTO(ClienteDTO objDto){
        return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null);
    }
    public Cliente fromDTO(ClienteNewDTO objDto){
       Cliente cli = new Cliente(null, objDto.getNome(), objDto.getEmail(), objDto.getCpfouCnpj(), TipoCliente.toEnum(objDto.getTipo()));
       Cidade cid = new Cidade(objDto.getCidadeId(), null, null);
       Endereco end = new Endereco(null, objDto.getLogadouro(), objDto.getNumero(), objDto.getComplemento(), objDto.getBairro(), objDto.getCep(), cli, cid);
       cli.getEnderecos().add(end);
       cli.getTelefones().add(objDto.getTelefone1());
       if(objDto.getTelefone2()!=null){
           cli.getTelefones().add(objDto.getTelefone2());
       }
        if(objDto.getTelefone3()!=null){
            cli.getTelefones().add(objDto.getTelefone3());
        }
        return cli;
    }
    private void updateData(Cliente newObj, Cliente obj){
        newObj.setNome(obj.getNome());
        newObj.setEmail(obj.getEmail());
    }

}


