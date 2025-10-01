package br.com.mottu.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.mottu.challenge.domain.Patio;

public interface PatioRepository extends JpaRepository<Patio, Long> {
}
