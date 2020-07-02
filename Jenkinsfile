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
        try {
          sh './mvnw test'
      } finally {
          junit 'target/surefire-reports/*.xml'
          archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
        }
      }
    }
  }
}
