CREATE TABLE pharmacies ( id INTEGER NOT NULL, title TEXT NOT NULL, rating TEXT, category TEXT NOT NULL, address TEXT, website TEXT, phone_number TEXT, monday TEXT, tuesday TEXT, wednesday TEXT, thursday TEXT, friday TEXT, saturday TEXT, sunday TEXT, latitude TEXT, longitude TEXT );

CREATE TABLE clinics ( id INTEGER NOT NULL, title TEXT NOT NULL, rating TEXT, category TEXT NOT NULL, address TEXT, website TEXT, phone_number TEXT, monday TEXT, tuesday TEXT, wednesday TEXT, thursday TEXT, friday TEXT, saturday TEXT, sunday TEXT, latitude TEXT, longitude TEXT );


COPY pharmacies FROM 'D:\FINKI\Dizajn i arhitektura na softver\Laboratoriski vezbi_Domasni zadaci\Hw1\PharmaciesDB.csv' DELIMITER ',' CSV HEADER ENCODING 'Windows-1251';

COPY clinics FROM 'D:\FINKI\Dizajn i arhitektura na softver\Laboratoriski vezbi_Domasni zadaci\Hw1\ClinicsDB.csv' DELIMITER ',' CSV HEADER ENCODING 'Windows-1251';

