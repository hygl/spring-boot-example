def label = "worker-${UUID.randomUUID().toString()}"

podTemplate(label: label, containers: [
  containerTemplate(name: 'maven', image: 'maven:3.6-jdk8', command: 'cat', ttyEnabled: true),
  containerTemplate(name: 'docker', image: 'docker', command: 'cat', ttyEnabled: true),
  containerTemplate(name: 'kubectl', image: 'lachlanevenson/k8s-kubectl:v1.14.9', command: 'cat', ttyEnabled: true),
  ],
volumes: [
  hostPathVolume(mountPath: '/var/run/docker.sock', hostPath: '/var/run/docker.sock')
]) {
  node(label) {
    def myRepo = checkout scm
    def gitCommit = myRepo.GIT_COMMIT
    def gitBranch = myRepo.GIT_BRANCH
    def shortGitCommit = "${gitCommit[0..10]}"
    def previousGitCommit = sh(script: "git rev-parse ${gitCommit}~", returnStdout: true)


    stage('Build') {
      container('maven') {
        sh "mvn package"
      }
    }
    stage('Create Docker images') {
      container('docker') {
        withCredentials([[$class: 'UsernamePasswordMultiBinding',
          credentialsId: 'dockerhub',
          usernameVariable: 'DOCKER_HUB_USER',
          passwordVariable: 'DOCKER_HUB_PASSWORD']]) {
          sh """
            docker login -u ${DOCKER_HUB_USER} -p ${DOCKER_HUB_PASSWORD}
            docker build -t hygl/spring-boot-example:${gitCommit} .
            docker push hygl/spring-boot-example:${gitCommit}
            """
        }
      }
    }
    stage('Run kubectl') {
      container('kubectl') {
        sh "kubectl get pods"
      }
    }
  }
}