# Test CLI - Rafael Fonseca
  <div>
    <img src="https://img.shields.io/badge/-Spring-black?style=for-the-badge&logoColor=white&logo=spring&color=6DB33F" alt="java" />
    <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logoColor=white&logo=java&color=ED8B00" alt="typescript" />
    <img src="https://img.shields.io/badge/-Bash-black?style=for-the-badge&logoColor=white&logo=gnubash&color=4EAA25" alt="clerk" />
  </div>



## How to use this repository?


### Setup (First time)
1. Clone the repository: 
```bash
git clone git@github.com:rfonseca85/test-cli.git
```
2. Go to the project folder
```bash
cd test-cli
```
3. Build project running the tests with: 
```bash
./gradlew clean test build
```

### Starting the CLI

Now you can run the test-cli by executing the following command on MAC/Linux:

```bash
./run.sh
```
or for windows users

```bash
run.bat
```


## How to use it?


Once installed and running you should see the screnn below:

Now you can run the command ```wordcount {filepath} ``` to retrieve the occurences of the same word in a text file

![Screenshot3](/public/Screenshot3.png)

## Help

If you need any help with the command please type ```help ``` for a list of commands or ```wordcount --help ``` for help with this specific command

![Screenshot2](/public/Screenshot2.png)




