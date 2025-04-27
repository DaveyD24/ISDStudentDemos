# ISD :: Davey Demo Labs

## First Time Setup
### Download and Install IntelliJ ☕
- Download Intellij Ultimate Edition: https://www.jetbrains.com/idea/download/
- Link your Jetbrains account with a free student license:
  - Go to this link: https://www.jetbrains.com/community/education/#students
  - Click `Apply Now`
  - Follow the instructions to link your **student email**
- After install, open IntelliJ and link your IntelliJ installation with your account using `Activate`

### Download Tomcat Server 10.01.36 🐈
- Visit https://archive.apache.org/dist/tomcat/tomcat-10/v10.1.36/bin/
- Download `apache-tomcat-10.1.36.zip` (3rd from the bottom)
- Unzip the folder. The location does not matter

### Generate a Default Project 🖥️
- Create a new Project
- Choose `Maven Archetype` from the left
- Set these settings:
  - **Name**: Project name of your choice
  - **Location**: Wherever your want
  - Untick `Create Git Repository`
  - **JDK**: Click `Download JDK`
    - Version: `21`
    - Vendor: `Eclipse Temurin`
  - **Archetype**: Click `org.apache.maven.archetypes:maven-archetype-webapp` from the dropdown (it's the last one in the list)
 
### Install Smart Tomcat Plugin 😼
- From the Cogwheel (top right), choose `Plugins`
- Search for "Smart Tomcat" and install
- From the Cogwheel, choose `Settings` -> `Tomcat Server`
- Press the `+` icon, navigate to the unzipped Tomcat Server folder (go one layer into the unzipped folder)

### Run Your First Project 🏃
- From the `Run` menu, choose `Edit Configurations...`
- Press the `+` icon, add a new instance of `Smart Tomcat`
  - Be very careful not to add a different tomcat. It should be named exactly **Smart Tomcat**
- Choose the following settings (many of these will be autofilled for you, just visually check they match)
  - **Tomcat server**: The same unzipped tomcat folder from earlier
  - **Catalina base**: Ignore this, it will be generated on build
  - **Deployment Directory**: Navigate to this projects folder, then `src -> main -> webapp`
  - **Use classpath of module**: Click the dropdown and choose the one that matches the project name
  - **Context path**: Type `/YourProjectName`
  - **Server port**: `8080`
  - **Admin port**: `8005`
  - _Don't change anything else_
- Press run, the console should output a url. Click it and you should see this:

![Screenshot of console output](/Images/console.png)
![Screenshot of live server](/Images/url.png)

## Initial Database Setup
### Create Database File
- Locate the Tomcat working directory for your project
  - This is under `/Users/.SmartTomcat/ProjectName/ContextName`
  - You may also be able to find it by adding a Run Configuration and examining where it creates the Catalina Base:
![Screenshot of Run Configuration](/Images/smorttomcar.PNG)
  - Mac users may need to turn on hidden folders with `CMD + SHIFT + .`
- Create a file with the extension `.db` 

### Add Database Connector
- Under the `Java` directory, create the package `uts.isd.model.dao`
  - If you already have a `model` folder, which you should, then this just means create a `dao` package under the `model` package
- Copy the `DBConnector.java` file from this project to your newly created `dao` package
  - **IMPORTANT**: This is the **ONLY** file that you have been given permission to directly copy.
- Rename line 18 to the name of your newly created `.db` file
![Screenshot of DBConnector.java file](/Images/Line18.PNG)

## Add a connection to your database
- On the right side window, click the Database icon
- Click `+` -> `New` -> `Data Source from Path`
- Locate your newly created `.db` file
  - Mac users may need to repeat the steps from earlier to view hidden files
- Under `Driver`, select `SQLLite`
- If you see a button along the lines of "_Install missing drivers_", click it and wait for it to finish
- Click `Test Connection`
- If successful you should see a dialog like below. Take note of the SQL version
![Screenshot of SQL Connection](/Images/connection.PNG)
## Add Dependencies
- Locate your `pom.xml file`
- Under the `<dependecies>` tag, add the following code:
  ```
    <dependency>
      <groupId>org.xerial</groupId>
      <artifactId>sqlite-jdbc</artifactId>
      <version>x.x.x.0</version>
    </dependency>
  ```
- Between the `version` tag, replace this with version noted earlier 
