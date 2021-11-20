package com.iitp.csp.domain.cspfile.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface CspFileRepository extends JpaRepository<CspFile, Long> {
    Optional<CspFile> findById(Long id);
}
