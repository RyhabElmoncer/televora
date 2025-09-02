package com.org.televora.BoxInternet.Repository;
import com.org.televora.BoxInternet.Entity.BoxInternet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoxInternetRepository extends JpaRepository<BoxInternet, Long> {
}