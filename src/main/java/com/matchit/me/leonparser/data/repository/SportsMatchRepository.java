package com.matchit.me.leonparser.data.repository;

import com.matchit.me.leonparser.data.entity.SportsMatchEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.UUID;

public interface SportsMatchRepository extends MongoRepository<SportsMatchEntity, String> {


    /**
     * Find sport match by uuid
     * @param sportMatchUid
     * @return
     */
    Optional<SportsMatchEntity> findByUuid(UUID sportMatchUid);


    /**
     * Delete sports match record by uuid
     * @param sportMatchUid
     */
    void deleteByUuid(UUID sportMatchUid);
}
