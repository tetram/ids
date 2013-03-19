# Only on Unix system
# requires xautomation
import getopt
import os
import sys
from subprocess import Popen, PIPE
########### Key sequences #############
switch_desktop_right = '''keydown Control_L
keydown Alt_L
key Right
keyup Alt_L
keyup Control_L
'''

switch_desktop_left = '''keydown Control_L
keydown Alt_L
key Left
keyup Alt_L
keyup Control_L
'''

switch_desktop_up = '''keydown Control_L
keydown Alt_L
key Up
keyup Alt_L
keyup Control_L
'''

switch_desktop_down = '''keydown Control_L
keydown Alt_L
key Down
keyup Alt_L
keyup Control_L
'''
########################################

def keypress(sequence):
    p = Popen(['xte'], stdin=PIPE)
    p.communicate(input=sequence)

def main():
	try:
		opts, args = getopt.getopt(sys.argv[1:], "h", ["help"])
	except getopt.GetoptError as err:
		print(str(err))
		sys.exit(2)
	direction = args[0]
	if(direction == "up"):
		keypress(switch_desktop_up)
	elif(direction == "down"):
		keypress(switch_desktop_down)
	elif(direction == "left"):
		keypress(switch_desktop_left)
	elif(direction == "right"):
		keypress(switch_desktop_right)
	else:
		print("Arg must be up, down, left or right")


if __name__ == "__main__":
    main()
