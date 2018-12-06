fastlane documentation
================
# Installation

Make sure you have the latest version of the Xcode command line tools installed:

```
xcode-select --install
```

Install _fastlane_ using
```
[sudo] gem install fastlane -NV
```
or alternatively using `brew cask install fastlane`

# Available Actions
## Android
### android gradletasks
```
fastlane android gradletasks
```
Build required apk and test apk for screengrab command
### android assemblerelease
```
fastlane android assemblerelease
```

### android lintscan
```
fastlane android lintscan
```

### android unittests
```
fastlane android unittests
```

### android grabprep
```
fastlane android grabprep
```
Build required apk and test apk for screengrab command
### android alltests
```
fastlane android alltests
```
Runs all the tests with coverage
### android smalltests
```
fastlane android smalltests
```
Runs Small QA flavor tests with coverage
### android beta
```
fastlane android beta
```
Submit a new Beta Build to Crashlytics Beta
### android deploy
```
fastlane android deploy
```
Deploy a new version to the Google Play

----

This README.md is auto-generated and will be re-generated every time [fastlane](https://fastlane.tools) is run.
More information about fastlane can be found on [fastlane.tools](https://fastlane.tools).
The documentation of fastlane can be found on [docs.fastlane.tools](https://docs.fastlane.tools).
