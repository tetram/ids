########################################
#
# Permet de lancer le monitoring des wifi
# actifs
#
########################################

bashtrap()
{
	echo "CTRL+C Detected !...executing bash trap !"
	# fin
	# TODO stopper airodump
	airmon-ng stop mon0
}

if [ $# = 1 ]
 then
	# Passer l'interface en mode monitoring
	airmon-ng start $1
	
	# Effacer le fichier out si existant
	rm -rf caprure*

	# Ecriture de la sortie dans le fichier capture
	gnome-terminal -e 'airodump-ng -w capture mon0' &
	sleep 10
	# Boucle de parsage/sortie plus proche
	#TODO boucle
	while true; do
		python ./python/csvparser.py capture-01.csv 3600
		sleep 2
	done
	
 else
	echo "Syntaxe : $0 interface"
fi 



