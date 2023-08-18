package com.example.baryset.repository;

import com.example.baryset.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {

    @Query(value = "select distinct r.* from region r" +
            " inner join region_location rl on r.id = rl.id_from" +
            " where id_in = ?1", nativeQuery = true)
    List<Region> findRegionLocation(Long id);

    @Query(value = "select distinct r.* from region r" +
            " inner join region_location rl on r.id = rl.id_in" +
            " where id_from = ?1", nativeQuery = true)
    List<Region> findRegionsIn(Long id);
}
