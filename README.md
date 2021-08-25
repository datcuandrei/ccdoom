# ccdoom
A cross-compatible DOOM launcher.

## What is ccdoom?
ccdoom is a FOSS (<b>F</b>ree and <b>O</b>pen <b>S</b>ource) and cross-compatible DOOM launcher that aims to be minimalist, lightweight and completely cross-compatible. To achieve that, ccdoom is written in Java and can be built using the Python script provided. It does not use any third-party library and the look and feel of ccdoom will be the one that's native for your operating system (for GNU/Linux distributions, ccdoom will use GTK).

## Features
- Add different source ports : ccdoom has support for the following source ports as of now : ZDoom, GZDoom, Chocolate Doom and Crispy Doom.
- You can use any IWAD you want.
- Support for PWADS and patches : You can add any kind of mod you want or patch, whether it is a WAD, DEH/BEX patche, CFGs or archive (ZIP, PK3, PK7, etc.).
- Easy management of mods and wads.
- You can add additional arguments to enhance your DOOM experience.
- ccdoom is lightweight : it uses under 50 MBs of RAM.
- The way you configure ccdoom is automatically saved : ccdoom will save your current configuration in a folder found in your user directory.

## Building
In order to build ccdoom, all you need is basically a jdk.

The way I build ccdoom, is through the Python script provided. The script is supposed to help the developer to easily build and compile ccdoom, and at the same time offer the freedom to add or remove anything he wants.

To build ccdoom with the `build.py` script, you need to launch it this way in the command-line :
```
python build.py build_dir
```
where `build_dir` is the directory where the source code is present.
If you do not provide the script the building directory, by default it will try to build the project using the files found in the directory the script is present.

To create ccdoom, I used the following tools :
- [MTIDE](https://github.com/datcuandrei/MTIDE) - my very own IDE.
- [OpenJDK 17](https://openjdk.java.net/)
- [Python 3](https://www.python.org/)
- [Krita](https://krita.org/en/) - for designing the logo of ccdoom.

## License
ccdoom is currently still in development. When the project will be finished and ready to publish, only by then the license will be made public.

<b>Copyright (c) 2021 Andrei Datcu. All rights reserved.</b>
