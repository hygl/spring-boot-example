pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh './mvnw clean package -DskipTests=true'
      }
    }
    stage('test') {
      steps {
        sh './mvnw  -Dmaven.test.failure.ignore=true test'
      }
      post {
        success {
          junit 'target/surefire-reports/*.xml'
          archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
        }
      }
    }
  }
}
