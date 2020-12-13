#! /usr/bin/bash

echo "Connecting to the database..."
read -p "Enter your username: " username
read -p "Enter the hostname: " hostname
echo "Enter your password: "; read -s password
read -p "Enter the database name: " database

PGPASSWORD=$password "/c/Program Files/PostgreSQL/13/bin/psql" -U $username -h $hostname -d $database -f "/d/FINKI/Dizajn i arhitektura na softver/Laboratoriski vezbi_Domasni zadaci/Hw1/DB_Management.sql"


