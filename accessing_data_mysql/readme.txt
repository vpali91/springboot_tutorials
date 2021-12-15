Az adatbázis és a felhasználó létrehozásához használt ezeket a lekérdezéseket!

mysql> create database db_example; -- Creates the new database
mysql> create user 'springuser'@'%' identified by 'ThePassword'; -- Creates the user
mysql> grant all on db_example.* to 'springuser'@'%'; -- Gives all privileges to the new user on the newly created database

Ezt követően nyiss egy új spring boot projektet és másold be az osztályok és html fájlok releváns tartalmát, valamint ellenőrizd a pom.xml fájlt, hogy a dependecy-k jól lettek-e megadva a projektedben.
