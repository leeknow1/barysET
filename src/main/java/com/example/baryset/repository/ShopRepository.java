package com.example.baryset.repository;

import com.example.baryset.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {

    @Query("select s from Shop s where s.region.id = ?1")
    Optional<Shop> findByRegionId(Long id);
}
