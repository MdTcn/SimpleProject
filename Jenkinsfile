node("ci-node") {
    stage("Checkout") {
        checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/MdTcn/SimpleProject.git']])
    }

    stage("Unit Tests") {
        sh "chmod 777 ./mvnw"
        sh "./mvnw test"
    }

    stage("Build") {
        sh "./mvnw -DskipTests package"
    }

    stage("build docker image"){
        sh "sudo docker build -t simpleProject ."
    }
}