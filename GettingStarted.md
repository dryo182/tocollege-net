# Getting Started with ToCollege Source Code #

# Checking Out #
Please note that this project is NOT using Google Code anymore. Please checkout the [project source on GitHub](http://github.com/jdwyah/tocollege.net/tree/master)

git clone git://github.com/jdwyah/tocollege.net.git

If you don't know, don't want, don't care about git. You can just click 'Download' from the page to download a zip file.

Sorry about the change, but I couldn't take Google Code anymore. Any change to the wiki made me need to reset the entire repository.

# Setup #

First, do read the [Building ToCollege.net](http://tocollege-net.googlecode.com/files/Building%20ToCollege.pdf) chapter from [the book](http://tinyurl.com/44y3df). There a lot of important information in there and it will explain the general flow of the ToCollege.net setup, database setup, and search setup and how to get the project going in Jetty and Eclipse.

That said, I am continuing to make changes and the book can't change along with me. It was either stay stuck in time at GWT 1.5 M1 or move on, and the idea has always been for ToCollege.net to be a living project. If you want to get the code from when the book was released you can check out the tag [release\_0\_1\_0](http://github.com/jdwyah/tocollege.net/commit/a90c2a8e2e8ce9cff3f588c6645e073e247b3941)




# Changes From the Book #

GWT 1.5.3 is now available on Maven repos, so we're using that.

2 main things to note.
  1. You'll still need to run Setup/install-all  to install some jars that are still not available on maven repos.
  1. The GWT in the maven repo does NOT have the system specific dll's that you need to run hosted mode. That's a big caveat. To fix this:

  * Download GWT 1.5.3 for your platform
  * Unzip it
  * Copy the lib**files (linux, mac) or**.dll (windows) to  ~/.m2/repository/com/google/gwt/gwt-dev/1.5.3/
(That's wherever your maven repo is for you windows users.)



# Tricky Thing 1 #

Make sure to run the launch configurations appropriate for Mac if you're a Mac user. There's tweaks in there that are important.

# Tricky Thing 2 #
To run the CollegeApp.launch it actually looks for the HTML file on localhost:8080
However ./run\_jetty does not create this file. ./run\_jetty\_gwt does.

When you go to run it, you may see:
Servlet Error Occurred
404 error for page null

You should ./run\_jetty\_gwt one time to create the HTML file. After that you can just run ./run\_jetty (unless you do maven clean) when using hosted mode.

For a more in depth description of all this ./run\_jetty stuff see the explanation in the book.


# Tricky Thing 3 #
It sounds like the run\_jetty\_gwt.bat script isn't working right on windows. Here's a tip from the groups.

"That said, I have the same problem with the run\_jetty\_gwt.bat script. The
second line of the script does not run. To get the whole app to run with the
gwt parts, simply run the second line of the bat from the command line. "






# Old Issues #
(shouldn't exist in trunk)


# Project Name #
(I've updated the launch configurations to refer to tocollege.net as the directory name)

The book mentions that you should name the project "ProGWT-ReadOnly" but then the launch configurations refer to "ProGWT". It will work to change the launch configurations, but changing the project name is easier. If you're getting it from GitHub it will be called tocollege.net. Renaming to ProGWT is a fine option here too.





## Installing GWT Maven Jars (old!) ##
(git trunk should get these straight from maven central repo!)

First off I should note is that, if you want to rock with the version from the time of the book, you can checkout tag 'release\_0\_1\_0' instead of 'trunk'. This tag runs with GWT: 1.5.0-M1, whereas trunk uses: 1.5.0.RC1. In general I'd stick with trunk, but there will be some differences from the book.

At the time the book was written, there were no versions of GWT in central repos. Unfortunately even though GWT is now in central repos, it will **not** work to use them, since in order to get hosted mode to work you need to have the DLL's in your local repository (right next to the gwt-dev jar) and the central poms aren't setup like that.

To make this happen, the source includes some little install scripts. They perform a mvn:install commands, then copy the DLL's (or lib's for Linux/Mac) into your local repository. So that's why you need to do this local Maven install, rather than standard pull from central repo.


The install scripts are located in Setup/maven/gwt. To make this happen just copy the install file for your platform into the directory created after you've downloaded the GWT zip file for your system. http://code.google.com/webtoolkit/download.html. Then run it **with** **an** **argument** of the version, eg "./install-mac 1.5.0.RC1".

From the book:
```
cd workspace/ProGWT-ReadOnly/Setup/maven/gwt
chmod a+x install*
cp install-windows /downloads/gwt-windows-0.0.2030/
cd /downloads/gwt-windows-0.0.2030/
./install-windows 1.5.0-M1
```
_for latest release of GWT use 1.5.0.RC1 as the version argument!_

## Special Windows User Notes ##
For windows:
The chmod command does not work in the normal Windows cmd.exe (Command Line Window) if you have permissions problems running the command you'll need to set them through explorer. (What's the DOS command?)

The "install-win.cmd" file is for the  in the normal Windows cmd.exe (Command Line Window)
The "install-win" file is for cygwin.







## GWT-Log ##

If you get:

[INFO](INFO.md) ------------------------------------------------------------------------
[ERROR](ERROR.md) BUILD ERROR
[INFO](INFO.md) ------------------------------------------------------------------------
[INFO](INFO.md) Failed to resolve artifact.

Missing:

---


1) com.allen\_sauer.gwt.log:gwt-log:jar:1.5.1




Change pom.xml:



&lt;dependency&gt;


> 

&lt;groupId&gt;

com.allen\_sauer.gwt.log

&lt;/groupId&gt;


> 

&lt;artifactId&gt;

gwt-log

&lt;/artifactId&gt;


> 

&lt;version&gt;

1.5.1

&lt;/version&gt;




&lt;/dependency&gt;



to



&lt;dependency&gt;


> 

&lt;groupId&gt;

com.allen\_sauer.gwt.log

&lt;/groupId&gt;


> 

&lt;artifactId&gt;

gwt-log

&lt;/artifactId&gt;


> 

&lt;version&gt;

1.5.6

&lt;/version&gt;




&lt;/dependency&gt;



[r93](https://code.google.com/p/tocollege-net/source/detail?r=93) seems to have a mismatch between the pom.xml and install-all script. Sorry!!