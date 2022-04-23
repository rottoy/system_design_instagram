package com.clone.instagram.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Indexed;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.Instant;
import java.util.Date;

@Table("user_feed")
@Data
@Builder
@ToString
public class UserFeed {

    @PrimaryKeyColumn(name = "user_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private int userId;

    @Indexed
    @PrimaryKeyColumn(name = "user_name", ordinal = 1)
    private String userName;

    @PrimaryKeyColumn(name = "create_at", ordinal = 2, ordering = Ordering.DESCENDING)
    private Date createdAt;

    @PrimaryKeyColumn(name = "post_id", ordinal = 3)
    private int postId;
}
