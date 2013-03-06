# Boucle d'execution du parsage !
while true; do
		echo start
		python ./python/csvparser.py capture-01.csv 200000
		echo end
		sleep 2
	done
