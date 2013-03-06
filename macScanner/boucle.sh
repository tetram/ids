# Boucle d'execution du parsage !
while true; do
		echo start
		python ./python/csvparser.py ./python/test-01.csv 36000000
		echo end
		sleep 2
	done
