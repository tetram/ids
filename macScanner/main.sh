########################################
#
# Permet de lancer le monitoring des wifi
# envirronnement actifs
#
########################################

if [ $# = 1 ]
 then
	# Passer l'interface en mode monitoring
	airomong-ng start $1
	
	# Effacer le fichier out si existant
	rm -rf caprure*

	# Ecriture de la sortie dans le fichier capture
	airodump-ng -w capture mon0 &

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



