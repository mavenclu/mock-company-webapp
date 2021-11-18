pipeline {
  agent {docker {image 'gradle:6.9.1-jdk8'}}
  stages {
      stage('build') {
          steps {
              sh './gradlew assemble --stacktrace'
          }
      }
      stage('test') {
        steps {
          sh './gradlew test'
        }
      }
  }
}
