# Boucle d'execution du parsage !
while true; do
		echo start
		python ./python/csvparser.py capture-01.csv 1800
		echo end
		sleep 2
	done
