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
    stage('build'){
      steps{
        node{
          checkout scm
          def customImage = docker.build("hygl/spring-boot:${env.BUILD_ID}")
          customImage.push()
          customImage.push("latest")
        }
      }
    }
  }
}
