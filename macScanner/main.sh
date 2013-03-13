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
	# TODO stopper airodump et le java ?
	airmon-ng stop mon0

	rm -rf capture*
}

# Definition de la focntion appelee après un CTRL+C
trap bashtrap INT
if [[ $EUID -ne 0 ]]
 then
	echo "Please run the script as root !"
	exit 1
fi
if [ $# = 1 ]
 then
	# Passer l'interface en mode monitoring
	airmon-ng start $1
	
	# Effacer le fichier out si existant
	rm -rf capture*

	# Ecriture de la sortie dans le fichier capture
	gnome-terminal -e 'airodump-ng -w capture mon0' &
	sleep 10
	# Execution
	sh boucle.sh | java -jar SinfageMac.jar
	
 else
	echo "Syntaxe : $0 interface"
fi 




