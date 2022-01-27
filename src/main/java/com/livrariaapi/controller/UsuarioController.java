package com.livrariaapi.controller;

import com.livrariaapi.domain.Usuario;
import com.livrariaapi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping("/cadastro")
    public Usuario registerUser(@RequestBody Usuario user) throws Exception{
        String tempEmail = user.getEmail();
        if(tempEmail != null && "".equals(tempEmail)){
            Usuario userObj = service.fetchUserByEmail(tempEmail);
            if(userObj != null){
                throw new Exception("Usuário com e-mail " + tempEmail + "já existe!");
            }
        }
        Usuario userObj = null;
        userObj = service.saveUser(user);
        return userObj;
    }
}







