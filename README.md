# ISD :: Davey Demo Labs

## First Time Setup
### Download and Install IntelliJ
- Download Intellij Ultimate Edition: https://www.jetbrains.com/idea/download/
- Link your Jetbrains account with a free student license:
  - Go to this link: https://www.jetbrains.com/community/education/#students
  - Click `Apply Now`
  - Follow the instructions to link your **student email**
- After install, open IntelliJ and link your IntelliJ installation with your account using `Activate`

### Download Tomcat Server 10.01.36
- Visit https://archive.apache.org/dist/tomcat/tomcat-10/v10.1.36/bin/
- Download `apache-tomcat-10.1.36.zip` (3rd from the bottom)
- Unzip the folder. The location does not matter

### Generate a Default Project
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
 
### Install Smart Tomcat Plugin
- From the Cogwheel (top right), choose `Plugins`
- Search for "Smart Tomcat" and install
- From the Cogwheel, choose `Settings` -> `Tomcat Server`
- Press the `+` icon, navigate to the unzipped Tomcat Server folder (go one layer into the unzipped folder)

### Run Your First Project
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

put image here
