########################################
#
# Permet de lancer le monitoring des wifi
# actifs
#
########################################

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
	python closer.py
	sleep 10

	# fin
	# TODO stopper airodump
	airmon-ng stop mon0
 else
	echo "Syntaxe : $0 interface"
fi 



