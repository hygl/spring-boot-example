
pipeline{
  agent any
  stage('Build') {
      steps{
        sh "./mvnv clean package -DskipTests=true"
      }
  }
  stage('test'){
    steps{ 
        try{
          sh "mvn test"
        }finally{
          junit 'target/surefire-reports/*.xml'
          archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
        }
      }
    } 
  }
}