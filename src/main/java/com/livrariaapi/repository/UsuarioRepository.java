package com.livrariaapi.repository;

import com.livrariaapi.domain.Categoria;
import com.livrariaapi.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    public Usuario findByEmail(String email);
}
