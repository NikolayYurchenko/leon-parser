package com.matchit.me.leonparser.service.contract;

import com.matchit.me.leonparser.model.SportsMatchRequest;
import com.matchit.me.leonparser.model.SportsMatchResponse;

import java.util.List;

public interface SportsMatchService {

    /**
     * Create all sport matches records
     * @param sportsMatchRequests
     * @return
     */
    List<SportsMatchResponse> createAll(List<SportsMatchRequest> sportsMatchRequests);

    /**
     * Find sport match by uuid
     * @param sportsMatchUid
     * @return
     */
    SportsMatchResponse findByUuid(String sportsMatchUid);

    /**
     * Find all sport matches
     * @return
     */
    List<SportsMatchResponse> findAll();

    /**
     * Delete sport match by uuid
     * @param sportsMatchUid
     */
    void delete(String sportsMatchUid);
}
