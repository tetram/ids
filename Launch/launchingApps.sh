# Script for launching apps
# RICM5 - IDS
# http://air.imag.fr/mediawiki/index.php/Projet_2013_:_Interactive_Digital_Signage


# Go on 1st desktop
python2.7 switch_desktop up
python2.7 switch_desktop left

# Start EDTdemon


# StartKiCtrl


# Start pdfViewer


# Go on 2nd desktop
sleep 1
python2.7 switch_desktop down

# Start macScanner
sh ../macScanner/main.sh wlan1 &

# Go back on 1st desktop
sleep 5
python2.7 switch_desktop up
