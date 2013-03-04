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
	rm -rf out.*

	# Ecriture de la sortie dans le fichier out
	airodump-ng -w out mon0 &

	# Boucle de parsage/sortie plus proche
	TODO
	# fin
	airmon-ng stop mon0
 else
	echo "Syntaxe : $0 interface"
fi 



