FROM mariadb:10.5

COPY ./DB_container/sql /docker-entrypoint-initdb.d
COPY ./DB_container/master_cnf/custom.cnf /etc/mysql/conf.d
COPY ./DB_container/master_cnf/my.cnf /etc/mysql/my.cnf
COPY ./DB_container/scheduling /workspace
COPY ./DB_container/docker-entrypoint.sh /usr/local/bin/

WORKDIR /workspace

RUN apt-get update -y  
RUN apt-get upgrade -y  
RUN apt-get install git vim -y 
RUN apt-get install cron -y
RUN mkdir /backup
RUN chmod 755 /workspace/backup.sh
RUN crontab /workspace/schedule.txt

ENV MYSQL_ROOT_PASSWORD 1234
