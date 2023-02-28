package com.matchit.me.leonparser.model;

import com.matchit.me.leonparser.data.entity.SportsMatchEntity;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class SportsMatchResponse {

    private String uuid;

    private SportType sportType;

    private String matchId;

    private String leagueName;

    private String matchName;

    private LocalDateTime startTime;

    private List<Market> markets;

    private LocalDateTime createdAt;


    public static SportsMatchResponse instance(SportsMatchEntity match) {

        return SportsMatchResponse.builder()
                .uuid(match.getUuid().toString())
                .sportType(match.getSportType())
                .matchId(match.getMatchId())
                .leagueName(match.getLeagueName())
                .matchName(match.getMatchName())
                .startTime(match.getStartTime())
                .markets(match.getMarkets())
                .createdAt(match.getCreatedAt())
                .build();
    }

    public static List<SportsMatchResponse> instance(List<SportsMatchEntity> matches) {

        return matches.stream()
                .map(SportsMatchResponse::instance)
                .toList();
    }
}
