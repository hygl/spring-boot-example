
podTemplate(label: 'test-pod',name: 'test-pod', containers: [
  containerTemplate(name: 'maven', image: 'maven:3.6-jdk-8', command: 'cat', ttyEnabled: true),
  ],
volumes: [
  hostPathVolume(mountPath: '/var/run/docker.sock', hostPath: '/var/run/docker.sock')
]) {
  node('test-pod') {
    stage('Checkout') {
        checkout scm
    }
    stage('Build') {
      container('maven') {
        sh "mvn clean package -DskipTests=true"
        sh "mvn test"
        archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
      }
    }
    post{
       always {
            junit 'target/surefire-reports/*.xml'
        }
    }
  }

}