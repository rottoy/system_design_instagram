
CREATE KEYSPACE IF NOT EXISTS insta_feed WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '1'}  AND durable_writes = true;

CREATE TABLE IF NOT EXISTS insta_feed.user_feed (
    user_id int,
    user_name text,
    create_at timestamp,
    post_id int,
    PRIMARY KEY (user_id, user_name, create_at, post_id)
) WITH CLUSTERING ORDER BY (user_name ASC, create_at DESC, post_id ASC)
    AND bloom_filter_fp_chance = 0.01
    AND caching = {'keys': 'ALL', 'rows_per_partition': 'NONE'}
    AND comment = ''
    AND compaction = {'class': 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy', 'max_threshold': '32', 'min_threshold': '4'}
    AND compression = {'chunk_length_in_kb': '16', 'class': 'org.apache.cassandra.io.compress.LZ4Compressor'}
    AND crc_check_chance = 1.0
    AND dclocal_read_repair_chance = 0.0
    AND default_time_to_live = 0
    AND gc_grace_seconds = 864000
    AND max_index_interval = 2048
    AND memtable_flush_period_in_ms = 0
    AND min_index_interval = 128
    AND read_repair_chance = 0.0
    AND speculative_retry = '99p';
CREATE INDEX IF NOT EXISTS user_feed_user_name_idx ON insta_feed."user_feed" (user_name);

