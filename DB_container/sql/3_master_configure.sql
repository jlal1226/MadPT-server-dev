GRANT REPLICATION SLAVE ON *.* TO 'repl'@'%' IDENTIFIED BY '1234';
grant all privileges on MadPT.* to 'repl'@'%' identified by '1234';
FLUSH PRIVILEGES;



-- CHANGE MASTER TO MASTER_HOST='172.17.0.3',MASTER_PORT=3306 , MASTER_USER='repl',MASTER_PASSWORD='1234', MASTER_LOG_FILE='master1-bin.000002', MASTER_LOG_POS=344;