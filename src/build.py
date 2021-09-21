# CCDOOM - A cross-compatible DOOM launcher. 
# Copyright (C) 2021  Andrei Datcu <@datcuandrei>

# This program is free software: you can redistribute it and/or modify
# it under the terms of the GNU General Public License as published by
# the Free Software Foundation, either version 3 of the License, or
# (at your option) any later version.

# This program is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# GNU General Public License, or LICENSE in the repository for more details.

#!/usr/bin/env python3
import os
import sys

# using python to ensure build cross-compatibility.

# checking if the user passed the location of building directory
if len(sys.argv) > 1:
	build_dir = str(sys.argv[1]) # if the user did, then the script will use the location provided by the user
else: build_dir = os.path.dirname(__file__) # otherwise, the script will use the location of itself.

os.system("javac -d "+ build_dir +" *.java") # build current project
os.system("jar -cvfm "+ build_dir +"/ccdoom.jar "+ build_dir +"/manifest.txt "+ build_dir +"/ *.class") # compile project
os.system("java -jar "+ build_dir +"/ccdoom.jar") # run program
