![](img/banner.png)

ccdoom is a FOSS (<b>F</b>ree and <b>O</b>pen <b>S</b>ource <b>S</b>oftware) and cross-compatible DOOM launcher that aims to be minimalist, lightweight and completely cross-compatible. To achieve that, ccdoom is written in Java and can be built using the Python script provided. It does not use any third-party library and the look and feel of ccdoom will be the one that's native for your operating system (for GNU/Linux distributions, ccdoom will use GTK).

## Setup
To get ccdoom, simply download the latest binary available in the releases page.
<b>The prebuilt binary requires JDK 16</b>

To learn how to use it, read the [instructions](instructions/instructions.md). You can also read the same instructions if you go to `Help > Get started with ccdoom`

This is how ccdoom looks across different OS'
![](img/interfaces.png)
> From left to right : GNU/Linux, Windows, Mac OS X. Same binary, different platforms.
## Features
- Add different source ports : ccdoom has support for the following source ports as of now : ZDoom, GZDoom, Zandronum, Chocolate Doom and Crispy Doom.
- You can use any IWAD you want.
- Support for PWADS and patches : You can add any kind of mod you want or patch, whether it is a WAD, DEH/BEX patch, CFGs or archive, ccdoom accepts all file types.
- Easy management of mods and wads.
- You can add additional arguments to enhance your DOOM experience.
- ccdoom is lightweight : it uses under 50 MBs of RAM.
- Support for profiles : Love your current configuration? You can save it as a profile, and load it any time you want. You can have as many profiles as you want.
- Partial multiplayer support : ccdoom's main focus is to be a great single player DOOM launcher, but from time to time, I do enjoy to have some multiplayer action. That's why I added partial multiplayer support. Thanks to [doomlist](https://doomlist.net) (credit goes to [Jan K](https://gitlab.com/jan_k)), ccdoom now has a server browser for Zandronum servers.

![](img/056-alpha.png)
> A screenshot of ccdoom 0.5.6-alpha running Zandronum with Brutal Doom mod on a multiplayer server, on ArcoLinux.

## What to expect in the future releases
- No PATH variable requirement:
If it isn't added to your PATH variable, you can browse for the location of your source port and ccdoom will save the location to it.

## Building
In order to build ccdoom, all you need is basically a JDK.

The way I build ccdoom, is through the Python script provided. The script is supposed to help the developer to easily build and compile ccdoom, and at the same time offer the freedom to add or remove anything he wants.

To build ccdoom with the `build.py` script, you need to launch it this way in the command-line :
```
python3 build.py build_dir
```
where `build_dir` is the directory where the source code is present.
If you do not provide the script the building directory, by default it will try to build the project using the files found in the directory the script is present.

To create ccdoom, I used the following tools :
- [MTIDE](https://github.com/datcuandrei/MTIDE) - my very own IDE.
- [OpenJDK 16](https://openjdk.java.net/)
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
