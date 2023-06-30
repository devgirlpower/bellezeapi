package br.com.belezze.belezzeAPIREST.domain.cliente;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Page<Client> findAllByAtivoTrue(Pageable pg);

    @Query("""
            select p.ativo
            from Client p
            where
            p.id = :id
            """)
    Boolean findAtivoById(Long id);
}
