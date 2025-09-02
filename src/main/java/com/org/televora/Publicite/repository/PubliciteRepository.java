package com.org.televora.Publicite.repository;

import com.org.televora.Publicite.entity.Publicite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PubliciteRepository extends JpaRepository<Publicite, UUID> {
}
