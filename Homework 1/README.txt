Искористени цевки и филтри за превземање и филтрирање на потребните податоци:
 
ЧЕКОР 1: ./parse_csv.sh Pharmacies.csv >> PharmaciesDB.csv | ./parse_csv.sh Clinics.csv >> ClinicsDB.csv

или
         ./parse_csv.sh Pharmacies.csv >> PharmaciesDB.csv
         ./parse_csv.sh Clinics.csv >> ClinicsDB.csv


ЧЕКОР 2: Повик на скриптата ./DB_Interaction.sh, која служи за интеракција со корисникот за поврзување со неговата
	 локална POSTGRESQL база. Потребни информации за успешна конекција се: username, hostname, password, database name.
	
	"Connecting to the database..."
	"Enter your username: " -> postgres
	"Enter the hostname: " -> localhost
	"Enter your password: " -> (индивидуална корисничка лозинка)
	"Enter the database name: " -> dians (наша однапред креирана база за целите на овој проект)
	
	 Интерно, скриптата DB_Interaction.sh повикува друга .sql скрипта (во нашиот случај, DB_Management.sql) која се
	 извршува над претходно наведената база на податоци. Оваа .sql скрипта вклучува команди за креирање на табелите
	 кои нам ни беа потребни, како и популација на истите со претходно филтрираните податоци (PharmaciesDB.csv, ClinicsDB.csv).
	
	НАПОМЕНА: Сите искористени патеки во рамките на овие скрипти се апсолутни патеки на фајловите PharmaciesDB.csv и
	ClinicsDB.csv. Соодветно ќе бидат прикачени овие фајлови на GitHub, при што и Вие би имале пристап до нив и би можеле
	локално да ги измените соодветните патеки. Во текот на понатамошната работа на проектот, ќе посветиме внимание истите
	да бидат соодветно прилагодени.
		
	
	