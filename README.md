Webhandle Starter
=================

Welcome to the Webhandle Starter project, an easy way to get a project up and going with
the Webhandle framework.


Setup
-----

To start from the very beginning, install Git, the Java JDK, Ant, and Ivy. Later, if you'd like, you can use
Eclipse to edit all these files since the included .project file makes importing pretty easy. No need
to if you don't want to.

For me, installing the above is as easy as:

sudo apt-get install openjdk-7-jdk
sudo apt-get install ant
sudo apt-get install ivy
sudo apt-get install git

Occasionally, I've see a problem where the ivy jar wasn't placed in a location ant could find it.
If you get some weird messages from the next couple steps about ivy not being found, you might need
to find the ivy jar (locate ivy.jar or find / -name "ivy.jar") and copy it to either ~/.ant/lib 
or /usr/share/java


Downloading
-----------

The easiest way to download this starter application is to run:

git clone git@github.com:EmergentIdeas/starter.git

or run (if you don't have your github credentials set up):

git clone https://github.com/EmergentIdeas/starter.git


This will give you a repository in a directory called "starter".


Fire it Up
----------

Change into the "starter" directory.

Run:

ant jetty

This will build all the code in this project (none yet), download all of the dependencies (quite a few), and download
a copy of jetty (to serve as a web container). You shouldn't need to run the jetty target every time since you won't
need to download jetty or the dependencies very often. More often you may want to run the "compile" target. Running
the "jetty" target sets up a fully compatible J2EE app so if you want you can point Tomcat or your favorite J2EE 
Servlet container here and run it (I do).


Run:

ant run

This will start the Jetty server with the default (no database) configuration.

You can now point your browser to http://localhost:8080/ and get the default start page.



