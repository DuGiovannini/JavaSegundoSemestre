package br.com.mottu.challenge.repository;

import br.com.mottu.challenge.domain.Moto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotoRepository extends JpaRepository<Moto, Long> {
        long countByPatioIdPatio(Long patioId); 
}


