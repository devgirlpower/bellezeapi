package br.com.belezze.belezzeAPIREST.domain.profissional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface ProfessionalRepository extends JpaRepository<Professional, Long> {
    Page<Professional> findAllByAtivoTrue(Pageable pg);
    @Query("""
            select m from Professional m
            where
            m.ativo = true
            and
            m.area = :area
            and
            m.id not in(
                select c.professional.id from Reserva c
                where
                c.data = :data
                and
                c.reasonCancel is null
            )
            order by rand()
            limit 1
        """)
    Professional selecionaProfissionalAleatorioLivreData(AreaAtuacao area, LocalDateTime data);

    @Query("""
            select m.ativo
            from Professional m
            where
            m.id = :id
            """)
    Boolean findAtivoById(Long id);
}
