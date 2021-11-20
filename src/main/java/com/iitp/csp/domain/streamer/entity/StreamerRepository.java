package com.iitp.csp.domain.streamer.entity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StreamerRepository extends JpaRepository<Streamer,Long> {
    Optional<Streamer> findById(Long id);
    Page<Streamer> findAll(Pageable pageable);
}
