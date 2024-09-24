-- autovacuum(Dead Tuple)관련 파라미터 조회
select name,setting from pg_settings where name in ('autovacuum_vacuum_scale_factor', 'autovacuum_vacuum_threshold');

-- autovacuum(Anti Wraparound)관련 파라미터 조회
select name,setting from pg_settings where name like '%freeze%';