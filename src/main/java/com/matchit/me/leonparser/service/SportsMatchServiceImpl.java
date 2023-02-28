package com.matchit.me.leonparser.service;

import com.matchit.me.leonparser.data.service.SportsMatchDataService;
import com.matchit.me.leonparser.model.SportsMatchRequest;
import com.matchit.me.leonparser.model.SportsMatchResponse;
import com.matchit.me.leonparser.service.contract.SportsMatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SportsMatchServiceImpl implements SportsMatchService {

    private final SportsMatchDataService sportsMatchDataService;

    @Override
    public List<SportsMatchResponse> createAll(List<SportsMatchRequest> sportsMatchRequests) {

        return sportsMatchDataService.create(sportsMatchRequests);
    }

    @Override
    public SportsMatchResponse findByUuid(String sportsMatchUid) {

        return sportsMatchDataService.findByUuid(sportsMatchUid);
    }

    @Override
    public List<SportsMatchResponse> findAll() {

        return sportsMatchDataService.findAll();
    }

    @Override
    public void delete(String sportsMatchUid) {

        sportsMatchDataService.delete(sportsMatchUid);
    }
}
