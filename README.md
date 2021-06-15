# vulnerable-play1.4-app

****!! THIS IS AN INTENTIONALLY VULNERABLE PLAY 1.4 APP MEANT FOR DEMONSTRATION PURPOSES ONLY. PLEASE DO NOT DEPLOY ANYWHERE!! ****

# Setup Instructions

## Installing play 1.4
```
$ export PLAY=<play-install-directory>
$ wget -qO- https://downloads.typesafe.com/play/1.4.6/play-1.4.6.zip | tar xvz - -C $PLAY
# To confirm installation
$ $PLAY/play-1.4.6/play help
```
  
## Run the application
```
$ git clone https://github.com/manithirani/vulnerable-play1.4-app
$ cd vulnerable-play1.4-app
$ $PLAY/play-1.4.6/play run myVulnApp
```
  
## Demonstrate vulnerability (RCE)
Visit localhost:9000/rce?cmd=whoami to see the result of the command. There is also a /rce2 endpoint which uses the Play params map.
