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
          }
        }
      }
    }
    stage('container deploy') {
      steps {
        script {
          sh 'kubectl cluster-info'
          sh "kind load docker-image localhost:5000/hygl/sping-boot:$BUILD_NUMBER"
          sh "./createdep.sh spring-boot $BUILD_NUMBER  spring-boot"
          sh 'kubectl apply -f deployment.yaml'
          archiveArtifacts artifacts: 'deployment.yaml', fingerprint: true
          sh 'rm deployment.yaml'
        }
      }
    }
  }
}
