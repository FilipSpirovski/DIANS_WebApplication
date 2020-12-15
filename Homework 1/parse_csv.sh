#! /bin/bash

if [ $# -ne 1 ]
then
	echo "USAGE: `basename $0` ['.csv' File]"
	exit 1;
fi

filename=$1

column_numbers=(0 2 4 6 8 9 10 11 12 13 14 15 16 19 20)
counter=0

while IFS=, read -a line
do
	row=""
	row+="$counter,"

	for i in $(seq 0 20)
	do
		if [[ " ${column_numbers[@]} " =~ " ${i} " ]]
		then
			if [ -z "${line[${i}]// }" ]
			then
				row+="null,"
			else
				row+="${line[i]},"
			fi
		fi
	done

	counter=$((counter+1))

	echo "${row::-1}"

done < $filename

exit 0;
