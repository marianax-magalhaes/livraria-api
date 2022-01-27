package com.livrariaapi.controller;

import com.livrariaapi.domain.Usuario;
import com.livrariaapi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping("/cadastro")
    @CrossOrigin("*")
    public Usuario registerUser(@RequestBody Usuario user) throws Exception{
        String tempEmail = user.getEmail();

        if(tempEmail != null && !"".equals(tempEmail)){
            Usuario userObj = service.fetchUserByEmail(tempEmail);
            if(userObj != null){
                throw new Exception("Usuário com e-mail " + tempEmail + " já existe!");
            }
        }
        Usuario userObj = null;
        userObj = service.saveUser(user);
        return userObj;
    }

    @PostMapping("/login")
    @CrossOrigin("*")
    public Usuario login(@RequestBody Usuario user) throws Exception{
        String tempEmail = user.getEmail();
        String tempSenha = user.getSenha();
        Usuario userObj = null;

        if(tempEmail !=null && tempSenha != null){
            userObj = service.fetchUserByEmailAndSenha(tempEmail, tempSenha);
        }
        if(userObj == null){
            throw new Exception("E-mail não cadastrado!");
        }
        return userObj;
    }
}





















