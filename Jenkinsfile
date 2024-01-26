node("ci-node") {
    stage("Checkout") {
        checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/MdTcn/SimpleProject.git']])
    }

    stage("Unit Tests") {
        sh "./mvnw test"
    }
}