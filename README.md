# <div align = center><img src="https://raw.githubusercontent.com/datcuandrei/ccdoom/master/img/banner.png" /></div>
ccdoom is a FOSS (<b>F</b>ree and <b>O</b>pen <b>S</b>ource <b>S</b>oftware) and cross-compatible DOOM launcher that aims to be minimalist, lightweight and completely cross-compatible. To achieve that, ccdoom is written in Java and can be built using the Python script provided. It does not use any third-party library and the look and feel of ccdoom will be the one that's native for your operating system (for GNU/Linux distributions, ccdoom will use GTK).

## Features
- Add different source ports : ccdoom has support for the following source ports as of now : ZDoom, GZDoom, Zandronum, Chocolate Doom and Crispy Doom.
- You can use any IWAD you want.
- Support for PWADS and patches : You can add any kind of mod you want or patch, whether it is a WAD, DEH/BEX patch, CFGs or archive, ccdoom accepts all file types.
- Easy management of mods and wads.
- You can add additional arguments to enhance your DOOM experience.
- ccdoom is lightweight : it uses under 50 MBs of RAM.
- Support for profiles : Love your current configuration? You can save it as a profile, and load it any time you want. You can have as many profiles as you want.

<div align = center><img src="https://raw.githubusercontent.com/datcuandrei/ccdoom/main/img/Screenshot%20from%202021-09-01%2013-59-35.png" width=70% height=70% /></div>

> ccdoom build 0.3-alpha (built on 1 Sep 2021) running ZDoom with SpongeBob-Doom2 mod on Debian 11 Bullseye.

## Building
In order to build ccdoom, all you need is basically a jdk.

The way I build ccdoom, is through the Python script provided. The script is supposed to help the developer to easily build and compile ccdoom, and at the same time offer the freedom to add or remove anything he wants.

To build ccdoom with the `build.py` script, you need to launch it this way in the command-line :
```
python3 build.py build_dir
```
where `build_dir` is the directory where the source code is present.
If you do not provide the script the building directory, by default it will try to build the project using the files found in the directory the script is present.

To create ccdoom, I used the following tools :
- [MTIDE](https://github.com/datcuandrei/MTIDE) - my very own IDE.
- [OpenJDK 17](https://openjdk.java.net/)
- [Python 3](https://www.python.org/)
- [Krita](https://krita.org/en/) - for designing the logo of ccdoom.

## License
ccdoom is currently still in development. The project will be released under the GNU GPL version 3.
```
    CCDOOM - A cross-compatible DOOM launcher. 
    Copyright (C) 2021 Andrei Datcu.

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
```

<b>Copyright (c) 2021 Andrei Datcu. All rights reserved.</b>
