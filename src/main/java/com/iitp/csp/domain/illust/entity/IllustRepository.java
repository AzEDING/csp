package com.iitp.csp.domain.illust.entity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IllustRepository extends JpaRepository<Illust, Long> {
    Optional<Illust> findById(Long id);
    Page<Illust> findAll(Pageable pageable);

}
