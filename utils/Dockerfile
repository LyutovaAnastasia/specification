FROM postgres:13-alpine
COPY scripts/init.sql /docker-entrypoint-initdb.d/
COPY scripts/server_localhost-2022_05_04_14_02_17-dump.sql /docker-entrypoint-initdb.d/