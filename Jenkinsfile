pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh 'mvn clean package -DskipTests=true'
      }
    }
    stage('test') {
      steps {
        sh 'mvn  -Dmaven.test.failure.ignore=true test'
      }
      post {
        success {
          junit 'target/surefire-reports/*.xml'
          archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
        }
      }
    }
    stage('container build') {
      steps {
        script {
          docker.withRegistry('http://localhost:5000') {
            def dockerImage = docker.build("hygl/sping-boot:$BUILD_NUMBER")
            dockerImage.push()
            dockerImage.push("latest")
            sh 'kubectl cluster-info'
          }
        }
      }
    }
  }
}
