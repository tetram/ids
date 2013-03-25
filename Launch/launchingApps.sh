# Script for launching apps
# RICM5 - IDS
# http://air.imag.fr/mediawiki/index.php/Projet_2013_:_Interactive_Digital_Signage
#
# This script assume that there are only too active desktops on your envirronment (one left and one right)


# Go on 1st desktop
python2.7 switch_desktop.py left

# Start macScanner on 2nd desktop
cd ../macScanner/
echo 'Launching macScanner...'
sudo sh main3.sh wlan1 &
sleep 25

# Go on 2nd desktop
cd ../Launch/
python2.7 switch_desktop.py right

# Start EDTdemon on 1st desktop
echo 'Launching EDTDemon...'
java -jar ../EDTDemons/EDTDemons.jar &
sleep 1

# StartKiCtrl on 1st desktop
echo 'Launching kinect controler...'
java -jar ../kinect/kinect.jar -b &
sleep 1

# Start pdfViewer on 1st desktop
cd ../PicViewer/
python2.7 print_pic.py &




