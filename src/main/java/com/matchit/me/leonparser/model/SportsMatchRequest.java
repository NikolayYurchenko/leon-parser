package com.matchit.me.leonparser.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SportsMatchRequest {

    private SportType sportType;

    private String matchId;

    private String leagueName;

    private String matchName;

    private LocalDateTime startTime;

    private List<Market> markets;
}
