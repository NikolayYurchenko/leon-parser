package com.matchit.me.leonparser.data.entity;

import com.matchit.me.leonparser.model.Market;
import com.matchit.me.leonparser.model.SportType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "sports_matches")
public class SportsMatchEntity {

    @Id
    private String id;

    private UUID uuid;

    @Enumerated(EnumType.STRING)
    private SportType sportType;

    private String matchId;

    private String leagueName;

    private String matchName;

    private LocalDateTime startTime;

    private List<Market> markets;

    @CreatedDate
    private LocalDateTime createdAt;
}
