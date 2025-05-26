FROM mysql
WORKDIR /tmp
COPY data/test_db.sql /docker-entrypoint-initdb.d
ENV MYSQL_ROOT_PASSWORD root