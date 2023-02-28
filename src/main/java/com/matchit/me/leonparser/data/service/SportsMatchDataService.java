package com.matchit.me.leonparser.data.service;

import com.matchit.me.leonparser.data.entity.SportsMatchEntity;
import com.matchit.me.leonparser.data.repository.SportsMatchRepository;
import com.matchit.me.leonparser.model.SportsMatchRequest;
import com.matchit.me.leonparser.model.SportsMatchResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class SportsMatchDataService {

    private final SportsMatchRepository sportsMatchRepository;


    /**
     * Create sport match record
     * @param sportsMatchRequest
     * @return
     */
    public SportsMatchResponse create(SportsMatchRequest sportsMatchRequest) {

        log.debug("Creating sport match record from data:[{}]", sportsMatchRequest);

        SportsMatchEntity match = SportsMatchEntity.builder()
                .uuid(UUID.randomUUID())
                .sportType(sportsMatchRequest.getSportType())
                .matchId(sportsMatchRequest.getMatchId())
                .leagueName(sportsMatchRequest.getLeagueName())
                .matchName(sportsMatchRequest.getMatchName())
                .startTime(sportsMatchRequest.getStartTime())
                .markets(sportsMatchRequest.getMarkets())
                .createdAt(LocalDateTime.now())
                .build();

        return SportsMatchResponse.instance(sportsMatchRepository.save(match));
    }

    /**
     * Create many sport matches records
     * @param sportsMatchRequests
     * @return
     */
    public List<SportsMatchResponse> create(List<SportsMatchRequest> sportsMatchRequests) {

        log.debug("Creating many sport  matches records from data:{}", sportsMatchRequests);

        List<SportsMatchEntity> matches = new ArrayList<>();

        sportsMatchRequests.forEach(sportsMatchRequest -> matches.add(SportsMatchEntity.builder()
                .uuid(UUID.randomUUID())
                .sportType(sportsMatchRequest.getSportType())
                .matchId(sportsMatchRequest.getMatchId())
                .leagueName(sportsMatchRequest.getLeagueName())
                .matchName(sportsMatchRequest.getMatchName())
                .startTime(sportsMatchRequest.getStartTime())
                .markets(sportsMatchRequest.getMarkets())
                .createdAt(LocalDateTime.now())
                .build()));

        return SportsMatchResponse.instance(sportsMatchRepository.saveAll(matches));
    }


    /**
     * Find sport match by uuid
     * @param sportsMatchUid
     * @return
     */
    public SportsMatchResponse findByUuid(String sportsMatchUid) {

        log.debug("Searching sport match by uuid:[{}]", sportsMatchUid);

        SportsMatchEntity sportsMatchEntity = sportsMatchRepository.findByUuid(UUID.fromString(sportsMatchUid))
                .orElseThrow(() -> new EntityNotFoundException("Not found sport match by uuid:["+ sportsMatchUid +"]"));

        log.debug("...found:[{}]", sportsMatchEntity);

        return SportsMatchResponse.instance(sportsMatchEntity);
    }

    /**
     * Find all sport matches
     * @return
     */
    public List<SportsMatchResponse> findAll() {

        log.debug("Searching for all sport matches");

        return SportsMatchResponse.instance(sportsMatchRepository.findAll());
    }

    /**
     * Delete sport match by uuid
     * @param sportsMatchUid
     */
    public void delete(String sportsMatchUid) {

        log.debug("Deleting sport match record by uuid:[{}]", sportsMatchUid);

        sportsMatchRepository.deleteByUuid(UUID.fromString(sportsMatchUid));
    }
}
