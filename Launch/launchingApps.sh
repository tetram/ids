# Script for launching apps
# RICM5 - IDS
# http://air.imag.fr/mediawiki/index.php/Projet_2013_:_Interactive_Digital_Signage
#
# This script assume that there are only too active desktops on your envirronment (one left and one right)


# Go on 2nd desktop
python2.7 switch_desktop right

# Start macScanner on 2nd desktop
sh ../macScanner/main.sh wlan1 &

# Go on 1st desktop
sleep 5
python2.7 switch_desktop left

# Start EDTdemon on 1st desktop
#java -jar ../EDTDemon/EDTDemons.jar

# StartKiCtrl on 1st desktop


# Start pdfViewer on 1st desktop
python2.7 ../PicViewer/print_pic.py




