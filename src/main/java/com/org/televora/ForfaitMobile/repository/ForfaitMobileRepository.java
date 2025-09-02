package com.org.televora.ForfaitMobile.repository;

import com.org.televora.ForfaitMobile.Entity.ForfaitMobile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForfaitMobileRepository extends JpaRepository<ForfaitMobile, Long> {
}
