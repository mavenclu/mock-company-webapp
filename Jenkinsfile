pipeline {
  agent {docker {image 'gradle:7.3.0-jdk8'}}
  stages {
      stage('build') {
          steps {
              sh './gradlew assemble'
          }
      }
      stage('test') {
        steps {
          sh './gradlew test'
        }
      }
  }
}
