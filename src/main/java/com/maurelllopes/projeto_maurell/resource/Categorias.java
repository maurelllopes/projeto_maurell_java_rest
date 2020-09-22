package com.maurelllopes.projeto_maurell.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/categorias")
public class Categorias {

    @RequestMapping(method=RequestMethod.GET)
    public String listar(){
        return "REST";
    }

}
