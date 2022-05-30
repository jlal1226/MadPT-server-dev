package com.example.MadPtApi.repository;

import com.example.MadPtApi.domain.Diet;
import com.example.MadPtApi.domain.DietType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface DietRepository extends JpaRepository<Diet, Long> {

    @Query("select d from Diet d where d.member.id = :memberId and d.dietDate between :start and :end")
    List<Diet> findDietsByMemberIdAndDietDate(@Param("memberId") Long memberId, @Param("start") LocalDateTime start, @Param("end") LocalDateTime end);

    @Query("select d from Diet d where d.member.id = :memberId and d.dietType =:dietType and d.dietDate between :start and :end")
    Diet findDietByDietTypeAndDietDate(@Param("memberId") Long memberId, @Param("dietType") DietType dietType, @Param("start") LocalDateTime start, @Param("end") LocalDateTime end);

    @Query("select d from Diet d where d.member.id = :memberId and FUNCTION('MONTH', d.dietDate) = :month ")
    List<Diet> findDietsByMonth(@Param("memberId") Long memberId, @Param("month") int month);
}
